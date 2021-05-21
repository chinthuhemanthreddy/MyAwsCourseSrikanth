package com.organization.university.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.organization.university.dto.ASPParamInfo;

public interface GetReasonForReturnByTenantIdRepository extends JpaRepository<ASPParamInfo, Integer> {

	    @Modifying
		@Transactional
	    @Query(value = " select param_value,param_desc from asp.asp_param where tenant_id = :tenantId and "
	    + " param_name = :paramName" , nativeQuery = true)
	public List<ASPParamInfo> findByTenant(String tenantId, String paramName);
		
}