<template lang="html">
  <div class="">
    <b-carousel id="carousel1" style="text-shadow: 1px 1px 2px #3433;"
                controls indicators background="#ababab" :interval="4000"
                img-width="100" img-height="200" v-model="slide"
                @sliding-start="onSlideStart" @sliding-end="onSlideEnd">

      <b-carousel-slide img-width="100" caption="First slide" text="Nulla vitae e 시발 럼아 몽둥이로 갖다 패버린다"
                img-src="../assets/olympic.png"></b-carousel-slide>

      <b-carousel-slide img-src="https://lorempixel.com/1024/480/technics/4/">
        <h1>Hello world!</h1>
      </b-carousel-slide>
      <b-carousel-slide img-src="https://lorempixel.com/1024/480/technics/8/"></b-carousel-slide>

    </b-carousel>
  </div>
</template>

<script>
export default {
  data : function(){
    return {
      slide : 0,
      sliding : null
    }
  },
  methods : {
    onSlideStart : function(slide){
      this.sliding = true;
    },
    onSlideEnd : function(slide){
      this.sliding = false;
    }
  }
}
</script>

<style lang="css">
</style>
