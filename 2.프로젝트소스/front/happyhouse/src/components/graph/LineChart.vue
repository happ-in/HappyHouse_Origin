<script>
//Importing Line class from the vue-chartjs wrapper
import { Line } from "vue-chartjs";
import { mapState } from "vuex";

//Exporting this so it can be used in other components
export default {
  extends: Line,
  computed: {
    ...mapState(["coronaDong", "corona"]),
  },
  created() {},
  watch: {
    coronaDong: function () {
      if (!this.dongs.includes(this.coronaDong)) {
        var colors = [
          "rgba(255,100,100,0.3)",
          "rgba(0,255,100,0.3)",
          "rgba(13,100,255,0.3)",
          "rgba(255,18,255,0.3)",
          "rgba(35,177,255,0.3)",
          "rgba(235, 15, 22, 0.3)",
          "rgba(243, 124, 73, 0.3)",
          "rgba(111, 129, 246, 0.3)",
        ];

        var tmp = {
          label: this.coronaDong.gu,
          backgroundColor: colors[Math.floor(Math.random() * colors.length)],
          borderWidth: 1,
          //Data to be represented on y-axis
          data: [],
        };

        this.dongs.push(this.coronaDong);

        this.corona.TbCorona19CountStatusJCG.row.forEach((element) => {
          tmp.data.push(element[this.coronaDong.id]);
        });
        tmp.data = tmp.data.reverse();
        this.datacollection.datasets.push(tmp);
        this.renderChart(this.datacollection, this.options);
      }
    },
  },

  data() {
    return {
      num: 0,
      dongs: [],
      datacollection: {
        //Data to be represented on x-axis
        labels: ["1", "2", "3", "4", "5", "6", "7"],
        datasets: [],
      },
      //Chart.js options that controls the appearance of the chart
      options: {
        scales: {
          yAxes: [
            {
              ticks: {},
              gridLines: {
                display: true,
              },
            },
          ],
          xAxes: [
            {
              gridLines: {
                display: false,
              },
            },
          ],
        },
        legend: {
          display: true,
        },
        responsive: true,
        maintainAspectRatio: false,
      },
    };
  },
  mounted() {
    //renderChart function renders the chart with the datacollection and options object.
    this.renderChart(this.datacollection, this.options);
  },
};
</script>
