$(function () {
    $.fn.serializeObject=function() {

        var o={};
        var a=this.serializeArray();
        // console.log(a);
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

function loginHandler() {
    var seller=$("#loginForm").serializeObject();
    var data=JSON.stringify(seller);
    var loginid=seller.loginid;
    loginSubmit("/loginHandler",data,loginid);

}

function loginSubmit(url,data,id) {

    $.ajax({

        url:url,
        data:data,
        type:"post",
        contentType:"application/json",
        success:function (result){
            // console.log(result);
            if(result.status==200){
                // console.log(typeof(data))
                sessionStorage.setItem("sellerphone",id)
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
