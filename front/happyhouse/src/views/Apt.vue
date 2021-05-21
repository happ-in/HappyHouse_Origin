<template>
  <v-row>
    <v-col cols="12" sm="3">
      <v-card> <apt-list> </apt-list> </v-card>
    </v-col>

    <v-col cols="12" sm="9">
      <v-card> <draw-map> </draw-map> </v-card>
    </v-col>
  </v-row>
</template>

<script>
import AptList from "@/components/apt/AptList.vue";
import DrawMap from "@/components/apt/DrawMap.vue";

export default {
  components: {
    AptList,
    DrawMap,
  },
};
</script>

<style></style>
