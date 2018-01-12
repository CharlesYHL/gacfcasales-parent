$(function() {
	getBrand();
	
	var oTable = new TableInitModel();
	oTable.Init();
	
});


var vm = new Vue({
	el : '#modelApp',
	data : {
		q : {
			PRODUCT_ID : null,
			BRAND_CODE : null,
			BRAND_NAME : null,
			SERIES_CODE : null,
			SERIES_NAME : null,
			MODEL_CODE : null,
			MODEL_NAME : null

		},
		showOperModel : true,
		title : null,
		tiOpiExtendedModel : {
			PRODUCT_ID : null,
			BRAND_CODE : null,
			BRAND_NAME : null,
			SERIES_CODE : null,
			SERIES_NAME : null,
			MODEL_CODE : null,
			MODEL_NAME : null

		}
	},
	methods : {
		query : function() {
			//vm.reload();
			var $menu = $("#tabUl");
			var $itemActive = $menu.find('.active').eq(0).attr('id'); // 选中项
			console.log($itemActive);
			
			if($itemActive == 'modelLi' ){
				var oTable = new TableInitModel();
				oTable.Init();
				vm.modelReload();
			}else{
				var oTable = new TableInitSeries();
				oTable.Init();
				vm.seriesReload();
			}
			
			
			
		},
		reset : function() {
			$("#brandId").empty();  
			$("#brandId").selectpicker('refresh');
			getBrand();
			$("#seriesId").empty();  
			$("#seriesId").selectpicker('refresh');
			$("#modelId").empty();  
			$("#modelId").selectpicker('refresh');
		},
		confirm : function(){
			
			var $menu = $("#tabUl");
			var $itemActive = $menu.find('.active').eq(0).attr('id'); // 选中项
			console.log($itemActive);
			
			if($itemActive == 'modelLi' ){
				var selected = $('#model_table').bootstrapTable('getSelections');
				console.log(selected.length);
				for(var item in selected){
					console.log(selected[item].model_ID);
					console.log(selected[item].model_NAME);
					console.log($("#productId").val());
					var productId = $("#productId").val();
					selected[item].product_ID = $("#productId").val();
				}
				$.ajax({
					type: "POST",
				    url: ctx + "/sysProduct/ajax/addProductModel",
			        contentType: "application/json",
				    dataType: "json",
				    data:JSON.stringify({
				    	"modelPageList":selected
				    }),
					cache: false,
				    success: function(data){
				    	console.log("返回参数:"+data);
				    	if(data == 0){
				    		window.location.href = ctx+ '/sysProduct/ajax/modelToProduct?productId='+$("#productId").val();
				    	}
					},error :function(data){
						console.log(data);
					}
				});
				
				
			}else{
				var selected = $('#series_table').bootstrapTable('getSelections');
				console.log(selected.length);
				
				for(var item in selected){
					console.log(selected[item].model_ID);
					console.log(selected[item].model_NAME);
					console.log($("#productId").val());
					var productId = $("#productId").val();
					selected[item].product_ID = $("#productId").val();
				}
				$.ajax({
					type: "POST",
				    url: ctx + "/sysProduct/ajax/addProductModel",
			        contentType: "application/json",
				    dataType: "json",
				    data:JSON.stringify({
				    	"modelPageList":selected
				    }),
					cache: false,
				    success: function(data){
				    	if(data == 0){
				    		window.location.href = ctx+ '/sysProduct/ajax/modelToProduct?productId='+$("#productId").val();
				    	}
					},error :function(data){
						
					}
				});
				
				
			}
		},
		goBack : function(){
			console.log("返回");
			var index = parent.layer.getFrameIndex(window.name);
			console.log(index);
			parent.layer.close(index);
		},
		modelReload : function() {
			vm.showOperModel = true;
			$('#model_table').bootstrapTable('refresh');
		},
		seriesReload : function() {
			vm.showOperModel = true;
			$('#series_table').bootstrapTable('refresh');
		}
	}
});

function getBrand(){
	$.ajax({
		type: "GET",
	    url: ctx + "/sysProduct/ajax/getBrandList",
        contentType: "application/json",
	    dataType: "json",
		cache: false,
	    success: function(data){
	    	if(data.length > 0){
	    		var optionstring = "<option value='0'>请选择</option>";  
	    		for(var item in data){
	    			console.log(data[item]);
	    			optionstring += "<option value='"+data[item].BRAND_ID+"'>"+data[item].BRAND_NAME+"</option>";
	    		}
	    		$("#brandId").html(optionstring);
	    		$("#brandId").selectpicker('refresh');
	    	}
		},error :function(data){
			
		}
	});
}

function getSeries(){
	var groupId = $("#brandId").val();
	$("#modelId").empty();  
	$("#modelId").selectpicker('refresh');
	$.ajax({
		type: "GET",
	    url: ctx + "/sysProduct/ajax/getSeriesList?groupId="+groupId,
        contentType: "application/json",
	    data: JSON.stringify(vm.sysUser),
	    dataType: "json",
		cache: false,
	    success: function(data){
	    	if(data.length > 0){
	    		var optionstring = "<option value='0'>请选择</option>";  
	    		for(var item in data){
	    			console.log(data[item]);
	    			optionstring += "<option value='"+data[item].SERIES_ID+"'>"+data[item].SERIES_NAME+"</option>";
	    		}
	    		$("#seriesId").html(optionstring);
	    		$("#seriesId").selectpicker('refresh');
	    		//$("#modelId").selectpicker('refresh');
	    	}
		},error :function(data){
			
		}
	});
}


function getModel(){
	var groupId = $("#seriesId").val();
	$.ajax({
		type: "GET",
	    url: ctx + "/sysProduct/ajax/getModelList?groupId="+groupId,
        contentType: "application/json",
	    data: JSON.stringify(vm.sysUser),
	    dataType: "json",
		cache: false,
	    success: function(data){
	    	if(data.length > 0){
	    		var optionstring = "<option value='0'>请选择</option>";  
	    		for(var item in data){
	    			console.log(data[item]);
	    			optionstring += "<option value='"+data[item].MODEL_ID+"'>"+data[item].MODEL_NAME+"</option>";
	    		}
	    		$("#modelId").html(optionstring);
	    		$("#modelId").selectpicker('refresh');
	    	}
		},error :function(data){
			
		}
	});
}


var TableInitModel = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#model_table').bootstrapTable({
			url : ctx + '/sysProduct/ajax/getModelTableList',
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
			}, {
	    		checkbox: true	
	    	},{
	            field : 'product_ID',
	            title : 'product_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'brand_ID',
	            title : 'brand_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'brand_CODE',
	            title : 'brand_CODE',
	            align : 'center',
	            valign : 'middle',
				visible : false
	            	
	        },{
	            field : 'brand_NAME',
	            title : '品牌',
	            align : 'center',
	            valign : 'middle'
	        },{
	            field : 'series_ID',
	            title : 'series_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'series_CODE',
	            title : '车系代码',
	            align : 'center',
	            valign : 'middle'
	        },{
	            field : 'series_NAME',
	            title : '车系名称',
	            align : 'center',
	            valign : 'middle'
	        },{
	            field : 'model_ID',
	            title : 'model_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'model_CODE',
	            title : 'model_CODE',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'model_NAME',
	            title : '车型名称',
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
			BRAND_ID : $("#brandId").val(),
			SERIES_ID : $("#seriesId").val(),
			MODEL_ID : $("#modelId").val(),
			
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


var TableInitSeries = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#series_table').bootstrapTable({
			url : ctx + '/sysProduct/ajax/getSeriesTableList',
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
			}, {
	    		checkbox: true	
	    	},{
	            field : 'product_ID',
	            title : 'product_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'brand_ID',
	            title : 'brand_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'brand_CODE',
	            title : 'brand_CODE',
	            align : 'center',
	            valign : 'middle',
				visible : false
	            	
	        },{
	            field : 'brand_NAME',
	            title : '品牌',
	            align : 'center',
	            valign : 'middle'
	        },{
	            field : 'series_ID',
	            title : 'series_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'series_CODE',
	            title : '车系代码',
	            align : 'center',
	            valign : 'middle'
	        },{
	            field : 'series_NAME',
	            title : '车系名称',
	            align : 'center',
	            valign : 'middle'
	        },{
	            field : 'model_ID',
	            title : 'model_ID',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'model_CODE',
	            title : 'model_CODE',
	            align : 'center',
	            valign : 'middle',
				visible : false
	        },{
	            field : 'model_NAME',
	            title : '车型名称',
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
			BRAND_ID : $("#brandId").val(),
			SERIES_ID : $("#seriesId").val(),
			MODEL_ID : $("#modelId").val(),
			
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


function modelClick(){
	var oTable = new TableInitModel();
	oTable.Init();
}

function seriesClick(){
	var oTable = new TableInitSeries();
	oTable.Init();
}



