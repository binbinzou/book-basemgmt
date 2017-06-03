/**
 * Project Name:book-basemgmt
 * File Name:BookCaseTypeLayerInsideServiceImpl.java
 * Package Name:com.bookcase.system.bookbasemgmt.service.impl
 * Date:2017年5月6日下午2:37:24
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

import com.bookcase.common.bookcommon.contant.CommonResultCodeConstant;
import com.bookcase.common.system.bookframework.page.PageInfo;
import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtConstant;
import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtResultConstant;
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseType;
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseTypeLayerinside;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqParam;
import com.bookcase.system.bookbasemgmt.dto.bookcasetypelayerinside.BookCaseTypeLayerInsideReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcasetypelayerinside.BookCaseTypeLayerInsideReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookcasetype.BookCaseTypeRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookcasetypelayerinside.BookCaseTypeLayerInsideRspBody;
import com.bookcase.system.bookbasemgmt.repository.BaseBookcaseTypeLayerinsideRepository;
import com.bookcase.system.bookbasemgmt.service.BookCaseTypeLayerInsideService;
import com.bookcase.system.bookbasemgmt.utils.BookCaseTypeConverter;
import com.bookcase.system.bookbasemgmt.utils.BookCaseTypeLayerInsideConverter;

/**
 * ClassName:BookCaseTypeLayerInsideServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月6日 下午2:37:24 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookCaseTypeLayerInsideServiceImpl implements BookCaseTypeLayerInsideService{

	@Autowired
	BaseBookcaseTypeLayerinsideRepository baseBookcaseTypeLayerinsideRepository;
	
	@Override
	public GeneralPagingResult<List<BookCaseTypeLayerInsideRspBody>> findBookCaseTypeLayerInsides(
			String page, String size) {
		GeneralPagingResult<List<BookCaseTypeLayerInsideRspBody>> result = new GeneralPagingResult<List<BookCaseTypeLayerInsideRspBody>>();
		List<BookCaseTypeLayerInsideRspBody> rspBodies = new ArrayList<BookCaseTypeLayerInsideRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<BaseBookcaseTypeLayerinside> pg = baseBookcaseTypeLayerinsideRepository
				.findBookCaseTypeLayerInsides(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (BaseBookcaseTypeLayerinside baseBookcaseTypeLayerinside : pg.getContent()) {
				rspBodies.add(BookCaseTypeLayerInsideConverter
								.baseBookcaseTypeLayerinside2BookCaseTypeLayerInsideRspBody(baseBookcaseTypeLayerinside));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookCaseTypeLayerInsideRspBody> findBookCaseTypeLayerInsideById(
			String bookCaseTypeLayerInsideId) {
		GeneralContentResult<BookCaseTypeLayerInsideRspBody> result = new GeneralContentResult<BookCaseTypeLayerInsideRspBody>();
		BaseBookcaseTypeLayerinside bookcaseTypeLayerinside = baseBookcaseTypeLayerinsideRepository.findOne(bookCaseTypeLayerInsideId);
		BookCaseTypeLayerInsideRspBody rspBody = BookCaseTypeLayerInsideConverter.baseBookcaseTypeLayerinside2BookCaseTypeLayerInsideRspBody(bookcaseTypeLayerinside);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	public GeneralContentResult<String> createBookCaseTypeLayerInside(
			BookCaseTypeLayerInsideReqBody bookCaseTypeLayerInsideReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		BaseBookcaseTypeLayerinside bookcaseTypeLayerinside = BookCaseTypeLayerInsideConverter.bookCaseTypeLayerInsideReqBody2BaseBookcaseTypeLayerinside(bookCaseTypeLayerInsideReqBody);
		bookcaseTypeLayerinside.setCreator("XXX");
		bookcaseTypeLayerinside.setOrgId("XXX");
		bookcaseTypeLayerinside.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcaseTypeLayerinside = baseBookcaseTypeLayerinsideRepository.save(bookcaseTypeLayerinside);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookcaseTypeLayerinside.getId());
		return result;
	}

	@Override
	public GeneralResult updateBookCaseTypeLayerInside(
			String bookCaseTypeLayerInsideId,
			BookCaseTypeLayerInsideReqBody bookCaseTypeLayerInsideReqBody) {
		GeneralResult result = new GeneralResult();
		BaseBookcaseTypeLayerinside tmp = baseBookcaseTypeLayerinsideRepository.findBookCaseTypeLayerInsideById(bookCaseTypeLayerInsideId);
		if(tmp==null){
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		BaseBookcaseTypeLayerinside bookcaseTypeLayerinside = BookCaseTypeLayerInsideConverter
				.bookCaseTypeLayerInsideReqBody2BaseBookcaseTypeLayerinside(bookCaseTypeLayerInsideReqBody);
		bookcaseTypeLayerinside.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcaseTypeLayerinside.setCreator("XXX");
		bookcaseTypeLayerinside.setOrgId("XXX");
		bookcaseTypeLayerinside.setId(bookCaseTypeLayerInsideId);
		bookcaseTypeLayerinside = baseBookcaseTypeLayerinsideRepository
				.save(bookcaseTypeLayerinside);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	public GeneralResult deleteBookCaseTypeLayerInsides(
			BookCaseTypeLayerInsideReqParam bookCaseTypeLayerInsideReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookCaseTypeLayerInsideReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookCaseTypeLayerInsideReqParam.getIds()){
			int tmp = baseBookcaseTypeLayerinsideRepository.setStatusFor(BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, id);
			tmpSize++;
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

