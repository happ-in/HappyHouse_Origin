<template>
  <v-container>
    <v-row>
      <v-col class="d-flex">
        <v-btn class="d-flex" elevation="1" medium @click="moveCreate">글쓰기</v-btn>
        <v-select :items="items" item-text="state" item-value="abbr"></v-select>
        <v-text-field class="d-flex"></v-text-field>
      </v-col>
    </v-row>
    <v-simple-table>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-center">글번호</th>
            <th class="text-center">제목</th>
            <th class="text-center">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="notice in notices" :key="notice.noticeno" class="text-center">
            <td>{{ notice.noticeno }}</td>
            <td>
              <router-link :to="`/notice/detail/${notice.noticeno}`">{{ notice.subject }}</router-link>
            </td>
            <td>{{ notice.regtime }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    <router-link to="/notice/detail">List</router-link>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      notices: [],
      items: [
        { state: "제목", abbr: "subject" },
        { state: "내용", abbr: "content" },
      ],
    };
  },
  created() {
    axios
      .get("http://localhost:8888/happyhouse/notice")
      .then(({ data }) => {
        console.log(data);
        this.notices = data;
      })
      .catch(() => {});
  },
  methods: {
    moveCreate() {
      this.$router.push("notice/create");
    },
  },
};
</script>

<style></style>
