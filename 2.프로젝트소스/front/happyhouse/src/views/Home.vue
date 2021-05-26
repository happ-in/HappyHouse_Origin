<template>
  <transition name="slide">
    <div class="foo">
      <v-container style="max-width: 1200px">
        <v-card class="pa-1 mb-5">
          <h2 class="header_title">아파트 거래정보 검색</h2>
          <v-row>
            <v-col cols="12" sm="8">
              <v-card> <draw-map> </draw-map> </v-card>
            </v-col>
            <v-col cols="12" sm="4">
              <v-card> <dong-list> </dong-list> </v-card>
            </v-col>
          </v-row>
        </v-card>

        <v-row>
          <v-col cols="12" sm="6">
            <v-card> <news-list> </news-list> </v-card>
          </v-col>
          <v-col cols="12" sm="6">
            <v-card>
              <h1 class="cookie-font" @click="moveToGraph">
                <v-container>
                  <v-row style="height: 60px">
                    <v-col style="color: black; font-size: 30pt">코로나 19현황</v-col>
                  </v-row>
                  <v-row>
                    <v-col
                      ><div style="color: grey; font-size: 7pt">('2021.05.26.00시 기준)</div></v-col
                    >
                  </v-row>
                  <v-divider class="ma-4"></v-divider>
                  <v-row>
                    <v-col>
                      <v-chip style="font-size: 20pt" color="green" text-color="white" width="300px"
                        >지역</v-chip
                      >
                    </v-col>
                    <v-col>
                      <v-chip style="font-size: 20pt" color="primary" text-color="white"
                        >확진자</v-chip
                      >
                    </v-col>
                    <v-col>
                      <v-chip style="font-size: 20pt" color="red" text-color="white"
                        >추가 확진자</v-chip
                      >
                    </v-col>
                  </v-row>
                  <v-row>
                    <v-col>서울시</v-col>
                    <v-col>43,001명</v-col>
                    <v-col>262명</v-col>
                  </v-row>
                  <v-row>
                    <v-col>전국</v-col>
                    <v-col>137,672명</v-col>
                    <v-col>707명</v-col>
                  </v-row>
                </v-container>
              </h1>
            </v-card>
            <v-card class="mt-6 pa-1">
              <iframe
                width="100%"
                height="400"
                src="https://www.youtube.com/embed/x9tYdmBQiSQ?autoplay=1"
                title="YouTube video player"
                frameborder="0"
                allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen
              >
              </iframe
            ></v-card>
          </v-col>
        </v-row>
      </v-container>
    </div>
  </transition>
</template>

<script>
import DrawMap from "@/components/home/DrawMap.vue";
import NewsList from "@/components/home/NewsList.vue";
import DongList from "@/components/home/DongList.vue";

export default {
  name: "Home",
  components: {
    NewsList,
    DrawMap,
    DongList,
  },
  methods: {
    moveToGraph() {
      this.$router.push("/graph");
    },
  },
};
</script>

<style scoped>
@font-face {
  font-family: "this_is_font_name";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff")
    format("woff");

  font-weight: normal;
  font-style: normal;
}

.header_title {
  text-align: center;
  font-family: this_is_font_name;
}
@font-face {
  font-family: "CookieRunOTF-Bold";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
.cookie-font {
  text-align: center;
  font-family: CookieRunOTF-Bold;
  cursor: pointer;
  font-size: 20px;
}
</style>
