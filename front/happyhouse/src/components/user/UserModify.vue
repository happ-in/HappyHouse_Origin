<template>
  <div class="text-center">
    <v-dialog v-model="dialog" width="374">
      <template v-slot:activator="{ on, attrs }">
        <a style="color: black" v-bind="attrs" v-on="on"> 회원정보수정 </a>
      </template>

      <v-card>
        <v-card-title class="headline lighten-2"> 회원정보수정 </v-card-title>

        <v-container>
          <v-text-field
            label="ID"
            v-model="id"
            hide-details="auto"
            ref="id"
            readonly
          ></v-text-field>
          <v-text-field
            type="password"
            label="Password"
            v-model="pw"
            hide-details="auto"
            ref="pw"
          ></v-text-field>
          <v-text-field
            label="Username"
            v-model="username"
            hide-details="auto"
            ref="username"
          ></v-text-field>
          <v-text-field
            label="E-mail"
            v-model="email"
            hide-details="auto"
            ref="email"
          ></v-text-field>

          <div class="d-flex">
            <v-text-field
              label="Address"
              v-model="address"
              hide-details="auto"
              ref="address"
              disabled
            ></v-text-field>
            <v-btn class="ml-5 mt-3" outlined @click="showApi">주소 찾기</v-btn>
          </div>
        </v-container>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="dialog = false"> Cancel </v-btn>
          <v-btn color="primary" text @click="update"> Update </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";
let baseURL = "http://localhost:8888/happyhouse/";

export default {
  created() {
    let user = JSON.parse(localStorage.getItem("user"));
    this.id = user.userid;
    this.pw = user.userpwd;
    this.username = user.username;
    this.email = user.email;
    this.address = user.address;
  },
  data() {
    return {
      dialog: false,
      id: "",
      pw: "",
      email: "",
      username: "",
      zip: "",

      addr2: "",
      address: "",
    };
  },
  methods: {
    moveHome() {
      this.$router.go(this.$router.currentRoute);
    },
    update() {
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
      } else {
        axios
          .put(baseURL + "user", {
            userid: this.id,
            userpwd: this.pw,
            username: this.username,
            email: this.email,
            address: this.address,
          })
          .then(({ data }) => {
            localStorage.setItem("user", JSON.stringify(data));
            this.$router.go();
          });
      }
    },
    showApi() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          let fullRoadAddr = data.roadAddress; // 도로명 주소 변수
          let extraRoadAddr = ""; // 도로명 조합형 주소 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== "" && data.apartment === "Y") {
            extraRoadAddr += extraRoadAddr !== "" ? ", " + data.buildingName : data.buildingName;
          }
          // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== "") {
            extraRoadAddr = " (" + extraRoadAddr + ")";
          }
          // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
          if (fullRoadAddr !== "") {
            fullRoadAddr += extraRoadAddr;
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          this.zip = data.zonecode; //5자리 새우편번호 사용
          this.address = fullRoadAddr;
        },
      }).open();
    },
  },
  watch: {
    id: function () {
      this.idcheck = false;
    },
  },
};
</script>
