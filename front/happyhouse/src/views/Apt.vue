<template>
  <div>
    <div id="header">
      <apt-header></apt-header>
    </div>
    <div id="nav">
      <apt-list></apt-list>
    </div>
    <div id="section">
      <draw-map></draw-map>
    </div>
  </div>
</template>

<script>
import AptHeader from "@/components/apt/AptHeader.vue";
import AptList from "@/components/apt/AptList.vue";
import DrawMap from "@/components/apt/DrawMap.vue";

export default {
  components: {
    AptHeader,
    AptList,
    DrawMap,
  },
};
</script>

<style scoped>
#header {
  height: 80px;
}

#nav {
  color: white;
  width: 300px;
  float: left;
}
#section {
  margin-left: 180px;
}
</style>
