<template>
  <div>
    <h3 class="elevation-4 primary text-center"></h3>

    <div class="apt_list overflow-y-auto mx-auto">
      <template>
        <v-expansion-panels v-model="active_class" popout>
          <v-expansion-panel v-for="(item, i) in aptDealList.data" :key="i">
            <template v-if="check(item.aptName)">
              <v-expansion-panel-header class="font-weight-bold">{{
                item.aptName
              }}</v-expansion-panel-header>

              <v-expansion-panel-content>
                <v-divider class="mx-4 mb-4"></v-divider>
                <v-row class="ml-1">
                  <v-col>
                    <v-img
                      max-height="150"
                      max-width="250"
                      v-if="item.aptName == '인왕산아이파크'"
                      src="@/assets/apart1.png"
                    ></v-img>
                    <v-img
                      max-height="150"
                      max-width="250"
                      v-else
                      src="@/assets/prepareImg.jpeg"
                    ></v-img>
                  </v-col>
                </v-row>
                <v-row class="text-center">
                  <v-col>
                    <div class="aptAttr">거래금액:<br /></div>
                    <div class="aptVal">{{ item.dealAmount }}만원</div>
                  </v-col>
                  <v-divider class="mt-2 mb-2" vertical></v-divider>
                  <v-col>
                    <div class="aptAttr">면적: <br /></div>
                    <div class="aptVal">{{ item.area.substr(0, 6) }} m<sup>2</sup></div>
                  </v-col>
                  <v-divider class="mt-2 mb-2" vertical></v-divider>
                  <v-col>
                    <div class="aptAttr">건축년도 : <br /></div>
                    <div class="aptVal">{{ item.buildYear }}년</div>
                  </v-col>
                </v-row>
                <v-divider class="mx-4 mt-4 mb-2"></v-divider>
                <v-row class="text-center">
                  <v-col>
                    <div class="aptAttr">거래일 :</div>
                    <div class="aptVal">
                      {{ item.dealYear }}년 {{ item.dealMonth }}월 {{ item.dealDay }}일
                    </div>
                  </v-col>
                </v-row>
              </v-expansion-panel-content>
            </template>
          </v-expansion-panel>
        </v-expansion-panels>
      </template>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  computed: {
    ...mapState(["apt", "dong", "aptDealList", "searchKeyword"]),
  },
  data() {
    return { active_class: -1, num: 0 };
  },
  mounted() {},
  methods: {
    ...mapActions(["selectApt", "getKeyword"]),
    check(key) {
      // 검색 필터링
      if (!this.searchKeyword) {
        return true;
      } else {
        if (key.includes(this.searchKeyword)) return true;
      }
      return false;
    },
  },
  watch: {
    active_class: function () {
      this.selectApt(this.active_class);
    },
  },

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
  font-weight: 500;
  font-size: 12px;
}

.aptVal {
  font-size: 10pt;
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
