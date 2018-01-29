<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="editSalesApp" v-cloak>

	<input type="text" id="rtbrandId" name="rtbrandId"
		value="${requestScope.ttOpiExtendedSales.BRAND_ID}" hidden="hidden" />
	<input type="text" id="rtbrandName" name="rtbrandName"
		value="${requestScope.ttOpiExtendedSales.BRAND_NAME}" hidden="hidden" />
	<input type="text" id="rtbrandCode" name="rtbrandCode"
		value="${requestScope.ttOpiExtendedSales.BRAND_CODE}" hidden="hidden" />
	<input type="text" id="rtseriesId" name="rtseriesId"
		value="${requestScope.ttOpiExtendedSales.SERIES_ID}" hidden="hidden" />
	<input type="text" id="rtseriesName" name="rtseriesName"
		value="${requestScope.ttOpiExtendedSales.SERIES_NAME}" hidden="hidden" />
	<input type="text" id="rtseriesCode" name="rtseriesCode"
		value="${requestScope.ttOpiExtendedSales.SERIES_CODE}" hidden="hidden" />
	<input type="text" id="rtmodelId" name="rtmodelId"
		value="${requestScope.ttOpiExtendedSales.MODEL_ID}" hidden="hidden" />
	<input type="text" id="rtmodelName" name="rtmodelName"
		value="${requestScope.ttOpiExtendedSales.MODEL_NAME}" hidden="hidden" />
	<input type="text" id="rtmodelCode" name="rtmodelCode"
		value="${requestScope.ttOpiExtendedSales.MODEL_CODE}" hidden="hidden" />
	<input type="text" id="rtapackageId" name="rtapackageId"
		value="${requestScope.ttOpiExtendedSales.APACKAGE_ID}" hidden="hidden" />
	<input type="text" id="rtapackage" name="rtapackage"
		value="${requestScope.ttOpiExtendedSales.APACKAGE}" hidden="hidden" />
	<input type="text" id="rtapackageName" name="rtapackageName"
		value="${requestScope.ttOpiExtendedSales.APACKAGE_NAME}"
		hidden="hidden" /> <input type="text" id="productSalesId"
		name="productSalesId"
		value="${requestScope.ttOpiExtendedSales.PRODUCT_SALES_ID}"
		hidden="hidden" /> <input type="text" id="saleOrderId"
		name="saleOrderId" value="${requestScope.dmsSalesDto.saleOrderId}"
		hidden="hidden" /> <input type="text" id="employeeName"
		name="employeeName" value="${requestScope.dmsSalesDto.employeeName}"
		hidden="hidden" /> <input type="text" id="brandCode" name="brandCode"
		value="${requestScope.ttOpiExtendedSales.BRAND_CODE}" hidden="hidden" />
	<input type="text" id="seriesCode" name="seriesCode"
		value="${requestScope.ttOpiExtendedSales.SERIES_CODE}" hidden="hidden" />
	<input type="text" id="modelCode" name="modelCode"
		value="${requestScope.ttOpiExtendedSales.MODEL_CODE}" hidden="hidden" />
	<input type="text" id="apackageCode" name="apackageCode"
		value="${requestScope.ttOpiExtendedSales.APACKAGE}" hidden="hidden" />

	<input type="text" id="brandName" name="brandName"
		value="${requestScope.ttOpiExtendedSales.BRAND_NAME}" hidden="hidden" />
	<input type="text" id="seriesName" name="seriesName"
		value="${requestScope.ttOpiExtendedSales.SERIES_NAME}" hidden="hidden" />
	<input type="text" id="modelName" name="modelName"
		value="${requestScope.ttOpiExtendedSales.MODEL_NAME}" hidden="hidden" />
	<input type="text" id="apackageName" name="apackageName"
		value="${requestScope.ttOpiExtendedSales.APACKAGE_NAME}"
		hidden="hidden" /> <input type="text" id="productId" name="productId"
		value="${requestScope.ttOpiExtendedSales.PRODUCT_ID}" hidden="hidden" />
	<input type="text" id="liceseNo" name="liceseNo"
		value="${requestScope.ttOpiExtendedSales.LICENSE_NO}" hidden="hidden" />


	<input type="text" id="rBrandId" name="rBrandId"
		value="${requestScope.dmsSalesDto.BRAND_ID}" hidden="hidden" /> <input
		type="text" id="rSeriesId" name="rSeriesId"
		value="${requestScope.dmsSalesDto.SERIES_ID}" hidden="hidden" /> <input
		type="text" id="rModelId" name="rModelId"
		value="${requestScope.dmsSalesDto.MODEL_ID}" hidden="hidden" /> <input
		type="text" id="rApackageId" name="rApackageId"
		value="${requestScope.dmsSalesDto.APACKAGE_ID}" hidden="hidden" />



	<div v-show="showList" class="dms-search">
		<form class="form-horizontal">
			<input type="text" id="productSalesId" name="productSalesId"
				value="${requestScope.ttOpiExtendedSales.PRODUCT_SALES_ID}"
				hidden="hidden" />
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
										value="${requestScope.ttOpiExtendedSales.PRODUCT_SALES_ORDER}"
										placeholder="请输入销售单编号" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">创建人</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="createdBy" id="createdBy"
										value="${requestScope.ttOpiExtendedSales.CREATE_NAME}"
										placeholder="请输入创建人" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">创建时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="createAt" id="createAt"
										value="${requestScope.ttOpiExtendedSales.CREATED_AT}"
										placeholder="请输入创建人" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">客户姓名</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="customerName"
										id="customerName"
										value="${requestScope.ttOpiExtendedSales.CUSTOMER_NAME}"
										placeholder="请输入客户姓名" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">联系方式</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="customerContact"
										id="customerContact"
										value="${requestScope.ttOpiExtendedSales.CUSTOMER_CONTACT}"
										placeholder="请输入联系方式" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">单据状态</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="orderStatus" id="orderStatus"
										value="${requestScope.ttOpiExtendedSales.ORDER_STATUS}"
										placeholder="请输入单据状态" />
								</div>
							</div>
						</div>


					</div>


					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">车主车辆信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-3 ">VIN</label>
								<div class="col-xs-7">
									<div class="input-group">
										<div class="input-icon-group">
											<input type="text" class="form-control" name="vin" id="vin"
												value="${requestScope.ttOpiExtendedSales.VIN}"
												placeholder="请输入VIN" />
										</div>
										<span class="input-group-btn" style="height: 30px;">
											<button class="btn btn-primary" type="button"
												onclick="queryVin()" style="height: 30px;">
												<i class="glyphicon glyphicon-search"></i>
											</button>
										</span>
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-3 ">品牌</label>
								<div class="col-xs-7">
									<select name="brandId" id="brandId"
										class="bs-select form-control" disabled="disabled"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-3 ">车系</label>
								<div class="col-xs-7">
									<select name="seriesId" id="seriesId"
										class="bs-select form-control" disabled="disabled"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 ">
							<div class="form-group">
								<label class="control-label col-xs-3 ">车型</label>
								<div class="col-xs-8">
									<select name="modelId" id="modelId" disabled="disabled"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-3 ">配置</label>
								<div class="col-xs-6">
									<select name="apackage" id="apackage" disabled="disabled"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-3 ">年款</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="yearModel"
										id="yearModel"
										value="${requestScope.ttOpiExtendedSales.YEAR_MODEL}"
										placeholder="请输入年款" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4 ">开票日期</label>
								<div class="col-xs-6">
									<input id="billingAt" name="billingAt" type="text"
										class="form-control"
										value="${requestScope.ttOpiExtendedSales.BILLING_AT}"
										placeholder="请输入开票日期" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主编号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerNo"
										disabled="disabled" id="ownerNo"
										value="${requestScope.ttOpiExtendedSales.OWNER_NO}"
										placeholder="请输入车主编号" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主电话</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerPhone"
										disabled="disabled" id="ownerPhone"
										value="${requestScope.ttOpiExtendedSales.OWNER_PHONE}"
										placeholder="请输入车主电话" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主姓名</label>
								<div class="col-xs-6">
									<input type="text" class="form-control" name="ownerName"
										disabled="disabled" id="ownerName"
										value="${requestScope.ttOpiExtendedSales.OWNER_NAME}"
										placeholder="请输入车主姓名" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主手机</label>
								<div class="col-xs-6">
									<input type="text" class="form-control" name="ownerMobile"
										disabled="disabled" id="ownerMobile"
										value="${requestScope.ttOpiExtendedSales.OWNER_MOBILE}"
										placeholder="请输入车主手机" />
								</div>
							</div>
						</div>



					</div>
					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">延长服务产品信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6  col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-3 ">产品编号</label>
								<div class="col-xs-7">
									<div class="input-group">
										<div class="input-icon-group">
											<input type="text" class="form-control" name="productNo"
												disabled="disabled" id="productNo"
												value="${requestScope.ttOpiExtendedSales.PRODUCT_NO}"
												placeholder="请输入产品编号" />
										</div>
										<span class="input-group-btn" style="height: 30px;">
											<button class="btn btn-primary" type="button"
												onclick="addProduct();" style="height: 30px;">
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
										value="${requestScope.ttOpiExtendedSales.PRODUCT_NAME}"
										placeholder="请输入车主手机" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品有效期</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productDate"
										disabled="disabled" id="productDate"
										value="${requestScope.ttOpiExtendedSales.PRODUCT_DATE}"
										placeholder="请输入产品有效期" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品说明</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productDate"
										disabled="disabled" id="productDate"
										value="${requestScope.requestScope.ttOpiExtendedSales.PRODUCT_DESCRIBTION}"
										placeholder="请输入产品有效期" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-6 ">终端不含税销售价</label>
								<div class="col-xs-6">
									<input type="text" class="form-control"
										name="terminalNonSalesPrice" id="terminalNonSalesPrice"
										disabled="disabled"
										value="${requestScope.ttOpiExtendedSales.TERMINAL_NON_SALES_PRICE}"
										placeholder="请输入终端不含税销售价" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-6 ">终端含税销售价</label>
								<div class="col-xs-6">
									<input type="text" class="form-control" disabled="disabled"
										name="terminalSalesPrice" id="terminalSalesPrice"
										value="${requestScope.ttOpiExtendedSales.TERMINAL_SALES_PRICE}"
										placeholder="请输入终端含税销售价" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">生效开始时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="takeEffectStart"
										id="takeEffectStart"
										value="${requestScope.ttOpiExtendedSales.TAKE_EFFECT_START}"
										placeholder="请输入生效开始时间" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-6 ">生效结束时间</label>
								<div class="col-xs-6">
									<input type="text" class="form-control" name="takeEffectEnd"
										id="takeEffectEnd"
										value="${requestScope.ttOpiExtendedSales.TAKE_EFFECT_END}"
										placeholder="请输入生效结束时间" />
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
										disabled="disabled" id="purchaseNumber"
										value="${requestScope.ttOpiExtendedSales.PURCHASE_NUMBER}"
										placeholder="请输入购买数量" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4">
							<div class="form-group">
								<label class="control-label col-xs-6 ">实际不含税销售价</label>
								<div class="col-xs-6">
									<input type="text" class="form-control"
										name="actualNonSalesPrice" id="actualNonSalesPrice"
										onkeyup="taxSales()"
										value="${requestScope.ttOpiExtendedSales.ACTUAL_NON_SALES_PRICE}"
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
										value="${requestScope.ttOpiExtendedSales.TOTAL_AMOUNT}"
										placeholder="请输入含税总额" />
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
								<button id="btn_submit" type="button" disabled="disabled"
									class="btn btn-primary btn-sm" onclick="submitASC()">
									<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
									提交
								</button>
								<button id="btn_print" type="button" disabled="disabled"
									class="btn btn-primary btn-sm" onclick="print()">
									<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
									打印
								</button>
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

<script src="${ctx}/resource/js/sysPage/dmsSales/editSales.js"></script>