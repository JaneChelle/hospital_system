// 添加药品明细
$(".select_drug").on('click',function () {
    var parent = $(this).parent().parent();
    var drug_code = parent.children("td.drug_code").text();
    var drug_name = parent.children("td.drug_name").text();
    var drug_num = $(this).parent().prev().children('input').val();
    var isModify = document.getElementById("test").value;
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

// 删除药品明细
$(".deletePre_drug").on('click',function () {
    var parent = $(this).parent().parent();
    var detail_idDrug = parent.children("td.detail_idDrug").text();
    var y = confirm("您确定要删除吗?");
    if(y == true){
        $.ajax({
            url: "/prescription/deleteDrug",
            data: {
                detailId:detail_idDrug
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $.ajax({
                        url: "/prescription/totalPrice",
                        data: {
                            isModify:'is'
                        },
                        dataType: "JSON",
                        success: function (data) {
                            if(data.code == 2){
                                location.reload();
                            }
                        },
                        error: function (msg) {
                            alert("网络故障");
                        }
                    })
                }
            },
            error: function (msg) {
                alert("网络故障");
            }
        })
    }
});

// 修改 药品明细(数量)

// 回显
$(".modify_2").on('click',function () {
    var parent = $(this).parent().parent();
    var detailDrug = parent.children("td.detail_idDrug").text();
    var numberPreDrug  = parent.children("td.numberPreDrug").text();
    $(".number_preDrug").val(numberPreDrug);
    $(".detailDrug").val(detailDrug);
});
$(".modify_preDrug").on('click',function () {
    $.ajax({
        url: "/prescription/modifyPrescriptionDrug",
        data: {
            detail_id:$(".detailDrug").val(),
            number:$(".number_preDrug").val()
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                $.ajax({
                    url: "/prescription/totalPrice",
                    data: {
                        isModify:'is'
                    },
                    dataType: "JSON",
                    success: function (data) {
                        if(data.code == 2){
                            location.reload();
                        }
                    },
                    error: function (msg) {
                        alert("网络故障");
                    }
                })
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});

//添加检查明细
$(".select_check").on('click',function () {
    var parent = $(this).parent().parent();
    var check_id = parent.children("td.check_id").text();
    var check_name = parent.children("td.check_name").text();
    var check_num = $(this).parent().prev().children('input').val();
    var isModify = document.getElementById("test_check").value;
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
                alert(isModify);
                window.location.href="/prescription/toAddCheck?isModify="+isModify;
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});

// 删除检查明细
$(".deletePre_check").on('click',function () {
    var parent = $(this).parent().parent();
    var check_idPre = parent.children("td.check_idPre").text();
    console.log(check_idPre);
    var y = confirm("您确定要删除吗？");
    if(y == true){
        $.ajax({
            url: "/prescription/deleteCheck",
            data: {
                checkId:check_idPre,
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $.ajax({
                        url: "/prescription/totalPrice",
                        data: {
                            isModify:'is'
                        },
                        dataType: "JSON",
                        success: function (data) {
                            if(data.code == 2){
                                location.reload();
                            }
                        },
                        error: function (msg) {
                            alert("网络故障");
                        }
                    })
                }
            },
            error: function (msg) {
                alert("网络故障");
            }
        })
    }
});

// 修改 检查明细(数量)

// 回显
$(".modify_3").on('click',function () {
    var parent = $(this).parent().parent();
    var detailCheck = parent.children("td.detail_idCheck").text();
    var numberPreCheck = parent.children("td.numberPreCheck").text();
    $(".number_preCheck").val(numberPreCheck);
    $(".detailCheck").val(detailCheck);
});
$(".modify_preCheck").on('click',function () {
    $.ajax({
        url: "/prescription/modifyPrescriptionCheck",
        data: {
            detail_id:$(".detailCheck").val(),
            number:$(".number_preCheck").val()
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                $.ajax({
                    url: "/prescription/totalPrice",
                    data: {
                        isModify:'is'
                    },
                    dataType: "JSON",
                    success: function (data) {
                        if(data.code == 2){
                            location.reload();
                        }
                    },
                    error: function (msg) {
                        alert("网络故障");
                    }
                })
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
    var treatment_name = parent.children("td.treatment_name").text();
    var treatment_num = $(this).parent().prev().children('input').val();
    var isModify = document.getElementById("test_treatment").value;
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
                alert(isModify);
                window.location.href="/prescription/toAddTreatment?isModify="+isModify;
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});

// 删除治疗明细
$(".deletePre_therapy").on('click',function () {
    var parent = $(this).parent().parent();
    var treatmentIdPre = parent.children("td.treatmentIdPre").text();
    var y = confirm("您确定要删除吗？");
    if(y == true){
        $.ajax({
            url: "/prescription/deleteTreatment",
            data: {
                treatmentId:treatmentIdPre,
                number:$(".number_preTreatment").val()
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $.ajax({
                        url: "/prescription/totalPrice",
                        data: {
                            isModify:'is'
                        },
                        dataType: "JSON",
                        success: function (data) {
                            if(data.code == 2){
                                location.reload();
                            }
                        },
                        error: function (msg) {
                            alert("网络故障");
                        }
                    })
                }
            },
            error: function (msg) {
                alert("网络故障");
            }
        })
    }
});

// 修改 治疗明细(数量)

// 回显
$(".modify_4").on('click',function () {
    var parent = $(this).parent().parent();
    var detailTreatment = parent.children("td.detail_idTreatment").text();
    var numberPreTreatment = parent.children("td.numberPreTreatment").text();
    $(".number_preTreatment").val(numberPreTreatment);
    $(".detailTreatment").val(detailTreatment);
});
$(".modify_preTreatment").on('click',function () {
    $.ajax({
        url: "/prescription/modifyPrescriptionTreatment",
        data: {
            detail_id:$(".detailTreatment").val(),
            number:$(".number_preTreatment").val()
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                $.ajax({
                    url: "/prescription/totalPrice",
                    data: {
                        isModify:'is'
                    },
                    dataType: "JSON",
                    success: function (data) {
                        if(data.code == 2){
                            location.reload();
                        }
                    },
                    error: function (msg) {
                        alert("网络故障");
                    }
                })
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});


//添加 完成时计算总价
$(".price_allPre").on("click",function () {
    $.ajax({
        url: "/prescription/totalPrice",
        data: {

        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                $(".adiv1").hide();
                $(".adiv2").fadeIn();
            }else if(data.code == 2){
                alert(data.count);
                window.location.href="/prescription/findPrescriptionById?prescriptionId"+data.count;
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});
// 修改 添加
$(".is_modifyDrug").on("click",function () {
    $.ajax({
        url: "/prescription/totalPrice",
        data: {
            isModify:'is'
        },
        dataType: "JSON",
        success: function (data) {
            if(data.code == 2){
                console.log(data.count);
                window.location.href="/prescription/findPrescriptionById?prescriptionId="+data.count;
            }
        },
        error: function (msg) {
            alert("网络故障");
        }
    })
});