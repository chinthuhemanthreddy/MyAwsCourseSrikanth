package com.organization.university.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.organization.university.dto.ASPVehicleInfo;

public interface GetVehicleInformationByKeyRepository extends  JpaRepository<ASPVehicleInfo, Integer> {

	@Modifying
	@Transactional
    @Query(value = "INSERT INTO asp.asp_vehicle_info (vin,brand,model,model_number,model_year,ext_color, tenant_id) VALUES " +
    		"( :vin, :brand, :model, :model_number, :model_year, :ext_color, :tenantId ) ", nativeQuery = true)
	public Integer insertVehicleInfo(String vin, String brand, String model, String model_number, 
			int model_year, String ext_color, String tenantId
			);
	
	@Modifying
	@Transactional
    @Query(value = "update asp.asp_vehicle_info set brand = :brand , model = :model, model_number = :model_number,"
    		+ " model_year = :model_year, ext_color = :ext_color, tenant_id= :tenantId where  vin = :vin ", nativeQuery = true)
	public Integer updateVehicleInfo(String vin, String brand, String model, String model_number, 
			int model_year, String ext_color, String tenantId
			);

	@Modifying
	@Transactional
    @Query(value = "select vin,brand,model,model_number,model_year,ext_color from asp.asp_vehicle_info where vin= :vin    ", nativeQuery = true)
	public List<ASPVehicleInfo> findByAccount(String vin);
}