// 下拉框提示
function spin(){
    if($('.patient_name').val() != ""){
        $('.spintwo').fadeIn();
    }
    else{
        $('.spintwo').fadeOut();
    }
}
function spin3(){
    if($('.patient_name').val() != ""){
        $('.spin3').fadeIn();
    }
    else{
        $('.spin3').fadeOut();
    }
}
function spin4(){
    if($('.patient_name').val() != ""){
        $('.spin4').fadeIn();
    }
    else{
        $('.spin4').fadeOut();
    }
}

$('.add_item2').on('click',function () {
    $('.window2_popup').css('display','block');
});
$('.cancel_2').on('click',function () {
    $('.window2_popup').css('display','none');
});
// 患者下拉框
var patient_name=$('.patient_name');
function spainner(){

    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/patient/keyword",//要发送的后台地址
        data: {
            patientAttribute:$('.patient_name').val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas = data.data;
            console.log(data);
            if (data.code == 0) {
                $('.spinners').html(" ");
                for (var i = 0; i < datas.length; i++) {
                    // var aa="<a href=/patient/patientLink/"+ datas[i].patient_number+ " >"+datas[i].patient_name+ "</a>"+'</br>';
                    var aa = "<span class='spansty spansty2'>" + datas[i].patient_name + "</span>" + '</br>';
                    $('.spinners').append(aa);
                    $('.spansty2').on('click', function () {
                        patient_name.val($(this).text());
                        $('.spintwo').fadeOut();

                    });
                }
                check1()
            } else {
            }
        },
        error: function(msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}
// 查看单个患者是否存在
function check1() {
   // var patient_name=$('.patient_name').val();
    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/patient/checkPatient",//要发送的后台地址
        data: {
            patient_name:patient_name.val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            if (data.msg=="不存在！"){
                 $('.font').addClass('fontsty');
                $('.font').text('该患者不存在，请添加');
            }else{
               //患者存在
                $('.font').removeClass("fontsty");
                $('.font').text('');
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}
// 添加患者
$(".addPatient").on('click', function () {
    var option_sex = $(".gender option:selected");
    var option_text = option_sex.text();
    $('.patientGender').val(option_text);

    if (($(".namePatient").val() != "") && ($(".codePatient").val() != "") && ($(".agePatient").val() != "") && ($(".phonePatient").val() != "") && ($(".patient_gender").val() != "") && ($(".home_address").val() != "")){
        $.ajax({
            type: "POST",
            url: "/patient/patient",
            data: {
                patient_name:$(".namePatient").val(),
                patient_gender:$('.patientGender').val(),
                pinyin_code:$(".codePatient").val(),
                patient_age: $(".agePatient").val(),
                patient_phone:$('.phonePatient').val(),
                home_address: $('.home_address1').val()
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
        $('.cure').html('请把患者信息补充完整');
        setTimeout(function () {
            $('.cure').removeClass("uu");
            $('.cure').html('');
        }, 2000);
    }
});

// 疾病下拉框
var disease_name=$('#findName');
function spainner3(){

    $.ajax({
        url: "/disease/searchWord",//要发送的后台地址
        data: {
            search_word:disease_name.val()
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners3').html("");
                for (var i=0;i<datas.length;i++){
                    var aa="<span class='spansty spansty3'>" + datas[i].disease_name + "</span>"+'</br>';
                    $('.spinners3').append(aa);
                    $('.spansty3').on('click',function () {
                        disease_name.val($(this).text());
                        $('.spin3').fadeOut();
                    });
                }
                check2();
            }else{
                //alert(data.msg+'ggggg');
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}
// 查看单个疾病是否存在
function check2() {
    // var patient_name=$('.patient_name').val();
    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/disease/checkDisease",//要发送的后台地址
        data: {
            disease_name:disease_name.val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            if (data.msg=="不存在！"){
                $('.font').addClass('fontsty');
                $('.font').text('该疾病不存在，请添加');
            }else{
                //患者存在
                $('.font').removeClass("fontsty");
                $('.font').text('');
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}
//添加疾病
$(".add_check").on('click', function () {
    if($(".disease_name").val() != ""){
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
            $('.cure').removeClass("uu");
            $('.cure').html('');
        }, 2000);
    }
});
//处方下拉框

//查看单个处方是否存在

//总的提交按钮，发送ajax请求


