<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="6">
        <v-btn class="d-flex" elevation="1" medium @click="moveCreate">글쓰기</v-btn>
      </v-col>
      <v-col cols="12" sm="2">
        <v-select :items="items" item-text="state" item-value="abbr"></v-select>
      </v-col>
      <v-col cols="12" sm="4">
        <v-text-field class="d-flex"></v-text-field>
      </v-col>
    </v-row>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-center">글번호</th>
            <th class="text-center" width="50%">제목</th>
            <th class="text-center">작성자</th>
            <th class="text-center">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="qna in qnas" :key="qna.id" class="text-center">
            <td>{{ qna.id }}</td>
            <td>
              <router-link :to="`/qna/detail/${qna.id}`">{{ qna.title }}</router-link>
            </td>
            <td>{{ qna.username }}</td>
            <td>{{ qna.mod_date }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      qnas: [],
      items: [
        { state: "제목", abbr: "title" },
        { state: "내용", abbr: "content" },
      ],
    };
  },
  created() {
    axios
      .get("http://localhost:8888/happyhouse/qna")
      .then(({ data }) => {
        this.qnas = data;
      })
      .catch(() => {});
  },
  methods: {
    moveCreate() {
      if (localStorage.getItem("user")) {
        this.$router.push("qna/create");
      } else {
        alert("로그인 후 이용 가능합니다!");
      }
    },
  },
};
</script>

<style></style>
