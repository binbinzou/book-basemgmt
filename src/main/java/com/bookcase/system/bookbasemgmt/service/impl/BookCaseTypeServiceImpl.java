/**
 * Project Name:book-basemgmt
 * File Name:BookCaseTypeServiceImpl.java
 * Package Name:com.bookcase.system.bookbasemgmt.service.impl
 * Date:2017年5月6日下午12:37:44
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
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseLayerinsidesize;
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseType;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookcaselayerinsidesize.BookCaseLayerInsideSizeRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookcasetype.BookCaseTypeRspBody;
import com.bookcase.system.bookbasemgmt.repository.BaseBookcaseTypeRepository;
import com.bookcase.system.bookbasemgmt.service.BookCaseTypeService;
import com.bookcase.system.bookbasemgmt.utils.BookCaseLayerInsideSizeConverter;
import com.bookcase.system.bookbasemgmt.utils.BookCaseTypeConverter;

/**
 * ClassName:BookCaseTypeServiceImpl <br/>
 * Function: 图书柜类别service实现类. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月6日 下午12:37:44 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookCaseTypeServiceImpl implements BookCaseTypeService {

	@Autowired
	BaseBookcaseTypeRepository baseBookcaseTypeRepository;
	
	@Override
	public GeneralPagingResult<List<BookCaseTypeRspBody>> findBookCaseTypes(
			String page, String size) {
		GeneralPagingResult<List<BookCaseTypeRspBody>> result = new GeneralPagingResult<List<BookCaseTypeRspBody>>();
		List<BookCaseTypeRspBody> rspBodies = new ArrayList<BookCaseTypeRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		Page<BaseBookcaseType> pg = baseBookcaseTypeRepository
				.findBookCaseLayerInsideSizes(request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (BaseBookcaseType bookcaseType : pg.getContent()) {
				rspBodies.add(BookCaseTypeConverter
								.baseBookcaseType2BookCaseTypeRspBody(bookcaseType));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookCaseTypeRspBody> findBookCaseTypeById(
			String bookcasetypeId) {
		GeneralContentResult<BookCaseTypeRspBody> result = new GeneralContentResult<BookCaseTypeRspBody>();
		BaseBookcaseType baseBookcaseType = baseBookcaseTypeRepository.findOne(bookcasetypeId);
		BookCaseTypeRspBody rspBody = BookCaseTypeConverter.baseBookcaseType2BookCaseTypeRspBody(baseBookcaseType);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookCaseType(
			BookCaseTypeReqBody bookCaseTypeReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		BaseBookcaseType bookcaseType = BookCaseTypeConverter.bookCaseTypeReqBody2BaseBookcaseType(bookCaseTypeReqBody);
		bookcaseType.setCreator("XXX");
		bookcaseType.setOrgId("XXX");
		bookcaseType.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcaseType = baseBookcaseTypeRepository.save(bookcaseType);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookcaseType.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookCaseType(String bookcasetypeId,
			BookCaseTypeReqBody bookCaseTypeReqBody) {
		GeneralResult result = new GeneralResult();
		BaseBookcaseType tmp = baseBookcaseTypeRepository.findBaseBaseBookcaseTypeById(bookcasetypeId);
		if(tmp==null){
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		BaseBookcaseType bookcaseType = BookCaseTypeConverter
				.bookCaseTypeReqBody2BaseBookcaseType(bookCaseTypeReqBody);
		bookcaseType.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcaseType.setCreator("XXX");
		bookcaseType.setOrgId("XXX");
		bookcaseType.setId(bookcasetypeId);
		bookcaseType = baseBookcaseTypeRepository
				.save(bookcaseType);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookCaseTypes(
			BookCaseTypeReqParam bookCaseTypeReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookCaseTypeReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookCaseTypeReqParam.getIds()){
			int tmp = baseBookcaseTypeRepository.setStatusFor(BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, id);
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

