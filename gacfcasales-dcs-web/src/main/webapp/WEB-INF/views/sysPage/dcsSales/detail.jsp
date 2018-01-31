<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>
<div id="detailSalesApp" v-cloak>
	<div v-show="showOperPart" class="dms-search">
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">经销商信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">大区</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control" name="bigOrg"
										id="bigOrg" disabled="disabled"
										value="${requestScope.ttOpiSalesAll.BIG_ORG}"
										placeholder="请输入大区" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">小区</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="smallOrg" id="smallOrg" disabled="disabled"
										value="${requestScope.ttOpiSalesAll.SMALL_ORG}"
										placeholder="请输入小区" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">经销商代码</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="dealerCode" id="dealerCode" disabled="disabled"
										value="${requestScope.ttOpiSalesAll.DEALER_CODE}"
										placeholder="请输入经销商代码" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">经销商名称</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="dealerShortname" id="dealerShortname"
										disabled="disabled"
										value="${requestScope.ttOpiSalesAll.DEALER_SHORTNAME}"
										placeholder="请输入经销商名称" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">销售单编号</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="productSalesOrder" disabled="disabled"
										id="productSalesOrder"
										value="${requestScope.ttOpiSalesAll.PRODUCT_SALES_ORDER}"
										placeholder="请输入销售单编号" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">创建人</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="createdBy"
										disabled="disabled" id="createdBy"
										value="${requestScope.ttOpiSalesAll.CREATE_NAME}"
										placeholder="请输入创建人" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">创建时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="createAt"
										disabled="disabled" id="createAt"
										value="${requestScope.ttOpiSalesAll.CREATED_AT}"
										placeholder="请输入创建时间" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">结案人</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="closedBy"
										disabled="disabled" id="closedBy"
										value="${requestScope.ttOpiSalesAll.CLOSED_NAME}"
										placeholder="请输入结案人" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">结案时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="closedAt"
										disabled="disabled" id="closedAt"
										value="${requestScope.ttOpiSalesAll.CLOSED_AT}"
										placeholder="请输入结案时间" />
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
											<input type="text" class="form-control" name="vin" id="vin"
												disabled="disabled"
												value="${requestScope.ttOpiSalesAll.VIN}"
												placeholder="请输入VIN" />
										</div>
										 <span class="input-group-btn" style="height: 34px;">
											<button class="btn btn-primary" type="button"
												style="height: 34px;">
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
									<input type="text" class="form-control" name="brandName"
										disabled="disabled" id="brandName"
										value="${requestScope.ttOpiSalesAll.BRAND_NAME}"
										placeholder="请输入品牌" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车系</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="seriesName"
										disabled="disabled" id="seriesName"
										value="${requestScope.ttOpiSalesAll.SERIES_NAME}"
										placeholder="请输入车系" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车型</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="modelName"
										disabled="disabled" id="modelName"
										value="${requestScope.ttOpiSalesAll.MODEL_NAME}"
										placeholder="请输入车型" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">配置</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="apackage"
										id="apackage" disabled="disabled"
										value="${requestScope.ttOpiSalesAll.APACKAGE}"
										placeholder="请输入配置" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">年款</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="yearModel"
										disabled="disabled" id="yearModel"
										value="${requestScope.ttOpiSalesAll.YEAR_MODEL}"
										placeholder="请输入年款" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">开票日期</label>
								<div class="col-xs-7">
									<input id="billingAt" name="billingAt" type="text"
										class="form-control" disabled="disabled"
										value="${requestScope.ttOpiSalesAll.BILLING_AT}"
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
										value="${requestScope.ttOpiSalesAll.OWNER_NO}"
										placeholder="请输入车主编号" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主姓名</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerName"
										disabled="disabled" id="ownerName"
										value="${requestScope.ttOpiSalesAll.OWNER_NAME}"
										placeholder="请输入车主姓名" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主电话</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerPhone"
										disabled="disabled" id="ownerPhone"
										value="${requestScope.ttOpiSalesAll.OWNER_PHONE}"
										placeholder="请输入车主电话" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">车主手机</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="ownerMobile"
										disabled="disabled" id="ownerMobile"
										value="${requestScope.ttOpiSalesAll.OWNER_MOBILE}"
										placeholder="请输入车主手机" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">客户联系方式</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="customerContact"
										disabled="disabled" id="customerContact"
										value="${requestScope.ttOpiSalesAll.CUSTOMER_CONTACT}"
										placeholder="请输入客户联系方式" />
								</div>
							</div>
						</div>


					</div>
					<div class="row">
						<div
							style="background: #e8e8e8; margin-left: 20px; text-align: left; font-weight: 700; font-size: 16px;">产品信息</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品编号</label>
								<div class="col-xs-7">
									<div class="input-group">
										<div class="input-icon-group">
											<input type="text" class="form-control" name="productNo"
												disabled="disabled" id="productNo"
												value="${requestScope.ttOpiSalesAll.PRODUCT_NO}"
												placeholder="请输入产品编号" />
										</div>
										 <span class="input-group-btn" style="height: 34px;">
											<button class="btn btn-primary" type="button"
												style="height: 34px;">
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
										value="${requestScope.ttOpiSalesAll.PRODUCT_NAME}"
										placeholder="请输入产品名称" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品有效期</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productDate"
										disabled="disabled" id="productDate"
										value="${requestScope.ttOpiSalesAll.PRODUCT_DATE}"
										placeholder="请输入产品有效期" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品类别</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="productCategory" id="productCategory"
										value="${requestScope.ttOpiSalesAll.PRODUCT_CATEGORY}"
										placeholder="请输入产品类别" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品属性</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="productProperty" id="productProperty"
										value="${requestScope.ttOpiSalesAll.PRODUCT_PROPERTY}"
										placeholder="请输入产品属性" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品说明</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="productDescribtion" id="productDescribtion"
										value="${requestScope.ttOpiSalesAll.PRODUCT_DESCRIBTION}"
										placeholder="请输入产品说明" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">生效开始时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="takeEffectStart"
										id="takeEffectStart" disabled="disabled"
										value="${requestScope.ttOpiSalesAll.TAKE_EFFECT_START}"
										placeholder="请输入生效开始时间" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">生效结束时间</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="takeEffectEnd"
										id="takeEffectEnd" disabled="disabled"
										value="${requestScope.ttOpiSalesAll.TAKE_EFFECT_END}"
										placeholder="请输入生效结束时间" />
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
										value="${requestScope.ttOpiSalesAll.TERMINAL_NON_SALES_PRICE}"
										placeholder="请输入终端不含税销售价" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">终端含税销售价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="terminalSalesPrice" id="terminalSalesPrice"
										value="${requestScope.ttOpiSalesAll.TERMINAL_SALES_PRICE}"
										placeholder="请输入终端含税销售价" />
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
										value="${requestScope.ttOpiSalesAll.PURCHASE_NUMBER}"
										placeholder="请输入购买数量" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">实际不含税销售价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" disabled="disabled"
										name="actualNonSalesPrice" id="actualNonSalesPrice"
										value="${requestScope.ttOpiSalesAll.ACTUAL_NON_SALES_PRICE}"
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
										value="${requestScope.ttOpiSalesAll.TOTAL_AMOUNT}"
										placeholder="请输入含税总额" />
								</div>
							</div>
						</div>


					</div>
					<div class="row">
						<div class="col-xs-12 ">
							<div class="query-btn">
								<button id="btn_reset" type="button"
									class="btn btn-primary btn-sm" onclick="testaaaa()">
									<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
									&nbsp;&nbsp;返回
								</button>
							</div>
						</div>
					</div>


				</div>
			</div>
		</form>
	</div>
</div>




<script src="${ctx}/resource/js/sysPage/dcsSales/detailSales.js"></script>