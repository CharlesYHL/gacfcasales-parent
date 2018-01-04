(function ($) {
	$.extend($.validator.messages, {
		required: "",
		remote: "该字段已存在，请重新输入",
		email: "请输入正确格式的电子邮件",
		url: "请输入合法的网址",
		date: "请输入合法的日期",
		dateISO: "请输入合法的日期 (ISO).",
		number: "请输入合法的数字",
		digits: "只能输入整数",
		creditcard: "请输入合法的信用卡号",
		equalTo: "请再次输入相同的值",
		accept: "请输入拥有合法后缀名的字符串",
		maxlength: $.validator.format("请输入一个长度最多是 {0} 的字符串"),
		minlength: $.validator.format("请输入一个长度最少是 {0} 的字符串"),
		rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
		range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
		max: $.validator.format("请输入一个最大为 {0} 的值"),
		min: $.validator.format("请输入一个最小为 {0} 的值")
	});
	$.extend($.validator.defaults, {
		onkeyup : false,
		errorElement : 'span',
		errorClass : 'pull-left required',
		errorPlacement : function(error, element) {
			error.appendTo(element.closest('.form-group').find('.control-label:eq(1)'));
		},
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass('has-error');
		}
	});
}($));
$.validator.addMethod("mobile", function(value, element) {
    return this.optional(element) || /^1[3578]\d{9}$/.test(value);
}, "请填写正确的手机号码");

$.validator.addMethod("chrnum", function(value, element) {
    var chrnum = /^([a-zA-Z0-9]+)$/;
    return this.optional(element) || (chrnum.test(value));
}, "只能填写数字和字母(字符A-Z, a-z, 0-9)");

$.validator.addMethod("idCardNo", function(value, element) {   
	return this.optional(element) || isIdCardNo(value);   
}, "请正确填写您的身份证号码");

$.validator.addMethod("chinese", function(value, element) {
    var chinese = /^[\u4e00-\u9fa5]+$/;
    return this.optional(element) || (chinese.test(value));
}, "只能填写中文");
$.validator.addMethod("money", function(value, element) {
    return this.optional(element) || /^\d+(\.\d{1,2})?$/.test(value);         
}, "只允许输入两位小数"); 
$.validator.addMethod("taxNo", function(value, element) {
    return value.length == 15;         
}, "请输入正确的税号"); 
$.validator.addMethod("checkphone", function(value, element) {
    return value.length <= 20;         
}, "请输入正常的手机号"); 
$.validator.addMethod("jh", function(value, element) {
    var chrnum = /^105[0-9]{12}$/;
    //通过验证
    if(this.optional(element) || (chrnum.test(value.substring(0,3)))){
    	$("query-error").hide();
    }else{
    	$("query-error").show();
    }
    return this.optional(element) || (chrnum.test(value.substring(0,3)));
}, "只能填写以105开头的建行号");