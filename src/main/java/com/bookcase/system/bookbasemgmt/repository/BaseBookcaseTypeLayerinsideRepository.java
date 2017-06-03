package com.bookcase.system.bookbasemgmt.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtConstant;
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseLayerinsidesize;
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseType;
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseTypeLayerinside;

public interface BaseBookcaseTypeLayerinsideRepository extends JpaRepository<BaseBookcaseTypeLayerinside, String>{

	@Query("SELECT a FROM BaseBookcaseTypeLayerinside a where a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<BaseBookcaseTypeLayerinside> findBookCaseTypeLayerInsides(Pageable pageable);

	@Query("SELECT a FROM BaseBookcaseTypeLayerinside a where a.id = ?1 AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	BaseBookcaseTypeLayerinside findBookCaseTypeLayerInsideById(
			String bookCaseTypeLayerInsideId);

	@Modifying
	@Query("UPDATE BaseBookcaseTypeLayerinside a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

}
