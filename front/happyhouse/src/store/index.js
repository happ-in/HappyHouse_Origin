import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import createPersistedState from "vuex-persistedstate";
import { VTooltip, VPopover, VClosePopover } from "v-tooltip";

Vue.use(Vuex);
Vue.directive("tooltip", VTooltip);
Vue.directive("close-popover", VClosePopover);
Vue.component("v-popover", VPopover);

export default new Vuex.Store({
  plugins: [createPersistedState()],
  modules: {},
  state: {
    gu: Object, // 현재 선택된 구
    dong: Object, // 현재 선택된 동
    apt: Object, // 현재 선택된 아파트의 list num
    searchKeyword: Object, // 검색하려는 키워드
    coronaDong: Object, // 선택된 코로나 동

    range: [],
    dongs: [], // 구에 해당하는 동 목록
    aptDealList: [], // 동에 해당하는 거래 목록

    corona: [], // 코로나 정보
  },
  mutations: {
    SELECT_CORONA_DONG(state, data) {
      state.coronaDong = data;
    },
    GET_DONG_CORONA(state, data) {
      // console.log(data);
      state.corona = data;
    },
    GET_PRICE_RANGE(state, range) {
      state.range = range;
    },
    GET_KEYWORD(state, key) {
      state.searchKeyword = key;
    },
    SELECT_APT(state, apt) {
      state.apt = apt;
    },
    GET_APT_DEAL_LIST(state, list) {
      state.aptDealList = list;
    },
    GET_DONG_LIST(state, dongs) {
      state.dongs = dongs;
    },
    SELECT_GU(state, gu) {
      state.gu = gu;
    },
    SELECT_DONG(state, dong) {
      state.dong = dong;
    },
  },
  actions: {
    selectCoronaDong({ commit }, dong) {
      commit("SELECT_CORONA_DONG", dong);
    },
    getDongCorona({ commit }) {
      axios
        .get(`http://openapi.seoul.go.kr:8088/6a7471596670686238366148614672/json/TbCorona19CountStatusJCG/1/7/`)
        .then(({ data }) => {
          commit("GET_DONG_CORONA", data);
        });
    },

    getPriceRange({ commit }, range) {
      const SERVICE_URL = "http://localhost:8888/happyhouse/apt/price";

      var a = range[0] * 10000;
      var b = range[1] * 10000;
      console.log(range[2]);

      const params = {
        dong: range[2],
        min: a,
        max: b,
      };

      axios
        .get(SERVICE_URL, {
          params,
        })
        .then((response) => {
          console.log(response);
          commit("GET_APT_DEAL_LIST", response);
        })
        .catch((error) => {
          console.dir(error);
        });
      commit("GET_PRICE_RANGE", range);
    },
    getKeyword({ commit }, key) {
      commit("GET_KEYWORD", key);
    },

    selectApt({ commit }, apt) {
      commit("SELECT_APT", apt);
    },
    getAptDealList({ commit }, dong) {
      const SERVICE_URL = "http://localhost:8888/happyhouse/apt";

      const params = {
        dong: dong,
      };

      axios
        .get(SERVICE_URL, {
          params,
        })
        .then((response) => {
          commit("GET_APT_DEAL_LIST", response);
        })
        .catch((error) => {
          console.dir(error);
        });
    },

    selectDong({ commit }, dong) {
      commit("SELECT_DONG", dong);
    },

    selectGu({ commit }, gu) {
      commit("SELECT_GU", gu);
    },
    getDongList({ commit }, gu) {
      var gudong = [
        {
          gu: "종로구",
          dongs: [
            "청운효자동",
            "사직동",
            "삼청동",
            "부암동",
            "평창동",
            "무악동",
            "교남동",
            "가희동",
            "종로1가",
            "종로2가",
            "종로3가",
          ],
        },
        {
          gu: "중구",
          dongs: [
            "소공동",
            "회현동",
            "명동",
            "필동",
            "장충동",
            "광희동",
            "을지로동",
            "신당동",
            "다산동",
            "약수동",
            "청구동",
            "신당5동",
            "동화동",
            "황학동",
            "중림동",
          ],
        },
        {
          gu: "용산구",
          dongs: [
            "후암동",
            "용산2가동",
            "남영동",
            "청파동",
            "원효로1동",
            "원효로2동",
            "효창동",
            "용문동",
            "한강로동",
            "이촌1동",
            "이촌2동",
            "이태원1동",
            "이태원2동",
            "한남동",
            "서빙고동",
            "보광동",
          ],
        },
        {
          gu: "성동구",
          dongs: [
            "왕십리도선동",
            "왕십리2동",
            "마장동",
            "사근동",
            "행당1동",
            "행당2동",
            "응봉동",
            "금호1가동",
            "금호2·3가동",
            "금호4가동",
            "옥수동",
            "성수1가1동",
            "성수1가2동",
            "성수2가1동",
            "성수2가3동",
            "송정동",
            "용답동",
          ],
        },
        {
          gu: "광진구",
          dongs: [
            "중곡1동",
            "중곡2동",
            "중곡3동",
            "중곡4동",
            "능동",
            "구의1동",
            "구의2동",
            "구의3동",
            "광장동",
            "자양1동",
            "자양2동",
            "자양3동",
            "자양4동",
            "화양동",
            "군자동",
          ],
        },
        {
          gu: "동대문구",
          dongs: [
            "용신동",
            "제기동",
            "전농1동",
            "전농2동",
            "답십리1동",
            "답십리2동",
            "장안1동",
            "장안2동",
            "청량리동",
            "회기동",
            "휘경1동",
            "휘경2동",
            "이문1동",
            "이문2동",
          ],
        },
        {
          gu: "중랑구",
          dongs: [
            "면목본동",
            "면목2동",
            "면목3·8동",
            "면목4동",
            "면목5동",
            "면목7동",
            "상봉1동",
            "상봉2동",
            "중화1동",
            "중화2동",
            "묵1동",
            "묵2동",
            "망우본동",
            "망우3동",
            "신내1동",
            "신내2동",
          ],
        },
        {
          gu: "성북구",
          dongs: [
            "성북동",
            "삼선동",
            "동선동",
            "돈암1동",
            "돈암2동",
            "안암동",
            "보문동",
            "정릉1동",
            "정릉2동",
            "정릉3동",
            "정릉4동",
            "길음1동",
            "길음2동",
            "종암동",
            "월곡1동",
            "월곡2동",
            "장위1동",
            "장위2동",
            "장위3동",
            "석관동",
          ],
        },
        {
          gu: "강북구",
          dongs: [
            "삼양동",
            "미아동",
            "송중동",
            "송천동",
            "삼각산동",
            "번1동",
            "번2동",
            "번3동",
            "수유1동",
            "수유2동",
            "수유3동",
            "우이동",
            "인수동",
          ],
        },
        {
          gu: "도봉구",
          dongs: [
            "쌍문1동",
            "쌍문2동",
            "쌍문3동",
            "쌍문4동",
            "방학1동",
            "방학2동",
            "방학3동",
            "창1동",
            "창2동",
            "창3동",
            "창4동",
            "창5동",
            "도봉1동",
            "도봉2동",
          ],
        },
        {
          gu: "노원구",
          dongs: [
            "월계1동",
            "월계2동",
            "월계3동",
            "공릉1동",
            "공릉2동",
            "하계1동",
            "하계2동",
            "중계본동",
            "중계1동",
            "중계2·3동",
            "중계4동",
            "상계1동",
            "상계2동",
            "상계3·4동",
            "상계5동",
            "상계6·7동",
            "상계8동",
            "상계9동",
            "상계10동",
          ],
        },
        {
          gu: "은평구",
          dongs: [
            "녹번동",
            "불광1동",
            "불광2동",
            "갈현1동",
            "갈현2동",
            "구산동",
            "대조동",
            "응암1동",
            "응암2동",
            "응암3동",
            "역촌동",
            "신사1동",
            "신사2동",
            "증산동",
            "수색동",
            "진관동",
          ],
        },
        {
          gu: "서대문구",
          dongs: [
            "충현동",
            "천연동",
            "북아현동",
            "신촌동",
            "연희동",
            "홍제1동",
            "홍제2동",
            "홍제3동",
            "홍은1동",
            "홍은2동",
            "남가좌1동",
            "남가좌2동",
            "북가좌1동",
            "북가좌2동",
          ],
        },
        {
          gu: "마포구",
          dongs: [
            "공덕동",
            "아현동",
            "도화동",
            "용강동",
            "대흥동",
            "염리동",
            "신수동",
            "서강동",
            "서교동",
            "합정동",
            "망원1동",
            "망원2동",
            "연남동",
            "성산1동",
            "성산2동",
            "상암동",
          ],
        },
        {
          gu: "양천구",
          dongs: [
            "목1동",
            "목2동",
            "목3동",
            "목4동",
            "목5동",
            "신월1동",
            "신월2동",
            "신월3동",
            "신월4동",
            "신월5동",
            "신월6동",
            "신월7동",
            "신정1동",
            "신정2동",
            "신정3동",
            "신정4동",
            "신정6동",
            "신정7동",
          ],
        },
        {
          gu: "강서구",
          dongs: [
            "염창동",
            "등촌1동",
            "등촌2동",
            "등촌3동",
            "화곡본동",
            "화곡1동",
            "화곡2동",
            "화곡3동",
            "화곡4동",
            "화곡6동",
            "화곡8동",
            "우장산동",
            "가양1동",
            "가양2동",
            "가양3동",
            "발산1동",
            "공항동",
            "방화1동",
            "방화2동",
            "방화3동",
          ],
        },
        {
          gu: "구로구",
          dongs: [
            "신도림동",
            "구로1동",
            "구로2동",
            "구로3동",
            "구로4동",
            "구로5동",
            "가리봉동",
            "수궁동",
            "고척1동",
            "고척2동",
            "개봉1동",
            "개봉2동",
            "개봉3동",
            "오류1동",
            "오류2동",
            "항동",
          ],
        },
        {
          gu: "금천구",
          dongs: [
            "가산동",
            "독산1동",
            "독산2동",
            "독산3동",
            "독산4동",
            "시흥1동",
            "시흥2동",
            "시흥3동",
            "시흥4동",
            "시흥5동",
          ],
        },
        {
          gu: "영등포구",
          dongs: [
            "영등포본동",
            "영등포동",
            "여의동",
            "당산1동",
            "당산2동",
            "도림동",
            "문래동",
            "양평1동",
            "양평2동",
            "신길1동",
            "신길3동·신길4동",
            "신길5동",
            "신길6동",
            "신길7동",
            "대림1동",
            "대림2동",
            "대림3동",
          ],
        },
        {
          gu: "동작구",
          dongs: [
            "노량진1동",
            "노량진2동",
            "상도1동",
            "상도2동",
            "상도3동",
            "상도4동",
            "흑석동",
            "사당1동",
            "사당2동",
            "사당3동",
            "사당4동",
            "사당5동",
            "대방동",
            "신대방1동",
            "신대방2동",
          ],
        },
        {
          gu: "관악구",
          dongs: [
            "보라매동",
            "은천동",
            "성현동",
            "중앙동",
            "청림동",
            "행운동",
            "청룡동",
            "낙성대동",
            "인헌동",
            "남현동",
            "신림동",
            "신사동",
            "조원동",
            "미성동",
            "난곡동",
            "난향동",
            "서원동",
            "신원동",
            "서림동",
            "삼성동",
            "대학동",
          ],
        },
        {
          gu: "서초구",
          dongs: [
            "서초1동",
            "서초2동",
            "서초3동",
            "서초4동",
            "잠원동",
            "반포본동",
            "반포1동",
            "반포2동",
            "반포3동",
            "반포4동",
            "방배본동",
            "방배1동",
            "방배2동",
            "방배3동",
            "방배4동",
            "양재1동",
            "양재2동",
            "내곡동",
          ],
        },
        {
          gu: "강남구",
          dongs: [
            "신사동",
            "압구정동",
            "청담동",
            "논현1동",
            "논현2동",
            "삼성1동",
            "삼성2동",
            "대치1동",
            "대치2동",
            "대치4동",
            "역삼1동",
            "역삼2동",
            "도곡1동",
            "도곡2동",
            "개포1동",
            "개포2동",
            "개포4동",
            "일원본동",
            "일원1동",
            "일원2동",
            "수서동",
            "세곡동",
          ],
        },
        {
          gu: "송파구",
          dongs: [
            "풍납1동",
            "풍납2동",
            "거여1동",
            "거여2동",
            "마천1동",
            "마천2동",
            "방이1동",
            "방이2동",
            "오륜동",
            "오금동",
            "송파1동",
            "송파2동",
            "석촌동",
            "삼전동",
            "가락본동",
            "가락1동",
            "가락2동",
            "문정1동",
            "문정2동",
            "장지동",
            "위례동",
            "잠실본동",
            "잠실2동",
            "잠실3동",
            "잠실4동",
            "잠실6동",
            "잠실7동",
          ],
        },
        {
          gu: "강동구",
          dongs: [
            "강일동",
            "상일동",
            "명일1동",
            "명일2동",
            "고덕1동",
            "고덕2동",
            "암사1동",
            "암사2동",
            "암사3동",
            "천호1동",
            "천호2동",
            "천호3동",
            "성내1동",
            "성내2동",
            "성내3동",
            "길동",
            "둔촌1동",
            "둔촌2동",
          ],
        },
      ];

      for (let i = 0; i < gudong.length; i++) {
        if (gudong[i].gu == gu) {
          commit("GET_DONG_LIST", gudong[i].dongs);
          break;
        }
      }
    },
  },
});
