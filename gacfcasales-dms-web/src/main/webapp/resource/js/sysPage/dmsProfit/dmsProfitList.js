$(function(){
	// 产品有效期
	jQuery("#productDate").append("<option value='0'>请选择</option>");
	jQuery("#productDate").append("<option value='12'>12个月</option>");
	jQuery("#productDate").append("<option value='24'>24个月</option>");
	jQuery("#productDate").append("<option value='36'>36个月</option>");

	// 设置日期控件
	$('#createStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#createEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	$('#closedStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#closedEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	var oTable = new TableInit();
	oTable.Init();
});


var vm = new Vue({
	el : '#profitListApp',
	data : {
		q : {
			productSalesOrder : null,
			productNo : null,
			productName : null,
			productDate : null,
			vin : null,
			licenseNo : null,
			customerName : null,
			createStart : null,
			createEnd : null,
			closedStart : null,
			closedEnd : null

		},
		showList : true,
		title : null,
	},
	methods : {
		query : function() {
			var oTable = new TableInit();
			oTable.Init();
			vm.reload();
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
							url : ctx + '/dmsProfit/ajax/getProfitList',
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
							height : 450,
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
										field : '操作',
										title : '操作',
										align : 'center',
										valign : 'middle',
										width : '120',
										formatter : function(value, row, index) {
											var operate = '<div style="width:120px;">'
											operate += '<button class="btn btn-primary btn-xs" href="#" onclick="detail(\''
													+ row.PRODUCT_SALES_ID
													+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
											return operate;
										}
									}, {
										field : 'PRODUCT_SALES_ID',
										title : '主键ID',
										align : 'center',
										valign : 'middle',
										visible : false
									}, {
										field : 'PRODUCT_ID',
										title : '产品ID',
										align : 'center',
										valign : 'middle',
										visible : false
									}, {
										field : 'PRODUCT_SALES_ORDER',
										title : '销售单编号',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'SAP_SALES_ORDER',
										title : 'SAP订单号',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'ORDER_STATUS',
										title : '单据状态',
										align : 'center',
										valign : 'middle'
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
										field : 'PRODUCT_DATE',
										title : '产品有效期',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_DESCRIBTION',
										title : '产品说明',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CUSTOMER_NAME',
										title : '客户姓名',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CUSTOMER_CONTACT',
										title : '客户联系方式',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'VIN',
										title : 'VIN',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'LICENSE_NO',
										title : '车牌号',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'OWNER_NAME',
										title : '车主姓名',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'OWNER_MOBILE',
										title : '车主手机',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CREATED_AT',
										title : '创建时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CREATE_NAME',
										title : '创建人',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TAKE_EFFECT_START',
										title : '生效开始时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TAKE_EFFECT_END',
										title : '生效结束时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PURCHASE_NUMBER',
										title : '购买数量',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'NON_TAX_COST_PRICE',
										title : '不含税成本价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TAX_COST_PRICE',
										title : '含税成本价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TERMINAL_NON_SALES_PRICE',
										title : '终端不含税销售价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TERMINAL_SALES_PRICE',
										title : '终端含税销售价（6%）',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'ACTUAL_NON_SALES_PRICE',
										title : '实际不含税销售价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TOTAL_AMOUNT',
										title : '含税总额（6%）',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'COST_PROFIT',
										title : '毛利',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CLOSED_NAME',
										title : '结案人',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CLOSED_AT',
										title : '结案时间',
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
			PRODUCT_SALES_ORDER : $("#productSalesOrder").val(),
			PRODUCT_NO : $("#productNo").val(),
			PRODUCT_NAME : $("#productName").val(),
			PRODUCT_DATE : $("#productDate").val(),
			VIN : $("#vin").val(),
			LICENSE_NO : $("#licenseNo").val(),
			CUSTOMER_NAME : $("#customerName").val(),
			CREATED_AT_START : $("#createStart").val(),
			CREATED_AT_END : $("#createEnd").val(),
			CLOSED_AT_START : $("#closedStart").val(),
			CLOSED_AT_END : $("#closedEnd").val()
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
function resetaa() {
	$("#productSalesOrder").val('');
	$("#productNo").val('');
	$("#productName").val('');
	$('#productDate').val('0');
	$("#vin").val('');
	$("#licenseNo").val();
	$("#customerName").val();
	$("#createStart").val('');
	$("#createEnd").val('');
	$("#closedStart").val('');
	$("#closedEnd").val('');
	vm.reload();

}

function query() {
	var oTable = new TableInit();
	oTable.Init();
	vm.reload();
}

function exportExcel() {
	var PRODUCT_SALES_ORDER = $("#productSalesOrder").val();
	var PRODUCT_NO = $("#productNo").val();
	var PRODUCT_NAME = $("#productName").val();
	var PRODUCT_DATE = $("#productDate").val();
	var VIN = $("#vin").val();
	var LICENSE_NO = $("#licenseNo").val();
	var CUSTOMER_NAME = $("#customerName").val();
	var CREATED_AT_START = $("#createStart").val();
	var CREATED_AT_END = $("#createEnd").val();
	var CLOSED_AT_START = $("#closedStart").val();
	var CLOSED_AT_END = $("#closedEnd").val();

	window.location.href = ctx + '/dmsProfit/ajax/exportProfitExcel?PRODUCT_SALES_ORDER='
			+ encodeURI(encodeURI(PRODUCT_SALES_ORDER)) + '&PRODUCT_NO='
			+ encodeURI(encodeURI(PRODUCT_NO)) + '&PRODUCT_NAME='
			+ encodeURI(encodeURI(PRODUCT_NAME)) + '&PRODUCT_DATE='
			+ encodeURI(encodeURI(PRODUCT_DATE)) + '&VIN='
			+ encodeURI(encodeURI(VIN)) + '&LICENSE_NO='
			+ encodeURI(encodeURI(LICENSE_NO)) + '&CUSTOMER_NAME='
			+ encodeURI(encodeURI(CUSTOMER_NAME)) + '&CREATED_AT_START='
			+ encodeURI(encodeURI(CREATED_AT_START)) + '&CREATED_AT_END='
			+ encodeURI(encodeURI(CREATED_AT_END)) + '&CLOSED_AT_START='
			+ encodeURI(encodeURI(CLOSED_AT_START)) + '&CLOSED_AT_END='
			+ encodeURI(encodeURI(CLOSED_AT_END))

}

function detail(productSalesId){
	if(productSalesId != '' ){
		globe_index = layer.open({
			id : 'detailProfit',
			title : '销售盈利明细',
			type : 2,
			area : [ '60%', '100%' ],
			fixed : true, // 固定
			maxmin : false,
			content : ctx + '/dmsProfit/ajax/detailProfit?PRODUCT_SALES_ID='+productSalesId
		});
	}
}

