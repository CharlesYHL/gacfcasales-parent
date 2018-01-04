$(function(){
	$.post(ctx + '/sysUser/ajax/Looklist',{'loginName':""},function(data){
		console.log(data['sysUser']);
	},'json')
});



