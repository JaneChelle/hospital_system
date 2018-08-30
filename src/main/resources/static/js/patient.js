// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var patientId = parent.children("td.patientId").text();
        $.ajax({
            type: "DELETE",
            url: "/patient/patient/" + patientId,
            data: {
                patientId:patientId,
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    location.reload();
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
});
// 批量删除
$(".batchDelete").on('click', function () {
   var x = confirm("您确定要删除吗？");
   if ($('.browider').val() != ""){
       if (x == true){
           $.ajax({
               type: "POST",
               url: "/patient/deletePatients",
               data: {
                   patients:$('.browider').val()
               },
               dataType: "JSON",
               success: function (data) {
                   if (data.code == 0) {
                       location.reload();
                   } else {

                   }
               },
               error: function (msg) {
                   alert("网络错误");
               }
           })
       }
   }
   else {
       alert("请选择要删除的选项");
   }
});


// 添加患者
$(".addPatient").on('click', function () {

    // 添加  --  地址
    // var address = [];
    // address.splice(0,address.length);
    // var province = $('.province').val();//省
    // var city = $('.city').val();//市
    // var district = $('.district').val();//区
    // address.push(province+"-"+city+"-"+district);
    // $('.home_address').val(address);
    // 性别
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
                    location.reload();
                } else {

                }
            },
            error: function (msg) {
                alert("网络错误");
            }
        })
    }
    else {
        alert("请把患者信息补充完整");
    }
});

// 修改 显示信息
$(".modify_add").on('click', function () {
    var parent = $(this).parent().parent();
    var patientId = parent.children("td.patientId").text();
    var patientName = parent.children("td.patientName").text();
    var patientSex = parent.children("td.patientSex").text();
    var patientCode = parent.children("td.patientCode").text();
    var patientAge = parent.children("td.patientAge").text();
    var patientPhone = parent.children("td.patientPhone").text();
    var home_address2 = parent.children("td.patientAdress").text()
    $(".patient_number").val(patientId);
    $(".patient_name").val(patientName);
    $(".pinyin_code").val(patientCode);
    $(".patient_age").val(patientAge);
    $('.patient_phone').val(patientPhone);
    $('.home_address2').val(home_address2);
    // 性别
    var options = $('.patient_Sex option');
    for (var i = 0; i < options.length; i++) {
        if ($(options[i]).text() == patientSex) {
            $(options[i]).attr("selected", true);
        } else {
            $(options[i]).attr("selected", false);
        }
    }
});

// 修改患者
$(".modify_patient").on('click', function () {
    // var map = [];
    // map.splice(0,map.length);
    // var provinces = $('.provinces').val();//省
    // var citys = $('.citys').val();//市
    // var districts = $('.districts').val();//区
    // map.push(provinces+"-"+citys+"-"+districts);
    // $('.home_add').val(map);

    // 性别
    var optioned=$(".patient_Sex option:selected");
    var option_texts = optioned.val();
    $('.patient_sex').val(option_texts);

    if (($(".patient_name").val() != "") && ($(".pinyin_code").val() != "") && ($(".patient_age").val() != "") && ($(".patient_phone").val() != "")){
        $.ajax({
            type: "PUT",
            url: "/patient/patient",
            data: {
                patient_number:$(".patient_number").val(),
                patient_name:$(".patient_name").val(),
                patient_gender:$('.patient_sex').val(),
                pinyin_code:$(".pinyin_code").val(),
                patient_age: $(".patient_age").val(),
                patient_phone:$('.patient_phone').val(),
                home_address: $('.home_address2').val()
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    location.reload();
                } else {

                }
            },
            error: function (msg) {
                alert("网络错误");
            }
        })
    }
    else {
        alert("请把患者信息补充完整");
    }
});

// 下拉框提示
function spin(){
    if($('.patientAttribute').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){
    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/patient/keyword",//要发送的后台地址
        data: {
            patientAttribute:$('.patientAttribute').val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/patient/patient/1"+ datas[i].patient_number+ " >"+datas[i].patient_name+ "</a>"+'</br>';
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