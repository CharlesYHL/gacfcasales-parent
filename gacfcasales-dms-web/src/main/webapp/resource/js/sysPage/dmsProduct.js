$(function() {
	// 产品有效期
	jQuery("#productDate").append("<option value='0'>请选择</option>");
	jQuery("#productDate").append("<option value='12'>12个月</option>");
	jQuery("#productDate").append("<option value='24'>24个月</option>");
	jQuery("#productDate").append("<option value='36'>36个月</option>");

	// 发布状态
	jQuery("#releaseStatus").append("<option value='0'>请选择</option>");
	jQuery("#releaseStatus").append("<option value='54011001'>未发布</option>");
	jQuery("#releaseStatus").append("<option value='54011002'>已发布</option>");
	jQuery("#releaseStatus").append("<option value='54011003'>已取消</option>");

	// 设置日期控件
	$('#releaseStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#releaseEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	$('#salesStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#salesEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	var oTable = new TableInit();
	oTable.Init();
});



function exportExcel(){
	console.log("进入下载功能........");
	var PRODUCT_NO = $("#productNo").val();
	var PRODUCT_NAME = $("#productName").val();
	var PRODUCT_DATE = $("#productDate").val();
	var RELEASE_STATUS = $("#releaseStatus").val();
	var PRODUCT_MODEL = $("#productModel").val();
	var releaseStart = $("#releaseStart").val();
	var releaseEnd = $("#releaseEnd").val();
	var salesStart = $("#salesStart").val();
	var salesEnd = $("#salesEnd").val();
	
	window.location.href = ctx
	+ '/dmsProduct/ajax/productExcel?PRODUCT_NO='
	+ encodeURI(encodeURI(PRODUCT_NO)) + '&PRODUCT_NAME='
	+ encodeURI(encodeURI(PRODUCT_NAME)) + '&PRODUCT_DATE='
	+ encodeURI(encodeURI(PRODUCT_DATE)) + '&RELEASE_STATUS='
	+ encodeURI(encodeURI(RELEASE_STATUS)) + '&PRODUCT_MODEL='
	+ encodeURI(encodeURI(PRODUCT_MODEL)) + '&releaseStart='
	+ encodeURI(encodeURI(releaseStart)) + '&releaseEnd='
	+ encodeURI(encodeURI(releaseEnd)) + '&salesStart='
	+ encodeURI(encodeURI(salesStart)) + '&salesEnd='
	+ encodeURI(encodeURI(salesEnd));
}


var vm = new Vue({
	el : '#productApp',
	data : {
		q : {
			productNo : null,
			productName : null,
			productCategory : null,
			productProperty : null,
			IS_VALID : null,
			productDate : null,
			releaseStatus : null,
			productModel : null,
			isCSales : null,
			releaseStart : null,
			releaseEnd : null,
			salesStart : null,
			salesEnd : null

		},
		showList : true,
		showOper : false,
		showOperPart : false,
		title : null,
		tiOpiExtendedDCS : {
			PRODUCT_ID : null,
			PRODUCT_NO : null,
			PRODUCT_NAME : null,
			PRODUCT_PROPERTY : null,
			PRODUCT_CATEGORY : null,
			DNP_PRICE : null,
			MSRP_PRICE : null,
			SINGLE_DISCOUNT : null,
			IS_VALID : null,
			CREATED_BY : null,
			CREATED_AT : null,
			UPDATED_BY : null,
			UPDATED_AT : null,
			IS_C_SALE : null,
			PRODUCT_DATE : null,
			PRODUCT_MODEL : null,
			SALES_DATE : null,
			RELEASE_DATE : null,
			RELEASE_STATUS : null,
			STOP_DATE : null,
			PRODUCT_FAIT : null,
			PRODUCT_JEEP : null,
			PRODUCT_CJD : null,
			PRODUCT_DESCRIBTION : null,
			NON_TAX_COST_PRICE : null,
			TAX_COST_PRICE : null,
			TERMINAL_NON_SALES_PRICE : null,
			TERMINAL_SALES_PRICE : null,
			releaseStart : null,
			releaseEnd : null,
			salesStart : null,
			salesEnd : null
		}
	},
	methods : {
		query : function() {
			var oTable = new TableInit();
			oTable.Init();
			vm.reload();
		},
		reset : function() {
			$("#productNo").val('');
			$("#productName").val('');
			$('#productDate').selectpicker('val', '0');
			$('#releaseStatus').selectpicker('val', '0');
			$("#productModel").val('');
			$("#releaseStart").val('');
			$("#releaseEnd").val('');
			$("#salesStart").val('');
			$("#salesEnd").val('');
			vm.reload();
		},
		exportExcel : function() {
			var param = {
				PRODUCT_NO : $("#productNo").val(),
				PRODUCT_NAME : $("#productName").val(),
				PRODUCT_DATE : $("#productDate").val(),
				RELEASE_STATUS : $("#releaseStatus").val(),
				PRODUCT_MODEL : $("#productModel").val(),
				releaseStart : $("#releaseStart").val(),
				releaseEnd : $("#releaseEnd").val(),
				salesStart : $("#salesStart").val(),
				salesEnd : $("#salesEnd").val()
			};

		

			window.location.href = ctx
					+ '/dmsProduct/ajax/productExcel?PRODUCT_NO='
					+ encodeURI(encodeURI(PRODUCT_NO)) + '&PRODUCT_NAME='
					+ encodeURI(encodeURI(PRODUCT_NAME)) + '&PRODUCT_DATE='
					+ encodeURI(encodeURI(PRODUCT_DATE)) + '&RELEASE_STATUS='
					+ encodeURI(encodeURI(RELEASE_STATUS)) + '&PRODUCT_MODEL='
					+ encodeURI(encodeURI(PRODUCT_MODEL)) + '&releaseStart='
					+ encodeURI(encodeURI(releaseStart)) + '&releaseEnd='
					+ encodeURI(encodeURI(releaseEnd)) + '&salesStart='
					+ encodeURI(encodeURI(salesStart)) + '&salesEnd='
					+ encodeURI(encodeURI(salesEnd));

		},
		reload : function() {
			vm.showList = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#table')
				.bootstrapTable(
						{
							url : ctx + '/dmsProduct/ajax/getProductList',
							method : 'POST',
							toolbar : '#toolbar', // 工具按钮用哪个容器
							dataType : 'json',
							contentType : "application/x-www-form-urlencoded",
							cache : false,
							striped : true, // 是否显示行间隔色
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
							pagination : true,
							queryParams : this.queryParams,
							"queryParamsType" : "limit",
							minimumCountColumns : 2,
							pageNumber : 1, // 初始化加载第一页，默认第一页
							pageSize : 10, // 每页的记录行数（*）
							pageList : [ 10, 20, 50, 100 ], // 可供选择的每页的行数（*）
							uniqueId : "id", // 每一行的唯一标识，一般为主键列
							showRefresh : false, // 是否显示刷新按钮
							showToggle : false, // 是否显示详细视图和列表视图的切换按钮
							showColumns : false,
							responseHandler : this.responseHandler,
							columns : [
									{
										field : '',
										title : '序号',
										align : 'center',
										valign : 'middle',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										checkbox : true
									},
									{
										field : '操作',
										title : '操作',
										align : 'center',
										valign : 'middle',
										width : '120',
										formatter : function(value, row, index) {
											var operate = '<div style="width:120px;">'

											operate += '<button class="btn btn-primary btn-xs" href="#" onclick="detail(\''
													+ row.PRODUCT_ID
													+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '

											operate += '</div>';
											return operate;
										}
									}, {
										field : 'PRODUCT_ID',
										title : '产品ID',
										align : 'center',
										valign : 'middle',
										visible : false
									}, {
										field : 'PRODUCT_NO',
										title : '产品编号',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_NAME',
										title : '产品名称',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'IS_VALID',
										title : '是否有效',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'NON_TAX_COST_PRICE',
										title : '不含税成本价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TAX_COST_PRICE',
										title : '含税成本价(6%)',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TERMINAL_NON_SALES_PRICE',
										title : '终端不含税销售价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TERMINAL_SALES_PRICE',
										title : '终端含税销售价(6%)',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'SALES_DATE_ALL',
										title : '销售时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_DATE',
										title : '产品有效期',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'RELEASE_DATE',
										title : '发布时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'RELEASE_STATUS',
										title : '发布状态',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'IS_C_SALE',
										title : '是否可销售',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_MODEL',
										title : '适用车型',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_DESCRIBTION',
										title : '产品说明',
										align : 'center',
										valign : 'middle'
									} ]
						});
	};

	oTableInit.queryParams = function(params) {
		var param = {
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			pageindex : this.pageNumber,
			pageSize : this.pageSize,
			PRODUCT_NO : $("#productNo").val(),
			PRODUCT_NAME : $("#productName").val(),
			PRODUCT_DATE : $("#productDate").val(),
			RELEASE_STATUS : $("#releaseStatus").val(),
			PRODUCT_MODEL : $("#productModel").val(),
			releaseStart : $("#releaseStart").val(),
			releaseEnd : $("#releaseEnd").val(),
			salesStart : $("#salesStart").val(),
			salesEnd : $("#salesEnd").val()
		}
		return param;
	};

	// 用于server 分页，表格数据量太大的话
	// 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server" 改为
	// sidePagination: "client" ，同时去掉responseHandler: responseHandler就可以了，
	oTableInit.responseHandler = function(res) {
		if (res.code == 200) {
			return {
				"rows" : res.dataListMap,
				"total" : res.totalCount
			};
		} else {
			return {
				"rows" : [],
				"total" : 0
			};
		}
	};

	return oTableInit;

};


