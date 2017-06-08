/**
 * Project Name:book-basemgmt
 * File Name:BookTypeController.java
 * Package Name:com.bookcase.system.bookbasemgmt.controller
 * Date:2017年5月24日下午8:59:25
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqParam;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqBody;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqParam;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqQuery;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookbasemgmt.otd.booktype.BookTypeRspBody;
import com.bookcase.system.bookbasemgmt.service.BookAuthorService;
import com.bookcase.system.bookbasemgmt.service.BookTypeService;

/**
 * ClassName:BookTypeController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月24日 下午8:59:25 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="图书类型信息")
@RestController
@Slf4j
public class BookTypeController {

	@Autowired
	BookTypeService bookTypeService;

	@RequestMapping(value = "/auth/booktypes/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询图书类型信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookTypeRspBody>> findBookTypes(@RequestBody BookTypeReqQuery query,
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookTypeRspBody>> result = bookTypeService
				.findBookTypes(query,page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询图书类型信息(todo)")
	@RequestMapping(value = "/auth/booktypes/{bookTypeId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookTypeId", dataType = "String", required = true, value = "图书类型信息Id", defaultValue = "") })
	public GeneralContentResult<BookTypeRspBody> findBookTypeById(
			@PathVariable("bookTypeId") String bookTypeId) {
		GeneralContentResult<BookTypeRspBody> result = bookTypeService
				.findBookTypeById(bookTypeId);
		return result;
	}

	@ApiOperation(value = "创建图书类型信息(todo)")
	@RequestMapping(value = "/auth/booktypes", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookType(
			@RequestBody BookTypeReqBody bookTypeReqBody) {
		GeneralContentResult<String> result = bookTypeService
				.createBookType(bookTypeReqBody);
		return result;
	}

	@ApiOperation(value = "更新图书类型信息(todo)")
	@RequestMapping(value = "/auth/booktypes/{bookTypeId}", method = RequestMethod.PUT)
	public GeneralResult updateBookType(
			@PathVariable("bookTypeId") String bookTypeId,
			@RequestBody BookTypeReqBody bookTypeReqBody) {
		GeneralResult result = bookTypeService
				.updateBookType(bookTypeId,
						bookTypeReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除图书类型信息(todo)")
	@RequestMapping(value = "/auth/booktypes", method = RequestMethod.DELETE)
	public GeneralResult deleteBookTypes(
			@RequestBody BookTypeReqParam bookTypeReqParam) {
		GeneralResult result = bookTypeService
				.deleteBookTypes(bookTypeReqParam);
		return result;
	}
	
	@ApiOperation(value = "根据Name查询图书类型信息(todo)")
	@RequestMapping(value = "/auth/booktypes/{name}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "name", dataType = "String", required = true, value = "图书类型信息Id", defaultValue = "") })
	public GeneralContentResult<List<BookTypeRspBody>> findBookTypeByName(
			@PathVariable("name") String name) {
		GeneralContentResult<List<BookTypeRspBody>> result = bookTypeService
				.findBookTypeByName(name);
		return result;
	}
	
}

