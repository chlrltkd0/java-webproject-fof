<template>
  <div class="">
    <my-nav></my-nav>
    <router-view></router-view>
  </div>
</template>

<script>
import Nav from './components/Nav.vue';

export default {
  components : {
    'my-nav': Nav
  }
}
</script>

<style>

</style>
