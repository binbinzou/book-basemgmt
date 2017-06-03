/**
 * Project Name:book-basemgmt
 * File Name:BookTypeConverter.java
 * Package Name:com.bookcase.system.bookbasemgmt.utils
 * Date:2017年6月3日下午2:50:01
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.utils;

import com.bookcase.system.bookbasemgmt.domain.BaseBooktype;
import com.bookcase.system.bookbasemgmt.dto.booktype.BookTypeReqBody;
import com.bookcase.system.bookbasemgmt.otd.booktype.BookTypeRspBody;

/**
 * ClassName:BookTypeConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午2:50:01 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookTypeConverter {

	public static BookTypeRspBody booktype2BookBookTypeRspBody(
			BaseBooktype booktype) {
		BookTypeRspBody rspBody = new BookTypeRspBody();
		rspBody.setCreateTime(booktype.getCreateTime());
		rspBody.setCreator(booktype.getCreator());
		rspBody.setId(booktype.getId());
		rspBody.setName(booktype.getName());
		rspBody.setPid(booktype.getPid());
		rspBody.setStatus(booktype.getStatus());
		rspBody.setUpdateTime(booktype.getUpdateTime());
		return rspBody;
	}

	public static BaseBooktype bookTypeReqBody2BaseBooktype(
			BookTypeReqBody bookTypeReqBody) {
		BaseBooktype booktype = new BaseBooktype();
		booktype.setId(bookTypeReqBody.getId());
		booktype.setName(bookTypeReqBody.getName());
		booktype.setPid(bookTypeReqBody.getPid());
		return booktype;
	}
	

}

