$('.delete').on('click',function () {
    var record_number=$(this).parent().parent().children('.record_number').text();
    console.log(record_number);
    if (confirm('确认要删除吗?')) {
        $.ajax(
            {
                type: "delete",
                url: "/StorageRecord/StorageRecord/" + record_number,
                data: {
                    'record_number':record_number
                },
                async: false,
                success: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                    //alert(data.msg)
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

                    //alert(data.msg)
                }
            }
        )
    }
});
//批量删除
$('.duoshan').on('click',function () {
    allchk();
    if($('.browider').val()!='') {
        if (confirm('确认要删除吗?')) {
            $.ajax({
                type: "post",
                url: "/StorageRecord/StorageRecord",
                data: {
                    'storageIds': $('.browider').val()
                },
                async: false,
                success: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                    //alert(data.msg)
                },
                error: function (data) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);

                    alert(data.msg)
                }
            });
        } else {
            return false;

        }
    }else{
        $('.cure').addClass('uu');
        $('.cure').html('请先选择要删除的项');
        setTimeout(function () {
            $('.cure').css('display', 'none');
        }, 2000);
    }
});
//搜索
function spin(){
    if($('.drugName').val() != ""){
        $('.spin').fadeIn();
    }
    else{
        $('.spin').fadeOut();
    }
}
function spainner(){

    $.ajax({
        type: "post",//数据发送的方式（post 或者 get）
        url: "/StorageRecord/keyword",//要发送的后台地址
        data: {
            drugName:$('.drugName').val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            var datas=data.data;
            console.log(datas);
            if(data.code==0){
                $('.spinners').html(" ");
                for (var i=0;i<datas.length;i++){
                    var aa="<a href=/StorageRecord/recordLink/"+datas[i].record_number+">"+datas[i].drug_name+ "</a>"+'</br>';
                    $('.spinners').append(aa);
                }
            }else{
                alert(data.msg);
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息
        }
    });
}