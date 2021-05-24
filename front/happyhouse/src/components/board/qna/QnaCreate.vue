<template>
  <v-container fluid>
    <v-container>
      <v-text-field label="Title" v-model="title" hide-details="auto"></v-text-field><br />
      <v-textarea outlined label="Content" v-model="content" hide-details="auto"></v-textarea>
      <v-col class="text-right">
        <v-btn elevation="2" @click="moveList" class="mr-3">취소</v-btn>
        <v-btn elevation="2" @click="registQna">등록</v-btn>
      </v-col>
    </v-container>
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
    registQna() {
      if (this.title && this.content) {
        axios
          .post("http://localhost:8888/happyhouse/qna", {
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
      } else {
        alert("제목 또는 내용이 빈 칸입니다.");
      }
    },
    moveList() {
      this.$router.push("/qna");
    },
  },
  created() {
    this.userid = JSON.parse(localStorage.getItem("user")).userid;
  },
};
</script>

<style></style>
