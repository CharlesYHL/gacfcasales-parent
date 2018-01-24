<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="modelApp" v-cloak>
	<input type="text" id="productId" name="productId" value="${requestScope.productId}" hidden="hidden" />
	<div v-show="showOperModel">
		<div class="row">
			<div class="col-xs-offset-1 col-xs-10">
				<div class="panel panel-default">
					<!-- <div class="panel-heading">
						<h3 class="panel-title">{{title}}</h3>
					</div> -->
					<div class="box-header with-border form-inline">
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">品牌</span> <select
									name="brandId" id="brandId" class="selectpicker"
									onchange="getSeries()"></select>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车系</span> <select
									name="seriesId" id="seriesId" class="selectpicker"
									onchange="getModel()"></select>
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">车型</span> <select
									name="modelId" id="modelId" class="selectpicker"></select>
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-left: 40%;; margin-right: 8px;">
								<button id="btn_add_product" type="button"
									class="btn btn-primary btn-sm" @click="query">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									查询
								</button>
							</div>
							<div class="input-group input-group-sm">
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
	</div>

	<div v-show="showOperModel" class="box box-custom collapsed-box"
		style="margin-bottom: 0;">
		<div class="box-body">
			<ul id="tabUl" class="nav nav-tabs">
				<li class="active" id="modelLi" onclick="modelClick()"><a href="#modelSelect" data-toggle="tab">按车型选择</a></li>
				<li id="seriesLi" onclick="seriesClick()"><a href="#seriesSelect" data-toggle="tab">按车系选择</a></li>
			</ul>

			<div id="tabContent" class="tab-content">
				<div class="tab-pane fade in active" id="modelSelect">
					<table id="model_table" class="table"></table>
				</div>
				<div class="tab-pane fade" id="seriesSelect">
					<table id="series_table" class="table"></table>
				</div>
			</div>

			<!-- <table id="table" class="table"></table> -->
		</div>
		<div>
			<div class="input-group input-group-sm" style="margin-left: 42%;">
				<button id="btn_add_product" type="button"
					style="margin-right: 8px;" class="btn btn-primary btn-sm"
					@click="confirm">
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
</div>

<script src="${ctx}/resource/js/sysPage/dcsProduct/addModel.js"></script>