$(document).ready(function () {
  $('#to-recover').click(function () {
        var userAccount=$('#loginname').val();
        var userPassword=$('#password').val();
        console.log(userAccount);
        console.log(userPassword);
        $.ajax({
            type: "POST",
            url: "/login",
            data: {
                "userAccount": userAccount,
                'userPassword':userPassword
            },
            dateType:"JSON",
            async: false,
            success: function (data) {
                if(data.code == 0){
                    $('.cure').addClass('uu');
                    $('.cure').html('成功');
                    window.location.href = '/toHome';
                    setTimeout(function () {
                        $('.cure').css('display','none');
                    },2000);

                }
                // alert(data.msg)
            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html('失败');
                setTimeout(function () {
                    $('.cure').css('display','none');
                },500);
                setTimeout(function () {
                    location.reload(true);
                },2000);

                alert('hdfuwehurie');
            }
        })
    })






















});