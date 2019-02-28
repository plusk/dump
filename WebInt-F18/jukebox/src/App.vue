<template>
  <div id="app">
    <HelloWorld msg="Hello, world!"/>
    <Jukebox/>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
import Jukebox from "./components/Jukebox.vue";

export default {
  name: "app",
  components: {
    HelloWorld,
    Jukebox
  }
};
</script>

<style>
body {
  margin: 0;
}

#app {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-family: sans-serif;
  color: #2c3e50;
}
</style>
