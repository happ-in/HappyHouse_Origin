<template>
  <div class="apt_list">
    <template>
      <v-expansion-panels focusable>
        <v-expansion-panel v-for="(item, i) in aptDealList.data" :key="i">
          <v-expansion-panel-header>{{ item.aptName }}</v-expansion-panel-header>
          <v-expansion-panel-content>
            거래금액: {{ item.dealAmount }}만원<br />
            면적: {{ item.area }}
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-expansion-panels>
    </template>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  computed: {
    ...mapState(["aptDealList"]),
  },
  data() {
    return {};
  },
  methods: {},

  created() {},
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
