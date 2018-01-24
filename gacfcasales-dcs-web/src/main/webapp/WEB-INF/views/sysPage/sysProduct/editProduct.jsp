<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="editProduct" v-cloak>
	<div v-show="showOper">
		<input type="text" id="productId" name="productId"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_ID }" hidden="hidden" />
		<input type="text" id="productFait" name="productFait"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_FAIT }" hidden="hidden" />
		<input type="text" id="productJeep" name="productJeep"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_JEEP }" hidden="hidden" />
		<input type="text" id="productCjd" name="productCjd"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_CJD }" hidden="hidden" />
		<input type="text" id="productDateRet" name="productDateRet"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_DATE }" hidden="hidden" />
		<div class="row">
			<div class="col-xs-offset-1 col-xs-10">
				<div class="panel panel-default">
					<!-- <div class="panel-heading">
						<h3 class="panel-title">新增产</h3>
					</div> -->
					<div class="box-header with-border form-inline">
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品编号</span>
								<input type="text" class="form-control" name="productNo"
									id="productNo"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_NO }"
									placeholder="请输入产品编号" />
								<!-- <span class="input-group-btn">
									<button class="btn default btn-sm" onclick="addPart();">
										<i class="fa fa-list-alt"></i>
									</button>
								</span> -->
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品名称</span>
								<input type="text" class="form-control" name="productName"
									id="productName"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_NAME }"
									placeholder="请输入产品编号" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品类别</span>
								<input type="text" class="form-control" name="productCategory"
									id="productCategory"
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
									id="productProperty"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_PROPERTY }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品有效期</span>
								<select name="productDate" id="productDate" class="selectpicker" onchange="getProductDate()"></select>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">DNP价格</span>
								<input type="text" class="form-control" name="dnpPrice"
									id="dnpPrice"
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
									id="msrpPrice"
									value="${requestScope.tiOpiExtendedDCS.MSRP_PRICE }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 330px;">
								<span class="input-group-addon" style="width: 50px;">销售时间</span>
								<input id="salesStart" name="salesStart" type="text"
									class="form-control"
									value="${requestScope.tiOpiExtendedDCS.SALES_DATE_START }"
									placeholder="请输入开始日期" /> <span class="input-group-addon">
									- </span> <input id="salesEnd" name="salesEnd" type="text"
									class="form-control"
									value="${requestScope.tiOpiExtendedDCS.SALES_DATE_END }"
									placeholder="请输入结束日期" />
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否FIAT授权</span>
								<select name="isFiat" id="isFiat" class="selectpicker"></select>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否国产JEEP授权</span>
								<select name="isJeep" id="isJeep" class="selectpicker"></select>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否CJD授权</span>
								<select name="isCjd" id="isCjd" class="selectpicker"></select>
							</div>

						</div>
						<div style="height: 3px;"></div>
						<div>
						<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">适用车型</span>
								<input type="text" class="form-control" name="productModel"
									id="productModel"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_MODEL }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 600px;">
								<span class="input-group-addon" style="width: 150px;">产品说明</span>
								<input type="text" class="form-control"
									name="productDescribtion" style="height: 50px;"
									id="productDescribtion"
									value="${requestScope.tiOpiExtendedDCS.PRODUCT_DESCRIBTION }"
									placeholder="产品说明" />
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


