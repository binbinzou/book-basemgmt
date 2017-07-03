/**
 * Project Name:book-basemgmt
 * File Name:BookCaseTypeLayerInsideService.java
 * Package Name:com.bookcase.system.bookbasemgmt.service
 * Date:2017年5月6日下午2:36:53
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.bookcasetypelayerinside.BookCaseTypeLayerInsideReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcasetypelayerinside.BookCaseTypeLayerInsideReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookcasetypelayerinside.BookCaseTypeLayerInsideRspBody;

/**
 * ClassName:BookCaseTypeLayerInsideService <br/>
 * Function: 图书柜类别内部分层管理. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月6日 下午2:36:53 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookCaseTypeLayerInsideService {

	GeneralPagingResult<List<BookCaseTypeLayerInsideRspBody>> findBookCaseTypeLayerInsides(
			String page, String size);

	GeneralContentResult<BookCaseTypeLayerInsideRspBody> findBookCaseTypeLayerInsideById(
			String bookCaseTypeLayerInsideId);

	GeneralContentResult<String> createBookCaseTypeLayerInside(
			BookCaseTypeLayerInsideReqBody bookCaseTypeLayerInsideReqBody);

	GeneralResult updateBookCaseTypeLayerInside(
			String bookCaseTypeLayerInsideId,
			BookCaseTypeLayerInsideReqBody bookCaseTypeLayerInsideReqBody);

	GeneralResult deleteBookCaseTypeLayerInsides(
			String bookCaseTypeLayerInsideId);

}

