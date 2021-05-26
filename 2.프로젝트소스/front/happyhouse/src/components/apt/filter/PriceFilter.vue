<template>
  <div>
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="primary" dark v-bind="attrs" v-on="on"> 매물가격 </v-btn>
      </template>
      <v-card class="mx-auto" max-width="344">
        <v-card-text>
          <div>Word of the Day</div>
          <p class="display-1 text--primary">el·ee·mos·y·nar·y</p>
          <p>adjective</p>
          <div class="text--primary">
            relating to or dependent on charity; charitable.<br />
            "an eleemosynary educational institution."
          </div>
        </v-card-text>
      </v-card>
    </v-menu>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
