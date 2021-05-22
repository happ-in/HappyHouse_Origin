<template>
  <div class="apt_list">
    <template>
      <v-expansion-panels focusable>
        <v-expansion-panel v-for="(item, i) in 5" :key="i">
          <v-expansion-panel-header>Item</v-expansion-panel-header>
          <v-expansion-panel-content>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
            exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </template>
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

<style scoped>
@font-face {
  font-family: "this_is_font_name";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_tway@1.0/twaysky.woff")
    format("woff");

  font-weight: normal;
  font-style: normal;
}

.header_title {
  text-align: center;
  font-family: this_is_font_name;
}
</style>
