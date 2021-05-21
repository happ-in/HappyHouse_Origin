<template>
  <v-app>
    <Bar />
    <Header />
    <v-main>
      <router-view />
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
import Header from "@/layout/Header.vue";
import Footer from "@/layout/Footer.vue";
import Bar from "@/layout/Bar.vue";
export default {
  name: "App",
  components: {
    Bar,
    Header,
    Footer,
  },
};
</script>
