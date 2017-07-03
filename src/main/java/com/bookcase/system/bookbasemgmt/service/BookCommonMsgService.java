/**
 * Project Name:book-basemgmt
 * File Name:BookCommonMsgService.java
 * Package Name:com.bookcase.system.bookbasemgmt.service
 * Date:2017年5月24日下午8:54:00
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcommonmsg.BookCommonMsgReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcommonmsg.BookCommonMsgReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcommonmsg.BookCommonMsgRspBody;

/**
 * ClassName:BookCommonMsgService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月24日 下午8:54:00 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface BookCommonMsgService {

	GeneralPagingResult<List<BookCommonMsgRspBody>> findBookCommonMsgs(BookAuthorRspQuery query,
			String page, String size);

	GeneralContentResult<BookCommonMsgRspBody> findBookCommonMsgById(
			String bookCommonMsgId);

	GeneralContentResult<String> createBookCommonMsg(
			BookCommonMsgReqBody bookCommonMsgReqBody);

	GeneralResult updateBookCommonMsg(String bookCommonMsgId,
			BookCommonMsgReqBody bookCommonMsgReqBody);

	GeneralResult deleteBookCommonMsgs(
			String bookCommonMsgId);

	GeneralContentResult<List<BookCommonMsgRspBody>> findBookCommonMsgByName(
			String name);

	
}

