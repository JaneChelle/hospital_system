// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var diseaseID = parent.children("td.diseaseID").text();
        $.ajax({
            type: "DELETE",
            url: "/disease/" + diseaseID,
            data: {
                diseaseId: diseaseID,
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
    if(x == true){
        $.ajax({
            url: "/disease/deleteDiseaseByIds",
            data: {
                DiseaseIds:$('.browider').val(),
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
});

// 添加
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