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
$('.duoshan').on('click', function () {
    // allchk();
    if($('.browider').val() != "") {
        console.log('fhdjkhdjkghdfgh'+$('.browider').val());
        if (confirm('确认要删除吗?')) {
            $.ajax({
                type: "post",
                url: "/DrugInventory/DrugInventorys",
                data: {
                    'drugInventorys': $('.browider').val()
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
        } else {
            return false;
        }
    }
    else{
        $('.cure').addClass('uu');
        $('.cure').html('请先选择要删除的项');
        setTimeout(function () {
            $('.cure').css('display', 'none');
        }, 2000);
        // setTimeout(function () {
        //     location.reload(true);
        // }, 2000);
    }
});
function spin(){
    if($('.drugName').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){

    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/DrugInventory/keywordDate",//要发送的后台地址
        data: {
            drugName:$('.drugName').val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/DrugInventory/DrugInventoryDate/1/"+ datas[i].pinyin_code+ " >"+datas[i].drug_name+ "</a>"+'</br>';
                    $('.spinners').append(aa);
                }
            }else{
                alert(data.msg);
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}
//删除
$('.del').on('click',function () {
    if (confirm('确认要删除吗?')) {
        // var attribute_number = $(this).next().text();
        var drugInventoryId =$(this).parent().parent().children('.stock_number').text();
        console.log('s12324:---------'+drugInventoryId);
        $.ajax({
            type: "delete",
            url: "/DrugInventory/DrugInventory/" + drugInventoryId,
            data: {
                'drugInventoryId':drugInventoryId
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
                }, 2000);
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
                }, 2000);

                //alert(data.msg)
            }
        });
    }else{
        return false;
    }
});

//修改
//日期的正则表达式
var reg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
var regExp = new RegExp(reg);
$('.modify_add').on('click',function () {
    var drug_code=$(this).next().val();
    //console.log(drug_code);
    var first=$(this).parent().prev();
    var stock_number=$(this).parent().parent().children('.stock_number').text();
    //console.log(stock_number);
    $('.write').val(first.text());
    var storage=$(this).parent().parent().children('.sl').text();
    $('.storage_amount').val(storage);
    //console.log(storage_amount);
   // console.log($('.write').val());
    $(".modifys").on('click', function () {
        var valid_period=$('.write').val();
        //console.log(valid_period);
        var storage_amount= $('.storage_amount').val();
        //console.log(storage_amount);
        if(regExp.test(valid_period)) {
            // alert("日期格式不正确，正确格式为：2014-01-01");
            //return false;

            $.ajax({
                type: "put",
                url: "/DrugInventory/DrugInventory",
                async: false,
                data: {
                    'date': valid_period,
                    'storage_amount': storage_amount,
                    'stock_number': stock_number,
                    'drug_code': drug_code

                },
                success: function (data) {
                    $('.modify1').click(function () {
                        $('.window2_popup').css('display', 'none');
                    });
                    $('.cure').addClass('uu');
                    $('.cure').html('修改成功');
                    setInterval(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000)
                    //alert(data.msg)

                },
                error: function (data) {
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000)
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setInterval(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);

                    alert(data.msg)
                }
            });
        }else{
            $('.cure').addClass('uu');
            $('.cure').html('"日期格式不正确，正确格式为：2014-01-01"');
            setInterval(function () {
                $('.cure').css('display', 'none');
            }, 2000);
            return false;
        }
    });
});
function spin(){
    if($('.drugName').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){

    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/DrugInventory/keywordDate",//要发送的后台地址
        data: {
            drugName:$('.drugName').val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/DrugInventory/storageLink/"+ datas[i].stock_number+ " >"+datas[i].drug_name+ "</a>"+'</br>';
                    $('.spinners').append(aa);
                }
            }else{
                alert(data.msg);
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}

// $(function () {
//     $('#selectId').on('change', function () {
//         var selectId = $('#selectId option:selected');
//         if (selectId.val() == 1) {
//             window.open('/DrugInventory/getUnsafeStorage/1');
//         } else if (selectId.val() == 2) {
//             window.open('/DrugInventory/getMonthLimit');
//         }
//     })
// });

