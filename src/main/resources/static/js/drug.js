		var winheight=$(window).height();
		winheight-=100;
		$('.wrapper').css('height',winheight);

$(document).ready(function(){
	$('.modify_add').click(function(){
		$('.window2_popup').fadeIn();
		var height=$(".inform").height()
		console.log(height);
		if(height<=326){
			$('.inform').animate({
				top:"115px",
			})
		}
		else{
			$('.inform').animate({
				top:"64px",
			})
		}
		
	})
	$('.cancel_2').click(function(){
		$('.window2_popup').fadeOut();
		$('.inform').animate({
			top:"-32px",
		})
	})
})

$(document).ready(function(){
//	添加
	$('.add_item').click(function(){
		$(".window1_popup").fadeIn();
		var height=$(".add_infor").height()
		console.log(height);
		if(height<=326){
			$('.add_infor').animate({
				top:"115px",
			})
		}
		else{
			$('.add_infor').animate({
				top:"64px",
			})
		}
	})
//	取消
	$(".cancel_1").click(function(){
		$(".window1_popup").fadeOut();
		$('.add_infor').animate({
			top:"-32px",
		})
	})
})	   

$(function () {
	//全选或全不选
	$("#all").click(function(){   
    	if(this.checked){   
        	$(".section_table :checkbox").prop("checked", true);  
    	}else{   
		$(".section_table :checkbox").prop("checked", false);
    	}   
 	}); 
	//全选  
    $("#selectAll").click(function () {
         $(".section_table :checkbox,#all").prop("checked", true);  
    });  
	//全不选
    $("#unSelect").click(function () {  
         $(".section_table :checkbox,#all").prop("checked", false);  
    });  
    //反选 
    $("#reverse").click(function () { 
         $(".section_table :checkbox").each(function () {  
              $(this).prop("checked", !$(this).prop("checked"));  
         });
		 allchk();
    });
	
	//设置全选复选框
	$(".section_table :checkbox").click(function(){
		allchk();
	});
 
	//获取选中选项的值
	$("#getValue").click(function(){ 
		var vals="";
		$(".section_table :checkbox").each(function(){ 
			if($(this).prop("checked")==true){ 
				vals += $(this).val()+",";
			} 
		}); 
		alert(vals); 
	});
}); 
function allchk(){
	var chknum = $(".section_table :checkbox").size();//选项总个数
	var chk = 0;
	$(".section_table :checkbox").each(function () {  
        if($(this).prop("checked")==true){
			chk++;
		}
    });
	if(chknum==chk){//全选
		$("#all").prop("checked",true);
	}else{//不全选
		$("#all").prop("checked",false);
	}
}
var tableCont = document.querySelector('.section_table');
  function scrollHandle (e){
   // console.log(this)
    var scrollTop = this.scrollTop;
    this.querySelector('thead').style.transform = 'translateY(' + scrollTop + 'px)';
  }

  tableCont.addEventListener('scroll',scrollHandle);