$('.btn-success').on('click',function () {
    if($('.jeinput').val() != ""){
        $.ajax({
            url: "/note/chargeNote",
            data: {
                time:$('.jeinput').val()
            },
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