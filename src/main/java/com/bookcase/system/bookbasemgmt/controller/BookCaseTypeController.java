package com.bookcase.system.bookbasemgmt.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.List;

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
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqParam;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqParam;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcasetype.BookCaseTypeRspBody;
import com.bookcase.system.bookbasemgmt.service.BookCaseTypeService;

/**
 * ClassName: BookCaseTypeController <br/>
 * Function: 图书柜类型控制器. <br/>
 * date: 2017年5月6日 下午12:20:32 <br/>
 *
 * @author binbin
 * @version 
 * @since JDK 1.8
 */
@Api(value="图书柜类型")
@RestController
@Slf4j
public class BookCaseTypeController {

	@Autowired
	BookCaseTypeService bookCaseTypeService;
	
	@RequestMapping(value = "/auth/bookcasetypes/page/{page}/size/{size}", method = RequestMethod.POST)
	@ApiOperation(value = "查询图书柜类别一栏(done)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookCaseTypeRspBody>> findBookCaseTypes(@RequestBody BookCaseTypeReqQuery query,
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookCaseTypeRspBody>> result = bookCaseTypeService
				.findBookCaseTypes(query,page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询图书柜类别(done)")
	@RequestMapping(value = "/auth/bookcasetype/{bookCaseTypeId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookCaseTypeId", dataType = "String", required = true, value = "图书柜类别Id", defaultValue = "") })
	public GeneralContentResult<BookCaseTypeRspBody> findBookCaseTypeById(
			@PathVariable("bookCaseTypeId") String bookCaseTypeId) {
		GeneralContentResult<BookCaseTypeRspBody> result = bookCaseTypeService
				.findBookCaseTypeById(bookCaseTypeId);
		return result;
	}

	@ApiOperation(value = "创建图书柜类别(done)")
	@RequestMapping(value = "/auth/bookcasetype", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookCaseType(
			@RequestBody BookCaseTypeReqBody bookCaseTypeReqBody) {
		GeneralContentResult<String> result = bookCaseTypeService
				.createBookCaseType(bookCaseTypeReqBody);
		return result;
	}

	@ApiOperation(value = "更新图书柜类别(done)")
	@RequestMapping(value = "/auth/bookcasetype/{bookCaseTypeId}", method = RequestMethod.PUT)
	public GeneralResult updateBookCaseType(
			@PathVariable("bookCaseTypeId") String bookCaseTypeId,
			@RequestBody BookCaseTypeReqBody bookCaseTypeReqBody) {
		GeneralResult result = bookCaseTypeService
				.updateBookCaseType(bookCaseTypeId,
						bookCaseTypeReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除图书柜类别(done)")
	@RequestMapping(value = "/auth/bookcasetypes/{bookCaseTypeId}", method = RequestMethod.DELETE)
	public GeneralResult deleteBookCaseTypes(
			@PathVariable("bookCaseTypeId") String bookCaseTypeId) {
		GeneralResult result = bookCaseTypeService
				.deleteBookCaseTypes(bookCaseTypeId);
		return result;
	}
	
	@ApiOperation(value = "根据name查询图书柜类别(done)")
	@RequestMapping(value = "/auth/bookcasetype/name/{name}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "name", dataType = "String", required = true, value = "图书柜类别名字", defaultValue = "") })
	public GeneralContentResult<List<BookCaseTypeRspBody>> findBookCaseTypeByName(
			@PathVariable("name") String name) {
		GeneralContentResult<List<BookCaseTypeRspBody>> result = bookCaseTypeService
				.findBookCaseTypeByName(name);
		return result;
	}
	
}
