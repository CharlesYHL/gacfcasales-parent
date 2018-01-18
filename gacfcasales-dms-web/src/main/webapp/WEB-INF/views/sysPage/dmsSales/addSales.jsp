<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="addSalesApp" v-cloak>
	<input type="text" id="saleOrderId" name="saleOrderId"
		value="${requestScope.dmsSalesDto.saleOrderId}" hidden="hidden" />
		<input
		type="text" id="employeeName" name="employeeName"
		value="${requestScope.dmsSalesDto.employeeName}" hidden="hidden" />
		
		<input
		type="text" id="brandCode" name="brandCode"
		value="${requestScope.dmsSalesDto.BRAND}" hidden="hidden" />
		<input
		type="text" id="seriesCode" name="seriesCode"
		value="${requestScope.dmsSalesDto.SERIES}" hidden="hidden" />
		<input
		type="text" id="modelCode" name="modelCode"
		value="${requestScope.dmsSalesDto.MODEL}" hidden="hidden" />
		<input
		type="text" id="apackageCode" name="apackageCode"
		value="${requestScope.dmsSalesDto.APACKAGE}" hidden="hidden" />
		
		<input
		type="text" id="brandName" name="brandName"
		value="${requestScope.dmsSalesDto.BRAND_NAME}" hidden="hidden" />
		<input
		type="text" id="seriesName" name="seriesName"
		value="${requestScope.dmsSalesDto.SERIES_NAME}" hidden="hidden" />
		<input
		type="text" id="modelName" name="modelName"
		value="" hidden="hidden" />
		<input
		type="text" id="apackageName" name="apackageName"
		value="" hidden="hidden" />
		
		<input type="text" id="productId" name="productId"
		value="" hidden="hidden" />
		<input type="text" id="liceseNo" name="liceseNo"
		value="" hidden="hidden" />
		
		
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
									value="${requestScope.dmsSalesDto.saleOrderId}" placeholder="请输入销售单编号" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">创建人</span>
								<input type="text" class="form-control" name="createdBy"
									disabled="disabled" id="createdBy"
									value="${requestScope.dmsSalesDto.employeeName}" placeholder="请输入创建人" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">创建时间</span>
								<input id="createAt" name="createAt" type="text" disabled="disabled"
									class="form-control" value="${requestScope.dmsSalesDto.createAt}" placeholder="请输入创建时间" />
							</div>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">客户姓名</span>
								<input type="text" class="form-control" name="customerName"
									id="customerName" value="${requestScope.dmsSalesDto.customerName}" placeholder="请输入客户姓名" /> <span
									class="input-group-addon" style="color: red">*</span>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">联系方式</span>
								<input type="text" class="form-control" name="customerContact"
									id="customerContact" value="${requestScope.dmsSalesDto.customerContact}" placeholder="请输入联系方式" /> <span
									class="input-group-addon" style="color: red">*</span>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">单据状态</span>
								<input type="text" class="form-control" name="orderStatus" disabled="disabled"
									id="orderStatus" value="${requestScope.dmsSalesDto.orderStatus}" placeholder="请输入单据状态" />
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
									value="${requestScope.dmsSalesDto.VIN}" placeholder="请输入VIN" /> <span class="input-group-btn">
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
									disabled="disabled" id="yearModel" value="${requestScope.dmsSalesDto.YEAR_MODEL}" placeholder="请输入年款" />
							</div>

						</div>

						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">开票日期</span>
								<input id="billingAt" name="billingAt" type="text"
									class="form-control" value="${requestScope.dmsSalesDto.INVOICE_DATE}" placeholder="请输入开票日期" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主编号</span>
								<input type="text" class="form-control" name="ownerNo" disabled="disabled"
									id="ownerNo" value="${requestScope.dmsSalesDto.OWNER_NO}" placeholder="请输入车主编号" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主姓名</span>
								<input type="text" class="form-control" name="ownerName" disabled="disabled"
									id="ownerName" value="${requestScope.dmsSalesDto.OWNER_NAME}" placeholder="请输入车主姓名" />
							</div>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主电话</span>
								<input type="text" class="form-control" name="ownerPhone" disabled="disabled"
									id="ownerPhone" value="${requestScope.dmsSalesDto.PHONE}" placeholder="请输入车主电话" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车主手机</span>
								<input type="text" class="form-control" name="ownerMobile" disabled="disabled"
									id="ownerMobile" value="${requestScope.dmsSalesDto.MOBILE}" placeholder="请输入车主手机" />
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
									id="productNo" value="${requestScope.dmsSalesDto.PRODUCT_NO}" placeholder="请输入产品编号" /> <span
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
									id="productName" value="${requestScope.dmsSalesDto.PRODUCT_NAME}" placeholder="请输入产品名称" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品有效期</span>
								<input type="text" class="form-control" name="productDate" disabled="disabled"
									id="productDate" value="${requestScope.dmsSalesDto.PRODUCT_DATE}" placeholder="请输入产品有效期" />
							</div>

						</div>

						<div style="height: 3px;"></div>

						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品说明</span>
								<input type="text" class="form-control" disabled="disabled"
									name="productDescribtion" id="productDescribtion" value="${requestScope.dmsSalesDto.PRODUCT_DESCRIBTION}"
									placeholder="请输入产品说明" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">终端不含税销售价</span>
								<input type="text" class="form-control"
									name="terminalNonSalesPrice" id="terminalNonSalesPrice" disabled="disabled"
									value="${requestScope.dmsSalesDto.TERMINAL_NON_SALES_PRICE}" placeholder="请输入终端不含税销售价" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">终端含税销售价</span>
								<input type="text" class="form-control" disabled="disabled"
									name="terminalSalesPrice" id="terminalSalesPrice" value="${requestScope.dmsSalesDto.TERMINAL_SALES_PRICE}"
									placeholder="请输入终端含税销售价" />
							</div>

						</div>

						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">生效开始时间</span>
								<input type="text" class="form-control" name="takeEffectStart"
									id="takeEffectStart" value="${requestScope.dmsSalesDto.SALES_DATE_START}" placeholder="请输入生效开始时间" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">生效结束时间</span>
								<input type="text" class="form-control" name="takeEffectEnd"
									id="takeEffectEnd" value="${requestScope.dmsSalesDto.SALES_DATE_END}" placeholder="请输入生效结束时间" />
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
									id="purchaseNumber" value="1" placeholder="请输入购买数量" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">实际不含税销售价</span>
								<input type="text" class="form-control"
									name="actualNonSalesPrice" id="actualNonSalesPrice" onkeyup="taxSales()" value="${requestScope.dmsSalesDto.ACTUAL_NON_SALES_PRICE}"
									placeholder="请输入实际不含税销售价" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 19px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">含税总额(6%)</span>
								<input type="text" class="form-control" name="totalAmount" disabled="disabled"
									id="totalAmount" value="${requestScope.dmsSalesDto.TOTAL_AMOUNT}" placeholder="请输入含税总额" />
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
							<div class="input-group input-group-sm"
								style="margin-right: 8px;">
								<button id="btn_print" type="button" disabled="disabled"
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

<script src="${ctx}/resource/js/sysPage/addSales.js"></script>