/**
 * Project Name:book-basemgmt
 * File Name:BookAuthorController.java
 * Package Name:com.bookcase.system.bookbasemgmt.controller
 * Date:2017年5月24日下午8:36:20
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
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqQuery;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookcaselayerinsidesize.BookCaseLayerInsideSizeRspBody;
import com.bookcase.system.bookbasemgmt.service.BookAuthorService;
import com.bookcase.system.bookbasemgmt.service.BookCaseLayerInsideSizeService;

/**
 * ClassName:BookAuthorController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月24日 下午8:36:20 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="作者信息")
@RestController
@Slf4j
public class BookAuthorController {

	@Autowired
	BookAuthorService authorService;

	@RequestMapping(value = "/auth/bookauthors/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询作者信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookAuthorRspBody>> findBookAuthors(@RequestBody BookAuthorReqQuery query,
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookAuthorRspBody>> result = authorService
				.findBookAuthors(query,page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询作者信息(todo)")
	@RequestMapping(value = "/auth/bookauthors/{anthorId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "anthorId", dataType = "String", required = true, value = "作者信息Id", defaultValue = "") })
	public GeneralContentResult<BookAuthorRspBody> findBookAuthorById(
			@PathVariable("anthorId") String anthorId) {
		GeneralContentResult<BookAuthorRspBody> result = authorService
				.findBookAuthorById(anthorId);
		return result;
	}

	@ApiOperation(value = "创建作者信息(todo)")
	@RequestMapping(value = "/auth/bookauthors", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookAuthor(
			@RequestBody BookAuthorReqBody bookAuthorReqBody) {
		GeneralContentResult<String> result = authorService
				.createBookAuthor(bookAuthorReqBody);
		return result;
	}

	@ApiOperation(value = "更新作者信息(todo)")
	@RequestMapping(value = "/auth/bookauthors/{anthorId}", method = RequestMethod.PUT)
	public GeneralResult updateBookAuthor(
			@PathVariable("anthorId") String anthorId,
			@RequestBody BookAuthorReqBody bookAuthorReqBody) {
		GeneralResult result = authorService
				.updateBookAuthor(anthorId,
						bookAuthorReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除作者信息(todo)")
	@RequestMapping(value = "/auth/bookauthors", method = RequestMethod.DELETE)
	public GeneralResult deleteBookAuthors(
			@RequestBody BookAuthorReqParam bookAuthorReqParam) {
		GeneralResult result = authorService
				.deleteBookAuthors(bookAuthorReqParam);
		return result;
	}
	
	@ApiOperation(value = "根据名字查询作者信息(todo)")
	@RequestMapping(value = "/auth/bookauthors/{name}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "name", dataType = "String", required = true, value = "作者名字", defaultValue = "") })
	public GeneralContentResult<List<BookAuthorRspBody>> findBookAuthorByName(
			@PathVariable("name") String name) {
		GeneralContentResult<List<BookAuthorRspBody>> result = authorService
				.findBookAuthorByName(name);
		return result;
	}
	
}

