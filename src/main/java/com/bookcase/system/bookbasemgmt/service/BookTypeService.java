/**
 * Project Name:book-basemgmt
 * File Name:BookTypeService.java
 * Package Name:com.bookcase.system.bookbasemgmt.service
 * Date:2017年5月24日下午8:55:39
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqBody;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqParam;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqQuery;
import com.bookcase.system.bookbasemgmt.otd.booktype.BookTypeRspBody;

/**
 * ClassName:BookTypeService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月24日 下午8:55:39 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookTypeService {

	GeneralPagingResult<List<BookTypeRspBody>> findBookTypes(BookTypeReqQuery query,String page,
			String size);

	GeneralContentResult<BookTypeRspBody> findBookTypeById(String bookTypeId);

	GeneralContentResult<String> createBookType(BookTypeReqBody bookTypeReqBody);

	GeneralResult updateBookType(String bookTypeId,
			BookTypeReqBody bookTypeReqBody);

	GeneralResult deleteBookTypes(BookTypeReqParam bookTypeReqParam);

	GeneralContentResult<List<BookTypeRspBody>> findBookTypeByName(String name);

}

