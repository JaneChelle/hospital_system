//选择患者
$(".selsety_1").on('click',function () {
    var parent = $(this).parent().parent();
    var patientId = parent.children("td.patientId").text();
    $.ajax({
        url: "/patient/choicePatient",
        data: {
            patient_number:patientId,
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                location.href="/note/toAddNote";
            } else {

            }
        },
        error: function (msg) {
            alert("网络错误");
        }
    })
});

//选择疾病
$(".selsety_2").on('click',function () {
    var parent = $(this).parent().parent();
    var diseaseID = parent.children("td.diseaseID").text();
    $.ajax({
        url: "/disease/selectDisease",
        data: {
            disease_id:diseaseID,
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                location.href="/note/toAddNote";
            } else {

            }
        },
        error: function (msg) {
            alert("网络错误");
        }
    })
});

//选择处方
$(".selsety_3").on('click',function () {
    var parent = $(this).parent().parent();
    var prescriptionId = parent.children("td.prescriptionId").text();
    $.ajax({
        url: "/choicePrescription",
        data: {
            prescription_id:prescriptionId
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                location.href="/note/toAddNote";
            } else {

            }
        },
        error: function (msg) {
            alert("网络错误");
        }
    })
});