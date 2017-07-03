/**
 * Project Name:book-basemgmt
 * File Name:BookCaseTypeService.java
 * Package Name:com.bookcase.system.bookbasemgmt.service
 * Date:2017年5月6日下午12:37:13
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqParam;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcasetype.BookCaseTypeRspBody;

/**
 * ClassName:BookCaseTypeService <br/>
 * Function: 图书柜类别service接口. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月6日 下午12:37:13 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookCaseTypeService {

	GeneralPagingResult<List<BookCaseTypeRspBody>> findBookCaseTypes(BookCaseTypeReqQuery query, String page,
			String size);

	GeneralContentResult<BookCaseTypeRspBody> findBookCaseTypeById(
			String bookcasetypeId);

	GeneralContentResult<String> createBookCaseType(
			BookCaseTypeReqBody bookCaseTypeReqBody);

	GeneralResult updateBookCaseType(String bookcasetypeId,
			BookCaseTypeReqBody bookCaseTypeReqBody);

	GeneralResult deleteBookCaseTypes(String bookCaseTypeId);

	GeneralContentResult<List<BookCaseTypeRspBody>> findBookCaseTypeByName(String name);

}

