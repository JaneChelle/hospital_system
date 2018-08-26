// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var drugUnit_number = parent.children("td.drugUnit_number").text();
        $.ajax({
            type: "DELETE",
            url: "/attribute/attribute/" + drugUnit_number,
            data: {
                attribute_number: drugUnit_number,
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