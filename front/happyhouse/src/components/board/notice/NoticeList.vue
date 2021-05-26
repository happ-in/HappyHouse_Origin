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
          v-model="keyword"
          placeholder="검색"
          @keyup.enter="searchByKeyword(1)"
        ></v-text-field>
      </v-col>
    </v-row>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-center">글번호</th>
            <th class="text-center" style="width: 70%">제목</th>
            <th class="text-center">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="notice in notices" :key="notice.noticeno" class="text-center">
            <td>{{ notice.noticeno }}</td>
            <td>
              <router-link :to="`/notice/detail/${notice.noticeno}`">{{ notice.title }}</router-link>
            </td>
            <td>{{ notice.regtime }}</td>
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

let baseURL = "http://localhost:8888/happyhouse/notice/";
export default {
  data() {
    return {
      notices: [],
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
    searchAll() {
      axios
        .get(baseURL + `/list/${this.page}`)
        .then(({ data }) => {
          this.notices = data.list;
          this.length = data.length;
        })
        .catch(() => {});
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
            this.notices = data.list;
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
            this.notices = data.list;
            this.page = data.page;
            this.length = data.length;
          })
          .catch(() => {});
      } else {
        this.searchAll();
      }
    },
    moveCreate() {
      let user = JSON.parse(localStorage.getItem("user"));
      if (user && user.role === "ADMIN") {
        this.$router.push("/notice/create");
      } else {
        this.$swal.fire({
          icon: "error",
          width: 370,
          title: "관리자 권한이 필요합니다.",
          showConfirmButton: false,
          timer: 1500,
        });
      }
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
