function recyle(obj) {
	// 用来保存所有的属性名称和值
	var props = "";
	// 开始遍历
	for ( var p in obj) {
		// 方法
		if (typeof (obj[p]) == "function") {
			/*if (p == "querySelector") {
				console.log('--------------asfawa');
			}*/
			props += "function:" + p + "\n";
		} else {
			// p 为属性名称，obj[p]为对应属性的值
			props += p + " = " + obj[p] + " \n ";
		}
	}
	// 最后显示所有的属性
	console.log(props + "\n");
	// document.getElementById('id_txt').value = props;
}
