<template>
  <div>
    <v-btn elevation="1" medium @click="moveCreate">글쓰기</v-btn>
    <router-link to="/notice/detail">List</router-link>
  </div>
</template>

<script>
export default {
  methods: {
    moveCreate() {
      this.$router.push("notice/create");
    },
  },
};
</script>

<style></style>
