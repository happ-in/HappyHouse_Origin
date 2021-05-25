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
              <v-img src="@/assets/seoulChart.png" />
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
</style>
