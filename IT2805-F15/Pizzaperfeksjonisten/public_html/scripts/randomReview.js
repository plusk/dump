//REVIEW

document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
    var review = [
        "Best pizza I've ever had!", 
        "Extremely good!!", 
        "The best culinary experience of my life!", 
        "Raul er pizzaguden.", "Lages med kun ferske råvarer!", 
        "Pizzaen til Raul reddet livet mitt!", 
        "Kjempegod mat, kommer tilbake!", 
        "Den eneste oppturen i eksamenslesinga", 
        "Trondheims beste pizza, punktum.", 
        "NOMNOM NOMNOM NOMNOM NOMNOM NOMNOM NOMNOM"];

    var reviewer = [
        "-Gordon Ramsey", 
        "-Jamie Oliver", 
        "-Paul Bocuse",
        "-Studenter i Trondheim",
        "-Raul","-Odd Geirson", 
        "-Lasse Svenning",
        "-Per Person",
        "-Kari Nygård",
        "-Pizzamonsteret"];
        
    function getRandom() {
      return Math.random();
    };
    function randomPick(computerChoice){
        if (computerChoice <= 0.10) {
            index = 0;
        } else if (computerChoice <= 0.20) {
            index = 1; 
        } else if (computerChoice <= 0.30) {
            index = 2;
        } else if (computerChoice <= 0.40) {
            index = 3; 
        } else if (computerChoice <= 0.50) {
            index = 4;
        } else if (computerChoice <= 0.60) {
            index = 5; 
        } else if (computerChoice <= 0.70) {
            index = 6;
        } else if (computerChoice <= 0.80) {
            index = 7; 
        } else if (computerChoice <= 0.90) {
            index = 8;
        } else if (computerChoice <= 1.00) {
            index = 9;
        }
    };
    var random = getRandom();
    randomPick(random);

    var printText = document.getElementById("reviewText");
    var printReviewer = document.getElementById("reviewPerson");
    printText.innerHTML = review[index];
    printReviewer.innerHTML = reviewer[index];
}