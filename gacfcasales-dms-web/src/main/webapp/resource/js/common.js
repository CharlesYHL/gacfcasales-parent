;(function(){
	
	$.ajaxSetup({
	    complete: function (request, status) {
	    	//console.log("00000000"+request.responseJSON.code);
	        if (typeof (request) != 'undefined') {
	            var responseText = request.getResponseHeader("X-Responded-JSON");
	            //console.log("2222"+responseText)
	            if (responseText != null) {
	                window.tipError('系统提示', '登录超时，请重新登录', null, null, function () {
	                    window.location.href = ctx+"/casfailed.jsp";
	                });
	            }
	            if(request.responseJSON.code == 401){
	            	console.log("====================");
	            	 window.location.href = ctx+"/casfailed.jsp";
	            }
	        }
	    }
	});
	
	$.post(ctx + '/sysResource/ajax/getMenu', null, function(data) {
		$.each(data, function(i, e) {
			if(e.level == 1){
				var menuStr = '<li class="treeview">'
				+'<a href="">'
				+'<i class="fa fa-' + (e.icon ? e.icon : 'folder') + '"></i>'
				+ '<span>' + e.name + '</span>';
				if(e.isMenu == 1) {
					menuStr += '<span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span></a>';
					menuStr += '<ul id="_menu_' + e.id + '" class="treeview-menu"></ul>';
				}else {
					menuStr += '</a>';
				}
				menuStr += '</li>';
				$('.sidebar-menu').append($(menuStr));
			}else{
				var menuStr = '<li class="treeview-s">'
					+'<a href="'+(e.level == 2 ? ctx + e.url : "#")+'">'
					+'<i class="fa fa-' + (e.icon ? e.icon : 'circle-o') + '"></i>'
					+ '<span>' + e.name + '</span>';
					if(e.isMenu == 1) {
						menuStr += '<span class="pull-right-container"><i class="fa fa-angle-left pull-right"></i></span></a>';
						menuStr += '<ul id="_menu_' + e.id + '" class="treeview-menu"></ul>';
					}else {
						menuStr += '</a>';
					}
					menuStr += '</li>';
					$('#_menu_'+e.pid).append($(menuStr));
			}
		});
		setTimeout(function(){
			var url = window.location.pathname;
			$(".treeview-s").removeClass("active");
			$(".treeview-s a").each(function(){
				var href = $(this).attr("href");
				if(href == url){
					$(this).parents(".treeview-s").addClass("active");
					$(this).parents(".treeview").addClass("active");
					var parentTitle =  $('.treeview.active').children('a').text();
					var currentTitle = $(this).text();
					$("#navParentTitle").html(parentTitle);
					$("#navCurrentTitle").html(currentTitle);
				}
			});
		},0);
	}, 'json');
	
})();


//重写alert
window.alert = function(msg, callback){
	parent.layer.alert(msg, function(index){
		parent.layer.close(index);
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
}

//重写confirm式样框
window.confirm = function(msg, callback){
	parent.layer.confirm(msg, {btn: ['确定','取消']},
	function(){//确定事件
		if(typeof(callback) === "function"){
			callback("ok");
		}
	});
}

jQuery.dateFormatter = function(value,fmt) {
	  var date = new Date(value);
	  var o = {
	    "M+": date.getMonth() + 1, //月份
	    "d+": date.getDate(), //日
	    "H+": date.getHours(), //小时
	    "m+": date.getMinutes(), //分
	    "s+": date.getSeconds(), //秒
	    "q+": Math.floor((date.getMonth() + 3) / 3), //季度
	    "S": date.getMilliseconds() //毫秒
	  };
	  if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
	  for (var k in o)
	  if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	  return fmt;
};


