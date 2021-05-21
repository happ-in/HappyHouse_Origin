<template>
  <div class="header">
    <v-card color="basil" class="overflow-hidden">
      <v-img
        class="white--text py-6"
        height="200px"
        src="https://picsum.photos/1920/1080?random"
        gradient="to top right, rgba(100,115,201,.5), rgba(25,32,72,.6)"
      >
        <v-card-title class="font-weight-bold text-center justify-center display-4"
          ><div class="header_title">내 집 마 련</div></v-card-title
        >
        <div class="header_title">행복한 우리집</div>
      </v-img>

      <v-tabs fixed-tabs background-color="indigo" dark>
        <v-tab @click="$router.push('/')"> 홈 </v-tab>
        <v-tab @click="$router.push('/notice')"> 공지사항 </v-tab>
        <v-tab @click="$router.push('/qna')"> Q & A </v-tab>
        <v-tab @click="checkLogin"> 마이 페이지 </v-tab>
      </v-tabs>
    </v-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      items: ["Home", "Notice", "Q&A", "My Page"],
    };
  },
  methods: {
    checkLogin() {
      if (localStorage.getItem("user")) {
        this.$router.push("/mypage");
      } else {
        alert("로그인 후 이용 가능합니다!");
        this.$router.push("/");
      }
    },
  },
};
</script>

<style scoped>
/* Helper classes */
.basil {
  background-color: #283593 !important;
}

.basil--text {
  color: #ffffff !important;
}

@font-face {
  font-family: "this_is_font_name";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_tway@1.0/twayair.woff") format("woff");

  font-weight: normal;
  font-style: normal;
}

.header_title {
  text-align: center;
  font-family: this_is_font_name;
}

/* 상단 고정 */
/* .header {
  z-index: 9;
  display: inline-block;
  position: sticky;
  top: 0px;
} */
</style>
