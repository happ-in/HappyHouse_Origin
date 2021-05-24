<template>
  <v-sheet class="ml-auto" max-width="700">
    <div v-if="!user" class="d-flex">
      <login />
      <join />
    </div>
    <template v-else>
      <v-container>
        <v-btn outlined rounded @click="logout"> Logout </v-btn>
      </v-container>
    </template>
  </v-sheet>
</template>

<script>
import Login from "@/components/home/Login.vue";
import Join from "@/components/home/Join.vue";

export default {
  components: {
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
      if (this.$route.path === "/mypage") this.$router.push("/");
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>

<style></style>
