<template>
  <v-container>
    <div class="text-center">
      <v-dialog v-model="dialog" width="374">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="red lighten-2" dark v-bind="attrs" v-on="on"> 회원가입 </v-btn>
        </template>

        <v-card>
          <v-card-title class="headline lighten-2"> 회원가입 </v-card-title>

          <v-container>
            <div class="d-flex">
              <v-text-field label="ID" v-model="id" hide-details="auto" ref="id"></v-text-field>
              <v-btn outlined @click="checkID">Check</v-btn>
            </div>
            <v-text-field type="password" label="Password" v-model="pw" hide-details="auto" ref="pw"></v-text-field>
            <v-text-field label="Username" v-model="username" hide-details="auto" ref="username"></v-text-field>
            <v-text-field label="E-mail" v-model="email" hide-details="auto" ref="email"></v-text-field>
            <v-text-field label="Address" v-model="address" hide-details="auto" ref="address"></v-text-field>
            <v-select v-model="role" :items="items" item-text="state" item-value="attr"></v-select>
          </v-container>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" text @click="closeDialog"> Cancel </v-btn>
            <v-btn color="primary" text @click="join"> Join </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>
  </v-container>
</template>

<script>
import axios from "axios";
let baseURL = "http://localhost:8888/happyhouse/";

export default {
  data() {
    return {
      dialog: false,
      id: "",
      pw: "",
      email: "",
      username: "",
      address: "",
      role: "USER",
      idcheck: false,
      items: [
        { state: "일반 사용자", attr: "USER" },
        { state: "관리자", attr: "ADMIN" },
      ],
    };
  },
  methods: {
    moveHome() {
      this.$router.go(this.$router.currentRoute);
    },
    join() {
      console.log(this.emailRule);
      if (!this.id) {
        alert("아이디를 작성하세요!");
        this.$refs.id.focus();
      } else if (!this.pw) {
        alert("비밀번호를 작성하세요!");
        this.$refs.pw.focus();
      } else if (!this.email) {
        alert("이메일를 작성하세요!");
        this.$refs.email.focus();
      } else if (!this.username) {
        alert("유저명을 작성하세요!");
        this.$refs.username.focus();
      } else if (!this.address) {
        alert("주소를 작성하세요!");
        this.$refs.address.focus();
      } else if (!this.idcheck) {
        alert("아이디 중복 체크를 하세요!");
        this.$refs.id.focus();
      } else {
        axios
          .post(baseURL + "join", {
            userid: this.id,
            userpwd: this.pw,
            username: this.username,
            email: this.email,
            address: this.address,
            role: this.role,
          })
          .then(() => {
            alert("회원가입이 완료됐습니다!");
            this.closeDialog();
          })
          .catch(() => {
            alert("회원가입 실패!");
          });
      }
    },
    checkID() {
      if (this.id) {
        axios
          .get(baseURL + "validate", {
            params: {
              id: this.id,
            },
          })
          .then(() => {
            alert("사용 가능한 ID입니다.");
            this.idcheck = true;
          })
          .catch(() => {
            alert("이미 사용 중인 ID입니다.");
          });
      } else {
        alert("아이디를 입력하세요!");
      }
    },
    closeDialog() {
      this.dialog = false;
      this.id = "";
      this.pw = "";
      this.email = "";
      this.role = "USER";
      this.username = "";
      this.address = "";
      this.idcheck = false;
      this.success = false;
      this.fail = false;
    },
  },
  watch: {
    id: function () {
      this.idcheck = false;
    },
  },
};
</script>
