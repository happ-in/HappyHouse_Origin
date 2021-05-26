<template>
  <div class="header">
    <v-card color="basil" class="overflow-hidden">
      <v-img
        class="white--text py-6"
        height="200px"
        src="https://source.unsplash.com/1600x900/?apartment"
        gradient="to top right, rgba(100,115,201,.5), rgba(25,32,72,.6)"
      >
        <v-card-title class="font-weight-bold text-center justify-center display-4">
          <div class="header_title">내 집 마 련</div></v-card-title
        >
        <div class="header_title">행복한 우리집</div>
      </v-img>

      <v-tabs fixed-tabs background-color="indigo" dark v-model="active_tab">
        <v-tab @click="moveToHome"> 홈 </v-tab>
        <v-tab @click="moveToNotice"> 공지사항 </v-tab>
        <v-tab @click="moveToQna"> Q & A </v-tab>
        <v-tab @click="checkLogin"> 마이 페이지 </v-tab>
      </v-tabs>
    </v-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      active_tab: 0,
      items: ["Home", "Notice", "Q&A", "My Page"],
    };
  },
  created() {
    // refresh 시 현재 탭 유지
    setTimeout(() => {
      if (this.$route.path === "/") {
        this.active_tab = 0;
      } else if (this.$route.path === "/notice") {
        this.active_tab = 1;
      } else if (this.$route.path === "/qna") {
        this.active_tab = 2;
      } else if (this.$route.path === "/mypage") {
        this.active_tab = 3;
      }
    }, 100);
  },
  methods: {
    moveToHome() {
      if (this.$route.path !== "/") this.$router.push("/");
    },
    moveToNotice() {
      if (this.$route.path !== "/notice") this.$router.push("/notice");
    },

    moveToQna() {
      if (this.$route.path !== "/qna") this.$router.push("/qna");
    },

    checkLogin() {
      if (localStorage.getItem("user")) {
        if (this.$route.path !== "/mypage") this.$router.push("/mypage");
      } else {
        this.$swal.fire({
          icon: "error",
          width: 350,
          title: "로그인이 필요합니다.",
          showConfirmButton: false,
          timer: 1500,
        });
        if (this.$route.path !== "/") this.$router.push("/");
        // this.active_tab = 0;
        setTimeout(() => {
          this.active_tab = 0;
        }, 100);
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
  font-family: "tway_sky";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/SDSamliphopangche_Outline.woff")
    format("woff");

  font-weight: normal;
  font-style: normal;
}

.header_title {
  text-align: center;
  font-family: tway_sky;
}
/* 상단 고정 */
/* .header {
  z-index: 9;
  display: inline-block;
  position: sticky;
  top: 0px;
} */
</style>
