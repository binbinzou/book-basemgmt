package com.bookcase.system.bookbasemgmt.repository;


import java.util.List;

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

	@Query("DELETE FROM BaseBookcaseTypeLayerinside a WHERE a.bookcaseTypeId = ?2" )
	void deleteByBookCaseTypeId(String bookcasetypeId);

	@Modifying
	@Query("UPDATE BaseBookcaseTypeLayerinside a SET a.status = ?1 where a.bookcaseTypeId = ?2" )
	int updateStatusByBookCaseTypeId(short statusGlobalDeleted, String bookcaseTypeId);

	@Query("SELECT a FROM BaseBookcaseTypeLayerinside a where a.bookcaseTypeId =?1 AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	List<BaseBookcaseTypeLayerinside> findByBookCaseTypeId(String bookcasetypeId);

}
