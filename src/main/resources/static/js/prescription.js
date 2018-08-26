
$(document).ready(function(){
    for(let i=1; i<=4; i++){
        $('.modify_'+i).click(function(){
            $('.window'+ i+'_popup').fadeIn(); // modify_1
            var height=$(".add_infor").height()
            console.log(height);
            if(height<=326){
                $('.add_infor').animate({
                    top:"215px",
                })
            }
            else{
                $('.add_infor').animate({
                    top:"64px",
                })
            }
        })
        $('.cancel_'+i).click(function(){
            $('.window'+i+'_popup').fadeOut();
            $('.add_infor').animate({
                top:"-32px",
            })
        })
    }
})