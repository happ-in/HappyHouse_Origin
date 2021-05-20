<template>
  <div>
    <v-subheader>동 선택</v-subheader>

    <v-card class="overflow-y-auto mx-auto" max-width="400" max-height="450" tile>
      <v-list flat>
        <v-list-item-group v-model="selectedItem">
          <v-list-item v-for="(item, i) in items" :key="i">
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
export default {
  data: () => ({
    selectedItem: 1,
    items: [
      "관악동",
      "봉천동",
      "신림동",
      "봉천동",
      "신림동",
      "관악동",
      "관악동",
      "봉천동",
      "신림동",
      "관악동",
      "봉천동",
      "신림동",
      "관악동",
      "봉천동",
      "신림동",
      "관악동",
      "봉천동",
      "신림동",
    ],
  }),
};
</script>

<style></style>
