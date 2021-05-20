<template>
  <div>
    Board
    <notice-list></notice-list>
    <notice-detail></notice-detail>
  </div>
</template>

<script>
import NoticeList from "@/components/board/notice/NoticeList.vue";
import NoticeDetail from "@/components/board/notice/NoticeDetail.vue";

export default {
  name: "Notice",
  components: {
    NoticeList,
    NoticeDetail,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<style></style>
