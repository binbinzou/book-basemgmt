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
import com.bookcase.system.bookbasemgmt.domain.BaseBookcaseLayerinsidesize;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqParam;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqQuery;
import com.bookcase.system.bookbasemgmt.otd.bookcaselayerinsidesize.BookCaseLayerInsideSizeRspBody;
import com.bookcase.system.bookbasemgmt.repository.BaseBookcaseLayerinsidesizeRepository;
import com.bookcase.system.bookbasemgmt.service.BookCaseLayerInsideSizeService;
import com.bookcase.system.bookbasemgmt.utils.BookCaseLayerInsideSizeConverter;

@Service
@Slf4j
public class BookCaseLayerInsideSizeServiceImpl implements
		BookCaseLayerInsideSizeService {

	@Autowired
	BaseBookcaseLayerinsidesizeRepository baseBookcaseLayerinsidesizeRepository;

	@Override
	public GeneralPagingResult<List<BookCaseLayerInsideSizeRspBody>> findBookCaseLayerInsideSizes(
			BookCaseLayerInsideSizeReqQuery query, String page, String size) {
		GeneralPagingResult<List<BookCaseLayerInsideSizeRspBody>> result = new GeneralPagingResult<List<BookCaseLayerInsideSizeRspBody>>();
		List<BookCaseLayerInsideSizeRspBody> rspBodies = new ArrayList<BookCaseLayerInsideSizeRspBody>();
		PageRequest request = new PageRequest(Integer.parseInt(page) - 1,
				Integer.parseInt(size));
		String name = query.getName();
		String orgId = "XXX";
		Page<BaseBookcaseLayerinsidesize> pg = baseBookcaseLayerinsidesizeRepository
				.findBookCaseLayerInsideSizes(name,orgId,request);
		PageInfo pageInfo = new PageInfo();
		if (pg != null && pg.getContent().size() > 0) {
			pageInfo.setPage(pg.getNumber() + 1);
			pageInfo.setCount(Integer.parseInt(size));
			pageInfo.setTotalcount((int) pg.getTotalElements());
			pageInfo.setTotalpage(pg.getTotalPages());
			for (BaseBookcaseLayerinsidesize layerinsidesize : pg.getContent()) {
				rspBodies
						.add(BookCaseLayerInsideSizeConverter
								.baseBookcaseLayerinsidesize2BookCaseLayerInsideSizeRspBody(layerinsidesize));
			}
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询一栏成功");
		result.setPageInfo(pageInfo);
		result.setContent(rspBodies);
		return result;
	}

	@Override
	public GeneralContentResult<BookCaseLayerInsideSizeRspBody> findBookCaseLayerInsideSizeById(
			String bookCaseLayerInsideSizeId) {
		GeneralContentResult<BookCaseLayerInsideSizeRspBody> result = new GeneralContentResult<BookCaseLayerInsideSizeRspBody>();
		BaseBookcaseLayerinsidesize layerinsidesize = baseBookcaseLayerinsidesizeRepository
				.findOne(bookCaseLayerInsideSizeId);
		BookCaseLayerInsideSizeRspBody rspBody = BookCaseLayerInsideSizeConverter
				.baseBookcaseLayerinsidesize2BookCaseLayerInsideSizeRspBody(layerinsidesize);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBody);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralContentResult<String> createBookCaseLayerInsideSize(
			BookCaseLayerInsideSizeReqBody bookCaseLayerInsideSizeReqBody) {
		GeneralContentResult<String> result = new GeneralContentResult<String>();
		BaseBookcaseLayerinsidesize layerinsidesize = BookCaseLayerInsideSizeConverter
				.bookCaseLayerInsideSizeReqBody2BaseBookcaseLayerinsidesize(bookCaseLayerInsideSizeReqBody);
		layerinsidesize.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		layerinsidesize.setCreator("XXX");
		layerinsidesize.setOrgId("XXX");
		layerinsidesize = baseBookcaseLayerinsidesizeRepository
				.save(layerinsidesize);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("新增成功");
		result.setContent(layerinsidesize.getId());
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult updateBookCaseLayerInsideSize(
			String bookCaseLayerInsideSizeId,
			BookCaseLayerInsideSizeReqBody bookCaseLayerInsideSizeReqBody) {
		GeneralResult result = new GeneralResult();
		BaseBookcaseLayerinsidesize tmp = baseBookcaseLayerinsidesizeRepository
				.findBaseBookcaseLayerinsidesizeById(bookCaseLayerInsideSizeId);
		if (tmp == null) {
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("该更新数据不存在");
			return result;
		}
		BaseBookcaseLayerinsidesize layerinsidesize = BookCaseLayerInsideSizeConverter
				.bookCaseLayerInsideSizeReqBody2BaseBookcaseLayerinsidesize(bookCaseLayerInsideSizeReqBody);
		layerinsidesize.setStatus(BookBaseMgmtConstant.STATUS_GLOBAL_ENABLE);
		layerinsidesize.setCreator("XXX");
		layerinsidesize.setOrgId("XXX");
		layerinsidesize.setId(bookCaseLayerInsideSizeId);
		layerinsidesize = baseBookcaseLayerinsidesizeRepository
				.save(layerinsidesize);
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("更新成功");
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public GeneralResult deleteBookCaseLayerInsideSizes(
			String bookCaseLayerInsideSizeId) {
		GeneralResult result = new GeneralResult();
		int tmp = baseBookcaseLayerinsidesizeRepository.setStatusFor(
				BookBaseMgmtConstant.STATUS_GLOBAL_DELETED, bookCaseLayerInsideSizeId);
		if (1 == tmp) {
			result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
			result.setMessage("删除成功");
		} else {
			result.setCode(BookBaseMgmtResultConstant.BOOKBASEMGMT_UNKNOW_ERROR);
			result.setMessage("删除失败");
		}
		return result;
	}

	@Override
	public GeneralContentResult<List<BookCaseLayerInsideSizeRspBody>> findBookCaseLayerInsideSizeByName(
			String name) {
		GeneralContentResult<List<BookCaseLayerInsideSizeRspBody>> result = new GeneralContentResult<List<BookCaseLayerInsideSizeRspBody>>();
		String orgId = "XXX";
		List<BookCaseLayerInsideSizeRspBody> rspBodies = new ArrayList<BookCaseLayerInsideSizeRspBody>();
		List<BaseBookcaseLayerinsidesize> layerinsidesizes = baseBookcaseLayerinsidesizeRepository.findBookCaseLayerInsideSizesByName(name,orgId);
		for (BaseBookcaseLayerinsidesize layerinsidesize : layerinsidesizes) {
			rspBodies.add(BookCaseLayerInsideSizeConverter
							.baseBookcaseLayerinsidesize2BookCaseLayerInsideSizeRspBody(layerinsidesize));
		}
		result.setCode(CommonResultCodeConstant.OPERATE_SUCCESS);
		result.setMessage("查询成功");
		result.setContent(rspBodies);
		return result;
	}

}
