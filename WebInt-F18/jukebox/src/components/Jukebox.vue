<template>
  <div class="jukebox">
    <div class="controls">
      <div>
        <input v-model="url" type="url" name="inputUrl" id="inputUrl">
        <input v-on:click="changeUrl" type="button" value="GO">
      </div>
      <div class="inputControlsGroup">
        <label for="inputControls">Controls:</label>
        <input v-model="controls" type="checkbox" name="inputControls" id="inputControls">
      </div>
      <div class="inputSeekGroup">
        <label for="inputSeek">Seek at:</label>
        <input v-model="seconds" type="number" id="inputSeek" min="0" v-bind:max="videoLength">
        <input v-on:click="seek" type="button" value="GO">
      </div>
      <input v-on:click="rotate" type="button" value="ROTATE">
    </div>
    <video
      autoplay
      ref="videoCurrent"
      class="videoCurrent"
      v-bind:src="current"
      v-bind:controls="controls"
      v-on:durationchange="updateDuration"
    ></video>
    <div class="videoBacklog">
      <video v-for="vid in videos" :src="vid"></video>
    </div>
  </div>
</template>

<script>
export default {
  name: "Jukebox",
  data: function() {
    return {
      videos: [
        "https://ia800207.us.archive.org/24/items/ColorShiftingSunset/ColorShiftingSunset-720_512kb.mp4",
        "https://ia802708.us.archive.org/29/items/MilkyWayTimelapseHd/milikyway.mp4",
        "https://ia802305.us.archive.org/27/items/HaleakalaSunset/HaleakalaSunset_512kb.mp4",
        "https://ia800201.us.archive.org/35/items/PerpetuaFogTimelapse/PerpetuaLowFogTimelapse-720_512kb.mp4"
      ],
      current: "",
      url: "",
      seconds: 15,
      controls: true,
      videoLength: 0
    };
  },
  created: function() {
    this.current = this.videos.shift();
  },
  methods: {
    updateDuration: function() {
      // When the video duration changes, set new max value for sec input and update default to be halfway through the video
      this.videoLength = this.$refs.videoCurrent.duration;
      this.seconds = Number((this.videoLength / 2).toFixed(0));
    },
    changeUrl: function() {
      this.current = this.url;
    },
    seek: function() {
      this.$refs.videoCurrent.currentTime = this.seconds;
    },
    rotate: function() {
      // Add current video to list of videos, rotate, and make the next video current
      this.videos.push(this.current);
      this.videos.push(this.videos.shift());
      this.current = this.videos.pop();
    }
  }
};
</script>


<style scoped>
.jukebox {
  display: grid;
  grid-template-columns: 3fr 1fr;
  padding: 20px;
  grid-gap: 20px 10px;
  max-width: 800px;
}

.controls {
  grid-column: 1 / 3;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 50px;
}

.controls div {
  height: 100%;
}

input {
  height: 100%;
  box-sizing: border-box;
  margin: 2px;
}

input[type="button"] {
  border: none;
  color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  background: #41b883;
}

label {
  padding-right: 5px;
}

.inputControlsGroup,
.inputSeekGroup {
  display: flex;
  align-items: center;
}

.videoCurrent {
  width: 100%;
}

.videoBacklog video {
  width: 100%;
}
</style>
