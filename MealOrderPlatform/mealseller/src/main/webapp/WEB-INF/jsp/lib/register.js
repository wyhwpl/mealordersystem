$(function () {
    $.fn.serializeObject=function() {

        var o={};
        var a=this.serializeArray();
        console.log(a);
        $.each(a,function () {
            if(o[this.name]){
                if(!o[this.name].push){
                    o[this.name]=[o[this.name]];
                }
                o[this.name].push(this.value||'');
            }
            else{
                o[this.name]=this.value||'';
            }

        });
        return o;
    };

});

function registerHandler() {

    var data=JSON.stringify($("#regForm").serializeObject());
    console.log(data);
    registerSubmit("/registerHandler",data);

}

function registerSubmit(url,data) {

    $.ajax({

        url:url,
        data:data,
        type:"post",
        contentType:"application/json",
        success:function (result){
            console.log(result);
            if(result.status==200){
                var id=$("#regForm").serializeObject().loginid;
                sessionStorage.setItem("sellerphone",id);
                window.location.href="/"
            }
            else alert(result.message);
        },
        error:function (result) {
            console.log("error");
            console.log(result);
            if(result.status==200){
                window.location.href="/"
            }
            else alert(result.message);
        }

    });

}
function checkLoginId() {

    var loginId = $("#loginId").val();
    console.log(loginId);
    var reg=/^[a-zA-Z0-9]{1,15}$/;
    if(loginId==null||loginId==""){
        $("#loginId").next().text("登录账号不能为空");
    }
    else if(reg.test(loginId)){
        $("#loginId").next().text("");
    }else{
        $("#loginId").next().text( "长度为1-15，包含任意的字母、数字，不可以使用其他符号");
    }

}

function checkPassword() {

    var password = $("#password").val();
    console.log(password);
    var reg=/^[a-zA-Z0-9]{1,16}$/;
    if(password==null||password==""){
        $("#password").next().text("登录密码不能为空");
    }
    else if(reg.test(password)){
        $("#password").next().text("");
    }else{
        $("#password").next().text( "密码长度为1-16，包含任意的字母、数字，不可以使用其他符号");
    }

}
function checkPasswordAgain() {

    var password = $("#password").val();
    var passwordAgain= $("#passwordAgain").val();
    console.log(passwordAgain);
    if(passwordAgain==password){
        $("#passwordAgain").next().text("");
    }else{
        $("#passwordAgain").next().text( "两次密码不同");
    }

}
function checkIDCard() {

    var IDcard = $("#IDCard").val();
    console.log(IDcard);
    var reg=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if(IDcard==null||IDcard==""){
        $("#IDCard").next().text("证件号不能为空");
    }
    else if(reg.test(IDcard)){
        $("#IDCard").next().text("");
    }else{
        $("#IDCard").next().text( "长度为18，包含数字或以X结尾，不可以使用其他符号");
    }

}
function checkSellerName() {

    var sellerName = $("#sellerName").val();
    console.log(sellerName);
    var reg=/^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,15}$/;
    if(sellerName==null||sellerName==""){
        $("#sellerName").next().text("店铺名不能为空");
    }
    else if(reg.test(sellerName)){
        $("#sellerName").next().text("");
    }else{
        $("#sellerName").next().text( "长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号");
    }

}
function checkPhone() {

    var phone = $("#Phone").val();
    console.log(phone);
    var reg=/(^\d{11}$)/;
    if(phone==null||phone==""){
        $("#Phone").next().text("手机号不能为空");
    }
    else if(reg.test(phone)){
        $("#Phone").next().text("");
    }else{
        $("#Phone").next().text( "长度为11，包含数字，不可以使用其他符号");
    }

}
function checkName() {

    var Name = $("#Name").val();
    console.log(Name);
    var reg=/^([\u4e00-\u9fa5]){1,15}$/;
    if(Name==null||Name==""){
        $("#Name").next().text("姓名不能为空");
    }
    else if(reg.test(Name)){
        $("#Name").next().text("");
    }else{
        $("#Name").next().text( "长度为1-15，包含任意中文，不可以使用其他符号");
    }

}
function checkAddress() {

    var address = $("#Address").val();
    console.log(address);
    var reg=/^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,32}$/;
    if(address==null||address==""){
        $("#Address").next().text("地址不能为空");
    }
    else if(reg.test(address)){
        $("#Address").next().text("");
    }else{
        $("#Address").next().text( "长度为1-32，包含任意的字母、数字、中文，不可以使用其他符号");
    }

}
