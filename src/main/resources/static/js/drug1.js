//添加药品
$('.btn_add').on('click',function () {
    // var code=$('.drug_code').val();
    var category=$('.drug_category').val();
    var name=$('.drug_name').val();
    var pinyin=$('.pinyin_code').val();
    var content=$('.specification_content').val();
    var unit=$('.drug_unit').val();
    var form=$('.dosage_form').val();
    var manufacturer=$('.manufacturer').val();
    var number=$('.approval_number').val();
    var stock=$('.safety_stock').val();
    var price=$('.unit_price').val();
    var healthcare=$('.healthcare_code').val();
    var healthcare_name=$('.healthcare_name').val();
    console.log(name);
    if(name ==''){
        $('.cure').addClass('uu');
        $('.cure').html('药品名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(category==''){
        $('.cure').addClass('uu');
        $('.cure').html('药品类别不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(pinyin==''){
        $('.cure').addClass('uu');
        $('.cure').html('拼音码不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(content==''){
        $('.cure').addClass('uu');
        $('.cure').html('规格含量不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(unit==''){
        $('.cure').addClass('uu');
        $('.cure').html('单位不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(form==''){
        $('.cure').addClass('uu');
        $('.cure').html('剂型不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(manufacturer==''){
        $('.cure').addClass('uu');
        $('.cure').html('厂家不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(number==''){
        $('.cure').addClass('uu');
        $('.cure').html('批准文号不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(stock==''){
        $('.cure').addClass('uu');
        $('.cure').html('安全库存不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(price==''){
        $('.cure').addClass('uu');
        $('.cure').html('单位价格不能为空');
        setTimeout(function () {
            $('.cure').html(' ');
            $('.cure').removeClass('uu');
        },2000);
    }else if(healthcare==''){
        $('.cure').addClass('uu');
        $('.cure').html('医保编码不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(healthcare_name == ''){
        $('.cure').addClass('uu');
        $('.cure').html('医保名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }
    else{
        $.ajax({
            type: "post",
            url: "/drug/drug",
            data: {
                // 'drug_code':$('.drug_code').val(),
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
                    $('.cure').removeClass('uu');
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
                    $('.cure').removeClass('uu');
                },1000);
                // setTimeout(function () {
                //     location.reload(true);
                // },500);

                alert(data.msg)
            }
        });
        return true;
    }

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