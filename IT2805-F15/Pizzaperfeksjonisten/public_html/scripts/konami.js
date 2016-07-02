var index = 0;
var konami = [38,38,40,40,37,39,37,39,66,65]; // array of all the inputs for the konami code
window.addEventListener("keydown", function(tast) {  // when key is pressed
    if (tast.keyCode == konami[index]) { // if the key corresponds to the next key in the code
        index++; // advance to next key
    }
    else { // if not, reset code
        index = 0;
    } 
    if (index == 10){ // if all keys are cleared
        window.location = "https://www.peppes.no/"; //sends you to some real pizza
    }
});