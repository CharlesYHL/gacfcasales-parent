$(function() {
	// 设置日期控件
	$('#createAt').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#billingAt').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	
	jQuery("#brandId").append("<option value='0'>请选择</option>");
	jQuery("#seriesId").append("<option value='0'>请选择</option>");
	jQuery("#modelId").append("<option value='0'>请选择</option>");
	jQuery("#apackage").append("<option value='0'>请选择</option>");
	

});
var index;
var params;

function getChildValues(values){
	params = values;
	console.log("接受到数据："+JSON.stringify(params));
	var oldVin = $("#vin").val();
	if(oldVin != params.VIN){
		console.log(params.VIN);
		$("#vin").val(params.VIN);
		$("#billingAt").val(params.INVOICE_DATE);
		$("#ownerNo").val(params.OWNER_NO);
		$("#ownerName").val(params.OWNER_NAME);
		$("#ownerPhone").val(params.PHONE);
		$("#ownerMobile").val(params.MOBILE);
		$("#yearModel").val(params.YEAR_MODEL);
		$("#liceseNo").val(params.LICENSE);
		$("#licese").val(params.LICENSE);
		
		$("#brandCode").val(params.BRAND);
		$("#seriesCode").val(params.SERIES);
		$("#modelCode").val(params.MODEL);
		$("#apackageCode").val(params.APACKAGE);
		
		$("#brandName").val(params.BRAND_NAME);
		$("#seriesName").val(params.SERIES_NAME);
		$("#modelName").val(params.MODEL_NAME);
		$("#apackageName").val(params.APACKAGE_NAME);
		
		$("#customerName").val(params.OWNER_NAME);
		$("#customerContact").val(params.MOBILE);
		
		if(params.BRAND != ''){
			console.log(params.BRAND);
			$("#brandId").append("<option selected = 'selected' value='"+params.BRAND_ID+"'>"+params.BRAND_NAME+"</option>");
			$("#brandId").selectpicker('refresh');
			// jQuery("#brandId").append("<option selected = 'selected'
			// value='"+params.BRAND_ID+"'>"+params.BRAND_NAME+"</option>");
		}
		if(params.SERIES != ''){
			$("#seriesId").append("<option selected = 'selected' value='"+params.SERIES_ID+"'>"+params.SERIES_NAME+"</option>");
			$("#seriesId").selectpicker('refresh');
		}
		
		if(params.MODEL != ''){
			$("#modelId").append("<option selected = 'selected' value='"+params.MODEL_ID+"'>"+params.MODEL_NAME+"</option>");
			$("#modelId").selectpicker('refresh');
		}
		
		if(params.APACKAGE != ''){
			$("#apackage").append("<option selected = 'selected' value='"+params.APACKAGE_ID+"'>"+params.APACKAGE_NAME+"</option>");
			$("#apackage").selectpicker('refresh');
		}
		
		
		// 清空以前的产品信息
		$("#productId").val("");
		$("#productNo").val("");
		$("#productName").val("");
		$("#productDate").val("");
		$("#productDescribtion").val("");
		$("#terminalNonSalesPrice").val("");
		$("#terminalSalesPrice").val("");
		$("#nonTaxCostPrice").val("");
		$("#taxCostPrice").val("");
		$("#takeEffectStart").val("");
   	 	$("#takeEffectEnd").val("");
   	 	$("#actualNonSalesPrice").val("");
   	 	$("#totalAmount").val("");
   	 	
   	 var billingAt = params.INVOICE_DATE;
		if(billingAt != null && billingAt != ''){
			var nowDate = getNowDate();
			// var invoiceDate = $("#billingAt").val();
			getDay(nowDate,billingAt);
		}else{
			 $("#takeEffectStart").val('');
	    	 $("#takeEffectEnd").val('');
		}
		
	}else{
		console.log(params.VIN);
		$("#vin").val(params.VIN);
		$("#billingAt").val(params.INVOICE_DATE);
		$("#ownerNo").val(params.OWNER_NO);
		$("#ownerName").val(params.OWNER_NAME);
		$("#ownerPhone").val(params.PHONE);
		$("#ownerMobile").val(params.MOBILE);
		$("#yearModel").val(params.YEAR_MODEL);
		$("#liceseNo").val(params.LICENSE);
		
		$("#brandCode").val(params.BRAND);
		$("#seriesCode").val(params.SERIES);
		$("#modelCode").val(params.MODEL);
		$("#apackageCode").val(params.APACKAGE);
		
		$("#brandName").val(params.BRAND_NAME);
		$("#seriesName").val(params.SERIES_NAME);
		$("#modelName").val(params.MODEL_NAME);
		$("#apackageName").val(params.APACKAGE_NAME);
		
		$("#customerName").val(params.OWNER_NAME);
		$("#customerContact").val(params.MOBILE);
		
		var billingAt = params.INVOICE_DATE;
		if(billingAt != null && billingAt != ''){
			var nowDate = getNowDate();
			// var invoiceDate = $("#billingAt").val();
			getDay(nowDate,billingAt);
		}else{
			 $("#takeEffectStart").val('');
	    	 $("#takeEffectEnd").val('');
		}
		
		if(params.BRAND != ''){
			console.log(params.BRAND);
			$("#brandId").append("<option selected = 'selected' value='"+params.BRAND_ID+"'>"+params.BRAND_NAME+"</option>");
			$("#brandId").selectpicker('refresh');
			// jQuery("#brandId").append("<option selected = 'selected'
			// value='"+params.BRAND_ID+"'>"+params.BRAND_NAME+"</option>");
		}
		if(params.SERIES != ''){
			$("#seriesId").append("<option selected = 'selected' value='"+params.SERIES_ID+"'>"+params.SERIES_NAME+"</option>");
			$("#seriesId").selectpicker('refresh');
		}
		
		if(params.MODEL != ''){
			$("#modelId").append("<option selected = 'selected' value='"+params.MODEL_ID+"'>"+params.MODEL_NAME+"</option>");
			$("#modelId").selectpicker('refresh');
		}
		
		if(params.APACKAGE != ''){
			$("#apackage").append("<option selected = 'selected' value='"+params.APACKAGE_ID+"'>"+params.APACKAGE_NAME+"</option>");
			$("#apackage").selectpicker('refresh');
		}
	}
}

function getProductChild(values){
	params = values;
	console.log("接受到PRODUCT数据："+JSON.stringify(params));
	$("#productId").val(params.PRODUCT_ID);
	$("#productNo").val(params.PRODUCT_NO);
	$("#productName").val(params.PRODUCT_NAME);
	$("#productDate").val(params.PRODUCT_DATE);
	$("#productDescribtion").val(params.PRODUCT_DESCRIBTION);
	$("#terminalNonSalesPrice").val(params.TERMINAL_NON_SALES_PRICE);
	$("#terminalSalesPrice").val(params.TERMINAL_SALES_PRICE);
	
	$("#nonTaxCostPrice").val(params.NON_TAX_COST_PRICE);
	$("#taxCostPrice").val(params.TAX_COST_PRICE);
	
	var nowDate = getNowDate();
	var invoiceDate = $("#billingAt").val();
	getDay(nowDate,invoiceDate);
}

function queryVin() {
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSessionSign",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
			
			if(data.code != 401){
				index = layer.open({
					id : 'queryVin',
					title : '车主车辆查询',
					type : 2,
					area : [ '100%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/dmsSales/ajax/toVehclist?vin=' + $("#vin").val(),
					end : function() {
						i = 0;
					}
				});
			}else{
				/*
				 * alert("登陆超时，请重新登陆") setInterval(() => { var index1 =
				 * parent.layer.getFrameIndex(window.name);
				 * parent.layer.close(index1); }, 3000);
				 */
				
			}
		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});
	
	console.log(window.name);
}

function addProduct(){
	
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSessionSign",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
			
			if(data.code != 401){
				var billingAt= $("#billingAt").val();
				var vin = $("#vin").val();
				if(billingAt !='' && vin != ''){
				index = layer.open({
					id : 'queryProduct',
					title : '产品信息查询',
					type : 2,
					area : [ '100%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/dmsSales/ajax/toProductlist?productNo=' + $("#productNo").val()+'&modelId='+$("#modelId").val(),
					end : function() {
						i = 0;
					}
				});
				}else if(billingAt == '' && vin != ''){
					toastr.warning("开票日期不能为空");
					// alert("开票日期不能为空");
				}else{
					toastr.warning("请先选择车辆信息");
					// alert("请先选择车辆信息!");
				}
			}
			
		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});
	
	

}

var vm = new Vue({
	el : '#addSalesApp',
	data : {
		q : {
			salesOrder : null,
			createdBy : null,
			createAt : null,
			customerName : null,
			customerContact : null,
			orderStatus : null,
			vin : null,
			brandId : null,
			seriesId : null,
			modelId : null,
			apackage : null,
			yearModel : null,
			billingAt : null,
			ownerNo : null,
			ownerName : null,
			ownerPhone : null,
			ownerMobile : null,
			productNo : null,
			productName : null,
			productDate : null,
			productDescribtion : null,
			terminalNonSalesPrice : null,
			terminalSalesPrice : null,
			takeEffectStart : null,
			takeEffectEnd : null,
			purchaseNumber : null,
			actualNonSalesPrice : null,
			totalAmount : null

		},
		showList : true,
		title : null,
	},
	methods : {
		query : function() {
			vm.reload();
		},
		reload : function() {
			vm.showList = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});

function resetASC() {
	var index1 = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index1)
}


function getDay(a, b) {
	 a = new Date(a.replace(/-/g, '/'));
     b = new Date(b.replace(/-/g, '/'));
     var d = Math.abs(a.getTime() - b.getTime()) / 1000 / 24 / 60 / 60;
     // var year = Math.floor(d / 365);//
		// 不整除取最小的年数或者直接进位（Math.ceil），或者四舍五入Math.round，自己改这个罗
     var year = Math.ceil(d / 365)
     // alert(year)
     if (year > 3) {
         // 大于
    	 console.log('大于');
    	 
    	 //$("#takeEffectStart").val(addOneDay(more3YearStart(),1));
    	 //$("#takeEffectEnd").val(addOneDay(more3YeareEnd(),1));
    	 $("#takeEffectStart").val(more3YearStart());
    	 $("#takeEffectEnd").val(more3YeareEnd());
     }
     else {
         // 小于等于3年
    	 console.log('小于');
    	 getYear3Start(b);
    	 getYear3End(b);
    	 //$("#takeEffectStart").val(addOneDay(getYear3Start(b),1));
    	 //$("#takeEffectEnd").val(addOneDay(getYear3End(b),1));
    	 $("#takeEffectStart").val(getYear3Start(b));
    	 $("#takeEffectEnd").val(getYear3End(b));
     }
}


function getNowDate(){
	var d = new Date();
	var year = d.getFullYear();
	var month = d.getMonth()+1;
	var day = d.getDate();
	if(month < 10){
		month ='0'+(d.getMonth()+1);
	}
	if(day < 10){
		day='0'+d.getDate();
	}
	var str = year+'-'+month+'-'+day;
	console.log("nowDate===="+str);
	return str;
}

function getYear3Start(c){
	var year = c.getFullYear()+3
	var month = c.getMonth()+1;
	var day = c.getDate()+1;
	if(month < 10){
		month ='0'+(c.getMonth()+1);
	}
	if(day < 10){
		day='0'+day;
	}
	
	if(month == 2 && c.getDate() == 28){
		month = '03';
		day = '01'
	}
	
	var str = year+'-'+month+'-'+day;
	console.log("质保期内开始时间"+str);
	return str;
}

function getYear3End(c){
	var year = c.getFullYear()+3
	var month = c.getMonth()+1;
	var day = c.getDate()+1;
	if(month < 10){
		month ='0'+(c.getMonth()+1);
	}
	if(day < 10){
		day='0'+day;
	}
	
	if(month == 2 && c.getDate() == 28){
		month = '03';
		day = '01'
	}
	
	var productDate=$("#productDate").val();
	if(productDate == '12个月'){
		year = year+1;
	}else if(productDate == '24个月'){
		year = year+2;
	}else if (productDate == '36个月') {
		year = year+3;
	}else{
		year= year;
	}
	
	var str = year+'-'+month+'-'+day;
	console.log("质保期内结束时间"+str);
	return str;
}

function more3YearStart(){
	var d = new Date();
	var year = d.getFullYear();
	var month = d.getMonth()+1;
	var day = d.getDate()+1;
	if(month < 10){
		month ='0'+month;
	}
	if(day < 10){
		day='0'+day;
	}
	if(month == 2 && d.getDate() == 28){
		month = '03';
		day = '01'
	}
	
	var str = year+'-'+month+'-'+day;
	console.log("脱保期内开始时间"+str);
	return str;
}

function more3YeareEnd(){
	var d = new Date();
	var year = d.getFullYear();
	var month = d.getMonth()+1;
	var day = d.getDate()+1;
	if(month < 10){
		month ='0'+month;
	}
	if(day < 10){
		day='0'+day;
	}
	
	if(month == 2 && d.getDate() == 28){
		month = '03';
		day = '01'
	}
	
	var productDate=$("#productDate").val();
	if(productDate == '12个月'){
		year = year+1;
	}else if(productDate == '24个月'){
		year = year+2;
	}else if (productDate == '36个月') {
		year = year+3;
	}else{
		year= year;
	}
	var str = year+'-'+month+'-'+day;
	console.log("脱保期内结束时间"+str);
	return str;
}


function taxSales(){
	var totalAmount = $("#totalAmount").val();
	var actualNonSalesPrice = totalAmount/1.06;
	$("#actualNonSalesPrice").val(actualNonSalesPrice.toFixed(2));
}


function billingAtKDate(){
	var billingAt = $("#billingAt").val();
	if(billingAt != null && billingAt != ''){
		var nowDate = getNowDate();
		// var invoiceDate = $("#billingAt").val();
		getDay(nowDate,billingAt);
	}else{
		 $("#takeEffectStart").val('');
    	 $("#takeEffectEnd").val('');
	}
}
function billingAtCDate(){
	var billingAt = $("#billingAt").val();
	if(billingAt != null && billingAt != ''){
		var nowDate = getNowDate();
		// var invoiceDate = $("#billingAt").val();
		getDay(nowDate,billingAt);
	}else{
		 $("#takeEffectStart").val('');
    	 $("#takeEffectEnd").val('');
	}
}


function save(){
	var customerName = $("#customerName").val();
	var customerContact = $("#customerContact").val();
	var vin = $("#vin").val();
	var productNo = $("#productNo").val();
	var billingAt = $("#billingAt").val();
	var actualNonSalesPrice = $("#actualNonSalesPrice").val();
	if(customerName == ''){
		toastr.warning("客户姓名不能为空");
		// alert("客户姓名不能为空");
	}else if(customerContact == ''){
		toastr.warning("客户联系方式不能为空");
		// alert("客户联系方式不能为空");
	}else if(vin == ''){
		toastr.warning("请选择车辆信息");
		// alert("请选择车辆信息");
	}else if(billingAt == ''){
		toastr.warning("开票日期不能为空");
		// alert("开票日期不能为空");
	}else if(productNo == ''){
		toastr.warning("请选择产品信息");
		// alert("请选择产品信息");
	}else if(actualNonSalesPrice == ''){
		toastr.warning("请输入实际不含税销售价");
	}else{
		// document.getElementById("btn_submit").disabled = true;
		var param= {
				PRODUCT_SALES_ORDER:$("#salesOrder").val(),
				PRODUCT_ID:$("#productId").val(),
				PRODUCT_NO:$("#productNo").val(),
				PRODUCT_NAME:$("#productName").val(),
				ORDER_STATUS:$("#orderStatus").val(),
				VIN:$("#vin").val(),
				BILLING_AT:$("#billingAt").val(),
				LICENSE_NO:$("#liceseNo").val(),
				OWNER_NO:$("#ownerNo").val(),
				OWNER_NAME:$("#ownerName").val(),
				OWNER_PHONE:$("#ownerPhone").val(),
				OWNER_MOBILE:$("#ownerMobile").val(),
				CUSTOMER_NAME:$("#customerName").val(),
				CUSTOMER_CONTACT:$("#customerContact").val(),
				BRAND_CODE:$("#brandCode").val(),
				BRAND_NAME:$("#brandName").val(),
				SERIES_CODE:$("#seriesCode").val(),
				SERIES_NAME:$("#seriesName").val(),
				MODEL_CODE:$("#modelCode").val(),
				MODEL_NAME:$("#modelName").val(),
				APACKAGE:$("#apackageCode").val(),
				YEAR_MODEL:$("#yearModel").val(),
				TAKE_EFFECT_START:$("#takeEffectStart").val(),
				TAKE_EFFECT_END:$("#takeEffectEnd").val(),
				PURCHASE_NUMBER:$("#purchaseNumber").val(),
				TERMINAL_NON_SALES_PRICE:$("#terminalNonSalesPrice").val(),
				TERMINAL_SALES_PRICE:$("#terminalSalesPrice").val(),
				ACTUAL_NON_SALES_PRICE:$("#actualNonSalesPrice").val(),
				TOTAL_AMOUNT:$("#totalAmount").val(),
				NON_TAX_COST_PRICE:$("#nonTaxCostPrice").val(),
				TAX_COST_PRICE:$("#taxCostPrice").val()
		};
		
		$.ajax({
			type : "GET",
			url : ctx + "/dmsSales/ajax/createSales",
			contentType : "application/json",
			dataType : "json",
			data : param,
			cache : false,
			async:true,
			success : function(data) {
				console.log("返回参数:" + data);
				if (data.CODE == '0') {
					$("#btn_submit").attr("disabled", false);
					$("#orderStatus").val("已保存");
					$("#btn_save").attr("disabled", true);
					toastr.success("销售单新增成功,销售单号:"+data.PRODUCT_SALES_ORDER);
					// alert("销售单新增成功");
					/*var index1 = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index1);*/
				}
			},
			error : function(data) {
				console.log(data);
			}
		});
		
	}
	
}

function submitASC(){
	// $("#orderStatus").val("已提交");
	/*
	 * var orderStatus = $("#orderStatus").val(); if(orderStatus == '扣款成功'){
	 * $("#btn_print").attr("disabled", false); }
	 */
	var productSalesOrder = $("#salesOrder").val();
	layer.confirm('销售单据一旦提交，不可作废，请再次确认是否提交？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function(index) {
		$.ajax({
			type: "GET",
		    url: ctx + "/dmsSales/ajax/submitSales?productSalesOrder="+productSalesOrder,
	        contentType: "application/json",
		    dataType: "json",
			cache: false,
			async:true,
		    success: function(data){
		    	console.log("返回参数:"+data);
		    	if(data == 0){
		    		toastr.success("扣款成功");
		    		// alert("扣款成功!");
		    		$("#btn_print").attr("disabled", false);
		    		$("#btn_submit").attr("disabled",true)
		    		$("#btn_save").attr("disabled",true);
		    		layer.close(index);
		    		// vm.reload();
		    	}else{
		    		toastr.error("扣款失败!");
		    		layer.close(index);
		    	}
			},error :function(data){
				console.log(data);
			}
		});
		
		/*
		 * layer.msg('的确很重要', { icon : 1 });
		 */
	}, function() {

	});
	
}


function print(){
	// alert("11111111");
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSessionSign",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
			if(data.code != 401){
				var productSalesOrder = $("#salesOrder").val();
				console.log("进入打印页面" + productSalesOrder);
				globe_index = layer.open({
					title : '销售单打印',
					type : 2,
					area : [ '80%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/dmsSales/ajax/toSalesPrint?productSalesOrder='
							+ productSalesOrder
				});
			}
		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});
	
}



function addOneDay(date, days){
	var date = new Date(date);
	date.setDate(date.getDate() + days);
	var month = date.getMonth() + 1;
	var day = date.getDate();
	 return date.getFullYear() + '-' + getFormatDate(month) + '-' + getFormatDate(day);
}
function getFormatDate(arg){
	 if (arg == undefined || arg == '') {
         return '';
     }
     var re = arg + '';
     if (re.length < 2) {
         re = '0' + re;
     }
     return re;
}
