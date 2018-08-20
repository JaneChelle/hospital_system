var as=$('.add_a');
as.on('click',function (){
	for (let i=0;i<as.length;i++) {
//		console.log(as[i]);
		$(as[i]).removeClass('aa');
	}
	$(this).addClass('aa');			
	
})
