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
    if($('#findName').val() != ""){
        $('.spin3').fadeIn();
    }
    else{
        $('.spin3').fadeOut();
    }
}
function spin4(){
    if($('.prescription_name').val() != ""){
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
                $('.spintwo').removeClass('spin2');
                $('.spintwo').addClass('spin2');
                for (var i = 0; i < datas.length; i++) {
                    // var aa="<a href=/patient/patientLink/"+ datas[i].patient_number+ " >"+datas[i].patient_name+ "</a>"+'</br>';
                    var aa = "<span class='spansty spansty2'>" + datas[i].patient_name +"</span>" + '</br>';
                    $('.spinners').append(aa);
                    $('.spansty2').on('click', function () {
                        patient_name.val($(this).text());

                        $('.spintwo').removeClass('spin2');
                        $('.font').removeClass("fontsty");
                        $('.spinners').html('');
                        $('.font').text('');

                    });
                }
                check1()
            } else {
                $('.spintwo').removeClass('spin2');
                $('.spinners').html('');
                $('.font').addClass('fontsty');
                $('.font').text('该患者不存在，请添加');
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
//该患者名字已经存在，加以区别ajax
$(".namePatient").on("change", function (){
    var patient_name=$('.namePatient').val();
    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/patient/checkPatient",//要发送的后台地址
        data: {
            patient_name:patient_name,
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            if (data.msg=="存在！"){
                // $('.cure').addClass('uu');
                // $('.cure').text('该患者名称已存在，请加以区别');
                alert("该患者名称已存在，请加以区别");
            }else{
                // 添加患者)

                $(".addPatient").on('click', function () {
                    if(account()){
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
                    }

                });



            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
});

//手机号
function account(){
    var user=$('.phonePatient').val();
    if( /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/g.test(user) ){
        //$('.user-wain').html("<i class='fa fa-check'>");
        return true;
    }else {
        $('.cure').addClass('uu');
        $('.cure').html("手机格式错误！");
        setTimeout(function () {
            $('.cure').removeClass("uu");
            $('.cure').html('');
        }, 2000);
        return false;
    }
}

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
                $('.spin3').removeClass('spin2');
                $('.spin3').addClass('spin2');
                for (var i=0;i<datas.length;i++){
                    var aa="<span class='spansty spansty3'>" + datas[i].disease_name + "</span>"+'</br>';
                    $('.spinners3').append(aa);
                    $('.spansty3').on('click',function () {
                        disease_name.val($(this).text());
                        $('.spinners3').html('');
                        $('.spin3').removeClass('spin2');
                        $('.font2').removeClass("fontsty2");
                        $('.font2').text('');

                    });
                }
                check2();
            }else{
                $('.spin3').removeClass('spin2');
                $('.spinners3').html('');
                $('.font2').addClass('fontsty2');
                $('.font2').text('该疾病不存在，请添加');
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
                $('.font2').addClass('fontsty2');
                $('.font2').text('该疾病不存在，请添加');
            }else{
                //患者存在
                $('.font2').removeClass("fontsty2");
                $('.font2').text('');
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
var prescription_name=$('.prescription_name');
function spainner4(){

    $.ajax({
        url: "/prescription/searchWord",//要发送的后台地址
        data: {
            search_word:prescription_name.val()
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners4').html("");
                $('.spin4').removeClass('spin2');
                $('.spin4').addClass('spin2');
                for (var i=0;i<datas.length;i++){
                    var aa="<span class='spansty spansty4'>" + datas[i].prescription_name + "</span>"+'</br>';
                    $('.spinners4').append(aa);
                    $('.spansty4').on('click',function () {
                        prescription_name.val($(this).text());
                        $('.spinners4').html('');
                        $('.spin4').removeClass('spin2');
                        $('.font3').removeClass("fontsty3");
                        $('.font3').text('');
                    });
                }
                check3();
            }else{
                //alert(data.msg+'ggggg');
                $('.spin4').removeClass('spin2');
                $('.spinners4').html('');
                $('.font3').addClass('fontsty3');
                $('.font3').text('该处方不存在，请添加');
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}
//查看单个处方是否存在
function check3() {
    // var patient_name=$('.patient_name').val();
    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/disease/checkDisease",//要发送的后台地址
        data: {
            prescription_name:prescription_name.val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            if (data.msg=="不存在!"){
                $('.font3').addClass('fontsty3');
                $('.font3').text('该处方不存在，请添加');
            }else{
                //患者存在
                $('.font3').removeClass("fontsty3");
                $('.font3').text('');
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}


//总的提交按钮，发送ajax请求
//添加药品
var price_end=$('.price_end');
$('.btn_adds').on('click',function () {
    if(patient_name.val() ==''){
        $('.cure').addClass('uu');
        $('.cure').html('患者名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(disease_name.val()==''){
        $('.cure').addClass('uu');
        $('.cure').html('疾病名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(prescription_name==''){
        $('.cure').addClass('uu');
        $('.cure').html('处方名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(price_end.val()==''){
        $('.cure').addClass('uu');
        $('.cure').html('收费不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    } else {
        $.ajax({
            type: "put",
            url: "/note",
            data: {
                // 'drug_code':$('.drug_code').val(),
                "patient_name": patient_name.val(),
                'disease_name':disease_name.val(),
                'prescription_name':prescription_name.val(),
                'price_end':price_end.val()
            },
            async: false,
            success: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass('uu');
                },2000);
                setTimeout(function () {
                    location.reload(true);
                },1000);
                //alert(data.msg)
            },
            error: function (data) {
                alert(data.msg)
            }
        });
        return true;
    }

});
