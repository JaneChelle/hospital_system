$(".add_item").on('click', function () {
    var parent = $(this).parent().parent();
    var patient_id = parent.children("td.patient_id").text();
    var price_end = parent.children("td.price_end").text();
    console.log(patient_id);
    console.log(price_end);
    //还账
    $('.payback').on('click',function () {
        $.ajax({
            type: "post",
            url: "/bills/payback",
            data: {
                'patient_id':patient_id,
                // 'price':Math.abs(price_end)
                'price':price_end
            },
            async: true,
            success: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 2000);
                //alert("成功");
            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 2000);

                //alert("错误");
            }
        });
    });
});
