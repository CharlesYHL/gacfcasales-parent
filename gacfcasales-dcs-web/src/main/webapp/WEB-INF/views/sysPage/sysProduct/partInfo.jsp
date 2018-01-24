<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="partInfoApp" v-cloak>
	<input type="text" value="${requestScope.partNo}" hidden="hidden" />
	<div v-show="showOperPart">
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
								<span class="input-group-addon" style="width: 50px;">配件编号</span>
								<input type="text" class="form-control" name="partNo"
									id="partNo" value="${requestScope.partNo}"
									placeholder="请输入配件编号" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">配件名称</span>
								<input type="text" class="form-control" name="partName"
									id="partName" value="" placeholder="请输入配件编号" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否有效</span>
								<select name="partStatus" id="partStatus" class="selectpicker"></select>
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">配件属性</span>
								<select name="partProperty" id="partProperty"
									class="selectpicker"></select>
								<!-- <input type="text" class="form-control" name="partProperty"
									id="partProperty" value="" placeholder="请输入配件属性" /> -->
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">配件类别</span>
								<select name="partGroupCode" id="partGroupCode"
									class="selectpicker"></select>
								<!-- <input type="text" class="form-control" name="partGroupCode"
									id="partGroupCode" value="" placeholder="请输入配件类别" /> -->
							</div>
							<!-- <div class="input-group input-group-sm"
								style="margin-right: 16px; width: 330px;">
								<span class="input-group-addon" style="width: 50px;">发布时间</span>
								<input id="releaseStart" name="releaseStart" type="text"
									class="form-control" placeholder="请输入开始日期" /> <span
									class="input-group-addon"> - </span> <input id="releaseEnd"
									name="releaseEnd" type="text" class="form-control"
									placeholder="请输入结束日期" />
							</div> -->
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-left: 40%;; margin-right: 8px;">
								<button id="btn_add_product" type="button"
									class="btn btn-primary btn-sm" @click="query_part">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									查询
								</button>
							</div>
							<div class="input-group input-group-sm">
								<button id="btn_add_product" type="button"
									class="btn btn-primary btn-sm" @click="clear_part">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;重置
								</button>
							</div>
							<!-- <div class="input-group input-group-sm">
								<button id="btn_add_product" type="button"
									class="btn btn-primary btn-sm" @click="return_part">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;返回
								</button>
							</div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div v-show="showOperPart" class="box box-custom collapsed-box"
		style="margin-bottom: 0;">
		<div class="box-body">
			<table id="table" class="table"></table>
		</div>
		<div>
			<div class="input-group input-group-sm" style="margin-left: 48%;">
				<button id="btn_add_product" type="button" style="margin-right: 8px;"
					class="btn btn-primary btn-sm" @click="return_part">
					<span class="glyphicon glyphicon-film" aria-hidden="true"></span>&nbsp;&nbsp;确定
				</button>
				<button id="btn_add_product" type="button"
					class="btn btn-primary btn-sm" @click="goBack">
					<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>&nbsp;&nbsp;返回
				</button>
			</div>
		</div>
		<div style="height:10px;"></div>
	</div>

</div>

<script src="${ctx}/resource/js/sysPage/dcsProduct/partInfo.js"></script>