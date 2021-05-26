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
      @change="selectFile"
      name="image"
    ></v-file-input>

    <br />

    <v-row class="d-flex">
      <v-col><hr /></v-col>
      <v-col class="text-center text-font">
        <h2>{{ username }}님 환영합니다!</h2>
      </v-col>
      <v-col><hr /></v-col>
    </v-row>

    <br />

    <div class="text-center text-font">
      <template v-if="role === 'ADMIN'">
        <user-manage></user-manage>
      </template>
      <user-modify></user-modify>
      <user-delete></user-delete>
    </div>
    <router-view></router-view>
  </v-container>
</template>

<script>
import axios from "axios";
import UserModify from "@/components/user/UserModify.vue";
import UserDelete from "@/components/user/UserDelete.vue";
import UserManage from "@/components/user/UserManage.vue";
export default {
  components: {
    UserModify,
    UserDelete,
    UserManage,
  },
  data() {
    UserModify;
    return {
      username: "",
      role: "",
      image: "",
      active: false,
    };
  },
  created() {
    let user = JSON.parse(localStorage.getItem("user"));
    this.username = user.username;
    this.role = user.role;
    if (user.filename) {
      this.image = require(`@/assets/${user.folder}/${user.filename}`);
    } else {
      this.image = require("@/assets/person.png");
    }
  },
  methods: {
    fileUploadTag() {
      this.$refs.image.$refs.input.click();
    },
    saveImg() {
      this.saveBtn = false;
    },
    selectFile(file) {
      let image = new FormData();
      image.append("title", this.name);
      image.append("file", file);

      axios
        .post("http://localhost:8888/happyhouse/file", image, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
          params: {
            userid: JSON.parse(localStorage.getItem("user")).userid,
          },
        })
        .then(({ data }) => {
          localStorage.setItem("user", JSON.stringify(data));
        })
        .catch(() => {
          console.log("fail");
        });
    },
  },
};
</script>

<style>
@font-face {
  font-family: "Bazzi";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/Bazzi.woff") format("woff");
  font-weight: normal;
  font-style: normal;
}
.text-font {
  font-family: Bazzi;
}
.fileupload {
  width: 150px;
  height: 150px;
  margin: auto;
  border-radius: 50%;
}
a {
  text-decoration: none;
}
a:link {
  color: black;
}
a:visited {
  color: black;
}
a:hover {
  color: black;
}
a:active {
  color: black;
}
</style>
