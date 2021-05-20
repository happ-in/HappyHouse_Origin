<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <v-text-field v-model="message" outlined clearable label="Message" type="text">
          <template v-slot:append-outer>
            <v-btn>댓글등록</v-btn>
          </template>
        </v-text-field>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      message: "",
    };
  },
};
</script>

<style></style>
