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
            <v-text-field label="ID" v-model="id" hide-details="auto"></v-text-field>
            <v-text-field label="Password" v-model="pw"></v-text-field>
            <v-text-field label="E-mail" v-model="email"></v-text-field>
            <v-text-field label="Password" v-model="pw"></v-text-field>
          </v-container>

          <v-divider></v-divider>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="primary" text @click="dialog = false"> Cancel </v-btn>
            <v-btn color="primary" text @click="join"> Join </v-btn>
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
      email: "",
    };
  },
  methods: {
    join() {
      console.log("join");
    },
    moveHome() {
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>
