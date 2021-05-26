<template>
  <v-footer color="primary lighten-1" padless>
    <v-row justify="center" no-gutters>
      <v-col class="text-center">
        <v-btn color="white" text rounded class="my-2" @click="moveToHome">Home</v-btn>
        <v-btn color="white" text rounded class="my-2" @click="moveToAbout">About Us</v-btn>
        <v-btn color="white" text rounded class="my-2" @click="moveToBlog">Blog</v-btn>
        <v-btn href="mailto:happyhouse_seoul10@naver.com" color="white" text rounded class="my-2"
          >Contact Us</v-btn
        >
      </v-col>

      <v-col class="primary lighten-2 py-4 text-center white--text" cols="12">
        {{ new Date().getFullYear() }} — <strong>Happy House</strong>
      </v-col>
    </v-row>
  </v-footer>
</template>
<script>
export default {
  data: () => ({
    links: ["Home", "About Us", "Services", "Blog", "Contact Us"],
  }),
  methods: {
    moveToHome() {
      if (this.$route.path !== "/") this.$router.push("/");
    },
    moveToAbout() {
      if (this.$route.path !== "/aboutus") this.$router.push("/aboutus");
    },
    moveToBlog() {
      window.open("https://github.com/SSAFY-CS-STUDY/Tech_interview");
    },
    moveToContact() {
      window.open("https://github.com/SSAFY-CS-STUDY/Tech_interview");
    },
  },
};
</script>
