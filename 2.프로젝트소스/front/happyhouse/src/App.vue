<template>
  <v-app>
    <Bar />
    <Header />
    <v-main>
      <fade-transition origin="center" mode="out-in" :duration="250">
        <router-view />
      </fade-transition>
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
import { FadeTransition } from "vue2-transitions";
import Header from "@/layout/Header.vue";
import Footer from "@/layout/Footer.vue";
import Bar from "@/layout/Bar.vue";
export default {
  name: "App",
  components: {
    Bar,
    Header,
    Footer,
    FadeTransition,
  },
};
</script>
