<template>
  <header>
    <img alt="Vue logo" src="../assets/logo.png">
    <h1>{{ msg }}</h1>
  </header>
</template>

<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String
  }
};
</script>


<style scoped>
header {
  background: #222;
  color: #eee;
  text-align: center;
  padding: 20px;
  width: 100%;
}

h1 {
  margin: 0;
}
</style>
