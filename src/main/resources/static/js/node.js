// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var note_id = parent.children("td.note_id").text();
        $.ajax({
            type: "DELETE",
            url: "/note/" + note_id,
            data: {
                note_id: note_id,
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
            error: function (data) {
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


// // 批量删除
// $(".batchDelete").on('click', function () {
//     var x = confirm("您确定要删除吗？");
//     if (x == true){
//         $.ajax({
//             url: "/check/deleteCheckByIds",
//             data: {
//                 checkIds:$('.browider').val(),
//             },
//             dataType: "JSON",
//             success: function (data) {
//                 if (data.code == 0) {
//                     location.reload();
//                 } else {
//
//                 }
//             },
//             error: function (msg) {
//                 alert("网络错误");
//             }
//         })
//     }
// });

// 修改回显
$(".price_modify").on('click',function () {
    var parent = $(this).parent().parent();
    var note_id = parent.children("td.note_id").text();
    var price_end = parent.children("td.price_end").text();
    $(".noteId").val(note_id);
    $(".notePrice").val(price_end);
});

// 添加
$(".add_note").on('click',function () {
    if(($(".patient_number").val() != "") && ($(".patient_name").val() != "") && ($(".disease_id").val() != "") && ($(".disease_name").val() != "") && ($(".prescription_id").val() != "") && ($(".price_end").val() != "") && ($(".patient_number").val() != "") && ($(".note_time").val() != "")){
        $.ajax({
            type: "PUT",
            url: "/note",
            data: {
                patient_id:$(".patient_number").val(),
                patient_name:$(".patient_name").val(),
                disease_id:$(".disease_id").val(),
                disease_name:$(".disease_name").val(),
                prescription_id:$(".prescription_id").val(),
                price_end:$(".price_end").val(),
                timeStr:$(".note_time").val()
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
                        window.location.href="/note/findNote";
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
});

// // 下拉框提示
// function spin(){
//     if($('#findName').val() != ""){
//         $('.spin').fadeIn();
//     }
//     else{
//         $('.spin').fadeOut();
//     }
// }
// function spainner(){
//     $.ajax({
//         url: "/check/searchWord",//要发送的后台地址
//         data: {
//             search_word:$('#findName').val()
//         },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
//         dataType:"JSON",
//         success: function (data) {//ajax请求成功后触发的方法
//             var datas=data.data;
//             console.log(datas);
//             if(data.code==0){
//                 $('.spinners').html(" ");
//                 for (var i=0;i<datas.length;i++){
//                     var aa="<a href=/check/checkLink/"+ datas[i].check_id+ " >"+datas[i].check_name+ "</a>"+'</br>';
//                     $('.spinners').append(aa);
//                 }
//             }else{
//                 alert(data.msg);
//             }
//         },
//         error: function (msg) {//ajax请求失败后触发的方法
//             alert("网络故障");//弹出错误信息
//         }
//     });
// }
