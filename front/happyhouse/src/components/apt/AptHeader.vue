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
      <v-col class="mr-5" cols="12" sm="2">
        <v-btn style="height: 50px" depressed color="primary" @click="searchClick"> 검색 </v-btn>
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
    // searchKey: {
    //   get() {
    //     return this.searchKeyword;
    //   },
    //   set(value) {
    //     this.getKeyword(value);
    //   },
    // },
  },
  data: () => ({
    searchKey: "",
    items: ["아파트명", "동"],
    min: -50,
    max: 90,
    range: [-20, 70],
  }),
  methods: {
    ...mapActions(["getKeyword"]),
    searchClick() {
      this.getKeyword(this.searchKey);
    },
  },
  destroyed() {
    this.getKeyword("");
  },
};
</script>

<style scoped></style>
