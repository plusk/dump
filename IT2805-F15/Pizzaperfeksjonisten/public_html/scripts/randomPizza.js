document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
    var cla = Math.floor(Math.random() * 11) + 1;
    var classic = document.getElementById("classicPic");
    classic.src = "../images/menuimg/classic/" + cla + ".jpg";

    var pre = Math.floor(Math.random() * 14) + 12;
    var premium = document.getElementById("premiumPic");
    premium.src = "../images/menuimg/premium/" + pre + ".jpg";
}