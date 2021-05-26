<template>
  <v-container fluid>
    <v-text-field label="Title" v-model="title" hide-details="auto"></v-text-field><br />
    <v-textarea outlined label="Content" v-model="content" hide-details="auto"></v-textarea>
    <v-btn elevation="2" @click="moveList">취소</v-btn>
    <v-btn elevation="2" @click="updateNotice">수정</v-btn>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data: () => ({
    id: "",
    title: "",
    content: "",
  }),
  methods: {
    updateNotice() {
      axios
        .put(`http://localhost:8888/happyhouse/qna/`, {
          id: this.id,
          title: this.title,
          content: this.content,
        })
        .then(() => {
          alert("질문을 수정했습니다.");
          this.moveList();
        })
        .catch(() => {
          alert("질문 수정에 실패했습니다.");
        });
    },
    moveList() {
      this.$router.push(`/qna/detail/${this.$route.params.no}`);
    },
  },
  created() {
    this.id = this.$route.params.no;
    axios.get(`http://localhost:8888/happyhouse/qna/${this.$route.params.no}`).then(({ data }) => {
      this.title = data.title;
      this.content = data.content;
    });
  },
};
</script>

<style></style>
