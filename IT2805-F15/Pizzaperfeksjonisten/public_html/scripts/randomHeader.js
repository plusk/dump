document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
    var imgArray = ["1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png"]; // this could probably be more dynamic with jquery, but it's not a priority
    var num = Math.floor(Math.random() * imgArray.length); // picks random index of the array
    var img = document.getElementById("himg").src = "../images/headers/" + imgArray[num]; // the src of the element with id "himg" is now the pic corresponding to the random index
}