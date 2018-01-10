$(function(){
	var oTable = new TableInit();
	oTable.Init();
	
	//产品有效期
	jQuery("#productDate").append("<option value='0'>请选择</option>");
	jQuery("#productDate").append("<option value='12'>12个月</option>");
	jQuery("#productDate").append("<option value='24'>24个月</option>");
	jQuery("#productDate").append("<option value='36'>36个月</option>");
	
	//是否FIAT授权
	jQuery("#isFiat").append("<option value='0'>请选择</option>");
	jQuery("#isFiat").append("<option value='12781001'>是</option>");
	jQuery("#isFiat").append("<option value='12781002'>否</option>");
	
	
	//是否国产JEEP授权
	jQuery("#isJeep").append("<option value='0'>请选择</option>");
	jQuery("#isJeep").append("<option value='12781001'>是</option>");
	jQuery("#isJeep").append("<option value='12781002'>否</option>");
	
	
	//是否CJD授权
	jQuery("#isCjd").append("<option value='0'>请选择</option>");
	jQuery("#isCjd").append("<option value='12781001'>是</option>");
	jQuery("#isCjd").append("<option value='12781002'>否</option>");
	
});
/*弹出的层级*/
var index;
function addPart(){
	var partNo = $("#productNo").val();
	console.log("addPart ...");
	index = parent.layer.open({
		  title: '新增产品',
		  type: 2,
		  area: ['80%', '66%'],
		  fixed: true, //固定
		  maxmin: false,
		  content: ctx+'/sysProduct/ajax/partInfo?partNo='+partNo,
		  end : function(){
				i = 0;
			}
		});
	//parent.layer.close(index);
	var index1 = parent.layer.getFrameIndex(window.name); 
	parent.layer.close(index1)
};

var vm = new Vue({
	el:'#addProduct',
	data:{
		q:{
			productNo: null,
			productName:null,
			productCategory:null,
			productProperty:null,
			IS_VALID:null,
			productDate:null,
			releaseStatus:null,
			productModel:null,
			isCSales:null,
			releaseStart:null,
			releaseEnd:null,
			salesStart:null,
			salesEnd:null
			
		},
		showOper: true,
		title:null,
		tiOpiExtendedDCS:{
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
			releaseStart:null,
			releaseEnd:null,
			salesStart:null,
			salesEnd:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		mounted:function(){
			console.log("vue start...");
		},
		reload: function () {
	    	vm.showOper = true;
	    	$('#table').bootstrapTable('refresh'); 
		}
	}
});




var TableInit=function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#table').bootstrapTable({
			url : ctx + '/sysProduct/ajax/getProductModelList',
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
			columns : [ {
				field : '',
				title : '序号',
				align : 'center',
				valign : 'middle',
				formatter : function(value, row, index) {
					return index + 1;
				}
			},{
	    		checkbox: true	
	    	},
	    	{
				field : 'PRODUCT_MODEL_ID',
				title : 'MODEL_ID',
				align : 'center',
				valign : 'middle',
				visible : true
			},
			{
				field : 'PRODUCT_ID',
				title : 'PRODUCT_ID',
				align : 'center',
				valign : 'middle',
				visible : true
			},
			{
				field : 'PRODUCT_NO',
				title : 'PRODUCT_NO',
				align : 'center',
				valign : 'middle',
				visible : true
			},
			{
				field : 'PRODUCT_NAME',
				title : 'PRODUCT_NAME',
				align : 'center',
				valign : 'middle',
				visible : true
			},
			{
				field : 'PRODUCT_PROPERTY',
				title : 'PRODUCT_PROPERTY',
				align : 'center',
				valign : 'middle',
				visible : true
			},
	    	{
				field : 'BRAND_NAME',
				title : '品牌',
				align : 'center',
				valign : 'middle'
			},{
				field : 'SERIES_NAME',
				title : '车系',
				align : 'center',
				valign : 'middle'
			},{
				field : 'MODEL_NAME',
				title : '车系',
				align : 'center',
				valign : 'middle'
			}
			]
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
			PRODUCT_CATEGORY : $("#productCategory").val(),
			PRODUCT_PROPERTY : $("#productProperty").val(),
			PRODUCT_DATE : $("#productDate").val(),
			DNP_PRICE : $("#dnpPrice").val(),
			MSRP_PRICE : $("#msrpPrice").val(),
			PRODUCT_FAIT : $("#isFiat").val(),
			PRODUCT_JEEP : $("#isJeep").val(),
			PRODUCT_CJD : $("#isCjd").val(),
		}
		return param;
	};
	
	// 用于server 分页，表格数据量太大的话
	// 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server" 改为
	// sidePagination: "client" ，同时去掉responseHandler: responseHandler就可以了，
	oTableInit.responseHandler = function(res) {
		if (res.code == 200) {
			return {
				"rows" : res.dataList,
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

