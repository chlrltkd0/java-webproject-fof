<template lang="html">
  <div id="nav">
    <div id="logo">
      <img src="../assets/future.png">
    </div>
    <b-navbar toggleable="md" type="dark" variant="success">
      <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
      <b-collapse is-nav id="nav_collapse">
        <b-navbar-nav class="mr-auto">
          <b-nav-item-dropdown text="게시판" left>
            <b-dropdown-item v-on:click="getboardinfo(1)">비밀친구</b-dropdown-item>
            <b-dropdown-item v-for="category in this.$store.state.boardcategorys" v-on:click="getboardinfo(category.idx)">{{category.name}}</b-dropdown-item>
          </b-nav-item-dropdown>
          <b-nav-item><router-link to="/">공지사항</router-link></b-nav-item>
          <b-nav-item>예측하기</b-nav-item>
          <b-nav-item href="#">게임하기</b-nav-item>
          <b-nav-item href="#">채팅하기</b-nav-item>
          <b-nav-item href="#">고객센터</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item v-if="this.$store.state.userinfo == null" v-on:click="showRegisterModal = true">회원가입</b-nav-item>
          <b-nav-item v-if="this.$store.state.userinfo == null" v-on:click="showLoginModal = true">로그인</b-nav-item>
          <b-nav-item-dropdown v-if="this.$store.state.userinfo != null" v-bind:text="this.$store.state.userinfo.email" right>
            <b-dropdown-item>내정보</b-dropdown-item>
            <b-dropdown-item v-on:click="logout">로그아웃</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <registerModal v-if="showRegisterModal" v-on:close="showRegisterModal = false"></registerModal>
    <loginModal v-on:login="login" v-if="showLoginModal" v-on:close="showLoginModal = false"></loginModal>
  </div>
</template>

<script>
import registerModal from './registerModal.vue'
import loginModal from './loginModal.vue'

export default {
  data : function(){
    return {
      boardcategorys : null,
      showRegisterModal : false,
      showLoginModal : false
    }
  },
  mounted : function(){

  },
  methods : {
    logout : function(){
      this.$store.state.userinfo = null;
      axios.post('logout.do').then(function(){});
      this.$router.push('/');
    },
    getboardinfo : function(data){
      this.$store.dispatch('getBoardInfo', {
        categoryIdx : data,
        page : 1
      });
      this.$router.push('/BBS');
    }
  },
  components : {
    registerModal : registerModal,
    loginModal : loginModal
  }
}

</script>

<style lang="css">

/* #nav {
  font-family: "Helvetica Neue", Helvetica, Arial, "맑은 고딕";
} */

#logo {
  text-align : center;
}

b-navbar {
  text-align : center;
}
</style>
