<template>
  <v-container>
    <template v-for="comment in comments">
      <v-list-item :key="comment.id">
        <v-list-item-content>
          <v-row class="d-flex">
            <v-col cols="12" sm="1">
              <v-list-item-subtitle class="text--primary" v-text="comment.username"></v-list-item-subtitle>
            </v-col>
            <template v-if="comment.flag">
              <v-col cols="12" sm="9">
                <v-text-field outlined> {{ comment.content }} </v-text-field>
              </v-col>
            </template>
            <template v-else>
              <v-col cols="12" sm="9">
                <v-list-item-title v-text="comment.content"></v-list-item-title>
              </v-col>
            </template>

            <v-col cols="12" sm="2" class="text-right">
              <v-list-item-subtitle v-text="comment.regtime"></v-list-item-subtitle>
              <template v-if="comment.username === username">
                <div class="d-flex">
                  <v-list-item-subtitle>
                    <a href="#" @click="deleteComment(comment.id)">삭제</a>
                  </v-list-item-subtitle>
                </div>
              </template>
            </v-col>
          </v-row>
        </v-list-item-content>
      </v-list-item>
    </template>

    <v-row>
      <v-col cols="12">
        <v-text-field v-model="message" outlined clearable label="Message" type="text">
          <template v-slot:append-outer>
            <v-btn @click="registComment">댓글등록</v-btn>
          </template>
        </v-text-field>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      message: "",
      comments: [],
      username: "",
    };
  },

  created() {
    axios.get(`http://localhost:8888/happyhouse/comment/${this.$route.params.no}`).then(({ data }) => {
      data.forEach((element) => {
        this.comments.push({
          id: element.id,
          qna_id: element.qna_id,
          regtime: element.regtime,
          userid: element.userid,
          username: element.username,
          content: element.content,
        });
      });
    });
    this.username = JSON.parse(localStorage.getItem("user")).username;
  },
  methods: {
    registComment() {
      if (localStorage.getItem("user")) {
        if (this.message) {
          axios
            .post(`http://localhost:8888/happyhouse/comment`, {
              qna_id: this.$route.params.no,
              userid: JSON.parse(localStorage.getItem("user")).userid,
              content: this.message,
              tmpContent: this.message,
            })
            .then(() => {
              this.$router.go(this.$router.currentRoute);
            })
            .catch((error) => {
              console.log(error);
            });
        } else {
          alert("댓글을 입력해주세요!");
        }
      } else {
        alert("로그인 후 이용할 수 있습니다!");
      }
    },
    deleteComment(id) {
      axios.delete(`http://localhost:8888/happyhouse/comment/${id}`).then(() => {
        this.$router.go(this.$router.currentRoute);
      });
    },
  },
};
</script>

<style>
v-col {
  height: auto;
}
</style>
