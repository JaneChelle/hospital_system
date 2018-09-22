//删除
$('.delete').on('click',function () {
    var attribute_number =$(this).parent().parent().children('.leibie').text();
    console.log('s12324:---------'+attribute_number);
    var inform = "您确定要删除治疗编号为 " + attribute_number + " 的信息吗？";
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
// 添加
$(".add_unit").on('click', function () {
    if($(".unitName").val() != ""){
        $.ajax({
            type: "POST",
            url: "/attribute/attribute",
            data: {
                attribute_name:$(".unitName").val(),
                attribute_distinction:2,
            },
            dataType: "JSON",
            success: function (data) {
                $('.window1_popup').css('display','none');
                // if (data.code == 0) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setInterval(function () {
                        $('.cure').css('display','none');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },1000)
                   // location.reload();
            },
            error: function (msg) {
                alert("网络错误");
            }
        })
    }
    else {
        alert("请把信息补充完整");
    }
});

// 修改回显
$(".modify_add").on('click', function () {
    var parent = $(this).parent().parent();
    var drugUnitName = parent.children("td.drugUnit_name").text();
    var drugUnitNumber = parent.children("td.drugUnit_number").text();
    $(".unit_number").val(drugUnitNumber);
    $(".unit_name").val(drugUnitName);
});

$(".unit_modify").on('click', function () {
    if($(".unit_name").val() != ""){
        $.ajax({
            type: "PUT",
            url: "/attribute/attribute",
            data: {
                attribute_number:$(".unit_number").val(),
                attribute_name:$(".unit_name").val(),
                attribute_distinction:2
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setInterval(function () {
                        $('.cure').css('display','none');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },1000)
                    //location.reload();
                } else {

                }
            },
            error: function (msg) {
                alert("网络错误");
            }
        })
    }
    else {
        alert("请把信息补充完整");
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
            attribute_distinction:2
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
                console.log('成功');
            }else{
                alert(data.msg);
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}