<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="detailProduct" v-cloak>
	<div v-show="showOper" class="dms-search">
		<input type="text" id="productId" name="productId"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_ID }" hidden="hidden" />
			<input type="text" id="productDes" name="productDes"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_DESCRIBTION }" hidden="hidden" />
		
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品编号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productNo" disabled="disabled"
									id="productNo" value="${requestScope.tiOpiExtendedDCS.PRODUCT_NO }"
									placeholder="请输入产品编号" /> 
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品名称</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productName"
									disabled="disabled" id="productName"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_NAME }"
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
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_DATE }"
									placeholder="请输入产品有效期" />
								</div>
							</div>
						</div>
						
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">不含税成本价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="nonTaxCostPrice"
									disabled="disabled" id="nonTaxCostPrice"
									value="${requestScope.tiOpiExtendedDCS.NON_TAX_COST_PRICE }"
									placeholder="请输入产品类别" />
								</div>
							</div>
						</div>
						
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">含税成本价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="taxCostPrice"
									disabled="disabled" id="taxCostPrice"
									value="${requestScope.tiOpiExtendedDCS.TAX_COST_PRICE }"
									placeholder="请输入产品属性" />
								</div>
							</div>
						</div>
						
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">不含税终端销售价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="terminalNonSalesPrice"
									disabled="disabled" id="terminalNonSalesPrice"
									value="${requestScope.tiOpiExtendedDCS.TERMINAL_NON_SALES_PRICE }"
									placeholder="请输入产品类别" />
								</div>
							</div>
						</div>
						
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">含税终端销售价</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="terminalSalesPrice"
									disabled="disabled" id="terminalSalesPrice"
									value="${requestScope.tiOpiExtendedDCS.TERMINAL_SALES_PRICE }"
									placeholder="请输入产品属性" />
								</div>
							</div>
						</div>
						
						
						
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否有效</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="isValid"
									disabled="disabled" id="isValid"
									value="${requestScope.tiOpiExtendedDCS.IS_VALID }"
									placeholder="请输入DNP价格" />
								</div>
							</div>
						</div>
						
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">发布状态</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="releaseStatus"
									disabled="disabled" id="releaseStatus"
									value="${requestScope.tiOpiExtendedDCS.RELEASE_STATUS }"
									placeholder="请输入产品属性" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否可销售</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="isCSales"
									disabled="disabled" id="isCSales"
									value="${requestScope.tiOpiExtendedDCS.IS_C_SALE }"
									placeholder="请输入产品属性" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">销售时间</label>
								<div class="col-xs-7">
									<div class="input-group input-daterange">

										<input id="salesStart" name="salesStart" type="text" disabled="disabled"
											class="form-control" value="${requestScope.tiOpiExtendedDCS.SALES_DATE_START }" placeholder="请输入开始日期" /> <span
											class="input-group-addon"> - </span> <input id="salesEnd"
											name="salesEnd" type="text" disabled="disabled" class="form-control" value="${requestScope.tiOpiExtendedDCS.SALES_DATE_END }"
											placeholder="请输入结束日期" />
									</div>

								</div>
							</div>
						</div>
						<%-- <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否FIAT授权</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="isFiat"
									disabled="disabled" id="isFiat"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_FAIT }"
									placeholder="" />
								</div>
							</div>
						</div> --%>
						
						<%-- <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否JEEP授权</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="isJeep"
									disabled="disabled" id="isJeep"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_JEEP }"
									placeholder="" />
								</div>
							</div>
						</div> --%>
						<%-- <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否CJD授权</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="isCjd"
									disabled="disabled" id="isCjd"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_CJD }"
									placeholder="" />
								</div>
							</div>
						</div> --%>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 ">
							<div class="form-group">
								<label class="control-label col-xs-5">产品说明</label>
								<div class="col-xs-7">
									<textarea id="productDescribtion" name="productDescribtion" class="form-control" rows="3" disabled="disabled" ></textarea>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</form>

	</div>

	<div v-show="showOper" class="box box-custom collapsed-box"
		style="margin-bottom: 0;">
		<div class="box-body">
			<div>
				<table id="table" class="table"></table>
			</div>
		</div>

		<div>
			<div class="input-group input-group-sm" style="margin-left: 48%;">
				<!-- <button id="btn_add_product" type="button" style="margin-right: 8px;"
					class="btn btn-primary btn-sm" @click="dealerExport">
					<span class="glyphicon glyphicon-film" aria-hidden="true"></span>&nbsp;&nbsp;经销商范围下载
				</button> -->
				<button id="btn_add_product" type="button"
					class="btn btn-primary btn-sm" @click="goBack">
					<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>&nbsp;&nbsp;取消
				</button>
			</div>
		</div>
		<div style="height: 10px;"></div>

	</div>

</div>

<script src="${ctx}/resource/js/sysPage/dmsProduct/detailProduct.js"></script>