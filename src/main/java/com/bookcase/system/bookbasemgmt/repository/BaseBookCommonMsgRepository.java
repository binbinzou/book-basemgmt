/**
 * Project Name:book-basemgmt
 * File Name:BaseBookCommonMsgRepository.java
 * Package Name:com.bookcase.system.bookbasemgmt.repository
 * Date:2017年6月3日下午2:00:33
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

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
import com.bookcase.system.bookbasemgmt.domain.BaseBookCommonmsg;

/**
 * ClassName:BaseBookCommonMsgRepository <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午2:00:33 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Repository
public interface BaseBookCommonMsgRepository extends JpaRepository<BaseBookCommonmsg, String>{

	@Query("SELECT a FROM BaseBookCommonmsg a where a.name like CONCAT('%',:name,'%') AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	Page<BaseBookCommonmsg> findBookCommonMsgs(@Param("name") String name , Pageable pageable);

	@Query("SELECT a FROM BaseBookCommonmsg a where a.id = ?1 AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	BaseBookCommonmsg findBookCommonMsgById(String bookCommonMsgId);

	@Modifying
	@Query("UPDATE BaseBookCommonmsg a SET a.status = ?1 where a.id = ?2" )
	int setStatusFor(short statusGlobalDeleted, String id);

	@Query("SELECT a FROM BaseBookCommonmsg a where a.name like CONCAT('%',:name,'%') AND a.status<" + BookBaseMgmtConstant.STATUS_GLOBAL_DELETED)
	List<BaseBookCommonmsg> findBookCommonMsgByName(@Param("name") String name);

}

