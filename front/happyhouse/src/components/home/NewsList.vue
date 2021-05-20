<template>
  <v-card class="pa-1">
    <h1 class="text-center">오늘의 뉴스</h1>
    <v-hover
      v-slot="{ hover }"
      class="ma-1 mb-4"
      v-for="(news, index) in newsList.items"
      :key="index"
    >
      <v-card :elevation="hover ? 16 : 2" @click="test(index)">
        <v-list-item three-line>
          <v-list-item-content>
            <div class="overline mb-4">{{ news.pubDate }}</div>
            <v-list-item-title v-html="news.title" class="indigo--text font-weight-black mb-1" />
            <v-list-item-subtitle v-html="news.description" />
          </v-list-item-content>
        </v-list-item>
      </v-card>
    </v-hover>
  </v-card>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      newsList: [],
    };
  },
  methods: {
    test(num) {
      var url = this.newsList.items[num].link;
      window.open(url);
    },
  },

  created() {
    axios
      .get("http://localhost:8888/happyhouse/news", {
        params: {
          query: "부동산",
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
