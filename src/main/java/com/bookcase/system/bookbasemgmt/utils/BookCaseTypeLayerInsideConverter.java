/**
 * Project Name:book-basemgmt
 * File Name:BookCaseTypeLayerInsideConverter.java
 * Package Name:com.bookcase.system.bookbasemgmt.utils
 * Date:2017年5月10日上午7:25:15
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.utils;

import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseTypeLayerinside;
import com.bookcase.system.bookbasemgmt.dto.bookcasetypelayerinside.BookCaseTypeLayerInsideReqBody;
import com.bookcase.system.bookbasemgmt.otd.bookcasetypelayerinside.BookCaseTypeLayerInsideRspBody;

/**
 * ClassName:BookCaseTypeLayerInsideConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月10日 上午7:25:15 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookCaseTypeLayerInsideConverter {

	public static BookCaseTypeLayerInsideRspBody baseBookcaseTypeLayerinside2BookCaseTypeLayerInsideRspBody(
			BaseBookcaseTypeLayerinside baseBookcaseTypeLayerinside) {
		BookCaseTypeLayerInsideRspBody rspBody = new BookCaseTypeLayerInsideRspBody();
		rspBody.setId(baseBookcaseTypeLayerinside.getId());
		rspBody.setBoxX(baseBookcaseTypeLayerinside.getBoxX());
		rspBody.setBoxY(baseBookcaseTypeLayerinside.getBoxY());
		rspBody.setBoxZ(baseBookcaseTypeLayerinside.getBoxZ());
		rspBody.setBookCaseTypeId(baseBookcaseTypeLayerinside.getBookcaseTypeId());
		rspBody.setBookCaseLayerInsideSizeId(baseBookcaseTypeLayerinside.getBookcaseLayerinsidesizeId());
		rspBody.setCreator(baseBookcaseTypeLayerinside.getCreator());
		rspBody.setStatus(baseBookcaseTypeLayerinside.getStatus());
		rspBody.setCreateTime(baseBookcaseTypeLayerinside.getCreateTime());
		rspBody.setUpdateTime(baseBookcaseTypeLayerinside.getUpdateTime());
		rspBody.setOrgId(baseBookcaseTypeLayerinside.getOrgId());
		return rspBody;
	}

	public static BaseBookcaseTypeLayerinside bookCaseTypeLayerInsideReqBody2BaseBookcaseTypeLayerinside(
			BookCaseTypeLayerInsideReqBody bookCaseTypeLayerInsideReqBody) {
		BaseBookcaseTypeLayerinside layerinside = new BaseBookcaseTypeLayerinside();
		layerinside.setBoxX(bookCaseTypeLayerInsideReqBody.getBoxX());
		layerinside.setBoxY(bookCaseTypeLayerInsideReqBody.getBoxY());
		layerinside.setBoxZ(bookCaseTypeLayerInsideReqBody.getBoxZ());
		layerinside.setBookcaseLayerinsidesizeId(bookCaseTypeLayerInsideReqBody.getBookCaseLayerInsideSizeId());
		layerinside.setBookcaseTypeId(bookCaseTypeLayerInsideReqBody.getBookCaseTypeId());
		return layerinside;
	}

	
	
}

