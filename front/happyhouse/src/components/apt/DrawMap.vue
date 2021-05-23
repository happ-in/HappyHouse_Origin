<template>
  <div id="app">
    <div id="map" style="height: 1000px"></div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  name: "DrawMap",
  computed: {
    ...mapState(["aptDealList", "dong"]),
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      setTimeout(this.initMap, 500);
      //this.initMap();
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
  watch: {
    aptDealList: function () {},
  },
  methods: {
    ...mapActions(["getAptDealList"]),
    initMap() {
      var cam_pos;

      if (this.aptDealList.data.length > 0) {
        cam_pos = new kakao.maps.LatLng(this.aptDealList.data[0].lat, this.aptDealList.data[0].lng);
      } else {
        cam_pos = new kakao.maps.LatLng(37.5642135, 127.0016985);
      }

      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: cam_pos, // 지도의 중심좌표
          level: 5, // 지도의 확대 레벨
        };

      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

      // 마커 이미지의 이미지 주소입니다
      var imageSrc =
        "https://lh3.googleusercontent.com/proxy/9ASMfOTymihvo6CAsk4I87jgejkaiemo_WdgaoWh7BPRsM-3SuseWVvup59DcsPAfOp1yDNBkyyJzE7SZGbNGK968GaTtuLMVCWwaR30FmdbW8xzt6ibKSQrjc_f55vC7edZdTlDRzTo0hEUaz8TscANedAdBgRfgni08L4v-fnCQgRLKrKQk_N9cC1KQ8vagDsYdZid319CMBWJv4wvjnedeya6-3Fd_vfHdhZTBAMpDyDjTnhkw8L1-72X34rlHRfe6i6ySZi_KTrP20OHZv4wNjrjNw8peB07JYUIj_HPMMWDrH0ni4WXEUqppcNwihuZK31fAA-gMN2dEeTKBq0vVQ";

      for (let i = 0; i < this.aptDealList.data.length; i++) {
        // 마커 이미지의 이미지 크기 입니다
        var imageSize = new kakao.maps.Size(24, 35);
        // 마커 이미지를 생성합니다
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        var pos = new kakao.maps.LatLng(this.aptDealList.data[i].lat, this.aptDealList.data[i].lng);
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: pos, // 마커를 표시할 위치
          title: "gi", // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage, // 마커 이미지
        });
      }
      for (let i = 0; i < this.aptDealList.data.length; i++) {
        // 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        var movePos = new kakao.maps.LatLng(
          this.aptDealList.data[i].lat,
          this.aptDealList.data[i].lng
        );

        var content =
          '<div class="customoverlay" @click = "panTo(map,movePos)">' +
          "  <div>" +
          '    <span class="title" >' +
          this.aptDealList.data[i].aptName +
          "</span>" +
          "  </div>" +
          "</div>";

        // 커스텀 오버레이가 표시될 위치입니다
        var position = new kakao.maps.LatLng(
          this.aptDealList.data[i].lat,
          this.aptDealList.data[i].lng
        );

        // 커스텀 오버레이를 생성합니다
        var customOverlay = new kakao.maps.CustomOverlay({
          map: map,
          position: position,
          content: content,
          yAnchor: 1,
        });
      }
      console.log(marker + customOverlay + movePos);
    },
    panTo(map, movePos) {
      console.log(movePos);
      // 이동할 위도 경도 위치를 생성합니다

      // 지도 중심을 부드럽게 이동시킵니다
      // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
      map.panTo(movePos);
    },
  },
};
</script>

<style>
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

.customoverlay {
  position: relative;
  bottom: 55px;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  float: left;
}
.customoverlay:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.customoverlay div {
  display: block;
  text-decoration: none;
  color: #000;
  text-align: center;
  border-radius: 6px;
  font-size: 14px;
  font-weight: bold;
  overflow: hidden;
  background: #d95050;
  background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.customoverlay .title {
  display: block;
  text-align: center;
  background: #fff;
  margin-right: 35px;
  padding: 10px 15px;
  font-size: 14px;
  font-weight: bold;
}
.customoverlay:after {
  content: "";
  position: absolute;
  margin-left: -12px;
  left: 50%;
  bottom: -12px;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
</style>
