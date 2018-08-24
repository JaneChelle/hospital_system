// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var checkId = parent.children("td.checkId").text();
        $.ajax({
            type: "DELETE",
            url: "/check/" + checkId,
            data: {
                // check_id: checkId,
                checkId:checkId,
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
    if(($(".check_name").val() != "") && ($(".pinyin_code").val() != "") && ($(".check_price").val() != "")){
        $.ajax({
            type: "PUT",
            url: "/check",
            data: {
                check_name:$(".check_name").val(),
                pinyin_code:$(".pinyin_code").val(),
                check_price:$(".check_price").val(),
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
    var checkName = parent.children("td.checkName").text();
    var pinyinCode = parent.children("td.pinyinCode").text();
    var checkPrice = parent.children("td.checkPrice").text();
    var checkId = parent.children("td.checkId").text();
    $(".name").val(checkName);
    $(".code").val(pinyinCode);
    $(".price").val(checkPrice);
    $('.check-id').val(checkId);
});

// 修改信息
$(".modify").on('click', function () {
    if(($(".name").val() != "") && ($(".code").val() != "") && ($(".price").val() != "")){
        $.ajax({
            type: "POST",
            url: "/check",
            data: {
                check_name:$(".name").val(),
                pinyin_code:$(".code").val(),
                check_price:$(".price").val(),
                check_id: $('.check-id').val(),
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    window.location.href="/check/findCheck";
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