/**
 * Project Name:book-basemgmt
 * File Name:BookAuthorServiceImpl.java
 * Package Name:com.bookcase.system.bookbasemgmt.service.impl
 * Date:2017年5月24日下午8:51:38
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
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseType;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqParam;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqQuery;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookcasetype.BookCaseTypeRspBody;
import com.bookcase.system.bookbasemgmt.repository.BaseBookauthorRepository;
import com.bookcase.system.bookbasemgmt.repository.BaseBookcaseTypeRepository;
import com.bookcase.system.bookbasemgmt.service.BookAuthorService;
import com.bookcase.system.bookbasemgmt.utils.BookAuthorConverter;
import com.bookcase.system.bookbasemgmt.utils.BookCaseTypeConverter;

/**
 * ClassName:BookAuthorServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年5月24日 下午8:51:38 <br/>
 * 
 * @author binbin
 * @version
 * @since JDK 1.8
 * @see
 */
@Service
@Slf4j
public class BookAuthorServiceImpl implements BookAuthorService {

	@Autowired
	BaseBookauthorRepository baseBookauthorRepository;

	@Override
	public GeneralPagingResult<List<BookAuthorRspBody>> findBookAuthors(
			BookAuthorReqQuery query, String page, String size) {
		GeneralPagingResult<List<BookAuthorRspBody>> result = new GeneralPagingResult<List<BookAuthorRspBody>>();
		List<BookAuthorRspBody> rspBodies = new ArrayList<BookAuthorRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		String name = query.getName();
		Page<BaseBookauthor> pg = baseBookauthorRepository.findBookAuthors(
				name, request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (BaseBookauthor baseBookauthor : pg.getContent()) {
				rspBodies.add(BookAuthorConverter
						.baseBookauthor2BookAuthorRspBody(baseBookauthor));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookAuthorRspBody> findBookAuthorById(
			String authodId) {
		GeneralContentResult<BookAuthorRspBody> result = new GeneralContentResult<BookAuthorRspBody>();
		BaseBookauthor bookauthor = baseBookauthorRepository.findOne(authodId);
		BookAuthorRspBody rspBody = BookAuthorConverter
				.baseBookauthor2BookAuthorRspBody(bookauthor);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookAuthor(
			BookAuthorReqBody bookAuthorReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		BaseBookauthor bookauthor = BookAuthorConverter
				.bookAuthorReqBody2BaseBookauthor(bookAuthorReqBody);
		bookauthor.setCreator("XXX");
		bookauthor.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookauthor = baseBookauthorRepository.save(bookauthor);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookauthor.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookAuthor(String authodId,
			BookAuthorReqBody bookAuthorReqBody) {
		GeneralResult result = new GeneralResult();
		BaseBookauthor tmp = baseBookauthorRepository
				.findBookAuthorById(authodId);
		if (tmp == null) {
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		BaseBookauthor bookauthor = BookAuthorConverter
				.bookAuthorReqBody2BaseBookauthor(bookAuthorReqBody);
		bookauthor.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookauthor.setCreator("XXX");
		bookauthor.setId(authodId);
		bookauthor = baseBookauthorRepository.save(bookauthor);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookAuthors(String authodId) {
		GeneralResult result = new GeneralResult();
		int tmp = baseBookauthorRepository.setStatusFor(
				BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, authodId);
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
	public GeneralContentResult<List<BookAuthorRspBody>> findBookAuthorByName(
			String name) {
		GeneralContentResult<List<BookAuthorRspBody>> result = new GeneralContentResult<List<BookAuthorRspBody>>();
		List<BookAuthorRspBody> bodies = new ArrayList<BookAuthorRspBody>();
		List<BaseBookauthor> bookauthors = baseBookauthorRepository
				.findBookAuthorByName(name);
		for (BaseBookauthor bookauthor : bookauthors) {
			bodies.add(BookAuthorConverter
					.baseBookauthor2BookAuthorRspBody(bookauthor));
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(bodies);
		return result;
	}

}
