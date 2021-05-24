<template>
  <v-container class="ma-0">
    <v-row no-gutters>
      <v-col class="mr-5" cols="12" sm="2">
        <v-select class="hi" :items="items" label="검색 필터" solo></v-select>
      </v-col>
      <v-col class="mr-5" cols="12" sm="2">
        <v-text-field v-model="searchKey" label="검색어를 입력하세요." solo></v-text-field>
      </v-col>
      <v-col cols="12" sm="4">
        <price-filter></price-filter>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import PriceFilter from "@/components/apt/filter/PriceFilter.vue";
import { mapActions, mapState } from "vuex";

export default {
  components: {
    PriceFilter,
  },
  computed: {
    ...mapState(["searchKeyword"]),
    searchKey: {
      get() {
        return this.searchKeyword;
      },
      set(value) {
        this.getKeyword(value);
      },
    },
  },
  data: () => ({
    search: "",
    items: ["아파트명", "동"],
    min: -50,
    max: 90,
    range: [-20, 70],
  }),
  methods: {
    ...mapActions(["getKeyword"]),
  },
};
</script>

<style scoped></style>
