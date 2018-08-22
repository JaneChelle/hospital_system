// 新增处方
$(".add_pre").on('click',function () {
    if(($(".pre_name").val() != "") && ($(".pre_pinyin").val() != "")){
        $.ajax({
            type: "PUT",
            url: "/prescription",
            data: {
                prescription_name:$(".pre_name").val(),
                pinyin_code:$(".pre_pinyin").val(),
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    location="/prescription/toAddDrug";
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