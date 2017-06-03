package com.bookcase.system.bookbasemgmt.service;

import java.util.List;

import com.bookcase.common.system.bookframework.returnresult.GeneralContentResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralPagingResult;
import com.bookcase.common.system.bookframework.returnresult.GeneralResult;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqBody;
import com.bookcase.system.bookbasemgmt.dto.bookcaselayerinsidesize.BookCaseLayerInsideSizeReqParam;
import com.bookcase.system.bookbasemgmt.otd.bookcaselayerinsidesize.BookCaseLayerInsideSizeRspBody;

public interface BookCaseLayerInsideSizeService {

	GeneralPagingResult<List<BookCaseLayerInsideSizeRspBody>> findBookCaseLayerInsideSizes(String page, String size);

	GeneralContentResult<BookCaseLayerInsideSizeRspBody> findBookCaseLayerInsideSizeById(
			String bookCaseLayerInsideSizeId);

	GeneralContentResult<String> createBookCaseLayerInsideSize(
			BookCaseLayerInsideSizeReqBody bookCaseLayerInsideSizeReqBody);

	GeneralResult updateBookCaseLayerInsideSize(
			String bookCaseLayerInsideSizeId,
			BookCaseLayerInsideSizeReqBody bookCaseLayerInsideSizeReqBody);

	GeneralResult deleteBookCaseLayerInsideSizes(
			BookCaseLayerInsideSizeReqParam bookCaseLayerInsideSizeReqParam);

}