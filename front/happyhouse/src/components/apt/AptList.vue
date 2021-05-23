<template>
  <div class="apt_list overflow-y-auto mx-auto">
    <template>
      <v-expansion-panels popout>
        <v-expansion-panel v-for="(item, i) in aptDealList.data" :key="i">
          <v-expansion-panel-header>{{ item.aptName }}</v-expansion-panel-header>

          <v-expansion-panel-content>
            <v-divider class="mx-4 mb-4"></v-divider>
            <v-row>
              <v-col>
                <div class="aptAttr">거래금액:<br /></div>
                <div class="aptVal">{{ item.dealAmount }}만원</div>
              </v-col>
              <v-divider class="mt-2 mb-2" vertical></v-divider>
              <v-col>
                <div class="aptAttr">면적: <br /></div>
                <div class="aptVal">{{ item.area }}m<sup>2</sup></div>
              </v-col>
              <v-divider class="mt-2 mb-2" vertical></v-divider>
              <v-col>
                <div class="aptAttr">건축년도 : <br /></div>
                <div class="aptVal">{{ item.buildYear }}년</div>
              </v-col>
            </v-row>
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
  mounted() {},
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

.aptAttr {
  color: #bdbdbd;
  font-weight: 800;
  font-size: 12px;
}

.aptVal {
  font-size: 15pt;
  font-weight: bold;
  color: #3f51b5;
}

.apt_list {
  height: 1000px;
}

.header_title {
  text-align: center;
  font-family: this_is_font_name;
}
</style>
