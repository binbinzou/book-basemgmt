/**
 * Project Name:book-basemgmt
 * File Name:BookTypeServiceImpl.java
 * Package Name:com.bookcase.system.bookbasemgmt.service.impl
 * Date:2017年5月24日下午8:57:00
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookcase.common.bookcommon.contant.CommonResultCodeConstant;
import com.bookcase.common.system.bookframework.page.PageInfo;
import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtConstant;
import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtResultConstant;
import com.bookcase.system.bookbasemgmt.domain.BaseBookauthor;
import com.bookcase.system.bookbasemgmt.domain.BaseBooktype;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqBody;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookbasemgmt.otd.booktype.BookTypeRspBody;
import com.bookcase.system.bookbasemgmt.repository.BaseBooktypeRepository;
import com.bookcase.system.bookbasemgmt.service.BookTypeService;
import com.bookcase.system.bookbasemgmt.utils.BookAuthorConverter;
import com.bookcase.system.bookbasemgmt.utils.BookTypeConverter;

/**
 * ClassName:BookTypeServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月24日 下午8:57:00 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookTypeServiceImpl implements BookTypeService {

	@Autowired
	BaseBooktypeRepository baseBooktypeRepository;
	
	@Override
	public GeneralPagingResult<List<BookTypeRspBody>> findBookTypes(
			String page, String size) {
		GeneralPagingResult<List<BookTypeRspBody>> result = new GeneralPagingResult<List<BookTypeRspBody>>();
		List<BookTypeRspBody> rspBodies = new ArrayList<BookTypeRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<BaseBooktype> pg = baseBooktypeRepository
				.findBookTypes(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (BaseBooktype booktype : pg.getContent()) {
				rspBodies.add(BookTypeConverter
								.booktype2BookBookTypeRspBody(booktype));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookTypeRspBody> findBookTypeById(
			String bookTypeId) {
		GeneralContentResult<BookTypeRspBody> result = new GeneralContentResult<BookTypeRspBody>();
		BaseBooktype booktype = baseBooktypeRepository.findOne(bookTypeId);
		BookTypeRspBody rspBody = BookTypeConverter.booktype2BookBookTypeRspBody(booktype);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookType(
			BookTypeReqBody bookTypeReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		BaseBooktype booktype = BookTypeConverter.bookTypeReqBody2BaseBooktype(bookTypeReqBody);
		booktype.setCreator("XXX");
		booktype.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		booktype = baseBooktypeRepository.save(booktype);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(booktype.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookType(String bookTypeId,
			BookTypeReqBody bookTypeReqBody) {
		GeneralResult result = new GeneralResult();
		BaseBooktype tmp = baseBooktypeRepository.findBaseBaseBookTypeById(bookTypeId);
		if(tmp==null){
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		BaseBooktype booktype = BookTypeConverter
				.bookTypeReqBody2BaseBooktype(bookTypeReqBody);
		booktype.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		booktype.setCreator("XXX");
		booktype.setId(bookTypeId);
		booktype = baseBooktypeRepository
				.save(booktype);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	public GeneralResult deleteBookTypes(BookTypeReqParam bookTypeReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookTypeReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookTypeReqParam.getIds()){
			int tmp = baseBooktypeRepository.setStatusFor(BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, id);
			if(tmp>0){
				tmpSize++;
			}
		}
		if(size==tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("删除成功");
		}else if(size>tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("部分数据删除成功");
		}else if(tmpSize==0){
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("删除失败");
		}
		return result;
	}

}

