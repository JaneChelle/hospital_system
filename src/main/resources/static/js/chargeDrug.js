$('.btn-success').on('click',function () {
    if($('.jeinput').val() != ""){
        $.ajax({
            url: "/note/drugUsage",
            data: {
                time:$('.jeinput').val()
            },
            success: function (data) {
                alert("成功");
            },
            error: function (msg) {
                alert("网络错误");
            }
        });
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