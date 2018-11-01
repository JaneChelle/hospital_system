// 删除
$(".delete").on('click', function () {
    var parent = $(this).parent().parent();
    var diseaseID = parent.children("td.diseaseID").text();
    var inform = "您确定要删除疾病编号为 " + diseaseID + " 的疾病信息吗？";
    var r = confirm(inform);
    if (r == true) {
        $.ajax({
            type: "DELETE",
            url: "/disease/" + diseaseID,
            data: {
                diseaseId: diseaseID,
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
                    $('.cure').removeClass("uu")
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
});

// 批量删除
$(".batchDelete").on('click', function () {
    if($('.browider').val() != ""){
        var x = confirm("您确定要删除吗？");
        if(x == true){
            $.ajax({
                url: "/disease/deleteDiseaseByIds",
                data: {
                    DiseaseIds:$('.browider').val()
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
    }
    else{
        $('.cure').addClass('uu');
        $('.cure').html('请先选择要删除的项');
        setTimeout(function () {
            $('.cure').removeClass("uu")
            $('.cure').html('');
        }, 2000);
    }
});

// 添加
$(".add_check").on('click', function () {
    if(($(".disease_name").val() != "") && ($(".pinyin_code").val() != "")){
        $.ajax({
            type: "PUT",
            url: "/disease",
            data: {
                disease_name:$(".disease_name").val(),
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

// 下拉框提示
function spin(){
    if($('#findName').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){
    $.ajax({
        url: "/disease/searchWord",//要发送的后台地址
        data: {
            search_word:$('#findName').val()
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/disease/findDisease?findName="+datas[i] +">" + datas[i] + "</a>"+'</br>';
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