package com.organization.Btech.repo;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.organization.Btech.daomodel.ASPGrounding;

public interface ASPGroundingRepository extends JpaRepository<ASPGrounding, Integer> {
	
	@Modifying
	@Transactional
    @Query(value = "Update grounding_id t SET t.return_date=:return_date WHERE t.account_number=:account_number", nativeQuery = true)
	public Integer updateGroundingDate(@Param("account_number")String account_number,@Param("return_date") LocalDate return_date);

}
