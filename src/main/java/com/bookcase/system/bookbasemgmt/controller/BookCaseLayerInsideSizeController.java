package com.bookcase.system.bookbasemgmt.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

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
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcaselayerinsidesize.BookCaseLayerInsideSizeRspBody;
import com.bookcase.system.bookbasemgmt.service.BookCaseLayerInsideSizeService;


/**
 * ClassName: BookCaseLayerInsideSizeController <br/>
 * Function: 图书柜内部规格 <br/>
 * date: 2017年5月6日 下午12:18:55 <br/>
 *
 * @author binbin
 * @version 
 * @since JDK 1.8
 */
@Api(value="图书柜内部规格")
@RestController
@Slf4j
public class BookCaseLayerInsideSizeController {

	@Autowired
	BookCaseLayerInsideSizeService bookCaseLayerInsideSizeService;

	@RequestMapping(value = "/auth/bookcaselayerinsidesizes/page/{page}/size/{size}", method = RequestMethod.POST)
	@ApiOperation(value = "查询图书柜内部规格一栏(done)")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "path", name = "page", dataType = "String", required = true, value = "第几页", defaultValue = "1"),
			@ApiImplicitParam(paramType = "path", name = "size", dataType = "String", required = true, value = "每页数量", defaultValue = "10") })
	public GeneralPagingResult<List<BookCaseLayerInsideSizeRspBody>> findBookCaseLayerInsideSizes(@RequestBody BookCaseLayerInsideSizeReqQuery query,
			@PathVariable("page") String page, @PathVariable("size") String size) {
		GeneralPagingResult<List<BookCaseLayerInsideSizeRspBody>> result = bookCaseLayerInsideSizeService
				.findBookCaseLayerInsideSizes(query,page, size);
		return result;
	}

	@ApiOperation(value = "根据id查询图书柜内部规格(done)")
	@RequestMapping(value = "/auth/bookcaselayerinsidesizes/{bookCaseLayerInsideSizeId}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "bookCaseLayerInsideSizeId", dataType = "String", required = true, value = "图书柜内部规格Id", defaultValue = "") })
	public GeneralContentResult<BookCaseLayerInsideSizeRspBody> findBookCaseLayerInsideSizeById(
			@PathVariable("bookCaseLayerInsideSizeId") String bookCaseLayerInsideSizeId) {
		GeneralContentResult<BookCaseLayerInsideSizeRspBody> result = bookCaseLayerInsideSizeService
				.findBookCaseLayerInsideSizeById(bookCaseLayerInsideSizeId);
		return result;
	}

	@ApiOperation(value = "创建图书柜内部规格(done)")
	@RequestMapping(value = "/auth/bookcaselayerinsidesizes", method = RequestMethod.POST)
	public GeneralContentResult<String> createBookCaseLayerInsideSize(
			@RequestBody BookCaseLayerInsideSizeReqBody bookCaseLayerInsideSizeReqBody) {
		GeneralContentResult<String> result = bookCaseLayerInsideSizeService
				.createBookCaseLayerInsideSize(bookCaseLayerInsideSizeReqBody);
		return result;
	}

	@ApiOperation(value = "更新图书柜内部规格(done)")
	@RequestMapping(value = "/auth/bookcaselayerinsidesizes/{bookCaseLayerInsideSizeId}", method = RequestMethod.PUT)
	public GeneralResult updateBookCaseLayerInsideSize(
			@PathVariable("bookCaseLayerInsideSizeId") String bookCaseLayerInsideSizeId,
			@RequestBody BookCaseLayerInsideSizeReqBody bookCaseLayerInsideSizeReqBody) {
		GeneralResult result = bookCaseLayerInsideSizeService
				.updateBookCaseLayerInsideSize(bookCaseLayerInsideSizeId,
						bookCaseLayerInsideSizeReqBody);
		return result;
	}
	
	@ApiOperation(value = "删除图书柜内部规格(done)")
	@RequestMapping(value = "/auth/bookcaselayerinsidesizes", method = RequestMethod.DELETE)
	public GeneralResult deleteBookCaseLayerInsideSizes(
			@RequestBody BookCaseLayerInsideSizeReqParam bookCaseLayerInsideSizeReqParam) {
		GeneralResult result = bookCaseLayerInsideSizeService
				.deleteBookCaseLayerInsideSizes(bookCaseLayerInsideSizeReqParam);
		return result;
	}
	
	@ApiOperation(value = "根据name查询图书柜内部规格(done)")
	@RequestMapping(value = "/auth/bookcaselayerinsidesizes/{name}", method = RequestMethod.GET)
	@ApiImplicitParams({ @ApiImplicitParam(paramType = "path", name = "name", dataType = "String", required = true, value = "图书柜内部规格名称", defaultValue = "") })
	public GeneralContentResult<List<BookCaseLayerInsideSizeRspBody>> findBookCaseLayerInsideSizeByName(
			@PathVariable("name") String name) {
		GeneralContentResult<List<BookCaseLayerInsideSizeRspBody>> result = bookCaseLayerInsideSizeService
				.findBookCaseLayerInsideSizeByName(name);
		return result;
	}

}
