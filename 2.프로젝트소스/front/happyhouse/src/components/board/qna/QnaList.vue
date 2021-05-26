<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="6">
        <v-btn class="d-flex" elevation="1" medium @click="moveCreate">글쓰기</v-btn>
      </v-col>
      <v-col cols="12" sm="2">
        <v-select v-model="select" :items="items" item-text="state" item-value="abbr"></v-select>
      </v-col>

      <v-col cols="12" sm="4">
        <v-text-field
          class="d-flex"
          placeholder="검색"
          v-model="keyword"
          @keyup.enter="searchByKeyword(1)"
        ></v-text-field>
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

    <template>
      <div class="text-center">
        <v-pagination v-model="page" :length="length" circle></v-pagination>
      </div>
    </template>
  </v-container>
</template>

<script>
import axios from "axios";

let baseURL = `http://localhost:8888/happyhouse/qna/`;
export default {
  data() {
    return {
      qnas: [],
      select: "title",
      items: [
        { state: "제목", abbr: "title" },
        { state: "내용", abbr: "content" },
      ],
      page: 1,
      length: 0,
      keyword: "",
    };
  },
  created() {
    this.searchAll();
  },
  methods: {
    moveCreate() {
      if (localStorage.getItem("user")) {
        this.$router.push("qna/create");
      } else {
        this.$swal.fire({
          icon: "error",
          width: 310,
          title: "로그인이 필요합니다.",
          showConfirmButton: false,
          timer: 1500,
        });
      }
    },
    searchByKeyword(pageno) {
      if (this.keyword && this.select === "title") {
        axios
          .get(baseURL + "list", {
            params: {
              title: this.keyword,
              content: "",
              page: pageno,
            },
          })
          .then(({ data }) => {
            this.qnas = data.list;
            this.page = data.page;
            this.length = data.length;
          })
          .catch(() => {});
      } else if (this.keyword && this.select === "content") {
        axios
          .get(baseURL + "list", {
            params: {
              title: "",
              content: this.keyword,
              page: pageno,
            },
          })
          .then(({ data }) => {
            this.qnas = data.list;
            this.page = data.page;
            this.length = data.length;
          })
          .catch(() => {});
      } else {
        this.searchAll();
      }
    },
    searchAll() {
      axios
        .get(baseURL + "list/" + this.page)
        .then(({ data }) => {
          this.qnas = data.list;
          this.length = data.length;
        })
        .catch(() => {});
    },
  },
  watch: {
    page: function () {
      if (this.keyword) {
        this.searchByKeyword(this.page);
      } else {
        this.searchAll();
      }
    },
  },
};
</script>

<style></style>
