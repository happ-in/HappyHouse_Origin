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
  },
  {
    path: "/notice",
    component: () => import("@/components/board/notice/Notice.vue"),
    children: [
      {
        path: "detail",
        component: () => import("@/components/board/notice/NoticeDetail.vue"),
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
