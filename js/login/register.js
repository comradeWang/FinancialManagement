$(function () {

});
var LOCAL = "http://localhost:8081/";
function register() {
    var userName = $('#register_userName').val();
    var pwd = $('#register_password').val();
    $.ajax({
        url:LOCAL+'register',
        type:"post",
        cache: false,
        dataType: "text",
        header:("Access-Control-Allow-Origin:*"),
        async:true,
        data:{
            username:userName,
            password:pwd
        },
        success:function (result) {
            alert('niubi');
        },
        error:function () {
            alert('出错了');
        }
    })
}