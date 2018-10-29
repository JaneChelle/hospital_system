$(".add_item").on('click', function () {
    var parent = $(this).parent().parent();
    var patient_id = parent.children("td.patientId").text();
    var price_end = parent.children("td.price_end").text();
    $('.price').val(price_end);
        //还账
        $('.payback').on('click',function () {

            var value=$('.price').val();
            //console.log(parseInt(value));
            if(parseInt(value).valueOf()>=0) {
                $.ajax({
                    type: "post",
                    url: "/bills/payback",
                    data: {
                        'patient_id': patient_id,
                        //'price':Math.abs(price_end)
                        'price': price_end
                    },
                    async: false,
                    success: function (data) {
                        $('.cure').addClass('uu');
                        $('.cure').html("还账成功");
                        setTimeout(function () {
                            $('.cure').removeClass('uu');
                            $('.cure').html("");
                        }, 2000);
                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                        //alert("成功");
                    },
                    error: function (data) {
                         alert("错误");
                    }
                });
            } else{
                $('.cure').addClass('uu');
                $('.cure').html("值必须大于等于0");
                setTimeout(function () {
                    $('.cure').removeClass('uu');
                    $('.cure').html("");
                }, 2000);
            }
        });
});
