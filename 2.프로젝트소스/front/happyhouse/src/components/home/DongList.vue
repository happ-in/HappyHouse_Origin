<template>
  <div>
    <v-subheader>동 선택</v-subheader>

    <v-card class="overflow-y-auto mx-auto" max-height="450" tile>
      <v-list flat>
        <v-list-item-group>
          <v-list-item v-for="(item, i) in dongs" :key="i" @click="change(i)">
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
import { mapActions } from "vuex";

export default {
  name: "DongList",
  computed: {
    ...mapState(["dongs"]),
  },
  data: () => ({}),

  methods: {
    ...mapActions(["getAptDealList", "selectDong"]),
    change(index) {
      this.getAptDealList(this.dongs[index]);
      this.selectDong(this.dongs[index]);
      this.$router.push("/apt");
    },
  },
};
</script>

<style></style>
