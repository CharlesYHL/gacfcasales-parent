$(function() {
	var oTable = new TableInit();
	oTable.Init();
});

var vm = new Vue({
	el : '#productApp',
	data : {
		q : {
			productNo : null,
			productName : null

		},
		showOperPart : true,
		title : null,
	},
	methods : {
		query : function() {

			var oTable = new TableInit();
			oTable.Init();

			vm.reload();
		},
		goBack : function() {
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index)
		},
		returnSales : function() {
			var selected = $('#table').bootstrapTable('getSelections');
			console.log(selected.length);
			
			var params = {
				PRODUCT_ID : selected[0].PRODUCT_ID,
				PRODUCT_NO : selected[0].PRODUCT_NO,
				PRODUCT_NAME : selected[0].PRODUCT_NAME,
				PRODUCT_DESCRIBTION:selected[0].PRODUCT_DESCRIBTION,
				PRODUCT_DATE:selected[0].PRODUCT_DATE,
				TERMINAL_NON_SALES_PRICE:selected[0].TERMINAL_NON_SALES_PRICE,
				TERMINAL_SALES_PRICE:selected[0].TERMINAL_SALES_PRICE,
				NON_TAX_COST_PRICE:selected[0].NON_TAX_COST_PRICE,
				TAX_COST_PRICE:selected[0].TAX_COST_PRICE
			};
			
			parent.getProductChild(params);
			var index1 = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index1);
			
			/*window.location.href = ctx
					+ '/dmsSales/ajax/fromProductToAddSales?PRODUCT_ID='
					+ selected[0].PRODUCT_ID + '&PRODUCT_NO='
					+ selected[0].PRODUCT_NO + '&PRODUCT_NAME='
					+ selected[0].PRODUCT_NAME + '&PRODUCT_DESCRIBTION='
					+ selected[0].PRODUCT_DESCRIBTION + '&PRODUCT_DATE='
					+ selected[0].PRODUCT_DATE + '&TERMINAL_NON_SALES_PRICE='
					+ selected[0].TERMINAL_NON_SALES_PRICE
					+ '&TERMINAL_SALES_PRICE='
					+ selected[0].TERMINAL_SALES_PRICE*/

			/*
			 * window.location.href = ctx+
			 * '/dmsSales/ajax/fromVehclistToAddSales?VIN=' +selected[0].VIN
			 */

		},
		reset : function() {
			$("#productNo").val('');
			$("#productName").val('');
			vm.reload();
		},
		reload : function() {
			vm.showOperPart = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#table').bootstrapTable({
			url : ctx + '/dmsSales/ajax/getProductList',
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
			pageSize : 5, // 每页的记录行数（*）
			pageList : [ 10, 20, 50, 100 ], // 可供选择的每页的行数（*）
			height : 350,
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
			}, {
				radio : true,
				sortable : false
			}, {
				field : 'PRODUCT_ID',
				title : 'PRODUCT_ID',
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
				field : 'PRODUCT_DESCRIBTION',
				title : '产品说明',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'PRODUCT_DATE',
				title : '产品有效期',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'TERMINAL_NON_SALES_PRICE',
				title : '不含税终端销售价',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'TERMINAL_SALES_PRICE',
				title : '含税终端销售价(6%)',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'NON_TAX_COST_PRICE',
				title : '不含税成本价',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'TAX_COST_PRICE',
				title : '含税成本价(6%)',
				align : 'center',
				valign : 'middle',
				visible : false
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
			PRODUCT_NAME : $("#productName").val()
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
