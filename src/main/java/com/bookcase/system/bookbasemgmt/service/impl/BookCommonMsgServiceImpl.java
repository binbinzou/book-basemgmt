/**
 * Project Name:book-basemgmt
 * File Name:BookCommonMsgServiceImpl.java
 * Package Name:com.bookcase.system.bookbasemgmt.service.impl
 * Date:2017年5月24日下午8:54:38
 * Copyright (c) 2017, binbin.zou@hpe.com All Rights Reserved.
 *
*/

package com.bookcase.system.bookbasemgmt.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bookcase.common.bookcommon.contant.CommonResultCodeConstant;
import com.bookcase.common.system.bookframework.page.PageInfo;
import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtConstant;
import com.bookcase.system.bookbasemgmt.constant.BookBaseMgmtResultConstant;
import com.bookcase.system.bookbasemgmt.domain.BaseBookCommonmsg;
import com.bookcase.system.bookbasemgmt.domain.BaseBookauthor;
import com.bookcase.system.bookbasemgmt.dto.bookcommonmsg.BookCommonMsgReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcommonmsg.BookCommonMsgReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspBody;
import com.bookcase.system.bookbasemgmt.otd.bookauthor.BookAuthorRspQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcommonmsg.BookCommonMsgRspBody;
import com.bookcase.system.bookbasemgmt.repository.BaseBookCommonMsgRepository;
import com.bookcase.system.bookbasemgmt.service.BookCommonMsgService;
import com.bookcase.system.bookbasemgmt.utils.BookAuthorConverter;
import com.bookcase.system.bookbasemgmt.utils.BookCommonMsgConverter;

/**
 * ClassName:BookCommonMsgServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年5月24日 下午8:54:38 <br/>
 * @author   binbin
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Slf4j
public class BookCommonMsgServiceImpl implements BookCommonMsgService {

	@Autowired
	BaseBookCommonMsgRepository baseBookCommonMsgRepository;
	
	@Override
	public GeneralPagingResult<List<BookCommonMsgRspBody>> findBookCommonMsgs(BookAuthorRspQuery query,
			String page, String size) {
		GeneralPagingResult<List<BookCommonMsgRspBody>> result = new GeneralPagingResult<List<BookCommonMsgRspBody>>();
		List<BookCommonMsgRspBody> rspBodies = new ArrayList<BookCommonMsgRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		String name = query.getName();
		String orgId = "XXX";
		Page<BaseBookCommonmsg> pg = baseBookCommonMsgRepository
				.findBookCommonMsgs(name,orgId,request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (BaseBookCommonmsg bookCommonmsg : pg.getContent()) {
				rspBodies.add(BookCommonMsgConverter
								.bookCommonmsg2BookCommonMsgRspBody(bookCommonmsg));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookCommonMsgRspBody> findBookCommonMsgById(
			String bookCommonMsgId) {
		GeneralContentResult<BookCommonMsgRspBody> result = new GeneralContentResult<BookCommonMsgRspBody>();
		BaseBookCommonmsg bookCommonmsg = baseBookCommonMsgRepository.findOne(bookCommonMsgId);
		BookCommonMsgRspBody rspBody = BookCommonMsgConverter.bookCommonmsg2BookCommonMsgRspBody(bookCommonmsg);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookCommonMsg(
			BookCommonMsgReqBody bookCommonMsgReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		BaseBookCommonmsg bookCommonmsg = BookCommonMsgConverter.bookCommonMsgReqBody2BaseBookCommonmsg(bookCommonMsgReqBody);
		bookCommonmsg.setCreator("XXX");
		bookCommonmsg.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookCommonmsg = baseBookCommonMsgRepository.save(bookCommonmsg);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(bookCommonmsg.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookCommonMsg(String bookCommonMsgId,
			BookCommonMsgReqBody bookCommonMsgReqBody) {
		GeneralResult result = new GeneralResult();
		BaseBookCommonmsg tmp = baseBookCommonMsgRepository.findBookCommonMsgById(bookCommonMsgId);
		if(tmp==null){
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		BaseBookCommonmsg bookCommonmsg = BookCommonMsgConverter
				.bookCommonMsgReqBody2BaseBookCommonmsg(bookCommonMsgReqBody);
		bookCommonmsg.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		bookCommonmsg.setCreator("XXX");
		bookCommonmsg.setId(bookCommonMsgId);
		bookCommonmsg = baseBookCommonMsgRepository
				.save(bookCommonmsg);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookCommonMsgs(
			BookCommonMsgReqParam bookCommonMsgReqParam) {
		GeneralResult result = new GeneralResult();
		int size = bookCommonMsgReqParam.getIds().size();
		int tmpSize = 0;
		for(String id : bookCommonMsgReqParam.getIds()){
			int tmp = baseBookCommonMsgRepository.setStatusFor(BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, id);
			if(tmp>0){
				tmpSize++;
			}
		}
		if(size==tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("删除成功");
		}else if(size>tmpSize){
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("部分数据删除成功");
		}else if(tmpSize==0){
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("删除失败");
		}
		return result;
	}

	@Override
	public GeneralContentResult<List<BookCommonMsgRspBody>> findBookCommonMsgByName(
			String name) {
		GeneralContentResult<List<BookCommonMsgRspBody>> result = new GeneralContentResult<List<BookCommonMsgRspBody>>();
		List<BookCommonMsgRspBody> rspBodies = new ArrayList<BookCommonMsgRspBody>();
		String orgId = "XXX";
		List<BaseBookCommonmsg> commonmsgs = baseBookCommonMsgRepository.findBookCommonMsgByName(name,orgId);
		for(BaseBookCommonmsg bookCommonmsg : commonmsgs){
			rspBodies.add(BookCommonMsgConverter.bookCommonmsg2BookCommonMsgRspBody(bookCommonmsg));
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBodies);
		return result;
	}

}

