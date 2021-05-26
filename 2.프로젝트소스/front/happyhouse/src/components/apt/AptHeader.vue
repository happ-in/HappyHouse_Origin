<template>
  <v-container class="ma-0">
    <v-row no-gutters>
      <v-col class="mr-5" cols="12" sm="2">
        <v-text-field
          v-model="searchKey"
          label="아파트명을 입력하세요."
          @keyup.enter="searchClick"
          solo
        ></v-text-field>
      </v-col>
      <v-col class="mr-6" cols="12" sm="1">
        <v-btn style="height: 50px" depressed color="primary" @click="searchClick"> 검색 </v-btn>
      </v-col>
      <v-col class="mr-5 mt-3" cols="12" sm="3">
        <v-range-slider v-model="range" hint="천만원" max="30" min="5" thumb-label>
        </v-range-slider>
      </v-col>
      <v-col class="mr-5" cols="12" sm="2">
        <v-btn style="height: 50px" depressed color="primary" @click="priceClick"> 적용 </v-btn>
      </v-col>

      <!-- <v-col cols="12" sm="2">
        <price-filter></price-filter>
      </v-col> -->
    </v-row>
  </v-container>
</template>

<script>
//import PriceFilter from "@/components/apt/filter/PriceFilter.vue";
import { mapActions, mapState } from "vuex";

export default {
  components: {
    //PriceFilter,
  },
  computed: {
    ...mapState(["gu", "dong", "searchKeyword"]),
  },
  data: () => ({
    range: [5, 50],
    searchKey: "",
    items: ["아파트명", "동"],
  }),
  methods: {
    ...mapActions(["getKeyword", "getPriceRange"]),
    searchClick() {
      this.getKeyword(this.searchKey);
    },
    priceClick() {
      var tmp = [this.range[0], this.range[1], this.dong];
      this.getPriceRange(tmp);
    },
  },
  destroyed() {
    this.getKeyword("");
  },
};
</script>

<style scoped></style>
