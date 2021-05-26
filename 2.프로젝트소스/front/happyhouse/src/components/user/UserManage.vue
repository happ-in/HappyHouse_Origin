<template>
  <div class="text-center">
    <v-dialog v-model="dialog" width="374">
      <template v-slot:activator="{ on, attrs }">
        <a style="color: black" v-bind="attrs" v-on="on"> 회원관리 </a>
      </template>

      <v-card>
        <v-card-title class="headline lighten-2"> 회원관리 </v-card-title>

        <v-container>
          <v-list>
            <v-list-item-group>
              <template v-for="user in userList">
                <v-list-item :key="user.userid">
                  <template>
                    <v-list-item-content>
                      <v-list-item-title v-text="user.userid"></v-list-item-title>
                      <v-list-item-subtitle v-text="user.username + '(' + user.email + ')'"></v-list-item-subtitle>
                    </v-list-item-content>
                    <template>
                      <v-btn elevation="2" rounded x-small @click="deleteUser(user.userid)">탈퇴</v-btn>
                    </template>
                  </template>
                </v-list-item>
              </template>
            </v-list-item-group>
          </v-list>
        </v-container>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="dialog = false"> Close </v-btn>
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
      userList: [],
    };
  },
  created() {
    this.getUerList();
  },
  methods: {
    getUerList() {
      axios.get("http://localhost:8888/happyhouse/user").then(({ data }) => {
        this.userList = data;
      });
    },
    deleteUser(userid) {
      axios.delete(`http://localhost:8888/happyhouse/user/${userid}`).then(() => {
        this.getUerList();
      });
    },
  },
};
</script>
