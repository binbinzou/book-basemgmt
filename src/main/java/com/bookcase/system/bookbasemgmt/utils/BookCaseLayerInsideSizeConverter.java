/**
 * Project Name:book-basemgmt
 * File Name:BookCaseLayerInsideSizeConverter.java
 * Package Name:com.bookcase.system.bookbasemgmt.utils
 * Date:2017年5月7日下午4:50:38
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
 */

package com.bookcase.system.bookbasemgmt.utils;

import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseLayerinsidesize;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqBody;
import com.bookcase.system.bookbasemgmt.otd.bookcaselayerinsidesize.BookCaseLayerInsideSizeRspBody;

/**
 * ClassName:BookCaseLayerInsideSizeConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年5月7日 下午4:50:38 <br/>
 * 
 * @author binbin
 * @version
 * @since JDK 1.8
 * @see
 */
public class BookCaseLayerInsideSizeConverter {

	public static BaseBookcaseLayerinsidesize bookCaseLayerInsideSizeReqBody2BaseBookcaseLayerinsidesize(
			BookCaseLayerInsideSizeReqBody reqBody) {
		BaseBookcaseLayerinsidesize layerinsidesize = new BaseBookcaseLayerinsidesize();
		layerinsidesize.setName(reqBody.getName());
		layerinsidesize.setLength(reqBody.getLength());
		layerinsidesize.setWide(reqBody.getWide());
		layerinsidesize.setHeight(reqBody.getHeight());
		layerinsidesize.setBookHeightlimit(reqBody.getBookHeight());
		layerinsidesize.setBookLenghtlimit(reqBody.getBookLength());
		layerinsidesize.setBookWidelimit(reqBody.getBookWide());
		return layerinsidesize;
	}

	public static BookCaseLayerInsideSizeRspBody baseBookcaseLayerinsidesize2BookCaseLayerInsideSizeRspBody(
			BaseBookcaseLayerinsidesize layerinsidesize) {
		BookCaseLayerInsideSizeRspBody rspBody = new BookCaseLayerInsideSizeRspBody();
		rspBody.setId(layerinsidesize.getId());
		rspBody.setName(layerinsidesize.getName());
		rspBody.setLength(layerinsidesize.getLength());
		rspBody.setWide(layerinsidesize.getWide());
		rspBody.setHeight(layerinsidesize.getHeight());
		rspBody.setBookLenghtlimit(layerinsidesize.getBookLenghtlimit());
		rspBody.setBookHeightlimit(layerinsidesize.getBookHeightlimit());
		rspBody.setBookWidelimit(layerinsidesize.getBookWidelimit());
		rspBody.setOrgId(layerinsidesize.getOrgId());
		rspBody.setStatus(layerinsidesize.getStatus());
		rspBody.setCreator(layerinsidesize.getCreator());
		rspBody.setCreateTime(layerinsidesize.getCreateTime());
		rspBody.setUpdateTime(layerinsidesize.getUpdateTime());
		return rspBody;
	}

}
