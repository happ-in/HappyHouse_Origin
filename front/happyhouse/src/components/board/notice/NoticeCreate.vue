<template>
  <v-container fluid>
    <v-text-field label="Title" v-model="title" hide-details="auto"></v-text-field><br />
    <v-textarea outlined label="Content" v-model="content" hide-details="auto"></v-textarea>
    <v-btn elevation="2" @click="registNotice">등록</v-btn>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    title: "",
    content: "",
  }),
  methods: {
    registNotice() {
      axios
        .post("http://localhost:8888/happyhouse/notice", {
          userid: "1",
          subject: this.title,
          content: this.content,
        })
        .then(() => {
          alert("공지사항이 등록됐습니다.");
          this.$router.push("/notice");
        })
        .catch(() => {
          alert("공지사항 등록에 실패했습니다.");
        });
    },
  },
};
</script>

<style></style>
