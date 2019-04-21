$("#btn_logout").click(function () {
    sessionStorage.removeItem("userInfo");
    localStorage.removeItem("access-token");
    location.href = "login.html";
});
var info = sessionStorage.getItem("userInfo");
if (info!=null&&info!=""){
    $("li>a[href='login.html']").parent().css("display","none");
    console.log("application.html");
}