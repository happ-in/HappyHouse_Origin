<template>
  <div id="app">
    <div id="map" @click="sendKeyword"></div>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "DrawMap",

  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      // 동적 스크립트 바인딩
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=d6752363187651fd8e9c4f66a13317cd";
      document.head.appendChild(script);
    }
  },
  methods: {
    ...mapActions(["getDongList"]),
    sendKeyword(areaname) {
      this.getDongList(areaname);
    },

    initMap() {
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.566826, 126.9818567), // 지도의 중심좌표
          level: 9, // 지도의 확대 레벨
        };

      var map = new kakao.maps.Map(mapContainer, mapOption);
      console.log(map);
    },
  },
};
</script>

<style scoped>
#map {
  height: 1000px;
}
.area {
  position: absolute;
  background: #fff;
  border: 1px solid #888;
  border-radius: 3px;
  font-size: 12px;
  top: -5px;
  left: 15px;
  padding: 2px;
}

.info {
  font-size: 12px;
  padding: 5px;
}
.info .title {
  font-weight: bold;
}
</style>
