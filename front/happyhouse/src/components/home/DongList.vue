<template>
  <div>
    <v-subheader>동 선택</v-subheader>

    <v-card class="overflow-y-auto mx-auto" max-height="450" tile>
      <v-list flat>
        <v-list-item-group v-model="selectedItem">
          <v-list-item v-for="(item, i) in dongs" :key="i" @click="change">
            <v-list-item-content>
              <v-list-item-title v-text="item"></v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-card>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "DongList",
  computed: {
    ...mapState(["dongs"]),
  },
  data: () => ({
    selectedItem: 1,
    items: [],
  }),

  methods: {
    change() {
      this.$router.push("/apt");
    },
  },
};
</script>

<style></style>
