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
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseType;

@Repository
public interface BaseBookcaseTypeRepository extends JpaRepository<BaseBookcaseType, String>{

	@Query("SELECT a FROM BaseBookcaseType a where a.name like CONCAT('%',:name,'%') AND a.orgId = :orgId  AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<BaseBookcaseType> findBookCaseLayerInsideSizes(
			@Param("name") String name,@Param("orgId") String orgId, Pageable pageable);
	
	@Query("SELECT a FROM BaseBookcaseType a where a.id = ?1 AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	BaseBookcaseType findBaseBaseBookcaseTypeById(String bookcasetypeId);

	@Modifying
	@Query("UPDATE BaseBookcaseType a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

	@Query("SELECT a FROM BaseBookcaseType a where a.name like CONCAT('%',:name,'%') AND a.orgId = :orgId  AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	List<BaseBookcaseType> findBookCaseTypeByName(@Param("name") String name,@Param("orgId") String orgId);

}
