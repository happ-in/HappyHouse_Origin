<template>
  <div class="text-center">
    <v-dialog v-model="dialog" width="374">
      <template v-slot:activator="{ on, attrs }">
        <a style="color: black" v-bind="attrs" v-on="on"> 회원탈퇴 </a>
      </template>

      <v-card>
        <v-card-title class="headline lighten-2"> 회원탈퇴 </v-card-title>

        <v-container>
          정말 탈퇴하시겠습니까?
          <v-text-field label="Delete" v-model="agree" placeholder="동의합니다." hide-details="auto"></v-text-field>
        </v-container>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="dialog = false"> Cancel </v-btn>
          <v-btn color="primary" text @click="deleteUser" :disabled="agree != '동의합니다.'"> Delete </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      dialog: false,
      agree: "",
    };
  },
  methods: {
    deleteUser() {
      axios
        .delete("http://localhost:8888/happyhouse/user/" + JSON.parse(localStorage.getItem("user")).userid)
        .then(() => {
          localStorage.clear();
          this.$router.push("/");
          this.$router.go(this.$router.currentRoute);
        });
    },
  },
};
</script>
