<template>
  <div class="footer">
    <UserInfo :loggedIn="loggedIn"/>
  </div>

  <div class="content">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
  
  
  
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import UserInfo from './components/UserInfo.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    UserInfo
  },
  data() {
    return {
      loggedIn: false 
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
