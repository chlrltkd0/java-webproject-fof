import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export const store = new Vuex.Store({
  state : {
    boardcategorys : null,
    userinfo : null,
    boardinfo : null,
    board : null,
  },
  getters : {
    getBoardInfo : function(state){
      return state.boardinfo;
    }
  },
  mutations : {
    setboardinfo : function(state, payload){
      return state.boardinfo = payload;
    },
    setuserinfo : function(state, payload){
      state.userinfo = payload;
    },
    setCurrentPage : function(state, payload){
      state.boardinfo.page = payload;
    },
    setboard : function(state, payload){
      state.board = payload;
    },
    setboardcategorys : function(state, payload){
      state.boardcategorys = payload;
    }
  },
  actions : {
    getBoardInfo : function(context, payload){
      axios({
        method : 'post',
        url : 'getBoardList.do',
        params : {
          categoryIdx : payload.categoryIdx,
          keyword : payload.keyword,
          page : payload.page
        }
      }).then((response) => {
        context.commit('setboardinfo', response.data);
      })
    }
  }
});
