$(function() {
	/* $.each(); */
	var a = 'abc';
	var atype = typeof a;
	var b = {a:'abc',b:'我是bbb',c:'abundant'};
	//b = ['abc','apple','ball'];
	var para = '我是参数';
	$.each(b,function(i,n){
		console.log('$.each(): i='+i+',n='+n);
	})
	
	
	
})
