package com.example.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.RequestTable;

public interface requestTableDao extends JpaRepository<RequestTable, Integer> {

	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("Update RequestTable SET status = 1 where userId = :studentId")
	void setAcceptStatus(@Param("studentId") int studentid);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("Update RequestTable SET status = 0 where userId = :studentId")
	void setIgnoreStatus(@Param("studentId") int studentid);
	
	
    @Query("Select status from RequestTable where userId =:userid")
    public boolean getStatus(@Param("userid") int userid);
    
    @Query("Select mentorid from RequestTable where userId =:userid")
    public int getMentor(@Param("userid") int userid);
	
}
