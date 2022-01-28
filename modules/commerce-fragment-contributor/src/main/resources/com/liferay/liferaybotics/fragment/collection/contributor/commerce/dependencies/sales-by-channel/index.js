var div = fragmentElement.querySelector("div");
var chart = bb.generate({
	bindto: div,
	data: {
		x: "x",
		columns: JSON.parse(configuration.data)
	},
  axis: {
		x: {
      type: "timeseries",
      tick: {
        format: "%b"
      }
    }
  },
  grid: {
    x: {
      show: true
    },
    y: {
      show: true
    }
  },
	regions: [
    {
      axis: "x",
      start: "2020-09-1",
      class: "regionX"
    }
	]
});


chart.data.colors({
	"Channel 1" : "#FFB68D",
	"Channel 2" : "#B0DEFF",
	"Channel 3" : "#AD93EF",
	"Channel 4" : "#4BC286",
	"Channel 5" : "#F5B3EF"
});