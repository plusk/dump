//Listen til bildene opprettes
var images = new Array();

//Bildene legges til listen
images.push("../images/slidesRest/rest1.jpg");
images.push("../images/slidesRest/rest2.jpg");
images.push("../images/slidesRest/rest3.jpg");
images.push("../images/slidesRest/rest4.jpg");
images.push("../images/slidesRest/rest5.jpg");

document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
    //Main slideshow
    var time = 5000;//time between picture change
    var fadeSpeed = 500;//speed of fade effect
    var index = Math.floor(Math.random()*(5));//chooses a random picture from images
    var himg = document.getElementById("restpics");
    himg.src = images[index];
    setTimeout(anim, time);//starts anim with a delay.
    
    function anim() {//fades out the current image and starts nextImg.
        $("#restpics").fadeTo(fadeSpeed, 0, "swing", nextImg);
    };

    function nextImg() {//selects the next image, fades it in and starts anim with a delay
        if (index == (images.length - 1)) {
            index = 0;
        } else {
            index++;
        };
        himg.src = images[index];
        $("#restpics").fadeTo(fadeSpeed, 1);        
        setTimeout(anim, time);
    };
}