<template>
  <v-container fluid>
    <v-container>
      <v-text-field label="Title" v-model="title" hide-details="auto"></v-text-field><br />
      <v-textarea outlined label="Content" v-model="content" hide-details="auto"></v-textarea>

      <v-col class="text-right">
        <v-btn elevation="2" @click="moveList" class="mr-3">취소</v-btn>
        <v-btn elevation="2" @click="registNotice">등록</v-btn>
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
  }),
  methods: {
    registNotice() {
      axios
        .post("http://localhost:8888/happyhouse/notice", {
          userid: JSON.parse(localStorage.getItem("user")).userid,
          title: this.title,
          content: this.content.replace(/(\r\n|\n|\n\n)/gi, "<br />"),
        })
        .then(() => {
          alert("공지사항이 등록됐습니다.");
          this.$router.push("/notice");
        })
        .catch(() => {
          alert("공지사항 등록에 실패했습니다.");
        });
    },
    moveList() {
      this.$router.push("/notice");
    },
  },
};
</script>

<style></style>
