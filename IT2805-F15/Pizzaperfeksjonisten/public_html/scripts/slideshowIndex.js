//Listen til bildene opprettes
var images = new Array();

//Bildene legges til listen
images.push("../images/slidesIndex/index1.jpg");
images.push("../images/slidesIndex/index2.jpg");
images.push("../images/slidesIndex/index3.jpg");
images.push("../images/slidesIndex/index4.jpg");

document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
    //Main slideshow 
    
    var index = Math.floor(Math.random()*(images.length));//Chooses a random picture from images
    var time = 6000;//time between picture change
    var fadeSpeed = 500;//speed of fade effect
    var himg = document.getElementById("himg");
    himg.src = images[index];
    setTimeout(anim, time);//starts anim with a delay.

    function anim() {//fades out the current image and starts nextImg.
        $("#himg").fadeTo(fadeSpeed, 0, "swing", nextImg);
    };

    function nextImg() {//selects the next image, fades it in and starts anim with a delay
        if (index == (images.length - 1)) {
            index = 0;
        } else {
            index++;
        };
        himg.src = images[index];
        $("#himg").fadeTo(fadeSpeed, 1);
        setTimeout(anim, time);
    };  
}