<template>
  <div>
    {{ newsList }}
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      newsList: [],
    };
  },
  created() {
    axios
      .get("http://localhost:8888/happyhouse/news", {
        params: {
          query: "삼성",
        },
      })
      .then(({ data }) => {
        this.newsList = data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>

<style></style>
