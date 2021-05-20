<template>
  <v-container fluid>
    <v-text-field label="Title" :rules="rules" hide-details="auto"></v-text-field><br />
    <v-textarea outlined label="Content"></v-textarea>
    <v-btn elevation="2">등록</v-btn>
  </v-container>
</template>

<script>
export default {
  data: () => ({
    rules: [
      (value) => !!value || "Required.",
      (value) => (value && value.length >= 3) || "최소 3글자 이상이어야 합니다.",
    ],
  }),
};
</script>

<style>
.create {
  padding: 3px;
}
</style>
