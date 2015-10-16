var chart; // global
$(function() {
  // a map on the left, and a panel on the right/left that lists the
  // information about the currently selected monitor (mix of fixed and streaming).
  // On the map itself maybe some visual cue that an anomaly has been detected
  // wind direction and speed at each buoy location


  // open WS connection
  var connection = new WebSocket('ws://127.0.0.1:1337');



  window.WebSocket = window.WebSocket || window.MozWebSocket;
  if (!window.WebSocket) {
    console.log("That no good. No websockets here.");
  }

  //StationID: [Station Name, Long, Lat, Number of Anomalies getting updated Realtime]
  var stationLatLongs_dict = {
    45165: ["Toledo Water Intake", -83.26145, 41.7020333, 0],
    45164: ["Cleveland DO Buoy", -81.69372, 41.73213, 0],
    45169: ["Cleveland Wind Buoy", -81.79164, 41.58990, 0]
  };

  var stationStaticMarkers = {};
  var map = L.map('map').setView([41.7, -82.6], 8);

  L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
    attribution: '&copy; <a href="http://openstreetmap.org">OSM</a>, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">MB</a>',
    maxZoom: 18,
    id: 'gisdev001.nlf17c69',
    accessToken: 'pk.eyJ1IjoiZ2lzZGV2MDAxIiwiYSI6ImNpZmoyb2UwMzNscDlpdWx4d2ZoOG45ejIifQ.NQTlzgyyNcLfxZYrY-IU7w'
  }).addTo(map);

  var popup = L.popup();


  function GetAndShowStaticStationLocs() {
    for (var stationID in stationLatLongs_dict) {
      if (stationLatLongs_dict.hasOwnProperty(stationID)) {
        var stationObj = stationLatLongs_dict[stationID];
        var stationName = stationObj[0];
        stationStaticMarkers[stationID] = L.circleMarker([stationObj[2], stationObj[1]], {
          markerStationID: stationID,
          radius: 10,
          fillColor: "white",
          color: "white",
          weight: 1,
          opacity: 1,
          fillOpacity: 0.6
          //}).addTo(map);
        }).bindLabel(stationName, {
          direction: 'left',
          noHide: '',
          className: 'map-label'
        }).addTo(map).on('click', onStationClick);
        stationStaticMarkers[stationID].bindPopup("<b>Station Name: " + stationName + "</b><br>Total Anomaly Alerts: " + stationLatLongs_dict[stationID][3]); //.openPopup();
      }
    }
  }

  GetAndShowStaticStationLocs();

  function onStationClick(e) {
    var clickedStationID = e.target.options.markerStationID;
    console.log('Clicked ' + clickedStationID);
    switch (Number(clickedStationID)) {
      case 45165:
        chart.series[0].show();
        chart.series[1].hide();
        chart.series[2].hide();
        break;
      case 45164:
        chart.series[1].show();
        chart.series[0].hide();
        chart.series[2].hide();
        break;
      case 45169:
        chart.series[2].show();
        chart.series[0].hide();
        chart.series[1].hide();
        break;
    }
  }

  function DisplayNewPosition(lat, lng, stationName, windSpd, windDirDeg) {
    //rgba(67,67,72,0.25) //'#434348'
    //rgba(144,237,125,0.25)
    //rgba(124,181,236,0.25)

    if (typeof circle !== 'undefined') {
      map.removeLayer(circle);
      circle = L.circleMarker([lat, lng], {
        radius: 1,
        fillColor: 'black',
        color: 'black',
        weight: 1,
        opacity: 1,
        fillOpacity: 0.5
      }).addTo(map);
    } else {
      circle = L.circleMarker([lat, lng], {
        radius: 1,
        fillColor: 'black',
        color: 'black',
        weight: 1,
        opacity: 1,
        fillOpacity: 0.5
      }).addTo(map);
    }
  }

  function ChangeDotSizeOfStation(stationident) {
    switch (stationident) {
      case 45165:
        if (stationStaticMarkers[stationident].getRadius() < 30) {
          stationStaticMarkers[stationident].setRadius(stationStaticMarkers[stationident].getRadius() * 1.1);
        }
        stationStaticMarkers[stationident].setStyle({
          color: getColor(stationLatLongs_dict[stationident][3]),
          fillColor: getColor(stationLatLongs_dict[stationident][3])
        });
        break;
      case 45164:
        if (stationStaticMarkers[stationident].getRadius() < 30) {
          stationStaticMarkers[stationident].setRadius(stationStaticMarkers[stationident].getRadius() * 1.1);
        }
        stationStaticMarkers[stationident].setStyle({
          color: getColor(stationLatLongs_dict[stationident][3]),
          fillColor: getColor(stationLatLongs_dict[stationident][3])
        });
        break;
      case 45169:
        if (stationStaticMarkers[stationident].getRadius() < 30) {
          stationStaticMarkers[stationident].setRadius(stationStaticMarkers[stationident].getRadius() * 1.1);
        }
        stationStaticMarkers[stationident].setStyle({
          color: getColor(stationLatLongs_dict[stationident][3]),
          fillColor: getColor(stationLatLongs_dict[stationident][3])
        });
        break;
    }
    stationStaticMarkers[stationident].hideLabel();

  }




  connection.onopen = function() {
    connection.send("Solid copy from client to server");
  };

  connection.onerror = function(error) {
    console.log('Error or WS connection or the server is down.');
  };

  //each message received over the websocket to the client
  connection.onmessage = function(message) {
    var reading = JSON.parse(message.data);
    var stationID = reading.station;
    var isAnom = reading.isAnomaly;
    var windSpd = reading.windSpeed;
    var windDirDeg = reading.windDirection;
    var stationName = stationLatLongs_dict[stationID][0];
    var lat = stationLatLongs_dict[stationID][2];
    var lon = stationLatLongs_dict[stationID][1];
    //console.log(stationName + " at Lat: " + lat + ", Lon: " + lon);

    DisplayNewPosition(lat, lon, stationName, windSpd, windDirDeg);

    if (isAnom === true) {
      ProcessIncomingAnomaly(stationID, stationName);
    }

    UpdateChart(reading);
  };


  function ProcessIncomingAnomaly(anomalyStationID, anomalyStationName) {
    //add anom reading to the global counter
    stationLatLongs_dict[anomalyStationID][3]++;

    //Update map popup dynamically with new total number
    stationStaticMarkers[anomalyStationID].showLabel();
    stationStaticMarkers[anomalyStationID].bindPopup("<b>Station Name: " + anomalyStationName + "</b><br>Total Anomaly Alerts: " + stationLatLongs_dict[anomalyStationID][3]); //.openPopup();

    ChangeDotSizeOfStation(anomalyStationID);
  }




  var legend = L.control({
    position: 'bottomright'
  });

  legend.onAdd = function(map) {
    var div = L.DomUtil.create('div', 'legend');
    categories = ['0', '1-2', '3-5', '6-7', '8-15', '16-20', '21-25', '>25'];
    colors = ['#E6E6E6', '#FED976', '#FEB24C', '#FD8D3C', '#FC4E2A', '#E31A1C', '#BD0026', '#800026'];
    div.innerHTML = 'Alert Count' + '<br>';
    for (var i = 0; i < categories.length; i++) {
      div.innerHTML +=
        '<i class="circle" style="background:' + colors[i] + '"></i> ' +
        (categories[i] ? categories[i] + '<br>' : '+');
    }

    return div;
  };

  legend.addTo(map);

  function getColor(d) {
    return d > 25 ? '#800026' :
      d > 20 ? '#BD0026' :
      d > 15 ? '#E31A1C' :
      d > 7 ? '#FC4E2A' :
      d > 5 ? '#FD8D3C' :
      d > 2 ? '#FEB24C' :
      d > 0 ? '#FED976' :
      '#E6E6E6';
  }


  function UpdateChart(incomingMsg) {
    var stationID = incomingMsg.station;
    var isAnom = incomingMsg.isAnomaly;
    //console.log(stationID);
    var series;
    switch (stationID) {
      case 45165:
        series = chart.series[0];
        break;
      case 45164:
        series = chart.series[1];
        break;
      case 45169:
        series = chart.series[2];
        break;
    }

    // shift chart if series is getting big
    var shift = series.data.length > 20;

    //console.log(incomingMsg.waterTemperature);
    //console.log(incomingMsg.sampleDate);
    //2015-10-07T12:33:19.406-04:00

    //moment( '08/Jun/2015:15:03:29', 'YYYY-MM-DDH:mm:ss Z').format("YYYY-MM-DD HH:mm:ss")

    //var xVal = new Date().getTime();
    var xVal = Date.parse(incomingMsg.sampleDate);

    var yVal = Number(incomingMsg.waterTemperature);
    //console.log([xVal, yVal]);
    //console.log(series);
    var addPt;
    //Add Point to spline chart, special symbol for Anomalies
    if (isAnom !== true) {
      addPt = {
        y: yVal,
        x: xVal
      };
    } else {
      addPt = {
        y: yVal,
        x: xVal,
        marker: {
          symbol: 'circle',
          fillColor: "red",
          lineColor: "red",
          radius: 4
        }
      };
    }
    series.addPoint(addPt, true, shift);
  }


  $(document).ready(function() {
    var seriesOptions = [],
      seriesCounter = 0,
      names = ['Toledo Intake', 'Cleveland DO Buoy', 'Cleveland Wind Buoy'];

    createChart = function() {
      chart = new Highcharts.Chart({
        chart: {
          renderTo: 'container',
          defaultSeriesType: 'spline',
          events: {}
        },
        title: {
          text: 'Buoy Water Temperature'
        },
        xAxis: {
          type: 'datetime',
          title: {
            text: 'Time of Day (Local Time)'
          }
        },
        yAxis: {
          title: {
            text: 'Water Temp. (C)'
          }
        },
        tooltip: {
          valueDecimals: 2
        },
        series: seriesOptions
      });
    };

    //3 series of data, 1 for each buoy

    $.each(names, function(i, name) {
      seriesOptions[i] = {
        name: name,
        data: []
      };
      seriesCounter += 1;

      if (seriesCounter === names.length) {
        seriesOptions = seriesOptions;
        createChart();
      }
    });
  });


});