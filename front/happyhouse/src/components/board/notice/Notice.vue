<template>
  <div>
    <h2>Notice</h2>
    <notice-list></notice-list>
    <router-view></router-view>
  </div>
</template>

<script>
import NoticeList from "@/components/board/notice/NoticeList.vue";
export default {
  components: {
    NoticeList,
  },
};
</script>

<style></style>
