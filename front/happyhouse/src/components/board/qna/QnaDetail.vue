<template>
  <v-container>
    <v-row class="d-flex">
      <v-col cols="12" sm="1">
        <v-btn icon color="orange">
          <v-icon>mdi-account</v-icon>
          Q&A
        </v-btn>
      </v-col>
      <v-col cols="12" sm="9">
        <h2>{{ qna.title }}</h2>
      </v-col>
      <template v-if="userid === qna.userid">
        <v-col cols="12" sm="2" class="text-right">
          <v-chip outlined @click="moveModify">수정</v-chip>
          <v-chip outlined @click="deleteQna">삭제</v-chip>
        </v-col>
      </template>
    </v-row>
    <hr />
    <br />
    <v-row class="d-flex">
      <h6 class="ml-3">작성일 : {{ qna.mod_date }}</h6>
      <h6 class="ml-auto mr-3">작성자 : {{ qna.username }}</h6>
      <img class="userimage" :src="image" />
    </v-row>

    <br />

    <div class="border">
      {{ qna.content }}
    </div>

    <br />
    <comment />
  </v-container>
</template>
<script>
import axios from "axios";
import Comment from "@/components/board/qna/QnaDetailComment.vue";
export default {
  components: {
    Comment,
  },
  data() {
    return {
      qna: [],
      userid: "",
      image: "",
    };
  },
  created() {
    axios
      .get(`http://localhost:8888/happyhouse/qna/${this.$route.params.no}`)
      .then(({ data }) => {
        this.qna = data;
        if (data.filename) this.image = require(`@/assets/${data.folder}/${data.filename}`);
        else this.image = require("@/assets/person.png");
      })
      .catch(() => {
        alert("Error!");
      });
    this.userid = JSON.parse(localStorage.getItem("user")).userid;
  },
  methods: {
    deleteQna() {
      axios
        .delete(`http://localhost:8888/happyhouse/qna/${this.$route.params.no}`)
        .then(() => {
          alert("QnA를 삭제했습니다.");
          this.moveList();
        })
        .catch(() => {
          alert("QnA 삭제 실패!");
        });
    },
    moveList() {
      this.$router.push("/qna");
    },
    moveModify() {
      this.$router.push(`/qna/modify/${this.$route.params.no}`);
    },
  },
};
</script>

<style>
.border {
  padding: 5px;
}
.userimage {
  width: 20px;
  object-fit: cover;
  margin-right: 10px;
}
</style>
