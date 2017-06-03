/**
 * Project Name:book-basemgmt
 * File Name:BookCaseTypeLayerInside.java
 * Package Name:com.bookcase.system.bookbasemgmt.controller
 * Date:2017年5月6日下午2:07:11
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.bookcasetypelayerinside.BookCaseTypeLayerInsideReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcasetypelayerinside.BookCaseTypeLayerInsideReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookcasetypelayerinside.BookCaseTypeLayerInsideRspBody;
import com.bookcase.system.bookbasemgmt.service.BookCaseTypeLayerInsideService;

/**
 * ClassName:BookCaseTypeLayerInsideController <br/>
 * Function: 图书柜类型内部分层管理. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月6日 下午2:07:11 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="图书柜类型内部分层")
@RestController
@Slf4j
public class BookCaseTypeLayerInsideController {

	BookCaseTypeLayerInsideService bookCaseTypeLayerInsideService;
	
	@RequestMapping(value = "/auth/bookcasetypelayerinsides/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询图书柜类别内部分层一栏")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookCaseTypeLayerInsideRspBody>> findBookCaseTypeLayerInsides(
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookCaseTypeLayerInsideRspBody>> result = bookCaseTypeLayerInsideService
				.findBookCaseTypeLayerInsides(page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询图书柜类别内部分层")
	@RequestMapping(value = "/auth/bookcasetypelayerinsides/{bookCaseTypeLayerInsideId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookCaseTypeLayerInsideId", dataType = "String", required = true, value = "图书柜类别Id", defaultValue = "") })
	public GeneralContentResult<BookCaseTypeLayerInsideRspBody> findBookCaseTypeLayerInsideById(
			@PathVariable("bookCaseTypeLayerInsideId") String bookCaseTypeLayerInsideId) {
		GeneralContentResult<BookCaseTypeLayerInsideRspBody> result = bookCaseTypeLayerInsideService
				.findBookCaseTypeLayerInsideById(bookCaseTypeLayerInsideId);
		return result;
	}

	@ApiOperation(value = "创建图书柜类别内部分层")
	@RequestMapping(value = "/auth/bookcasetypelayerinside", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookCaseTypeLayerInside(
			@RequestBody BookCaseTypeLayerInsideReqBody bookCaseTypeLayerInsideReqBody) {
		GeneralContentResult<String> result = bookCaseTypeLayerInsideService
				.createBookCaseTypeLayerInside(bookCaseTypeLayerInsideReqBody);
		return result;
	}

	@ApiOperation(value = "更新图书柜类别内部分层")
	@RequestMapping(value = "/auth/bookcasetypelayerinside/{bookCaseTypeLayerInsideId}", method = RequestMethod.PUT)
	public GeneralResult updateBookCaseTypeLayerInside(
			@PathVariable("bookCaseTypeLayerInsideId") String bookCaseTypeLayerInsideId,
			@RequestBody BookCaseTypeLayerInsideReqBody bookCaseTypeLayerInsideReqBody) {
		GeneralResult result = bookCaseTypeLayerInsideService
				.updateBookCaseTypeLayerInside(bookCaseTypeLayerInsideId,
						bookCaseTypeLayerInsideReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除图书柜类别内部分层")
	@RequestMapping(value = "/auth/bookcasetypelayerinsides", method = RequestMethod.DELETE)
	public GeneralResult deleteBookCaseTypeLayerInsides(
			@RequestBody BookCaseTypeLayerInsideReqParam bookCaseTypeLayerInsideReqParam) {
		GeneralResult result = bookCaseTypeLayerInsideService
				.deleteBookCaseTypeLayerInsides(bookCaseTypeLayerInsideReqParam);
		return result;
	}
	
}

