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
  border: 1px solid rgba(172, 172, 172, 0.714);
}

#nav {
  color: white;
  width: 340px;
  border: 1px solid rgba(172, 172, 172, 0.714);
  float: left;
}
</style>
