$(function() {
	var oTable = new TableInit();
	oTable.Init();
});

var vm = new Vue({
	el : '#detailProduct',
	data : {
		q : {
			PRODUCT_ID : null,
			PRODUCT_NO : null,
			PRODUCT_NAME : null,
			PRODUCT_PROPERTY : null,
			PRODUCT_CATEGORY : null,
			DNP_PRICE : null,
			MSRP_PRICE : null,
			PRODUCT_DATE : null,
			SALES_DATE_START : null,
			SALES_DATE_END : null,
			PRODUCT_FAIT : null,
			PRODUCT_JEEP : null,
			PRODUCT_CJD : null,
			PRODUCT_DESCRIBTION : null

		},
		showOper : true,
		title : null,
		tiExtendedPage : {
			PRODUCT_ID : null,
			PRODUCT_NO : null,
			PRODUCT_NAME : null,
			PRODUCT_PROPERTY : null,
			PRODUCT_CATEGORY : null,
			DNP_PRICE : null,
			MSRP_PRICE : null,
			PRODUCT_DATE : null,
			SALES_DATE_START : null,
			SALES_DATE_END : null,
			PRODUCT_FAIT : null,
			PRODUCT_JEEP : null,
			PRODUCT_CJD : null,
			PRODUCT_DESCRIBTION : null
		}
	},
	methods : {
		query : function() {
			vm.reload();
		},
		mounted : function() {
			console.log("vue start...");
		},
		goBack : function() {
			console.log("返回");
			// console.log(parent.globe_index);
			index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		},
		dealerExport : function() {
			var productId = $("#productId").val();
			if (productId != '') {
				window.location.href = ctx
						+ '/sysProduct/ajax/dealerDetail?PRODUCT_ID='
						+ productId;
			} else {
				alert("产品信息不存在，无法导出");
			}

		},
		reload : function() {
			vm.showOper = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#table').bootstrapTable({
			url : ctx + '/sysProduct/ajax/getDetailModelList',
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
			columns : [ {
				field : '',
				title : '序号',
				align : 'center',
				valign : 'middle',
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				checkbox : true
			}, {
				field : 'PRODUCT_MODEL_ID',
				title : 'PRODUCT_MODEL_ID',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'PRODUCT_ID',
				title : 'PRODUCT_ID',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'PRODUCT_NO',
				title : 'PRODUCT_NO',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'PRODUCT_NAME',
				title : 'PRODUCT_NAME',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'PRODUCT_PROPERTY',
				title : 'PRODUCT_PROPERTY',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'BRAND_NAME',
				title : '品牌',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'SERIES_NAME',
				title : '车系',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'MODEL_NAME',
				title : '车型',
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
			PRODUCT_ID : $("#productId").val()

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
