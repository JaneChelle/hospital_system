		var winheight=$(window).height();
		winheight-=100;
		$('.wrapper').css('height',winheight);

$(document).ready(function(){
	$('.modify_add').click(function(){
		$('.window2_popup').fadeIn();
		var height=$(".inform").height();
		console.log(height);
		if(height<=326){
			$('.inform').animate({
				top:"135px"
			})
		}
		else{
			$('.inform').animate({
				top:"64px"
			})
		}
		
	})
	$('.cancel_2').click(function(){
		$('.window2_popup').fadeOut();
		$('.inform').animate({
			top:"-32px"
		})
	})
})

$(document).ready(function(){
//	添加
	$('.add_item').click(function(){
		$(".window1_popup").fadeIn();
		var height=$(".add_infor").height();
		console.log(height);
		if(height<=326){
			$('.add_infor').animate({
				top:"115px"
			})
		}
		else{
			$('.add_infor').animate({
				top:"64px"
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
});

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
            var listarr = [];
            listarr.splice(0,listarr.length);
            var list=$('.selectall');
            for (var x = 0; x < list.length; x++) {
                if(list[x].checked==true){
                    var del =$(list[x]).val();
                    listarr.push(del);
                    $('.browider').val(listarr);
                    console.log( $('.browider').val());
                }
            }
        }
//批量删除
	$('.Batchdelet').on('click',function () {
		if (confirm('确认要删除吗?')){
            $.ajax({
                type: "post",
                url: "/drug/drugs",
                data: {
                    'drugCodes':$('.browider').val()
                },
                async: false,
                success: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                    //alert(data.msg)
                },
                error: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);

                    alert(data.msg)
                }
            });
		}else{
			return false;

		}
    });
var tableCont = document.querySelector('.section_table');
  function scrollHandle (e){
   // console.log(this)
    var scrollTop = this.scrollTop;
    this.querySelector('thead').style.transform = 'translateY(' + scrollTop + 'px)';
  }

  tableCont.addEventListener('scroll',scrollHandle);
//删除ajax
		$('.deletes').on('click',function () {
            if (confirm('确认要删除吗?')) {
                var drug_code = $(this).next().val();
                console.log(drug_code);
                $.ajax({
                    type: "delete",
                    url: "/drug/drug/" + drug_code,
                    // data: {
                    //     'drug_code':drug_code
                    // },
                    async: false,
                    success: function (data) {
                        $('.cure').addClass('uu');
                        $('.cure').html(data.msg);
                        setTimeout(function () {
                            $('.cure').css('display', 'none');
                        }, 2000);
                        setTimeout(function () {
                            location.reload(true);
                        }, 1000);
                        //alert(data.msg)
                    },
                    error: function (data) {
                        $('.cure').addClass('uu');
                        $('.cure').html(data.msg);
                        setTimeout(function () {
                            $('.cure').css('display', 'none');
                        }, 2000);
                        setTimeout(function () {
                            location.reload(true);
                        }, 1000);

                        alert(data.msg)
                    }
                });
            }else{
            	return false;
			}

        });
