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
				top:"135px",
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
  //添加药品
		$('.btn_add').on('click',function () {
            $.ajax({
                type: "post",
                url: "/drug/drug",
                data: {
                	'drug_code':$('.drug_code').val(),
                    "drug_category": $('.drug_category').val(),
					'drug_name':$('.drug_name').val(),
					'pinyin_code':$('.pinyin_code').val(),
					'specification_content':$('.specification_content').val(),
					'drug_unit':$('.drug_unit').val(),
					'dosage_form':$('.dosage_form').val(),
					'manufacturer':$('.manufacturer').val(),
					'approval_number':$('.approval_number').val(),
					'safety_stock':$('.safety_stock').val(),
					'unit_price':$('.unit_price').val(),
					'healthcare_code':$('.healthcare_code').val(),
					'healthcare_name':$('.healthcare_name').val()
                },
                async: false,
                success: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display','none');
                    },2000);
                    // setTimeout(function () {
                    //     location.reload(true);
                    // },500);
                     alert(data.msg)
                },
                error: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display','none');
                    },2000);
                    // setTimeout(function () {
                    //     location.reload(true);
                    // },500);

                    alert(data.msg)
                }
            });
        });

//修改药品信息
		$('.modifya').on('click',function () {
            $.ajax({
                type: "put",
                url: "/drug/drug",
                data: {
                    'drug_code':$('.drug_code').val(),
                    "drug_category": $('.drug_category').val(),
                    'drug_name':$('.drug_name').val(),
                    'pinyin_code':$('.pinyin_code').val(),
                    'specification_content':$('.specification_content').val(),
                    'drug_unit':$('.drug_unit').val(),
                    'dosage_form':$('.dosage_form').val(),
                    'manufacturer':$('.manufacturer').val(),
                    'approval_number':$('.approval_number').val(),
                    'safety_stock':$('.safety_stock').val(),
                    'unit_price':$('.unit_price').val(),
                    'healthcare_code':$('.healthcare_code').val(),
                    'healthcare_name':$('.healthcare_name').val()
                },
                async: false,
                success: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display','none');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },500);
                    alert(data.msg)
                },
                error: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display','none');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },500);

                    alert(data.msg)
                }
            });
        });