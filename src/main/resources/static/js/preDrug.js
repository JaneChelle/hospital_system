// 添加药品明细
$(".select_drug").on('click',function () {
    var parent = $(this).parent().parent();
    var drug_code = parent.children("td.drug_code").text();
    var drug_name = parent.children("td.drug_name").text();
    var drug_num = $(this).parent().prev().children('input').val();
    var isModify = document.getElementById("test").value;
    console.log(drug_num);
    if(drug_num != ""){
        $.ajax({
            url: "/prescription/addDrug",
            data: {
                drug_code:drug_code,
                drug_name:drug_name,
                number:drug_num,
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    alert(isModify);
                    window.location.href="/prescription/toAddDrug?isModify="+isModify;
                }
            },
            error: function (msg) {
                alert("网络故障");
            }
        })
    }
    else {
        alert("请选择数量");
    }
});
//添加检查明细
$(".select_check").on('click',function () {
    var parent = $(this).parent().parent();
    var check_id = parent.children("td.check_id").text();
    var check_name = parent.children("td.check_name").text();
    var check_num = $(this).parent().prev().children('input').val();
    $.ajax({
        url: "/prescription/addCheck",
        data: {
            check_id:check_id,
            check_name:check_name,
            number:check_num,
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                window.location.href="/prescription/toAddCheck";
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});
//添加治疗明细
$(".select_therapy").on('click',function () {
    var parent = $(this).parent().parent();
    var treatment_id = parent.children("td.treatment_id").text();
    console.log(treatment_id);
    var treatment_name = parent.children("td.treatment_name").text();
    var treatment_num = $(this).parent().prev().children('input').val();
    console.log(treatment_num);
    $.ajax({
        url: "/prescription/addTreatment",
        data: {
            treatment_id:treatment_id,
            treatment_name:treatment_name,
            number:treatment_num,
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                window.location.href="/prescription/toAddTreatment";
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});

//完成时计算总价
$(".price_all").on("click",function () {
    $.ajax({
        url: "/prescription/totalPrice",
        data: {
            // prescription_id:
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                // window.location.href="/prescription/findPrescriptionById?prescriptionId";
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});