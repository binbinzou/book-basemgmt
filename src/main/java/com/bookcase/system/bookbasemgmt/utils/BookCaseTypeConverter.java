/**
 * Project Name:book-basemgmt
 * File Name:BookCaseTypeConverter.java
 * Package Name:com.bookcase.system.bookbasemgmt.utils
 * Date:2017年5月8日下午10:32:54
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.utils;

import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseType;
import com.bookcase.system.bookbasemgmt.dto.bookcasetype.BookCaseTypeReqBody;
import com.bookcase.system.bookbasemgmt.otd.bookcasetype.BookCaseTypeRspBody;

/**
 * ClassName:BookCaseTypeConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月8日 下午10:32:54 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookCaseTypeConverter {

	public static BaseBookcaseType bookCaseTypeReqBody2BaseBookcaseType(BookCaseTypeReqBody bookCaseTypeReqBody){
		BaseBookcaseType type = new BaseBookcaseType();
		type.setName(bookCaseTypeReqBody.getName());
		type.setLength(bookCaseTypeReqBody.getLength());
		type.setWide(bookCaseTypeReqBody.getWide());
		type.setHeight(bookCaseTypeReqBody.getHeight());
		type.setBoxCount(bookCaseTypeReqBody.getBoxCount());
		return type;
	}
	
	public static BookCaseTypeRspBody baseBookcaseType2BookCaseTypeRspBody(BaseBookcaseType baseBookcaseType){
		BookCaseTypeRspBody rspBody = new BookCaseTypeRspBody();
		rspBody.setId(baseBookcaseType.getId());
		rspBody.setName(baseBookcaseType.getName());
		rspBody.setBoxCount(baseBookcaseType.getBoxCount());
		rspBody.setLength(baseBookcaseType.getLength());
		rspBody.setWide(baseBookcaseType.getWide());
		rspBody.setHeight(baseBookcaseType.getHeight());
		rspBody.setCreator(baseBookcaseType.getCreator());
		rspBody.setOrgId(baseBookcaseType.getOrgId());
		rspBody.setStatus(baseBookcaseType.getStatus());
		rspBody.setCreateTime(baseBookcaseType.getCreateTime());
		rspBody.setUpdateTime(baseBookcaseType.getUpdateTime());
		return rspBody;
	}
	
}

