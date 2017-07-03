/**
 * Project Name:book-basemgmt
 * File Name:BookCommonMsgConverter.java
 * Package Name:com.bookcase.system.bookbasemgmt.utils
 * Date:2017年6月3日下午2:05:50
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.utils;

import com.bookcase.system.bookbasemgmt.domain.BaseBookCommonmsg;
import com.bookcase.system.bookbasemgmt.dto.bookcommonmsg.BookCommonMsgReqBody;
import com.bookcase.system.bookbasemgmt.otd.bookcommonmsg.BookCommonMsgRspBody;

/**
 * ClassName:BookCommonMsgConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午2:05:50 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookCommonMsgConverter {

	public static BookCommonMsgRspBody bookCommonmsg2BookCommonMsgRspBody(
			BaseBookCommonmsg bookCommonmsg) {
		BookCommonMsgRspBody rspBody = new BookCommonMsgRspBody();
		rspBody.setAnotherName(bookCommonmsg.getAnotherName());
		rspBody.setAuthorId(bookCommonmsg.getAuthorId());
		rspBody.setBriefing(bookCommonmsg.getBriefing());
		rspBody.setCatalog(bookCommonmsg.getCatalog());
		rspBody.setCreateTime(bookCommonmsg.getCreateTime());
		rspBody.setCreator(bookCommonmsg.getCreator());
		rspBody.setId(bookCommonmsg.getId());
		rspBody.setName(bookCommonmsg.getName());
		rspBody.setPageCnt(bookCommonmsg.getPageCnt());
		rspBody.setReadOvertime(bookCommonmsg.getReadOvertime());
		rspBody.setStatus(bookCommonmsg.getStatus());
		rspBody.setTranslatorId(bookCommonmsg.getTranslatorId());
		rspBody.setUpdateTime(bookCommonmsg.getUpdateTime());
		rspBody.setBooktypeId(bookCommonmsg.getBooktypeId());
		return rspBody;
	}

	public static BaseBookCommonmsg bookCommonMsgReqBody2BaseBookCommonmsg(
			BookCommonMsgReqBody bookCommonMsgReqBody) {
		BaseBookCommonmsg commonmsg = new BaseBookCommonmsg();
		commonmsg.setAnotherName(bookCommonMsgReqBody.getAnotherName());
		commonmsg.setAuthorId(bookCommonMsgReqBody.getAuthorId());
		commonmsg.setBriefing(bookCommonMsgReqBody.getBriefing());
		commonmsg.setCatalog(bookCommonMsgReqBody.getCatalog());
		commonmsg.setName(bookCommonMsgReqBody.getName());
		commonmsg.setPageCnt(bookCommonMsgReqBody.getPageCnt());
		commonmsg.setReadOvertime(bookCommonMsgReqBody.getReadOvertime());
		commonmsg.setTranslatorId(bookCommonMsgReqBody.getTranslatorId());
		commonmsg.setBooktypeId(bookCommonMsgReqBody.getBooktypeId());
		return commonmsg;
	}

	
	
}

