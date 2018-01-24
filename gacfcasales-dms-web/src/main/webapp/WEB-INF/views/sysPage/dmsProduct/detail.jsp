<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="detailProduct" v-cloak>
	<div v-show="showOper">
		<input type="text" id="productId" name="productId" value="${requestScope.tiOpiExtendedDCS.PRODUCT_ID }"
			hidden="hidden" />
		<div class="row">
			<div class="col-xs-offset-1 col-xs-10">
				<div class="panel panel-default">
					<div class="box-header with-border form-inline">
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品编号</span>
								<input type="text" class="form-control" name="productNo" disabled="disabled"
									id="productNo" value="${requestScope.tiOpiExtendedDCS.PRODUCT_NO }"
									placeholder="请输入产品编号" /> 
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品名称</span>
								<input type="text" class="form-control" name="productName"
									disabled="disabled" id="productName"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_NAME }"
									placeholder="请输入产品名称" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品类别</span>
								<input type="text" class="form-control" name="productCategory"
									disabled="disabled" id="productCategory"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_CATEGORY }"
									placeholder="请输入产品类别" />
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品属性</span>
								<input type="text" class="form-control" name="productProperty"
									disabled="disabled" id="productProperty"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_PROPERTY }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品有效期</span>
								<input type="text" class="form-control" name="productDate"
									disabled="disabled" id="productDate"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_DATE }"
									placeholder="请输入产品有效期" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">DNP价格</span>
								<input type="text" class="form-control" name="dnpPrice"
									disabled="disabled" id="dnpPrice"
									value="${requestScope.tiOpiExtendedDCS.DNP_PRICE }"
									placeholder="请输入DNP价格" />
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">MSRP价格</span>
								<input type="text" class="form-control" name="msrpPrice"
									disabled="disabled" id="msrpPrice"
									value="${requestScope.tiOpiExtendedDCS.MSRP_PRICE }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 330px;">
								<span class="input-group-addon" style="width: 50px;">销售时间</span>
								<input id="salesStart" name="salesStart" type="text" disabled="disabled" 
									class="form-control" value="${requestScope.tiOpiExtendedDCS.SALES_DATE_START }" placeholder="请输入开始日期" /> <span
									class="input-group-addon"> - </span> <input id="salesEnd" disabled="disabled" 
									name="salesEnd" type="text" class="form-control" value="${requestScope.tiOpiExtendedDCS.SALES_DATE_END }" 
									placeholder="请输入结束日期" />
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否FIAT授权</span>
								<input type="text" class="form-control" name="isFiat"
									disabled="disabled" id="isFiat"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_FAIT }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否国产JEEP授权</span>
								<input type="text" class="form-control" name="isJeep"
									disabled="disabled" id="isJeep"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_JEEP }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否CJD授权</span>
								<input type="text" class="form-control" name="isCjd"
									disabled="disabled" id="isCjd"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_CJD }"
									placeholder="请输入产品属性" />
							</div>

						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 600px;">
								<span class="input-group-addon" style="width: 150px;">产品说明</span>
								<input type="text" class="form-control"
									name="productDescribtion" style="height: 50px;" disabled="disabled"
									id="productDescribtion" value="${requestScope.tiOpiExtendedDCS.PRODUCT_DESCRIBTION }" placeholder="产品说明" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
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
		<div style="height:10px;"></div>
		
	</div>

</div>

<script src="${ctx}/resource/js/sysPage/dmsProduct/detailProduct.js"></script>