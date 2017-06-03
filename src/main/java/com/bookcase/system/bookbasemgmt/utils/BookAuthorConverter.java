/**
 * Project Name:book-basemgmt
 * File Name:BookAuthorConverter.java
 * Package Name:com.bookcase.system.bookbasemgmt.utils
 * Date:2017年6月3日下午1:25:01
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.utils;

import com.bookcase.system.bookbasemgmt.domain.BaseBookauthor;
import com.bookcase.system.bookbasemgmt.dto.bookauthor.BookAuthorReqBody;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;

/**
 * ClassName:BookAuthorConverter <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年6月3日 下午1:25:01 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class BookAuthorConverter {

	public static BookAuthorRspBody baseBookauthor2BookAuthorRspBody(
			BaseBookauthor baseBookauthor) {
		BookAuthorRspBody rspBody = new BookAuthorRspBody();
		rspBody.setId(baseBookauthor.getId());
		rspBody.setName(baseBookauthor.getName());
		rspBody.setAnotherName(baseBookauthor.getAnotherName());
		rspBody.setBirthday(baseBookauthor.getBirthday());
		rspBody.setCreateTime(baseBookauthor.getCreateTime());
		rspBody.setCreator(baseBookauthor.getCreator());
		rspBody.setDescription(baseBookauthor.getDescription());
		rspBody.setNationality(baseBookauthor.getNationality());
		rspBody.setPenName(baseBookauthor.getPenName());
		rspBody.setStatus(baseBookauthor.getStatus());
		rspBody.setUpdateTime(baseBookauthor.getUpdateTime());
		return rspBody;
	}

	public static BaseBookauthor bookAuthorReqBody2BaseBookauthor(
			BookAuthorReqBody bookAuthorReqBody) {
		BaseBookauthor bookauthor = new BaseBookauthor();
		bookauthor.setAnotherName(bookAuthorReqBody.getAnotherName());
		bookauthor.setBirthday(bookAuthorReqBody.getBirthday());
		bookauthor.setDescription(bookAuthorReqBody.getDescription());
		bookauthor.setName(bookAuthorReqBody.getName());
		bookauthor.setNationality(bookAuthorReqBody.getNationality());
		bookauthor.setPenName(bookAuthorReqBody.getPenName());
		return bookauthor;
	}

}

