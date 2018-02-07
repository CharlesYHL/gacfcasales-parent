<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>


<div id=productApp " v-cloak>
	<div v-show="showOperPart" class="dms-search">
		<input type="text" id="modelId" name="modelId"
			value="${requestScope.modelId }" hidden="hidden" />
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品编号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productNo"
										id="productNo" value="${requestScope.productNo }"
										placeholder="请输入产品编号" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品名称</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productName"
										id="productName" value="" placeholder="请输入产品名称" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12 ">
								<div class="query-btn">
									<button id="btn_add_product" type="button"
										class="btn btn-primary btn-sm" @click="query">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										查询
									</button>
									<button id="btn_add_product" type="button"
										class="btn btn-primary btn-sm" @click="reset">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;重置
									</button>

								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</form>

	</div>

	<div v-show="showOperPart" class="box box-custom collapsed-box"
		style="margin-bottom: 0;">
		<div class="box-body">
			<table id="table" class="table"></table>
		</div>
		<div>
			<div class="input-group input-group-sm" style="margin-left: 48%;">
				<button id="btn_add_product" type="button"
					style="margin-right: 8px;" class="btn btn-primary btn-sm"
					@click="returnSales">
					<span class="glyphicon glyphicon-film" aria-hidden="true"></span>&nbsp;&nbsp;确定
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

<script src="${ctx}/resource/js/sysPage/dmsSales/productList.js"></script>