let urlInput;
let secInput;
let videoPlayer;
let videoFormError;

let canvas;
let ctx;

let rotation = 0;

let circleToggled = false;

function updateVideo() {
  if (urlInput.value) {
    videoPlayer.src = urlInput.value;
    videoFormError.textContent = "";
    if (secInput.value) {
      videoPlayer.currentTime = secInput.value;
    }
  } else if (secInput.value) {
    videoPlayer.currentTime = secInput.value;
  } else {
    videoFormError.textContent = "You need to specify a URL";
  }
  return false;
}

function rotateVideo() {
  rotation = document.querySelector("#rotInput").value;
  ctx.clearRect(0, 0, canvas.width * 2, canvas.height * 2);
  ctx.translate(canvas.width / 2, canvas.height / 2);
  ctx.rotate((rotation * Math.PI) / 180);
  ctx.translate(-canvas.width / 2, -canvas.height / 2);
}

// Doesn't actually work due to problems with "tainted canvas"
function screenshotVideo() {
  const ss = document.querySelector("#videoScreenshot");
  ss.src = canvas.toDataURL("image/png");
}

function mirrorVideo() {
  ctx.translate(canvas.width, 0);
  ctx.scale(-1, 1);
}

function toggleCircle() {
  circleToggled = !circleToggled;
}

function drawImages() {
  const vid = this;
  (function loop() {
    if (!vid.paused && !vid.ended) {
      var hRatio =
        (canvas.width / videoPlayer.videoWidth) * videoPlayer.videoHeight;
      ctx.drawImage(vid, 0, 0, canvas.width, hRatio);
      if (circleToggled) {
        ctx.save();
        ctx.globalCompositeOperation = "destination-in";
        ctx.beginPath();
        ctx.arc(
          canvas.width / 2,
          canvas.height / 2,
          canvas.height / 2,
          0,
          Math.PI * 2
        );
        ctx.closePath();
        ctx.fill();
        ctx.restore();
      }
      setTimeout(loop, 1000 / 30); // drawing at 30fps
    }
  })();
}

document.addEventListener("DOMContentLoaded", function() {
  urlInput = document.querySelector("#urlInput");
  secInput = document.querySelector("#secInput");
  videoPlayer = document.querySelector("#videoPlayer");
  videoFormError = document.querySelector("#videoFormError");

  videoPlayer.onerror = function() {
    videoFormError.textContent = "Couldn't load video";
  };

  const videoForm = document.querySelector("#videoForm");
  videoForm.onsubmit = updateVideo;

  canvas = document.querySelector("#videoCanvas");
  ctx = canvas.getContext("2d");

  videoPlayer.addEventListener("play", drawImages, 0);

  const rotButton = document.querySelector("#rotButton");
  rotButton.onclick = rotateVideo;

  const ssButton = document.querySelector("#ssButton");
  ssButton.onclick = screenshotVideo;

  const mirrorButton = document.querySelector("#mirrorButton");
  mirrorButton.onclick = mirrorVideo;

  const circleButton = document.querySelector("#circleButton");
  circleButton.onclick = toggleCircle;
});
