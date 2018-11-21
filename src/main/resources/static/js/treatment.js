// function tip_display() {
//     $('.tip_popup').removeClass('tip_none').addClass('block');
// }
// function tip_hidden() {
//     $('.tip_popup').removeClass('tip_block').addClass('tip_none');
// }


// 删除
$(".delete").on('click', function () {
    var parent = $(this).parent().parent();
    var treatmentId = parent.children("td.treatmentId").text();
    var inform = "您确定要删除治疗编号为 " + treatmentId + " 的治疗信息吗？";
    var r = confirm(inform);
    $.ajax({
        type: "post",
        url: "/treatment/TakeUpTreatment",
        data: {
            treatment_id: treatmentId,
        },
        dataType: "JSON",
        success: function (data) {
            if(data.code==0){
                if (r == true) {
                    $.ajax({
                        type: "DELETE",
                        url: "/treatment/" + treatmentId,
                        data: {
                            treatment_id: treatmentId,
                        },
                        dataType: "JSON",
                        success: function (data) {
                            if (data.code == 0) {
                                $('.cure').addClass('uu');
                                $('.cure').html("删除成功");
                                setTimeout(function () {
                                    $('.cure').removeClass("uu")
                                    $('.cure').html('');
                                }, 2000);
                                setTimeout(function () {
                                    location.reload(true);
                                }, 1000);
                            } else {

                            }
                        },
                        error: function (msg) {
                            alert("网络错误");
                        }
                    })
                }
                else {

                }
            }else{
                $('.cure').addClass('uu');
                $('.cure').html('治疗被使用,不能删除');
                setTimeout(function () {
                    $('.cure').removeClass("uu");
                    $('.cure').html('');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
            }
        },
        error: function (msg) {
            alert("网络错误");
        }
    })

});

// 批量删除
$(".batchDelete").on('click', function () {
    if($('.browider').val() != ""){
        var x = confirm("您确定要删除吗？");
        if (x == true) {
            $.ajax({
                url: "/check/deleteByIds",
                data: {
                    treatmentIds:$('.browider').val()
                },
                dataType: "JSON",
                success: function (data) {
                    if (data.code == 0) {
                        $('.cure').addClass('uu');
                        $('.cure').html("删除成功");
                        setTimeout(function () {
                            $('.cure').removeClass("uu")
                            $('.cure').html('');
                        }, 2000);
                        setTimeout(function () {
                            location.reload(true);
                        }, 1000);
                    } else {

                    }
                },
                error: function (msg) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').removeClass("uu");
                        $('.cure').html('');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                    alert("网络错误");
                }
            })
        }
        else {

        }
    }else{
        $('.cure').addClass('uu');
        $('.cure').html('请先选择要删除的项');
        setTimeout(function () {
            $('.cure').removeClass("uu")
            $('.cure').html('');
        }, 2000);
    }
});

// 添加
$(".add_treatment").on('click', function () {
    if(($(".treatment_name").val() != "") && ($(".pinyin_code").val() != "") && ($(".treatment_price").val() != "")){
        $.ajax({
            type: "PUT",
            url: "/treatment",
            data: {
                treatment_name:$(".treatment_name").val(),
                pinyin_code:$(".pinyin_code").val(),
                treatment_price:$(".treatment_price").val(),
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $('.cure').addClass('uu');
                    $('.cure').html("添加成功");
                    setTimeout(function () {
                        $('.cure').removeClass("uu")
                        $('.cure').html('');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                } else {

                }
            },
            error: function (msg) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass("uu");
                    $('.cure').html('');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                alert("网络错误");
            }
        })
    }
    else {
        $('.cure').addClass('uu');
        $('.cure').html('请把信息补充完整');
        setTimeout(function () {
            $('.cure').removeClass("uu")
            $('.cure').html('');
        }, 2000);
    }
});

// 修改 显示信息
$(".modify_add").on('click', function () {
    var parent = $(this).parent().parent();
    var treatment = parent.children("td.treatmentId").text();
    var treatmentPrice = parent.children("td.treatmentPrice").text();
    $(".price").val(treatmentPrice);
    $(".treatment").val(treatment);
});

// 修改信息
$(".modify").on('click', function () {
    if($(".price").val() != ""){
        $.ajax({
            type: "POST",
            url: "/treatment",
            data: {
                treatment_price:$(".price").val(),
                treatment_id:$(".treatment").val(),
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $('.cure').addClass('uu');
                    $('.cure').html("修改成功");
                    setTimeout(function () {
                        $('.cure').removeClass("uu")
                        $('.cure').html('');
                    }, 2000);
                    setTimeout(function () {
                        window.location.href="/treatment/findTreatment/1";
                    }, 1000);
                } else {

                }
            },
            error: function (msg) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass("uu");
                    $('.cure').html('');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                alert("网络错误");
            }
        })
    }
    else {
        $('.cure').addClass('uu');
        $('.cure').html('请把信息补充完整');
        setTimeout(function () {
            $('.cure').removeClass("uu")
            $('.cure').html('');
        }, 2000);
    }
});

//搜索提示
function spin(){
    if($('.findName').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){

    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: " /treatment/searchWord",//要发送的后台地址
        data: {
            search_word:$('.drugName').val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/drug/toView/"+ datas[i].drug_code+ " >"+datas[i].drug_name+ "</a>"+'</br>';
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

// 下拉框提示
function spin(){
    if($('.findName').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){
    $.ajax({
        url: "/treatment/searchWord",//要发送的后台地址
        data: {
            search_word:$('.findName').val()
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/treatment/findTreatment?findName="+datas[i] +">" + datas[i] + "</a>"+'</br>';
                    $('.spinners').append(aa);
                }
            }else{
                $('.spinners').html(" ");
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}