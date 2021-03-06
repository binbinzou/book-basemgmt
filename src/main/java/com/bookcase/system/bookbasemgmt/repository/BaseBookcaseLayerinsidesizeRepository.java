package com.bookcase.system.bookbasemgmt.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtConstant;
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseLayerinsidesize;

@Repository
public interface BaseBookcaseLayerinsidesizeRepository extends JpaRepository<BaseBookcaseLayerinsidesize, String>{

	@Query("SELECT a FROM BaseBookcaseLayerinsidesize a where a.name like CONCAT('%',:name,'%') AND a.orgId = :orgId  AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<BaseBookcaseLayerinsidesize> findBookCaseLayerInsideSizes(@Param("name") String name,@Param("orgId") String orgId,
			Pageable pageable);

	@Query("SELECT a FROM BaseBookcaseLayerinsidesize a where a.id = ?1 AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	BaseBookcaseLayerinsidesize findBaseBookcaseLayerinsidesizeById(String bookCaseLayerInsideSizeId);

	@Modifying
	@Query("UPDATE BaseBookcaseLayerinsidesize a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short status,String id);

	
	@Query("SELECT a FROM BaseBookcaseLayerinsidesize a where a.name like CONCAT('%',:name,'%') AND a.orgId = :orgId  AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	List<BaseBookcaseLayerinsidesize> findBookCaseLayerInsideSizesByName(
			@Param("name") String name, @Param("orgId") String orgId);

	
	
}
