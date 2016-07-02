document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
	var display = document.getElementById("display-area");
	var btnToggle = document.getElementById("toggle-button");
	var btnReset = document.getElementById("reset-button")

	var ticking = false;

	var startTime = 0;
	var currentTime = 0;
	var elapsedTime = 0;
	var totalTime = 0;

	var timer;

	btnToggle.addEventListener("click", toggleTimer);
	function toggleTimer() {
		if(ticking == false) {
			ticking = true;

			startTime = new Date();

			timer = window.setInterval(function() {
				currentTime = new Date();

				totalTime = currentTime - startTime + elapsedTime
				
				var nH = Math.floor(totalTime / (1000*60*60))
				totalTime = totalTime % (1000*60*60);
				var nM = Math.floor(totalTime / (1000*60));
				totalTime = totalTime % (1000*60);
				var nS = Math.floor(totalTime / 1000);
				var nMS = totalTime % 1000;
				
				if(nH < 10){nH = "0" + nH}
				if(nM < 10){nM = "0" + nM}
				if(nS < 10){nS = "0" + nS}
				if(nMS < 10){nMS = "00" + nMS}
				else if(nMS < 100){nMS = "0" + nMS}
				
				display.innerHTML = nH + ":" + nM + ":" + nS + "." + nMS
			}, 1);
		}
		else {
			ticking = false;
			window.clearInterval(timer)
			elapsedTime = totalTime
		}
	}
	btnReset.addEventListener("click", resetTimer);
	function resetTimer() {
		startTime = new Date();
		elapsedTime = 0
		
		display.innerHTML = "0:0:0.0"
	}
}