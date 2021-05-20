<template>
  <div>
    <v-container>
      <v-row>
        <v-col cols="12" sm="12">
          <v-card> <draw-map> </draw-map> </v-card>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12" sm="6">
          <v-card> <news-list> </news-list> </v-card>
        </v-col>
        <v-col cols="12" sm="6">
          <v-card> <draw-map></draw-map> </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import DrawMap from "@/components/home/DrawMap.vue";
import NewsList from "@/components/home/NewsList.vue";

export default {
  name: "Home",

  components: {
    NewsList,
    DrawMap,
  },
};
</script>

<style scoped></style>
