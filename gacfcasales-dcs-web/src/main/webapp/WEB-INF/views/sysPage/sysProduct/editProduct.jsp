<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="editProduct" v-cloak>
	<div v-show="showOper">
		<input type="text" id="productId" name="productId"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_ID }" hidden="hidden" />
		<input type="text" id="productFait" name="productFait"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_FAIT }"
			hidden="hidden" /> <input type="text" id="productJeep"
			name="productJeep"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_JEEP }"
			hidden="hidden" /> <input type="text" id="productCjd"
			name="productCjd"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_CJD }" hidden="hidden" />
		<input type="text" id="productDateRet" name="productDateRet"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_DATE }"
			hidden="hidden" />
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">产品编号</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_NO }"
											class="form-control" id="productNo" name="productNo" />
										<!-- <span
											class="input-group-addon" onclick="addPart();"> <i
											class="fa fa-list-alt"></i>
										</span> -->
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">产品名称</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_NAME }"
											class="form-control" id="productName" name="productName" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">产品类别</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_CATEGORY }"
											class="form-control" id="productCategory"
											name="productCategory" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">产品属性</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_PROPERTY }"
											class="form-control" id="productProperty"
											name="productProperty" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">产品属性</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_PROPERTY }"
											class="form-control" id="productProperty"
											name="productProperty" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品有效期</label>
								<div class="col-xs-7">
									<select name="productDate" id="productDate"
										class="bs-select form-control" onchange="getProductDate()"></select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">DNP价格</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.DNP_PRICE }"
											class="form-control" id="dnpPrice" name="dnpPrice" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">MSRP价格</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.MSRP_PRICE }"
											class="form-control" id="msrpPrice" name="msrpPrice" />
									</div>
								</div>
							</div>
						</div>


						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否FIAT授权</label>
								<div class="col-xs-7">
									<select name="isFiat" id="isFiat"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否JEEP授权</label>
								<div class="col-xs-7">
									<select name="isJeep" id="isJeep"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否CJD授权</label>
								<div class="col-xs-7">
									<select name="isCjd" id="isCjd" class="bs-select form-control"></select>
								</div>
							</div>
						</div>


						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5">适用车型</label>
								<div class="col-xs-7 ">
									<div class="input-group">
										<input type="text"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_MODEL }"
											class="form-control" id="productModel" name="productModel" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-12 col-md-8 col-lg-5">
							<div class="form-group">
								<label class="control-label col-xs-3">销售时间</label>
								<div class="col-xs-6 col-sm-8">
									<div class="input-group input-daterange">
										<input id="salesStart" name="salesStart" type="text"
											class="form-control" placeholder="请输入开始日期"
											value="${requestScope.tiOpiExtendedDCS.SALES_DATE_START }" />
										<span class="input-group-addon"> - </span> <input
											id="salesEnd" name="salesEnd" type="text"
											class="form-control"
											value="${requestScope.tiOpiExtendedDCS.SALES_DATE_END }"
											placeholder="请输入结束日期" />
									</div>

								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4">
							<div class="form-group">
								<label class="control-label col-xs-4">产品说明</label>
								<div class="col-xs-8">
									<textarea id="productDescribtion" name="productDescribtion" class="form-control" rows="3" value="${requestScope.tiOpiExtendedDCS.PRODUCT_DESCRIBTION }"></textarea>
									<%-- <input id="productDescribtion" name="productDescribtion"
										class="form-control" type="text"
										value="${requestScope.tiOpiExtendedDCS.PRODUCT_DESCRIBTION }" /> --%>
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
			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-primary"
					style="margin-right: 10px;" @click="addProductModel();">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					新增
				</button>

				<button id="btn_export" type="button" class="btn btn-primary"
					@click="deleteModel">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					删除
				</button>
			</div>
			<!-- <div style="height: 3px;"></div> -->
			<div>
				<table id="table" class="table"></table>
			</div>
		</div>

		<div>
			<div class="input-group input-group-sm" style="margin-left: 48%;">
				<button id="btn_add_product" type="button"
					style="margin-right: 8px;" class="btn btn-primary btn-sm"
					@click="saveModel">
					<span class="glyphicon glyphicon-film" aria-hidden="true"></span>&nbsp;&nbsp;保存
				</button>
				<button id="btn_add_product" type="button"
					class="btn btn-primary btn-sm" @click="goBack">
					<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>&nbsp;&nbsp;返回
				</button>
			</div>
		</div>
		<div style="height: 10px;"></div>

	</div>

</div>



<script src="${ctx}/resource/js/sysPage/dcsProduct/editProduct.js"></script>


