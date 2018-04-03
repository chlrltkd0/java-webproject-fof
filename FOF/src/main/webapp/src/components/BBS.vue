<template lang="html">
  <div id="BBS">
    <h1>{{category}}</h1>
    <b-table v-if="this.$store.state.boardinfo" hover :items="this.$store.state.boardinfo.boardList" :fields="fields" caption-top>
      <template slot="title" slot-scope="data"><i v-on:click="getBoard(data.item.idx)">{{data.item.title}}</i></template>
      <template slot="regDate" slot-scope="data">{{new Date(data.item.regDate)}}</template>
    </b-table>
    <div id="writeBtn">
      <b-container>
        <b-row align-h="center">
          <b-col cols="2"><b-form-select v-model="selected" :options="options" class="mb-3"/></b-col>
          <b-col cols="3"><b-form-input v-model:value="keyword"></b-form-input></b-col>
          <b-col cols="1"><b-button v-on:click="getboardinfoSearch">검색</b-button></b-col>
          <b-col cols="1"><b-button variant="default" v-on:click="write">글작성</b-button></b-col>
        </b-row>
      </b-container>
    </div>
    <div id="paging">
      <b-pagination v-if="this.$store.state.boardinfo" align="center" size="md" :total-rows="this.$store.state.boardinfo.boardCount" v-on:change="getboardinfo" :per-page="10" limit="10">
      </b-pagination>
    </div>
  </div>
</template>

<script>
export default {
  methods : {
    getBoard : function(data){
      console.log(data);
      axios({
        method:'post',
        url:'getBoard.do',
        params : {idx : data}
      }).then((response) => {
        this.$store.commit('setboard', response.data);
        this.$router.push('/board');
      }).catch(function(){
        alert('서버측 에러로 데이터를 전송받지 못했습니다.')
      })
    },
    getboardinfoSearch : function(event){
      this.$store.dispatch('getBoardInfo', {
        categoryIdx : this.$store.state.boardinfo.categoryIdx,
        keyword : this.keyword,
        page : 1
      });
    },
    getboardinfo : function(event){
      this.$store.dispatch('getBoardInfo', {
        categoryIdx : this.$store.state.boardinfo.categoryIdx,
        keyword : this.$store.state.boardinfo.keyword,
        page : event
      });
    },
    write : function(){
      this.$router.push('/writeboard');
    }
  },
  data : function() {
    return {
      category : '자유게시판',
      keyword : '',
      selected : '',
      options : ['제목', '내용', '작성자', '댓글'],
      fields: [
        {key:'idx', label:"번호"},
        {key:'title', label:"제목"},
        {key:'writer', label:"작성자"},
        {key:'regDate', label:'작성시간'}
      ]
    }
  }
}
</script>

<style lang="css">
table {
  margin-left:2rem;
  margin-right:2rem;
}

h1 {
  text-align: center;
}
</style>
