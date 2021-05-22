<template>
  <v-container>
    <br />
    <v-img class="fileupload" :src="image" alt="" srcset="" @click="fileUploadTag" />

    <v-file-input
      hide-input
      truncate-length="15"
      accept="image/*"
      ref="image"
      prepend-icon
      @change="saveImg"
    ></v-file-input>

    <br />

    <v-row class="d-flex">
      <v-col><hr /></v-col>
      <v-col class="text-center">
        <h2>{{ username }}님 환영합니다!</h2>
      </v-col>
      <v-col><hr /></v-col>
    </v-row>

    <br />

    <div class="text-center">
      <router-link to="/">회원정보수정</router-link> <br />
      <router-link to="/">회원탈퇴</router-link>
    </div>
    <router-view></router-view>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      image: "",
    };
  },
  created() {
    this.username = JSON.parse(localStorage.getItem("user")).username;
    this.image = require("@/assets/person.png");
  },
  methods: {
    fileUploadTag() {
      this.$refs.image.$refs.input.click();
    },
    saveImg() {
      console.log("save image");
    },
  },
};
</script>

<style>
.fileupload {
  width: 150px;
  height: 150px;
  margin: auto;
  border-radius: 50%;
}
</style>
