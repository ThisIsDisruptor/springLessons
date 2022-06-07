<template>
  <h2 v-if="loggedIn"> You are logged in!</h2>
  <h2 v-else> You are not logged in! Please log in</h2>

</template>

<script>
export default {
  props: {
    loggedIn: Boolean
  }
}
</script>

