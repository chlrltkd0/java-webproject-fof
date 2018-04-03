<template lang="html">
  <div class="">
    <b-carousel id="carousel1" style="text-shadow: 1px 1px 2px #3433;"
                controls indicators background="#ababab" :interval="4000"
                img-width="1000" img-height="417" v-model="slide"
                @sliding-start="onSlideStart" @sliding-end="onSlideEnd">

      <b-carousel-slide img-width="100" caption="예쁘다"
        img-src="https://post-phinf.pstatic.net/MjAxNzA5MTJfMjA2/MDAxNTA1MTgzMjU4MzU3.KifBS50azn9NzP6PQcgPTQ3vGrP68wN9X0wJzwR3D7wg.fnWQVRt26-0MGrWgMVtf3iCPmxlf1kkwPA4Aukw8Q3Ug.JPEG/bs1.jpg?type=w1200"
      ></b-carousel-slide>

      <b-carousel-slide img-src="https://social.lge.co.kr/wp-content/uploads/2017/09/twice_%EB%8C%80%EB%AC%B8.jpg">
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
