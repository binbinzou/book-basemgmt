/**
 * Project Name:book-basemgmt
 * File Name:BookCommonMsgController.java
 * Package Name:com.bookcase.system.bookbasemgmt.controller
 * Date:2017年5月24日下午8:59:07
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
import com.bookcase.system.bookbasemgmt.dto.bookcommonmsg.BookCommonMsgReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcommonmsg.BookCommonMsgReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcommonmsg.BookCommonMsgRspBody;
import com.bookcase.system.bookbasemgmt.service.BookAuthorService;
import com.bookcase.system.bookbasemgmt.service.BookCommonMsgService;

/**
 * ClassName:BookCommonMsgController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月24日 下午8:59:07 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Api(value="书信息")
@RestController
@Slf4j
public class BookCommonMsgController {

	@Autowired
	BookCommonMsgService commonMsgService;

	@RequestMapping(value = "/auth/bookcommonmsgs/page/{page}/size/{size}", method = RequestMethod.GET)
	@ApiOperation(value = "查询书信息一栏(todo)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookCommonMsgRspBody>> findBookCommonMsgs(@RequestBody BookAuthorRspQuery query,
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookCommonMsgRspBody>> result = commonMsgService
				.findBookCommonMsgs(query,page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询书信息(todo)")
	@RequestMapping(value = "/auth/bookcommonmsgs/{bookCommonMsgId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookCommonMsgId", dataType = "String", required = true, value = "书信息Id", defaultValue = "") })
	public GeneralContentResult<BookCommonMsgRspBody> findBookCommonMsgById(
			@PathVariable("bookCommonMsgId") String bookCommonMsgId) {
		GeneralContentResult<BookCommonMsgRspBody> result = commonMsgService
				.findBookCommonMsgById(bookCommonMsgId);
		return result;
	}

	@ApiOperation(value = "创建书信息(todo)")
	@RequestMapping(value = "/auth/bookcommonmsgs", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookCommonMsg(
			@RequestBody BookCommonMsgReqBody bookCommonMsgReqBody) {
		GeneralContentResult<String> result = commonMsgService
				.createBookCommonMsg(bookCommonMsgReqBody);
		return result;
	}

	@ApiOperation(value = "更新书信息(todo)")
	@RequestMapping(value = "/auth/bookcommonmsgs/{bookCommonMsgId}", method = RequestMethod.PUT)
	public GeneralResult updateBookCommonMsg(
			@PathVariable("bookCommonMsgId") String bookCommonMsgId,
			@RequestBody BookCommonMsgReqBody bookCommonMsgReqBody) {
		GeneralResult result = commonMsgService
				.updateBookCommonMsg(bookCommonMsgId,
						bookCommonMsgReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除书信息(todo)")
	@RequestMapping(value = "/auth/bookcommonmsgs", method = RequestMethod.DELETE)
	public GeneralResult deleteBookCommonMsgs(
			@RequestBody BookCommonMsgReqParam bookCommonMsgReqParam) {
		GeneralResult result = commonMsgService
				.deleteBookCommonMsgs(bookCommonMsgReqParam);
		return result;
	}
	
	@ApiOperation(value = "根据Name查询书信息(todo)")
	@RequestMapping(value = "/auth/bookcommonmsgs/{name}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "name", dataType = "String", required = true, value = "书信息名字", defaultValue = "") })
	public GeneralContentResult<List<BookCommonMsgRspBody>> findBookCommonMsgByName(
			@PathVariable("name") String name) {
		GeneralContentResult<List<BookCommonMsgRspBody>> result = commonMsgService
				.findBookCommonMsgByName(name);
		return result;
	}
	
}

