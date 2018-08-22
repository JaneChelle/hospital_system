// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var prescriptionID = parent.children("td.prescriptionId").text();
        $.ajax({
            type: "DELETE",
            url: "/prescription/" + prescriptionID,
            data: {
                prescription_id: prescriptionID,
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