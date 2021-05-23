<template>
  <div>
    <v-container style="max-width: 1200px">
      <v-row>
        <v-col cols="12" sm="8">
          <v-card> <draw-map> </draw-map> </v-card>
        </v-col>
        <v-col cols="12" sm="4">
          <v-card> <dong-list> </dong-list> </v-card>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12" sm="6">
          <v-card> <news-list> </news-list> </v-card>
        </v-col>
        <v-col cols="12" sm="6">
          <v-card><draw-graph></draw-graph> </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import DrawMap from "@/components/home/DrawMap.vue";
import NewsList from "@/components/home/NewsList.vue";
import DongList from "@/components/home/DongList.vue";
import DrawGraph from "@/components/home/DrawGraph.vue";

export default {
  name: "Home",

  components: {
    NewsList,
    DrawMap,
    DongList,
    DrawGraph,
  },
};
</script>

<style scoped></style>
