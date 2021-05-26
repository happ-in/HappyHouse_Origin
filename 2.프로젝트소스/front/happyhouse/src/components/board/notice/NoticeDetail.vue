<template>
  <v-container>
    <v-row class="d-flex">
      <v-col cols="12" sm="1">
        <v-btn icon color="red">
          <v-icon>mdi-star</v-icon>
          공지
        </v-btn>
      </v-col>
      <v-col cols="12" sm="9">
        <h2>{{ notice.title }}</h2>
      </v-col>
      <template v-if="role === 'ADMIN'">
        <v-col cols="12" sm="2" class="text-right">
          <v-chip outlined @click="deleteNotice">삭제</v-chip>
        </v-col>
      </template>
    </v-row>
    <hr />
    <br />
    <v-row>
      <v-col cols="12" sm="2">
        <h5>작성일 : {{ notice.regtime }}</h5>
      </v-col>
    </v-row>

    <br />

    <div class="border" v-html="notice.content"></div>
  </v-container>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      notice: [],
      role: "",
    };
  },
  created() {
    if (localStorage.getItem("user")) {
      this.role = JSON.parse(localStorage.getItem("user")).role;
    }
    axios.get(`http://localhost:8888/happyhouse/notice/${this.$route.params.no}`).then(({ data }) => {
      this.notice = data;
    });
  },
  methods: {
    deleteNotice() {
      axios
        .delete(`http://localhost:8888/happyhouse/notice/${this.$route.params.no}`)
        .then(() => {
          alert("공지사항을 삭제했습니다.");
          this.$router.push("/notice");
        })
        .catch(() => {
          alert("공지사항 삭제에 실패했습니다.");
        });
    },
  },
};
</script>

<style>
.border {
  padding: 5px;
}
</style>
