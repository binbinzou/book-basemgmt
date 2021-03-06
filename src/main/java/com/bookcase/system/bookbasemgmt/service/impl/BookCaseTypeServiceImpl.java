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
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseTypeLayerinside;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqParam;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcaselayerinsidesize.BookCaseLayerInsideSizeRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookcasetype.BookCaseTypeRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookcasetypelayerinside.BookCaseTypeLayerInsideRspBody;
import com.bookcase.system.bookbasemgmt.repository.BaseBookcaseTypeLayerinsideRepository;
import com.bookcase.system.bookbasemgmt.repository.BaseBookcaseTypeRepository;
import com.bookcase.system.bookbasemgmt.service.BookCaseTypeService;
import com.bookcase.system.bookbasemgmt.utils.BookCaseLayerInsideSizeConverter;
import com.bookcase.system.bookbasemgmt.utils.BookCaseTypeConverter;
import com.bookcase.system.bookbasemgmt.utils.BookCaseTypeLayerInsideConverter;

/**
 * ClassName:BookCaseTypeServiceImpl <br/>
 * Function: 图书柜类别service实现类. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年5月6日 下午12:37:44 <br/>
 * 
 * @author binbin
 * @version
 * @since JDK 1.8
 * @see
 */
@Service
@Slf4j
public class BookCaseTypeServiceImpl implements BookCaseTypeService {

	@Autowired
	BaseBookcaseTypeRepository baseBookcaseTypeRepository;

	@Autowired
	BaseBookcaseTypeLayerinsideRepository baseBookcaseTypeLayerinsideRepository;

	@Override
	public GeneralPagingResult<List<BookCaseTypeRspBody>> findBookCaseTypes(BookCaseTypeReqQuery query,
			String page, String size) {
		GeneralPagingResult<List<BookCaseTypeRspBody>> result = new GeneralPagingResult<List<BookCaseTypeRspBody>>();
		List<BookCaseTypeRspBody> rspBodies = new ArrayList<BookCaseTypeRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		String name = query.getName();
		String orgId = "XXX";
		Page<BaseBookcaseType> pg = baseBookcaseTypeRepository
				.findBookCaseLayerInsideSizes(name,orgId,request);
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
		BaseBookcaseType baseBookcaseType = baseBookcaseTypeRepository
				.findOne(bookcasetypeId);
		BookCaseTypeRspBody rspBody = BookCaseTypeConverter
				.baseBookcaseType2BookCaseTypeRspBody(baseBookcaseType);
		List<BookCaseTypeLayerInsideRspBody> bodies = new ArrayList<BookCaseTypeLayerInsideRspBody>();
		List<BaseBookcaseTypeLayerinside> layerinsides = baseBookcaseTypeLayerinsideRepository
				.findByBookCaseTypeId(bookcasetypeId);
		for (BaseBookcaseTypeLayerinside layerinside : layerinsides) {
			BookCaseTypeLayerInsideRspBody body = new BookCaseTypeLayerInsideRspBody();
			body = BookCaseTypeLayerInsideConverter
					.baseBookcaseTypeLayerinside2BookCaseTypeLayerInsideRspBody(layerinside);
			bodies.add(body);
		}
		rspBody.setLayerInsideRspBodies(bodies);
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
		BaseBookcaseType bookcaseType = BookCaseTypeConverter
				.bookCaseTypeReqBody2BaseBookcaseType(bookCaseTypeReqBody);
		bookcaseType.setCreator("XXX");
		bookcaseType.setOrgId("XXX");
		bookcaseType.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		List<BaseBookcaseTypeLayerinside> layerinsides = BookCaseTypeConverter
				.bookCaseTypeLayerInsideReqBodies2BaseBookcaseTypeLayerinsides(bookCaseTypeReqBody
						.getLayerInsideReqBodies());
		bookcaseType = baseBookcaseTypeRepository.save(bookcaseType);
		for (BaseBookcaseTypeLayerinside layerinside : layerinsides) {
			layerinside.setCreator("XXX");
			layerinside.setOrgId("XXX");
			layerinside.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
			layerinside.setBookcaseTypeId(bookcaseType.getId());
			baseBookcaseTypeLayerinsideRepository.save(layerinside);
		}
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
		BaseBookcaseType tmp = baseBookcaseTypeRepository
				.findBaseBaseBookcaseTypeById(bookcasetypeId);
		if (tmp == null) {
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		baseBookcaseTypeLayerinsideRepository
				.deleteByBookCaseTypeId(bookcasetypeId);
		BaseBookcaseType bookcaseType = BookCaseTypeConverter
				.bookCaseTypeReqBody2BaseBookcaseType(bookCaseTypeReqBody);
		bookcaseType.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookcaseType.setCreator("XXX");
		bookcaseType.setOrgId("XXX");
		bookcaseType.setId(bookcasetypeId);
		List<BaseBookcaseTypeLayerinside> layerinsides = BookCaseTypeConverter
				.bookCaseTypeLayerInsideReqBodies2BaseBookcaseTypeLayerinsides(bookCaseTypeReqBody
						.getLayerInsideReqBodies());
		bookcaseType = baseBookcaseTypeRepository.save(bookcaseType);
		for (BaseBookcaseTypeLayerinside layerinside : layerinsides) {
			layerinside.setCreator("XXX");
			layerinside.setOrgId("XXX");
			layerinside.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
			layerinside.setBookcaseTypeId(bookcaseType.getId());
			baseBookcaseTypeLayerinsideRepository.save(layerinside);
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookCaseTypes(
			String bookCaseTypeId) {
		GeneralResult result = new GeneralResult();
		int tmp = baseBookcaseTypeRepository.setStatusFor(
				BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, bookCaseTypeId);
		if (tmp > 0) {
			baseBookcaseTypeLayerinsideRepository
					.updateStatusByBookCaseTypeId(
							BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, bookCaseTypeId);
		}
		if (1 == tmp) {
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("删除成功");
		} else {
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("删除失败");
		}
		return result;
	}

	@Override
	public GeneralContentResult<List<BookCaseTypeRspBody>> findBookCaseTypeByName(
			String name) {
		String orgId = "XXX";
		GeneralContentResult<List<BookCaseTypeRspBody>> result = new GeneralContentResult<List<BookCaseTypeRspBody>>();
		List<BookCaseTypeRspBody> rspBodies = new ArrayList<BookCaseTypeRspBody>();
		List<BaseBookcaseType> types = baseBookcaseTypeRepository.findBookCaseTypeByName(name,orgId);
		for (BaseBookcaseType bookcaseType : types) {
			rspBodies.add(BookCaseTypeConverter
					.baseBookcaseType2BookCaseTypeRspBody(bookcaseType));
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBodies);
		return result;
	}

}
