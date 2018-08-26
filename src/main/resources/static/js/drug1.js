//添加药品
$('.btn_add').on('click',function () {
    $.ajax({
        type: "post",
        url: "/drug/drug",
        data: {
            'drug_code':$('.drug_code').val(),
            "drug_category": $('.drug_category').val(),
            'drug_name':$('.drug_name').val(),
            'pinyin_code':$('.pinyin_code').val(),
            'specification_content':$('.specification_content').val(),
            'drug_unit':$('.drug_unit').val(),
            'dosage_form':$('.dosage_form').val(),
            'manufacturer':$('.manufacturer').val(),
            'approval_number':$('.approval_number').val(),
            'safety_stock':$('.safety_stock').val(),
            'unit_price':$('.unit_price').val(),
            'healthcare_code':$('.healthcare_code').val(),
            'healthcare_name':$('.healthcare_name').val()
        },
        async: false,
        success: function (data) {
            $('.cure').addClass('uu');
            $('.cure').html(data.msg);
            setTimeout(function () {
                $('.cure').css('display','none');
            },2000);
            setTimeout(function () {
                location.reload(true);
            },1000);
            //alert(data.msg)
        },
        error: function (data) {
            $('.cure').addClass('uu');
            $('.cure').html(data.msg);
            setTimeout(function () {
                $('.cure').css('display','none');
            },1000);
            // setTimeout(function () {
            //     location.reload(true);
            // },500);

            alert(data.msg)
        }
    });
});

//修改药品信息
$('.modifya').on('click',function () {
    $.ajax({
        type: "put",
        url: "/drug/drug",
        data: {
            'drug_code':$('.drug_code').val(),
            "drug_category": $('.drug_category').val(),
            'drug_name':$('.drug_name').val(),
            'pinyin_code':$('.pinyin_code').val(),
            'specification_content':$('.specification_content').val(),
            'drug_unit':$('.drug_unit').val(),
            'dosage_form':$('.dosage_form').val(),
            'manufacturer':$('.manufacturer').val(),
            'approval_number':$('.approval_number').val(),
            'safety_stock':$('.safety_stock').val(),
            'unit_price':$('.unit_price').val(),
            'healthcare_code':$('.healthcare_code').val(),
            'healthcare_name':$('.healthcare_name').val()
        },
        async: false,
        success: function (data) {
            $('.cure').addClass('uu');
            $('.cure').html(data.msg);
            setTimeout(function () {
                $('.cure').css('display','none');
            },2000);
            setTimeout(function () {
                location.reload(true);
            },1000);
           // alert(data.msg)
        },
        error: function (data) {
            $('.cure').addClass('uu');
            $('.cure').html(data.msg);
            setTimeout(function () {
                $('.cure').css('display','none');
            },2000);
            setTimeout(function () {
                location.reload(true);
            },1000);

            alert(data.msg)
        }
    });
});