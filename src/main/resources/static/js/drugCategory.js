//修改
$('.modify_add').on('click',function () {
    $('.window2_popup').css('display','block');
    var first=$(this).parent().prev();
    $('.write').val(first.text());
    var attribute_number=$(this).parent().parent().children('.leibie').text();
    console.log();
    // var questionId=$(this).parent().next().children('input.questionId').val();
    $(".modify1").on('click', function () {
        var attribute_name=$('.write').val();
        $.ajax({
            type: "put",
            url: "/attribute/attribute",
            async: false,
            data: {
                'attribute_name':attribute_name,
                'attribute_distinction':1,
                'attribute_number':attribute_number

            },
            success: function (data) {
                $('.modify1').click(function () {
                    $('.window2_popup').css('display','none');
                });
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setInterval(function () {
                    $('.cure').css('display','none');
                },2000);
                setTimeout(function () {
                    location.reload(true);
                },1000)
                //alert(data.msg)

            },
            error: function (data) {
                setTimeout(function () {
                    location.reload(true);
                },1000)
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setInterval(function () {
                    $('.cure').css('display','none');
                },2000);

                alert(data.msg)
            }
        });
    });
});
//药品类别添加
$('.add1').on('click',function () {
    var attribute_name=$('.attribute_name').val();
    if(attribute_name != '') {
        $.ajax({
            type: "post",
            url: "/attribute/attribute",
            data: {
                'attribute_name': $('.attribute_name').val(),
                'attribute_distinction': 1
            },
            async: false,
            success: function (data) {
                $('.window1_popup').css('display','none');
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');

                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                },1000)
                // alert(data.msg)
            },
            error: function (data) {
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                $('.cure').addClass('uu');
                $('.cure').html('网络故障');
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                },1000)

                alert(data.msg)
            }
        });
    }else{
        $('.cure').addClass('uu');
        $('.cure').html('不能为空');
        setTimeout(function () {
            $('.cure').css('display', 'none');
        }, 2000);
    }
});
//删除
$('.deletess').on('click',function () {
    var attribute_number =$(this).parent().parent().children('.leibie').text();
    var attribute_name =$(this).parent().parent().children('.attribute_name').text();
    var inform = "您确定要删除--" + attribute_name + "--的信息吗？";
    var r = confirm(inform);
    if (r==true) {
        // var attribute_number = $(this).next().text();
        $.ajax({
            type: "delete",
            url: "/attribute/attribute/" + attribute_number,
            data: {
                'attribute_number':attribute_number
            },
            async: false,
            success: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass("uu");
                    $('.cure').html("");
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 2000);
                //alert(data.msg)
            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html("错误");
                setTimeout(function () {
                    $('.cure').removeClass("uu");
                    $('.cure').html("");
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
//搜索
function spin(){
    if($('.attributeName').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){

    $.ajax({
        type: "post",//数据发送的方式（post 或者 get）
        url: " /attribute/keyword",//要发送的后台地址
        data: {
            attributeName:$('.attributeName').val(),
            attribute_distinction:1
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/attribute/drugAttributeView/"+ datas[i].attribute_number+ " >"+datas[i].attribute_name+ "</a>"+'</br>';
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


