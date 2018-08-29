// 删除
$(".delete").on('click', function () {
    var r = confirm("您确定要删除吗？");
    if (r == true) {
        var parent = $(this).parent().parent();
        var note_id = parent.children("td.note_id").text();
        $.ajax({
            type: "DELETE",
            url: "/note/" + note_id,
            data: {
                note_id: note_id,
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').css('display', 'none');
                    }, 2000);
                    setTimeout(function () {
                        location.reload(true);
                    }, 1000);
                } else {

                }
            },
            error: function (data) {
                ('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
            }
        })
    }
    else {

    }
});

// 添加
$(".add_note").on('click', function () {
    $.ajax({
        type: "PUT",
        url: "/note",
        data: {
            disease_name:$(".note_patient").val(),
            patient_name: $(".note_patient").val()
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
            } else {

            }
        },
        error: function (data) {
            ('.cure').addClass('uu');
            $('.cure').html(data.msg);
            setTimeout(function () {
                $('.cure').css('display', 'none');
            }, 2000);
            setTimeout(function () {
                location.reload(true);
            }, 1000);
        }
    })
});

// 修改回显
$(".price_modify").on('click',function () {
    var parent = $(this).parent().parent();
    var note_id = parent.children("td.note_id").text();
    var price_end = parent.children("td.price_end").text();
    $(".noteId").val(note_id);
    $(".notePrice").val(price_end);
});

// 修改
$(".note_modify").on('click', function () {
    $.ajax({
        url: "/note/modifyNote",
        data: {
            note_id:$(".noteId").val(),
            price_end: $(".notePrice").val()
        },
        dataType: "JSON",
        success: function (data) {
            if (data.code == 0) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
            } else {

            }
        },
        error: function (data) {
            ('.cure').addClass('uu');
            $('.cure').html(data.msg);
            setTimeout(function () {
                $('.cure').css('display', 'none');
            }, 2000);
            setTimeout(function () {
                location.reload(true);
            }, 1000);
        }
    })
});