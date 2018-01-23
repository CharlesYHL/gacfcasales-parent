$(function(){
	var oDate = new Date(); //实例一个时间对象；
	var year = oDate.getFullYear();   //获取系统的年；
	var month = oDate.getMonth()+1;   //获取系统月份，由于月份是从0开始计算，所以要加1
	var today = oDate.getDate(); // 获取系统日，
	$('#printTime').html("打印时间: "+year+" 年 "+month+" 月 "+today+"日");
	
});


/*function print(){
	$("#printSales").printArea();
}*/
function reset(){
	var index1 = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index1)
}
