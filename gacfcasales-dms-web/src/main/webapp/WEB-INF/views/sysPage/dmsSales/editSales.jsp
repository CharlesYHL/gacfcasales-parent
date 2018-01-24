<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="editSalesApp" v-cloak>

	<input type="text" id="rtbrandId" name="rtbrandId" value="${requestScope.ttOpiExtendedSales.BRAND_ID}" hidden="hidden" />
	<input type="text" id="rtbrandName" name="rtbrandName" value="${requestScope.ttOpiExtendedSales.BRAND_NAME}" hidden="hidden" />
	<input type="text" id="rtbrandCode" name="rtbrandCode" value="${requestScope.ttOpiExtendedSales.BRAND_CODE}" hidden="hidden" />
	<input type="text" id="rtseriesId" name="rtseriesId" value="${requestScope.ttOpiExtendedSales.SERIES_ID}" hidden="hidden" />
	<input type="text" id="rtseriesName" name="rtseriesName" value="${requestScope.ttOpiExtendedSales.SERIES_NAME}" hidden="hidden" />
	<input type="text" id="rtseriesCode" name="rtseriesCode" value="${requestScope.ttOpiExtendedSales.SERIES_CODE}" hidden="hidden" />
	<input type="text" id="rtmodelId" name="rtmodelId" value="${requestScope.ttOpiExtendedSales.MODEL_ID}" hidden="hidden" />
	<input type="text" id="rtmodelName" name="rtmodelName" value="${requestScope.ttOpiExtendedSales.MODEL_NAME}" hidden="hidden" />
	<input type="text" id="rtmodelCode" name="rtmodelCode" value="${requestScope.ttOpiExtendedSales.MODEL_CODE}" hidden="hidden" />
	<input type="text" id="rtapackageId" name="rtapackageId" value="${requestScope.ttOpiExtendedSales.APACKAGE_ID}" hidden="hidden" />
	<input type="text" id="rtapackage" name="rtapackage" value="${requestScope.ttOpiExtendedSales.APACKAGE}" hidden="hidden" />
	<input type="text" id="rtapackageName" name="rtapackageName" value="${requestScope.ttOpiExtendedSales.APACKAGE_NAME}" hidden="hidden" />
	
	<input type="text" id="productSalesId" name="productSalesId" value="${requestScope.ttOpiExtendedSales.PRODUCT_SALES_ID}" hidden="hidden" />
	
	<input type="text" id="saleOrderId" name="saleOrderId"
		value="${requestScope.dmsSalesDto.saleOrderId}" hidden="hidden" />
		<input
		type="text" id="employeeName" name="employeeName"
		value="${requestScope.dmsSalesDto.employeeName}" hidden="hidden" />
		
		<input
		type="text" id="brandCode" name="brandCode"
		value="${requestScope.ttOpiExtendedSales.BRAND_CODE}" hidden="hidden" />
		<input
		type="text" id="seriesCode" name="seriesCode"
		value="${requestScope.ttOpiExtendedSales.SERIES_CODE}" hidden="hidden" />
		<input
		type="text" id="modelCode" name="modelCode"
		value="${requestScope.ttOpiExtendedSales.MODEL_CODE}" hidden="hidden" />
		<input
		type="text" id="apackageCode" name="apackageCode"
		value="${requestScope.ttOpiExtendedSales.APACKAGE}" hidden="hidden" />
		
		<input
		type="text" id="brandName" name="brandName"
		value="${requestScope.ttOpiExtendedSales.BRAND_NAME}" hidden="hidden" />
		<input
		type="text" id="seriesName" name="seriesName"
		value="${requestScope.ttOpiExtendedSales.SERIES_NAME}" hidden="hidden" />
		<input
		type="text" id="modelName" name="modelName"
		value="${requestScope.ttOpiExtendedSales.MODEL_NAME}" hidden="hidden" />
		<input
		type="text" id="apackageName" name="apackageName"
		value="${requestScope.ttOpiExtendedSales.APACKAGE_NAME}" hidden="hidden" />
		
		<input type="text" id="productId" name="productId"
		value="${requestScope.ttOpiExtendedSales.PRODUCT_ID}" hidden="hidden" />
		<input type="text" id="liceseNo" name="liceseNo"
		value="${requestScope.ttOpiExtendedSales.LICENSE_NO}" hidden="hidden" />
		
		
		<input
		type="text" id="rBrandId" name="rBrandId"
		value="${requestScope.dmsSalesDto.BRAND_ID}" hidden="hidden" />
		<input
		type="text" id="rSeriesId" name="rSeriesId"
		value="${requestScope.dmsSalesDto.SERIES_ID}" hidden="hidden" />
		<input
		type="text" id="rModelId" name="rModelId"
		value="${requestScope.dmsSalesDto.MODEL_ID}" hidden="hidden" />
		<input
		type="text" id="rApackageId" name="rApackageId"
		value="${requestScope.dmsSalesDto.APACKAGE_ID}" hidden="hidden" />
		
		

	<div v-show="showList">
		<div class="row">
			<div class="col-xs-offset-1 col-xs-10">
				<div class="panel panel-default">
					<!-- <div class="panel-heading">
						<h3 class="panel-title">{{title}}</h3>
					</div> -->
					<div class="box-header with-border form-inline">
						<div style="background: #e8e8e8;">延长服务销售单信息</div>
						<div style="height: 3px;"></div>
						<div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">销售单编号</span>
								<input type="text" class="form-control" name="salesOrder"
									disabled="disabled" id="salesOrder"
									value="${requestScope.ttOpiExtendedSales.PRODUCT_SALES_ORDER}" placeholder="请输入销售单编号" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">创建人</span>
								<input type="text" class="form-control" name="createdBy"
									disabled="disabled" id="createdBy"
									value="${requestScope.ttOpiExtendedSales.CREATE_NAME}" placeholder="请输入创建人" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">创建时间</span>
								<input id="createAt" name="createAt" type="text" disabled="disabled"
									class="form-control" value="${requestScope.ttOpiExtendedSales.CREATED_AT}" placeholder="请输入创建时间" />
							</div>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">客户姓名</span>
								<input type="text" class="form-control" name="customerName" disabled="disabled"
									id="customerName" value="${requestScope.ttOpiExtendedSales.CUSTOMER_NAME}" placeholder="请输入客户姓名" /> <span
									class="input-group-addon" style="color: red">*</span>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">联系方式</span>
								<input type="text" class="form-control" name="customerContact" disabled="disabled"
									id="customerContact" value="${requestScope.ttOpiExtendedSales.CUSTOMER_CONTACT}" placeholder="请输入联系方式" /> <span
									class="input-group-addon" style="color: red">*</span>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">单据状态</span>
								<input type="text" class="form-control" name="orderStatus" disabled="disabled"
									id="orderStatus" value="${requestScope.ttOpiExtendedSales.ORDER_STATUS}" placeholder="请输入单据状态" />
								<!-- <select name="orderStatus" id="orderStatus" class="selectpicker"></select> -->
							</div>

						</div>

						<div style="height: 20px;"></div>
						<div style="background: #e8e8e8;">车主车辆信息</div>
						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">VIN</span>
								<input type="text" class="form-control" name="vin" id="vin"
									value="${requestScope.ttOpiExtendedSales.VIN}" placeholder="请输入VIN" /> <span class="input-group-btn">
									<button class="btn default btn-sm" onclick="queryVin()">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</span>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">品牌</span> <select
									name="brandId" id="brandId" disabled="disabled"
									class="selectpicker"></select>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车系</span> <select
									name="seriesId" id="seriesId" disabled="disabled"
									class="selectpicker"></select>
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车型</span> <select
									name="modelId" id="modelId" disabled="disabled"
									class="selectpicker"></select>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">配置</span> <select
									name="apackage" id="apackage" disabled="disabled"
									class="selectpicker"></select>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">年款</span> <input
									type="text" class="form-control" name="yearModel"
									disabled="disabled" id="yearModel" value="${requestScope.ttOpiExtendedSales.YEAR_MODEL}" placeholder="请输入年款" />
							</div>

						</div>

						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">开票日期</span>
								<input id="billingAt" name="billingAt" type="text"
									class="form-control" value="${requestScope.ttOpiExtendedSales.BILLING_AT}" placeholder="请输入开票日期" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主编号</span>
								<input type="text" class="form-control" name="ownerNo" disabled="disabled"
									id="ownerNo" value="${requestScope.ttOpiExtendedSales.OWNER_NO}" placeholder="请输入车主编号" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主姓名</span>
								<input type="text" class="form-control" name="ownerName" disabled="disabled"
									id="ownerName" value="${requestScope.ttOpiExtendedSales.OWNER_NAME}" placeholder="请输入车主姓名" />
							</div>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主电话</span>
								<input type="text" class="form-control" name="ownerPhone" disabled="disabled"
									id="ownerPhone" value="${requestScope.ttOpiExtendedSales.OWNER_PHONE}" placeholder="请输入车主电话" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主手机</span>
								<input type="text" class="form-control" name="ownerMobile" disabled="disabled"
									id="ownerMobile" value="${requestScope.ttOpiExtendedSales.OWNER_MOBILE}" placeholder="请输入车主手机" />
							</div>
						</div>

						<div style="height: 20px;"></div>
						<div style="background: #e8e8e8;">延长服务产品信息</div>
						<div style="height: 3px;"></div>
						<div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品编号</span>
								<input type="text" class="form-control" name="productNo"
									id="productNo" value="${requestScope.ttOpiExtendedSales.PRODUCT_NO}" placeholder="请输入产品编号" /> <span
									class="input-group-btn">
									<button class="btn default btn-sm" onclick="addProduct();">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</span>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品名称</span>
								<input type="text" class="form-control" name="productName" disabled="disabled"
									id="productName" value="${requestScope.ttOpiExtendedSales.PRODUCT_NAME}" placeholder="请输入产品名称" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品有效期</span>
								<input type="text" class="form-control" name="productDate" disabled="disabled"
									id="productDate" value="${requestScope.ttOpiExtendedSales.PRODUCT_DATE}" placeholder="请输入产品有效期" />
							</div>

						</div>

						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品说明</span>
								<input type="text" class="form-control" disabled="disabled"
									name="productDescribtion" id="productDescribtion" value="${requestScope.requestScope.ttOpiExtendedSales.PRODUCT_DESCRIBTION}"
									placeholder="请输入产品说明" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">终端不含税销售价</span>
								<input type="text" class="form-control"
									name="terminalNonSalesPrice" id="terminalNonSalesPrice" disabled="disabled"
									value="${requestScope.ttOpiExtendedSales.TERMINAL_NON_SALES_PRICE}" placeholder="请输入终端不含税销售价" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">终端含税销售价</span>
								<input type="text" class="form-control" disabled="disabled"
									name="terminalSalesPrice" id="terminalSalesPrice" value="${requestScope.ttOpiExtendedSales.TERMINAL_SALES_PRICE}"
									placeholder="请输入终端含税销售价" />
							</div>

						</div>

						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">生效开始时间</span>
								<input type="text" class="form-control" name="takeEffectStart" disabled="disabled"
									id="takeEffectStart" value="${requestScope.ttOpiExtendedSales.TAKE_EFFECT_START}" placeholder="请输入生效开始时间" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">生效结束时间</span>
								<input type="text" class="form-control" name="takeEffectEnd" disabled="disabled"
									id="takeEffectEnd" value="${requestScope.ttOpiExtendedSales.TAKE_EFFECT_END}" placeholder="请输入生效结束时间" />
							</div>
						</div>


						<div style="height: 20px;"></div>
						<div style="background: #e8e8e8;">购买信息</div>
						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">购买数量</span>
								<input type="text" class="form-control" name="purchaseNumber" disabled="disabled"
									id="purchaseNumber" value="${requestScope.ttOpiExtendedSales.PURCHASE_NUMBER}" placeholder="请输入购买数量" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">实际不含税销售价</span>
								<input type="text" class="form-control"
									name="actualNonSalesPrice" id="actualNonSalesPrice" onkeyup="taxSales()" value="${requestScope.ttOpiExtendedSales.ACTUAL_NON_SALES_PRICE}"
									placeholder="请输入实际不含税销售价" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">含税总额(6%)</span>
								<input type="text" class="form-control" name="totalAmount" disabled="disabled"
									id="totalAmount" value="${requestScope.ttOpiExtendedSales.TOTAL_AMOUNT}" placeholder="请输入含税总额" />
							</div>

						</div>

						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-left: 40%;; margin-right: 8px;">
								<button id="btn_save" type="button"
									class="btn btn-primary btn-sm" onclick="save()">
									<span class="glyphicon glyphicon-film" aria-hidden="true"></span>
									保存
								</button>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 8px;">
								<button id="btn_submit" type="button" disabled="disabled"
									class="btn btn-primary btn-sm" onclick="submit()">
									<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
									提交
								</button>
							</div>
							<!--  -->
							<div class="input-group input-group-sm"
								style="margin-right: 8px;">
								<button id="btn_print" type="button"  disabled="disabled"
									class="btn btn-primary btn-sm" onclick="print()">
									<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
									打印
								</button>
							</div>
							<div class="input-group input-group-sm">
								<button id="btn_reset" type="button"
									class="btn btn-primary btn-sm" onclick="reset()">
									<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>&nbsp;&nbsp;返回
								</button>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>

</div>

<script src="${ctx}/resource/js/sysPage/dmsSales/editSales.js"></script>