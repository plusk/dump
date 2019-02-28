let videoTags;
const videoUrls = [];
const videoTitles = [
  "Color Shifting Sunset",
  "Milkyway Timelapse",
  "Haleakala Sunset",
  "Perpetual Fog Timelapse"
];
let title;

function rotateVideos() {
  videoTags[0].id = "";
  videoUrls.push(videoUrls.shift());
  videoTitles.push(videoTitles.shift());
  for (const [index, tag] of videoTags.entries()) {
    tag.src = videoUrls[index];
  }
  videoTags[0].id = "activeVideo";
  title.textContent = `Now playing: ${videoTitles[0]}`;
}

document.addEventListener("DOMContentLoaded", function() {
  videoTags = document.querySelectorAll("#jukeboxPost video");
  title = document.querySelector("#videoTitle");
  videoTags.forEach(tag => {
    videoUrls.push(tag.src);
    tag.onended = rotateVideos;
    console.log(tag);
  });
  videoTags[0].id = "activeVideo";
  title.textContent = `Now playing: ${videoTitles[0]}`;
});
