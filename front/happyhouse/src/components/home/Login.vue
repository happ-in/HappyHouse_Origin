<template>
  <v-container>
    <div class="text-center">
      <v-dialog v-model="dialog" width="374">
        <template v-slot:activator="{ on, attrs }">
          <v-btn outlined rounded v-bind="attrs" v-on="on"> Sign In </v-btn>
        </template>

        <v-card v-if="!isForgotPwd">
          <v-card-title class="headline lighten-2"> Login </v-card-title>

          <v-container>
            <v-text-field label="ID" v-model="id" hide-details="auto"></v-text-field>
            <v-text-field type="password" label="Password" v-model="pw"></v-text-field>
          </v-container>

          <div class="text-center">
            <a href="#" @click="isForgotPwd = true">Forgot Password?</a>
            <br />
          </div>

          <v-divider></v-divider>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" text @click="cancel"> Cancel </v-btn>
            <v-btn color="primary" text @click="loginCheck"> Login </v-btn>
          </v-card-actions>
        </v-card>

        <v-card v-else>
          <v-card-title class="headline lighten-2"> Find Password </v-card-title>

          <v-container>
            <v-text-field label="ID" v-model="findId" hide-details="auto"></v-text-field>
            <v-text-field label="Email" v-model="findEmail"></v-text-field>
          </v-container>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" text @click="isForgotPwd = false"> Cancel </v-btn>
            <v-btn color="primary" text @click="findPwd"> Send </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>
  </v-container>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      dialog: false,
      id: "",
      pw: "",
      findId: "",
      findEmail: "",
      isForgotPwd: false,
    };
  },
  methods: {
    loginCheck() {
      if (this.id && this.pw) {
        axios
          .post("http://localhost:8888/happyhouse/", {
            userid: this.id,
            userpwd: this.pw,
          })
          .then(({ data }) => {
            if (data.userid) localStorage.setItem("user", JSON.stringify(data));
            else alert("존재하지 않는 아이디 또는 틀린 비밀번호입니다.");
            this.moveHome();
          })
          .catch(() => {
            alert("로그인에 실패했습니다.");
          });
      } else {
        alert("ID 또는 Password가 빈 칸입니다.");
      }
    },
    findPwd() {
      axios
        .post("http://localhost:8888/happyhouse/find", {
          userid: this.findId,
          email: this.findEmail,
        })
        .then(() => {
          alert("임시 비밀번호가 이메일로 전송됐습니다!");
          this.cancel();
        })
        .catch(() => {
          alert("일치하는 정보가 없습니다!");
        });
    },
    moveHome() {
      this.$router.go(this.$router.currentRoute);
    },
    cancel() {
      this.dialog = false;
      this.isForgotPwd = false;
      this.id = "";
      this.pw = "";
      this.findId = "";
      this.findEmail = "";
    },
  },
};
</script>

<style>
a {
  text-decoration: none;
  color: black;
}
</style>
