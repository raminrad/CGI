var map = L.map('map').setView([41.7, -82.6], 8);

L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}', {
  attribution: '&copy; <a href="http://openstreetmap.org">OSM</a>, <a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="http://mapbox.com">MB</a>',
  maxZoom: 18,
  id: 'gisdev001.nlf17c69',
  accessToken: 'pk.eyJ1IjoiZ2lzZGV2MDAxIiwiYSI6ImNpZmoyb2UwMzNscDlpdWx4d2ZoOG45ejIifQ.NQTlzgyyNcLfxZYrY-IU7w'
}).addTo(map);


var datacenterIcon = L.icon({
  iconUrl: 'img/data-center-px-png.png',
  iconSize: [32, 37],
  iconAnchor: [16, 37],
  popupAnchor: [0, -28]
});


function onEachFeature(feature, layer) {
  var popupContent = "<p>Popup " +
    feature.geometry.type + ", with feature geom type!</p>";

  if (feature.properties && feature.properties.popupContent) {
    popupContent += feature.properties.popupContent;
  }

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
      icon: datacenterIcon
    });
  }
}).addTo(map);


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