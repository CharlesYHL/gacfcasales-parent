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
	
	var rtbrandId = $("#rtbrandId").val();
	var rtbrandCode = $("#rtbrandCode").val();
	var rtbrandName = $("#rtbrandName").val();
	var rtseriesId = $("#rtseriesId").val();
	var rtseriesCode = $("#rtseriesCode").val();
	var rtseriesName = $("#rtseriesName").val();
	var rtmodelId = $("#rtmodelId").val();
	var rtmodelName = $("#rtmodelName").val();
	var rtmodelCode = $("#rtmodelCode").val();
	var rtapackageId = $("#rtapackageId").val();
	var rtapackage = $("#rtapackage").val();
	var rtapackageName = $("#rtbrandName").val();
	
	
	if(rtbrandId != ''){
		$("#brandId").append("<option selected='selected' value='"+rtbrandId+"'>"+rtbrandName+"</option>");
	}
	if(rtseriesId != ''){
		$("#seriesId").append("<option selected='selected' value='"+rtseriesId+"'>"+rtseriesName+"</option>");
	}
	if(rtmodelId != ''){
		$("#modelId").append("<option selected='selected' value='"+rtmodelId+"'>"+rtmodelName+"</option>");
	}
	if(rtapackageId != ''){
		$("#apackage").append("<option selected='selected' value='"+rtapackageId+"'>"+rtapackageName+"</option>");
	}
	
	var orderStatus = $("#orderStatus").val();
	if(orderStatus == '已保存'){
		$("#btn_submit").attr("disabled", false);
	}
	

});
var index;
var params;

function getChildValues(values){
	params = values;
	console.log("接受到数据："+JSON.stringify(params));
	// var selected = JSON.stringify(params)
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
	
	/*
	 * var nowDate = getNowDate(); getDay(nowDate,params.INVOICE_DATE);
	 */
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
	
	var nowDate = getNowDate();
	var invoiceDate = $("#billingAt").val();
	getDay(nowDate,invoiceDate);
}

function queryVin() {
	index = layer.open({
		id : 'queryVin',
		title : '车主车辆查询',
		type : 2,
		area : [ '100%', '100%' ],
		fixed : true, // 固定
		maxmin : false,
		content : ctx + '/dmsSales/ajax/toVehclist?vin=' + $("#vin").val(),
		/* content : 'vehclist.jsp', */
		/*
		 * btn: ['确认', '返回'], yes: function(index, layero){ alert("success"); },
		 * btn2: function(index, layero){ alert("fanhui"); },
		 */
		end : function() {
			i = 0;
		}
	});
	console.log(window.name);
	// var index1 = parent.layer.getFrameIndex(window.name);
	// parent.layer.close(index1)
}

function addProduct(){
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
		content : ctx + '/dmsSales/ajax/toProductlist?productNo=' + $("#productNo").val(),
		end : function() {
			i = 0;
		}
	});
	}else if(billingAt == '' && vin != ''){
		alert("开票日期不能为空");
	}else{
		alert("请先选择车辆信息!");
	}

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
    	 $("#takeEffectStart").val(more3YearStart());
    	 $("#takeEffectEnd").val(more3YeareEnd);
     }
     else {
         // 小于等于3年
    	 console.log('小于');
    	 getYear3Start(b);
    	 getYear3End(b);
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
		day='0'+c.getDate();
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
		day='0'+c.getDate();
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
	console.log("脱保期内开始时间"+str);
	return str;
}


function taxSales(){
	var actualNonSalesPrice = $("#actualNonSalesPrice").val();
	var totalAmount = actualNonSalesPrice*1.06;
	$("#totalAmount").val(totalAmount.toFixed(2));
}


function save(){
	var customerName = $("#customerName").val();
	var customerContact = $("#customerContact").val();
	var vin = $("#vin").val();
	var productNo = $("#productNo").val();
	var billingAt = $("#billingAt").val();
	var actualNonSalesPrice = $("#actualNonSalesPrice").val();
	if(customerName == ''){
		alert("客户姓名不能为空");
	}else if(customerContact == ''){
		alert("客户联系方式不能为空");
	}else if(vin == ''){
		alert("请选择车辆信息");
	}else if(billingAt == ''){
		alert("开票日期不能为空");
	}else if(productNo == ''){
		alert("请选择产品信息");
	}else if(actualNonSalesPrice == ''){
		alert("请输入实际不含税销售价");
	}else{
		// document.getElementById("btn_submit").disabled = true;
		$("#btn_submit").attr("disabled", false);
		$("#orderStatus").val("已保存");
		
		var param= {
				PRODUCT_SALES_ID : $("#productSalesId").val(),
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
				TOTAL_AMOUNT:$("#totalAmount").val()
		};
		
		$.ajax({
			type : "GET",
			url : ctx + "/dmsSales/ajax/editSales",
			contentType : "application/json",
			dataType : "json",
			data : param,
			cache : false,
			async:true,
			success : function(data) {
				console.log("返回参数:" + data);
				if (data == '0') {
					alert("销售单编辑成功");
				}else{
					alert("销售单编辑失败");
				}
			},
			error : function(data) {
				console.log(data);
			}
		});
		
	}
	
}

function submitASC(){
	/*
	 * $("#orderStatus").val("已提交"); var orderStatus = $("#orderStatus").val();
	 * if(orderStatus == '扣款成功'){ $("#btn_print").attr("disabled", false); }
	 */
	
	var productSalesOrder = $("#salesOrder").val();
	layer.confirm('销售单据一旦提交，不可作废，请再次确认是否提交？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
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
		    		alert("扣款成功!");
		    		$("#btn_print").attr("disabled", false);
		    		$("#btn_submit").attr("disabled",true)
		    		$("#btn_save").attr("disabled",true);
		    		// vm.reload();
		    	}else{
		    		alert("扣款失败!");
		    	}
			},error :function(data){
				console.log(data);
			}
		});
		
	}, function() {

	});
	
}

function print(){
	//alert("11111111");
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


