<template>
  <v-app>
    <v-sheet class="ml-auto" max-width="700">
      <div v-if="!user" class="d-flex">
        <login />
        <join />
      </div>
      <template v-else>
        <v-container>
          <v-btn color="red lighten-2" dark @click="logout"> 로그아웃 </v-btn>
        </v-container>
      </template>
      <!-- <v-btn class="mr-2" :input-value="active" active-class="purple white--text" depressed rounded @click="toggle">
        로그인
      </v-btn>
      <v-btn class="mr-2" :input-value="active" active-class="purple white--text" depressed rounded @click="toggle">
        회원가입
      </v-btn> -->
    </v-sheet>
    <Header></Header>
    <v-main>
      <router-view />
    </v-main>

    <Footer></Footer>
  </v-app>
</template>

<script>
import Header from "@/layout/Header.vue";
import Footer from "@/layout/Footer.vue";
import Login from "@/components/home/Login.vue";
import Join from "@/components/home/Join.vue";

export default {
  name: "App",
  components: {
    Header,
    Footer,
    Login,
    Join,
  },
  data() {
    return {
      user: [],
    };
  },
  created() {
    this.user = localStorage.getItem("user");
  },
  methods: {
    logout() {
      localStorage.clear();
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>
