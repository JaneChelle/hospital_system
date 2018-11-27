
// 删除
$(".deletePre").on('click', function () {
    var parent = $(this).parent().parent();
    var prescriptionID = parent.children("td.prescriptionId").text();
    var inform = "您确定要删除处方编号为 " + prescriptionID + " 的处方信息吗？";
    var r = confirm(inform);
    if (r == true) {
        $.ajax({
            type: "DELETE",
            url: "/prescription/" + prescriptionID,
            data: {
                prescription_id: prescriptionID,
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
                }
                else if(data.code == -1){
                    $('.cure').addClass('uu');
                    $('.cure').html("该处方正在使用，暂且不能删除！");
                    setTimeout(function () {
                        $('.cure').removeClass("uu")
                        $('.cure').html('');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
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

// 回显处方信息
$(".modifyPrescription").on('click', function () {
    var parent = $(this).parent().parent();
    var prescription_ID = parent.children("td.prescriptionId").text();
    var prescription_name = parent.children("td.prescription_name").text();
    var pinyin_code = parent.children("td.pinyin_code").text();
    // var price_all = parent.children("td.price_all").text();
    $(".pre_id").val(prescription_ID);
    $(".pre_name").val(prescription_name);
    $(".pre_code").val(pinyin_code);
    // $(".pre_price").val(price_all);
})


// 修改处方信息
$(".pre_modify").on('click', function () {
    if (($(".pre_name").val() !="") && ($(".pre_code").val() != "")){
        $.ajax({
            type: "POST",
            url: "/prescription",
            data: {
                prescription_id:$(".pre_id").val(),
                prescription_name:$(".pre_name").val(),
                pinyin_code:$(".pre_code").val(),
                price_all:$(".pre_price").val()
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    // window.location.href="/prescription/findPrescription";
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
        $('.cure').addClass('uu');
        $('.cure').html('请把信息补充完整');
        setTimeout(function () {
            $('.cure').removeClass("uu")
            $('.cure').html('');
        }, 2000);
    }
});