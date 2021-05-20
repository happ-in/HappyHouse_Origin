import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: () => import("@/views/Home.vue"),
  },
  {
    path: "/apt",
    component: () => import("@/views/Apt.vue"),
  },
  {
    path: "/qna",
    component: () => import("@/components/board/qna/QnaCreate.vue"),
    children: [],
  },
  {
    path: "/notice",
    component: () => import("@/components/board/notice/Notice.vue"),
    children: [
      {
        path: "/",
        component: () => import("@/components/board/notice/NoticeList.vue"),
      },
      {
        path: "detail",
        component: () => import("@/components/board/notice/NoticeDetail.vue"),
      },
      {
        path: "create",
        component: () => import("@/components/board/notice/NoticeCreate.vue"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
