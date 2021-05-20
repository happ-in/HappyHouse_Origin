<template>
  <v-container>
    <v-row class="d-flex">
      <v-col cols="12" sm="1">
        <v-btn icon color="red">
          <v-icon>mdi-star</v-icon>
          공지
        </v-btn>
      </v-col>
      <v-col>
        <h2>{{ notice.subject }}</h2>
      </v-col>
      <v-col cols="12" sm="2">
        <h5>작성일 : {{ notice.regtime }}</h5>
      </v-col>
    </v-row>

    <hr />
    <br />

    <div class="border">
      {{ notice.content }}
    </div>
  </v-container>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      notice: [],
    };
  },
  created() {
    axios.get(`http://localhost:8888/happyhouse/notice/${this.$route.params.no}`).then(({ data }) => {
      this.notice = data;
    });
  },
};
</script>

<style>
.border {
  padding: 5px;
}
</style>
