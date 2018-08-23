// 添加药品明细
$(".select_drug").on('click',function () {
    var parent = $(this).parent().parent();
    var drug_code = parent.children("td.drug_code").text();
    var drug_name = parent.children("td.drug_name").text();
    var unit_price = parent.children("td.unit_price").text();
    var drug_num = parent.children("td.drug_num").val();
    if($(".drug_num").val() != ""){
        $.ajax({
            type: "POST",
            url: "/prescription/addDrug",
            data: {
                drug_code:drug_code,
                drug_name:drug_name,
                unit_price:unit_price,
                number:drug_num,
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    location.reload();
                }
            },
            error: function (msg) {
                alert(msg);
            }
        })
    }
});

//添加治疗明细
$(".select_check").on('click',function () {
    var parent = $(this).parent().parent();
    var check_id = parent.children("td.check_id").text();
    var check_name = parent.children("td.check_name").text();
    var check_price = parent.children("td.check_price").text();
    // if($(".drug_num").val() != ""){
        $.ajax({
            type: "POST",
            url: "/prescription/addCheck",
            data: {
                check_id:check_id,
                check_name:check_name,
                unit_price:check_price,
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    location.reload();
                }
            },
            error: function (msg) {
                alert(msg);
            }
        })
    // }
});