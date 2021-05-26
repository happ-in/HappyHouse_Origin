import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  {
    path: "/graph",
    component: () => import("@/views/Graph.vue"),
  },
  {
    path: "/",
    component: () => import("@/views/Home.vue"),
    // component: () => import("@/components/home/NewsList.vue"),
  },
  {
    path: "/apt",
    component: () => import("@/views/Apt.vue"),
  },
  {
    path: "/aboutus",
    component: () => import("@/views/AboutUs.vue"),
  },
  {
    path: "/qna",
    component: () => import("@/views/Qna.vue"),
    children: [
      {
        path: "",
        component: () => import("@/components/board/qna/QnaList.vue"),
      },
      {
        path: "create",
        component: () => import("@/components/board/qna/QnaCreate.vue"),
      },
      {
        path: "detail/:no",
        component: () => import("@/components/board/qna/QnaDetail.vue"),
      },
      {
        path: "modify/:no",
        component: () => import("@/components/board/qna/QnaModify.vue"),
      },
    ],
  },
  {
    path: "/notice",
    component: () => import("@/views/Notice.vue"),
    children: [
      {
        path: "/",
        component: () => import("@/components/board/notice/NoticeList.vue"),
      },
      {
        path: "detail/:no",
        component: () => import("@/components/board/notice/NoticeDetail.vue"),
      },
      {
        path: "create",
        component: () => import("@/components/board/notice/NoticeCreate.vue"),
      },
    ],
  },

  {
    path: "/mypage",
    component: () => import("@/views/MyPage.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
