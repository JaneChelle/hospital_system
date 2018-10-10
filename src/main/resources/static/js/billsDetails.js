$('.payback').on('click',function () {

    $.ajax({
        type: "get",
        url: "/bills/payback",
        data: {
            'patient_id':$('.patient_id').text(),
            'Price':$('.price_end').text()
        },
        async: true,
        success: function (data) {
            // $('.cure').addClass('uu');
            // $('.cure').html(data.msg);
            // setTimeout(function () {
            //     $('.cure').css('display', 'none');
            // }, 2000);
            // setTimeout(function () {
            //     location.reload(true);
            // }, 2000);
            alert("成功");
        },
        error: function (data) {
            // $('.cure').addClass('uu');
            // $('.cure').html(data.msg);
            // setTimeout(function () {
            //     $('.cure').css('display', 'none');
            // }, 2000);
            // setTimeout(function () {
            //     location.reload(true);
            // }, 2000);

            alert("错误");
        }
    });
});