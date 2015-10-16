$(function() {
  var map = L.map('map').setView([35, -96.6], 3);

  L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
    attribution: '&copy; <a href="http://openstreetmap.org">OSM</a>, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">MB</a>',
    maxZoom: 18,
    id: 'gisdev001.nlf17c69',
    accessToken: 'pk.eyJ1IjoiZ2lzZGV2MDAxIiwiYSI6ImNpZmoyb2UwMzNscDlpdWx4d2ZoOG45ejIifQ.NQTlzgyyNcLfxZYrY-IU7w'
  }).addTo(map);


  var smalldatacenterIcon = L.icon({
    iconUrl: 'img/data-center-px-png.png',
    iconSize: [20, 25],
    iconAnchor: [16, 37],
    popupAnchor: [0, -28]
  });

  var mediumdatacenterIcon = L.icon({
    iconUrl: 'img/data-center-px-png.png',
    iconSize: [25, 30],
    iconAnchor: [16, 37],
    popupAnchor: [0, -28]
  });

  var largedatacenterIcon = L.icon({
    iconUrl: 'img/data-center-px-png.png',
    iconSize: [30, 37],
    iconAnchor: [16, 37],
    popupAnchor: [0, -28]
  });


  function onEachFeature(feature, layer) {
    var props = feature.properties;
    //dirty string concatentation because HACKATHON MAN GO GO GO!
    var popupContent = "<b>" + props.City + ", " + props.State + "</b></br>";
    popupContent += "<b>Data Center ID: </b> " + props.Data_Center_ID + "</br>";
    popupContent += "<b>Total Virtual OS:</b> " + props.Total_Virtual_OS + "</br>";
    popupContent += "<b>Total Windows Servers:</b> " + props.Total_Windows_Servers + "</br>";
    popupContent += "<b>Total Linux Servers:</b> " + props.Total_Linux_Servers + "</br>";
    popupContent += "<b>Rack Count:</b> " + props.Rack_Count + "</br>";
    popupContent += "<b>Core Classification:</b> " + props.Core_Classification + "</br>";
    popupContent += "<b>Gross Floor Area:</b> " + props.Gross_Floor_Area + "</br>";

    layer.bindPopup(popupContent);
  }


  //data center layer from geojson
  L.geoJson(geojsonDataCenters, {

    style: function(feature) {
      return feature.properties && feature.properties.style;
    },

    onEachFeature: onEachFeature,

    pointToLayer: function(feature, latlng) {
      return L.marker(latlng, {
        icon: getIcon(feature.properties.Gross_Floor_Area)
      });
    }
  }).addTo(map);

  function getIcon(featureGrossFloorArea) {
    //Natural breaks, haha yeah right, just looked at the numbers real quick HACKATHON!
    return featureGrossFloorArea > 2000 ? largedatacenterIcon :
      featureGrossFloorArea > 100 ? mediumdatacenterIcon :
      featureGrossFloorArea > 0 ? smalldatacenterIcon :
      smalldatacenterIcon;
  }


  /*
    return L.circleMarker(latlng, {
      radius: 8,
      fillColor: "#ff7800",
      color: "#000",
      weight: 1,
      opacity: 1,
      fillOpacity: 0.8
    });
    */

});