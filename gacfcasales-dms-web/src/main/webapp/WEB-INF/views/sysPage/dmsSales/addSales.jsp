<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="addSalesApp" v-cloak>
	<input type="text" id="saleOrderId" name="saleOrderId"
		value="${requestScope.dmsSalesDto.saleOrderId}" hidden="hidden" /> <input
		type="text" id="employeeName" name="employeeName"
		value="${requestScope.dmsSalesDto.employeeName}" hidden="hidden" /> <input
		type="text" id="brandCode" name="brandCode"
		value="${requestScope.dmsSalesDto.BRAND}" hidden="hidden" /> <input
		type="text" id="seriesCode" name="seriesCode"
		value="${requestScope.dmsSalesDto.SERIES}" hidden="hidden" /> <input
		type="text" id="modelCode" name="modelCode"
		value="${requestScope.dmsSalesDto.MODEL}" hidden="hidden" /> <input
		type="text" id="apackageCode" name="apackageCode"
		value="${requestScope.dmsSalesDto.APACKAGE}" hidden="hidden" /> <input
		type="text" id="brandName" name="brandName"
		value="${requestScope.dmsSalesDto.BRAND_NAME}" hidden="hidden" /> <input
		type="text" id="seriesName" name="seriesName"
		value="${requestScope.dmsSalesDto.SERIES_NAME}" hidden="hidden" /> <input
		type="text" id="modelName" name="modelName" value="" hidden="hidden" />
	<input type="text" id="apackageName" name="apackageName" value=""
		hidden="hidden" /> <input type="text" id="productId" name="productId"
		value="" hidden="hidden" /> <input type="text" id="liceseNo"
		name="liceseNo" value="" hidden="hidden" /> <input type="text"
		id="rBrandId" name="rBrandId"
		value="${requestScope.dmsSalesDto.BRAND_ID}" hidden="hidden" /> <input
		type="text" id="rSeriesId" name="rSeriesId"
		value="${requestScope.dmsSalesDto.SERIES_ID}" hidden="hidden" /> <input
		type="text" id="rModelId" name="rModelId"
		value="${requestScope.dmsSalesDto.MODEL_ID}" hidden="hidden" /> <input
		type="text" id="rApackageId" name="rApackageId"
		value="${requestScope.dmsSalesDto.APACKAGE_ID}" hidden="hidden" /> <input
		type="text" id="nonTaxCostPrice" name="nonTaxCostPrice"
		value="${requestScope.dmsSalesDto.NON_TAX_COST_PRICE}" hidden="hidden" />
	<input type="text" id="taxCostPrice" name="taxCostPrice"
		value="${requestScope.dmsSalesDto.TAX_COST_PRICE}" hidden="hidden" />



	<div v-show="showList" class="dms-search">
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">延长服务销售单信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">销售单编号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="salesOrder" id="salesOrder"
										value="${requestScope.dmsSalesDto.saleOrderId}"
										placeholder="" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">创建人</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="createdBy" id="createdBy"
										value="${requestScope.dmsSalesDto.employeeName}"
										placeholder="" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">创建时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="createAt" id="createAt"
										value="${requestScope.dmsSalesDto.createAt}"
										placeholder="" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">客户姓名</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="customerName"
										id="customerName" value="" placeholder="请输入客户姓名" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">联系方式</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="customerContact"
										id="customerContact" value="" placeholder="请输入联系方式" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">单据状态</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="orderStatus" id="orderStatus" value=""
										placeholder="" />
								</div>
							</div>
						</div>


					</div>


					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">车主车辆信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">VIN</label>
								<div class="col-xs-7">
									<div class="input-group">
										<div class="input-icon-group">
											<input type="text" class="form-control" name="vin" id="vin" disabled="disabled"
												value="${requestScope.dmsSalesDto.VIN}" placeholder="" />
										</div>
										<span class="input-group-btn" style="height: 34px;">
											<button class="btn btn-primary" type="button"
												onclick="queryVin()" style="height: 34px;">
												<i class="glyphicon glyphicon-search"></i>
											</button>
										</span>
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">品牌</label>
								<div class="col-xs-7">
									<select name="brandId" id="brandId"
										class="bs-select form-control" disabled="disabled"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车系</label>
								<div class="col-xs-7">
									<select name="seriesId" id="seriesId"
										class="bs-select form-control" disabled="disabled"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车型</label>
								<div class="col-xs-6">
									<select name="modelId" id="modelId" disabled="disabled"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">配置</label>
								<div class="col-xs-7">
									<select name="apackage" id="apackage" disabled="disabled"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">年款</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="yearModel" disabled="disabled"
										id="yearModel" value="${requestScope.dmsSalesDto.YEAR_MODEL}"
										placeholder="" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">开票日期</label>
								<div class="col-xs-6">
									<input id="billingAt" name="billingAt" type="text"
										class="form-control"
										value="${requestScope.dmsSalesDto.INVOICE_DATE}"
										placeholder="请输入开票日期" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主编号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerNo"
										disabled="disabled" id="ownerNo"
										value="${requestScope.dmsSalesDto.OWNER_NO}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主电话</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerPhone"
										disabled="disabled" id="ownerPhone"
										value="${requestScope.dmsSalesDto.PHONE}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主姓名</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerName"
										disabled="disabled" id="ownerName"
										value="${requestScope.dmsSalesDto.OWNER_NAME}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主手机</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerMobile"
										disabled="disabled" id="ownerMobile"
										value="${requestScope.dmsSalesDto.MOBILE}"
										placeholder="" />
								</div>
							</div>
						</div>



					</div>
					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">延长服务产品信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品编号</label>
								<div class="col-xs-7">
									<div class="input-group">
										<div class="input-icon-group">
											<input type="text" class="form-control" name="productNo"
												 id="productNo" disabled="disabled"
												value="${requestScope.dmsSalesDto.PRODUCT_NO}"
												placeholder="" />
										</div>
										<span class="input-group-btn" style="height: 34px;">
											<button class="btn btn-primary" type="button"
												onclick="addProduct();" style="height: 34px;">
												<i class="glyphicon glyphicon-search"></i>
											</button>
										</span>
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品名称</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productName"
										disabled="disabled" id="productName"
										value="${requestScope.dmsSalesDto.PRODUCT_NAME}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品有效期</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productDate"
										disabled="disabled" id="productDate"
										value="${requestScope.dmsSalesDto.PRODUCT_DATE}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品说明</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productDate"
										disabled="disabled" id="productDate"
										value="${requestScope.dmsSalesDto.PRODUCT_DESCRIBTION}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">终端不含税销售价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control"
										name="terminalNonSalesPrice" id="terminalNonSalesPrice"
										disabled="disabled"
										value="${requestScope.dmsSalesDto.TERMINAL_NON_SALES_PRICE}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">终端含税销售价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="terminalSalesPrice" id="terminalSalesPrice"
										value="${requestScope.dmsSalesDto.TERMINAL_SALES_PRICE}"
										placeholder="" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">生效开始时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="takeEffectStart"
										id="takeEffectStart" disabled="disabled"
										value="${requestScope.dmsSalesDto.SALES_DATE_START}"
										placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">生效结束时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="takeEffectEnd"
										id="takeEffectEnd" disabled="disabled"
										value="${requestScope.dmsSalesDto.SALES_DATE_END}"
										placeholder="" />
								</div>
							</div>
						</div>


					</div>
					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">购买信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">购买数量</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="purchaseNumber"
										disabled="disabled" id="purchaseNumber" value="1"
										placeholder="" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">实际不含税销售价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control"
										name="actualNonSalesPrice" id="actualNonSalesPrice"
										onkeyup="taxSales()"
										value="${requestScope.dmsSalesDto.ACTUAL_NON_SALES_PRICE}"
										placeholder="请输入实际不含税销售价" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">含税总额(6%)</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="totalAmount"
										disabled="disabled" id="totalAmount"
										value="${requestScope.dmsSalesDto.TOTAL_AMOUNT}"
										placeholder="" />
								</div>
							</div>
						</div>


					</div>
					<div class="row">
						<div class="col-xs-12 ">
							<div class="query-btn">
							<button id="btn_save" type="button"
									class="btn btn-primary btn-sm" onclick="save()">
									<span class="glyphicon glyphicon-film" aria-hidden="true"></span>
									保存
								</button>
								<!-- <button id="btn_submit" type="button" disabled="disabled"
									class="btn btn-primary btn-sm" onclick="submitASC()">
									<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
									提交
								</button>
								<button id="btn_print" type="button" disabled="disabled"
									class="btn btn-primary btn-sm" onclick="print()">
									<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
									打印
								</button> -->
								<button id="btn_reset" type="button"
									class="btn btn-primary btn-sm" onclick="resetASC()">
									<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>&nbsp;&nbsp;返回
								</button>
							
							</div>
						</div>

					</div>


				</div>
			</div>
		</form>


	</div>

</div>
<link rel="stylesheet"
	href="${ctx}/resource/plugins/toastr/toastr.min.css">
<script src="${ctx }/resource/plugins/toastr/toastr.min.js"></script>
<script src="${ctx}/resource/js/sysPage/dmsSales/addSales.js"></script>


<script type="text/javascript">
	toastr.options = {
		closeButton : false,
		debug : false,
		progressBar : true,
		positionClass : "toast-top-center",
		onclick : null,
		showDuration : "300",
		hideDuration : "1000",
		timeOut : "2000",
		extendedTimeOut : "1000",
		showEasing : "swing",
		hideEasing : "linear",
		showMethod : "fadeIn",
		hideMethod : "fadeOut"
	};
</script>