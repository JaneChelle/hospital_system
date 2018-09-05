// var patient_name=$('.patient_name');
$(".patient_name").blur(function(){
    $('.font').addClass('fontsty');
    $('.font').html('该患者不存在');
    $('.btnn').addClass('btnsty');
    $('.btnn').html('添加');
});


