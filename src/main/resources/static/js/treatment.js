// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var treatmentId = parent.children("td.treatmentId").text();
        $.ajax({
            type: "DELETE",
            url: "/treatment/" + treatmentId,
            data: {
                treatment_id: treatmentId,
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
    if (x == true) {
        $.ajax({
            url: "/check/deleteByIds",
            data: {
                treatmentIds:$('.browider').val(),
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

// 添加
$(".add_check").on('click', function () {
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
        alert("请把信息补充完整");
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
                    window.location.href="/treatment/findTreatment";
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
})