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
                    window.location.href="/prescription/toAddDrug";
                    $.ajax({
                        url: "/prescription/totalPrice",
                        data: {
                        },
                        dataType: "JSON",
                        success: function (data) {
                        },
                        error: function (msg) {
                        }
                    })
                }
            },
            error: function (msg) {
                alert("网络错误");
            }
        })
    }
    else {
        $('.cure').addClass('uu');
        $('.cure').html('请把信息补充完整');
        setTimeout(function () {
            $('.cure').removeClass("uu")
            $('.cure').html('');
        }, 2000);
    }
});

