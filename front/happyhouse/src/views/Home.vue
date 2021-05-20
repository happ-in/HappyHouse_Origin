<template>
  <div>
    Home

    <news-list></news-list>
  </div>
</template>

<script>
import NewsList from "@/components/home/NewsList.vue";

export default {
  name: "Home",

  components: {
    NewsList,
  },
};
</script>
