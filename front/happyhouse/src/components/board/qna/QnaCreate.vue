<template>
  <v-container fluid>
    <v-text-field label="Title" v-model="title" hide-details="auto"></v-text-field><br />
    <v-textarea outlined label="Content" v-model="content" hide-details="auto"></v-textarea>
    <v-btn elevation="2" @click="moveList">취소</v-btn>
    <v-btn elevation="2" @click="registNotice">등록</v-btn>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    title: "",
    content: "",
    username: "",
    userid: "",
  }),
  methods: {
    registNotice() {
      axios
        .post("http://localhost:8888/happyhouse/qna", {
          username: this.username,
          userid: this.userid,
          title: this.title,
          content: this.content,
        })
        .then(() => {
          alert("질문이 등록됐습니다.");
          this.moveList();
        })
        .catch(() => {
          alert("질문 등록에 실패했습니다.");
        });
    },
    moveList() {
      this.$router.push("/qna");
    },
  },
  created() {
    this.username = JSON.parse(localStorage.getItem("user")).username;
    this.userid = JSON.parse(localStorage.getItem("user")).userid;
  },
};
</script>

<style></style>
