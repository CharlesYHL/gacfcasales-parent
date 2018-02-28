<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="detailProduct" v-cloak>
	<div v-show="showOper">
		<input type="text" id="productId" name="productId"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_ID }" hidden="hidden" />
		<input type="text" id="productDes" name="productDes"
			value="${requestScope.tiOpiExtendedDCS.PRODUCT_DESCRIBTION }"
			hidden="hidden" />
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">产品编号</label>
								<div class="col-xs-8 ">
									<div class="input-group">
										<input type="text" disabled="disabled"
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
								<label class="control-label col-xs-4">产品名称</label>
								<div class="col-xs-8 ">
									<div class="input-group">
										<input type="text" disabled="disabled"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_NAME }"
											class="form-control" id="productName" name="productName" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">产品类别</label>
								<div class="col-xs-8">
									<div class="input-group">
										<input type="text" disabled="disabled"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_CATEGORY }"
											class="form-control" id="productCategory"
											name="productCategory" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">产品属性</label>
								<div class="col-xs-8">
									<div class="input-group">
										<input type="text" disabled="disabled"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_PROPERTY }"
											class="form-control" id="productProperty"
											name="productProperty" />
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-8 col-lg-6">
							<div class="form-group">
								<label class="control-label col-xs-4 col-sm-2">销售时间</label>
								<div class="col-xs-8 col-sm-10">
									<div class="input-group input-daterange">
										<input id="salesStart" name="salesStart" type="text"
											disabled="disabled" class="form-control"
											placeholder="请输入开始日期"
											value="${requestScope.tiOpiExtendedDCS.SALES_DATE_START }" />
										<span class="input-group-addon"> - </span> <input
											id="salesEnd" name="salesEnd" type="text" disabled="disabled"
											class="form-control"
											value="${requestScope.tiOpiExtendedDCS.SALES_DATE_END }"
											placeholder="请输入结束日期" />
									</div>

								</div>
							</div>
						</div>

						<%-- <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
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
						</div> --%>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4 ">产品有效期</label>
								<div class="col-xs-8">
									<!-- <select name="productDate" id="productDate"
										class="bs-select form-control" onchange="getProductDate()"></select> -->
									<input type="text" class="form-control" name="productDate"
										disabled="disabled" id="productDate"
										value="${requestScope.tiOpiExtendedDCS.PRODUCT_DATE }"
										placeholder="请输入产品有效期" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">DNP价格</label>
								<div class="col-xs-8">
									<div class="input-group">
										<input type="text" disabled="disabled"
											value="${requestScope.tiOpiExtendedDCS.DNP_PRICE }"
											class="form-control" id="dnpPrice" name="dnpPrice" />
									</div>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">MSRP价格</label>
								<div class="col-xs-8">
									<div class="input-group">
										<input type="text" disabled="disabled"
											value="${requestScope.tiOpiExtendedDCS.MSRP_PRICE }"
											class="form-control" id="msrpPrice" name="msrpPrice" />
									</div>
								</div>
							</div>
						</div>


						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">FIAT授权</label>
								<div class="col-xs-8">
									<!-- <select name="isFiat" id="isFiat"
										class="bs-select form-control"></select> -->
									<input type="text" class="form-control" name="isFiat"
										disabled="disabled" id="isFiat"
										value="${requestScope.tiOpiExtendedDCS.PRODUCT_FAIT }"
										placeholder="请输入产品属性" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">JEEP授权</label>
								<div class="col-xs-8">
									<!-- <select name="isJeep" id="isJeep"
										class="bs-select form-control"></select> -->
									<input type="text" class="form-control" name="isJeep"
										disabled="disabled" id="isJeep"
										value="${requestScope.tiOpiExtendedDCS.PRODUCT_JEEP }"
										placeholder="请输入产品属性" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4 ">CJD授权</label>
								<div class="col-xs-8">
									<!-- <select name="isCjd" id="isCjd" class="bs-select form-control"></select> -->
									<input type="text" class="form-control" name="isCjd"
										disabled="disabled" id="isCjd"
										value="${requestScope.tiOpiExtendedDCS.PRODUCT_CJD }"
										placeholder="请输入产品属性" />
								</div>
							</div>
						</div>


						<%-- <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">适用车型</label>
								<div class="col-xs-8">
									<div class="input-group">
										<input type="text" disabled="disabled"
											value="${requestScope.tiOpiExtendedDCS.PRODUCT_MODEL }"
											class="form-control" id="productModel" name="productModel" />
									</div>
								</div>
							</div>
						</div> --%>

						

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-4">特别约定</label>
								<div class="col-xs-8">
									<textarea id="productDescribtion" name="productDescribtion"
										disabled="disabled" class="form-control" rows="3"></textarea>
									
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
				<button id="btn_add_product" type="button"
					style="margin-right: 8px;" class="btn btn-primary btn-sm"
					@click="dealerExport">
					<span class="glyphicon glyphicon-film" aria-hidden="true"></span>&nbsp;&nbsp;经销商范围下载
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

<script src="${ctx}/resource/js/sysPage/dcsProduct/detailProduct.js"></script>
<link rel="stylesheet"
	href="${ctx}/resource/plugins/toastr/toastr.min.css">
<script src="${ctx }/resource/plugins/toastr/toastr.min.js"></script>
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


