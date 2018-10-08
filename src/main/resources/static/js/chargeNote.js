$('.btn-success').on('click',function () {
    if($('.jeinput').val() != ""){
        $.ajax({
            url: "/note/chargeNote",
            data: {
                time:$('.jeinput').val()
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    var datas = data.data;
                    console.log(datas);
                    $(".total_price").text(datas.total_price);



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
        $('.cure').html('请先选择要查询的时间段');
        setTimeout(function () {
            $('.cure').removeClass("uu");
            $('.cure').html('');
        }, 2000);
    }
});