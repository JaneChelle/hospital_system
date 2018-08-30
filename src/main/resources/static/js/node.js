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
                    location.reload();
                } else {

                }
            },
            error: function (data) {
                location.reload();
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
                window.location.href="/note/findNote";
            } else {

            }
        },
        error: function (msg) {
            alert("网络错误");
        }
    })
});

