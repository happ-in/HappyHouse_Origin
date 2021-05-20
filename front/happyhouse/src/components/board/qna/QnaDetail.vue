<template>
  <v-container>
    <v-row class="d-flex">
      <v-col cols="12" sm="1">
        <v-btn icon color="orange">
          <v-icon>mdi-account</v-icon>
          Q&A
        </v-btn>
      </v-col>
      <v-col>
        <h2>{{ qna.title }}</h2>
      </v-col>
    </v-row>
    <hr />
    <br />
    <v-row>
      <h6 class="ml-3">작성일 : {{ qna.mod_date }}</h6>
      <h6 class="ml-auto mr-3">작성자 : {{ qna.username }}</h6>
    </v-row>

    <br />

    <div class="border">
      {{ qna.content }}
    </div>

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
    };
  },
  created() {
    axios.get(`http://localhost:8888/happyhouse/qna/${this.$route.params.no}`).then(({ data }) => {
      this.qna = data;
    });
  },
};
</script>

<style>
.border {
  padding: 5px;
}
</style>
