/**
 * 表单序列化
 */
(function ($) {
    $.fn.serializeJsonObj = function () {
        var serializeObj = {};
        var array = this.serializeArray();
        var str = this.serialize();
        $(array).each(function () {
            if (serializeObj[this.name]) {
                if ($.isArray(serializeObj[this.name])) {
                    serializeObj[this.name].push(this.value);
                } else {
                    serializeObj[this.name] = [serializeObj[this.name], this.value];
                }
            } else {
                serializeObj[this.name] = this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

var unlockflag = 0;
$(function () {
    var $container = $('#vertify');
    $container.slideToUnlock({
        text : '滑动以验证',
        succText : '验证成功',
        successFunc:function () {
        	unlockflag = 1;
           $("#login-submit").removeAttr("disabled");
        }
    });
    $(window).resize(function () {
        $('.slide-to-unlock-bg').width($container.width());
    });
      	
})
/**
* @author: WangXinYu
* @param: 
* @describe: 给注册按钮绑定事件 
* @create: 2017/12/20 0020 15:33
**/
function registerBtn(url) {
    window.location.href = url;
}

 //表单序列化
var commonSerializeForm = function(formId) {
	var inputAll=$('#'+formId+" :input[transmit='true']");//返回form中的所有表单对象，包括textarea、select、button等
	var  o={}; 
	$.each(inputAll, function(i, field){
        	if(field.type=='radio' || field.type=='checkbox'){
        		if(field.checked==true){
        			if (!o[field.name]){
        				o[field.name] = field.value;
        			} else {
        				o[field.name] = o[field.name] + "," + field.value;
        			}
        		}
        	}
        	else if(field.type=="select-multiple"){
        		var selected=field.selectedOptions;
				if(selected.length>0) {
					$.each(selected, function(j, selectedOption){
						   if (o[field.name]){
							   o[field.name] = o[field.name] + "," + selectedOption.value;
			    			} else {
			    			   o[field.name] = selectedOption.value;
			    		    }
					  });
				}
        	}
        	else{
        		if(field.value!=""){
        			if (o[field.name]){
        				o[field.name] = o[field.name] + "," + field.value;
        			} else {
        				o[field.name] = field.value;
        			}
        		}
        	}
	});
	return o;
};

function login(){
    	if(unlockflag == 0 ){
    		alert("验证后提交");
    		return;
    	}else if(unlockflag == 1){
    		var username = $("#login_userName").val();
    		var password = $("#login_password").val();
    		 if(username == ""){
    				$("#login_userName").focus();
    		    	return false;
    		    }
    		    if(password == ""){
    		    	alert("密码不能为空");
    		    	//密码不能为空
    				$("#login_password").focus();
    		    	return false;
    		    } 
    	    var jsonData = commonSerializeForm("loginForm");
    	    $.ajax({
    	        type : 'post',
    	        url : contextPath + "/userLogin/userLogin",
    	        data :jsonData,
    	        async: false,
    	        dataType : 'json',
    	    })
    	    } 
    	}













