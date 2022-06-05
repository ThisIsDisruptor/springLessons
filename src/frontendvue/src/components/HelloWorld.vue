<template>
    <h1>{{ msg }}</h1>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
        msg:''
    }
  },
  mounted() {
    fetch("/api/vue/vueMessage")
        .then(response => response.text())
        .then(stringData => {
            this.msg = 'Hello, ' + stringData
        })
    }

}
</script>

