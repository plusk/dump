let map;
let streetInput;
let cityInput;
let zipInput;
let countryInput;

function initMap(position) {
  map = new L.Map("mapContainer");

  // Create tile layer with correct attribution
  const osmUrl = "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png";
  const osmAttrib =
    'Map data © <a href="https://openstreetmap.org">OpenStreetMap</a> contributors';
  const osm = new L.TileLayer(osmUrl, {
    minZoom: 8,
    maxZoom: 18,
    attribution: osmAttrib
  });

  // Center map on current position
  map.setView(
    new L.LatLng(position.coords.latitude, position.coords.longitude),
    16
  );
  map.addLayer(osm);

  // Update form values
  updateForm({ lat: position.coords.latitude, lng: position.coords.longitude });
}

function updateForm(coords) {
  var geocodeService = L.esri.Geocoding.geocodeService();

  geocodeService
    .reverse()
    .latlng(coords)
    .run(function(error, result) {
      console.log(result.address);
      streetInput.value = result.address.Address;
      cityInput.value = result.address.City;
      zipInput.value = result.address.Postal;
      countryInput.value = result.address.CountryCode;
    });
}

function getLocation() {
  const x = document.querySelector("#mapContainer");
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(initMap);
  } else {
    x.innerHTML = "Geolocation is not supported by this browser.";
  }
}

function updateMap() {
  var geocode = L.esri.Geocoding.geocode();

  const searchString = `${streetInput.value}, ${cityInput.value}, ${
    zipInput.value
  }, ${countryInput.value}`;

  // Silly goose tried to search for nothing
  if (searchString === ", , , ") {
    const errorField = document.querySelector("#mapFormError");
    errorField.textContent = "You can't just search for nothing!";
    return false;
  } else {
    clearError();
  }
  geocode.text(searchString).run(function(error, results) {
    const reslat = results.results[0].latlng.lat;
    const reslng = results.results[0].latlng.lng;
    map.setView([reslat, reslng], 15);
  });
  return false;
}

function clearError() {
  document.querySelector("#mapFormError").textContent = "";
}

document.addEventListener("DOMContentLoaded", function() {
  const mapForm = document.querySelector("#mapForm");
  mapForm.onsubmit = updateMap;
  mapForm.onreset = clearError;

  streetInput = document.querySelector("#street");
  cityInput = document.querySelector("#city");
  zipInput = document.querySelector("#zip");
  countryInput = document.querySelector("#country");

  getLocation();
});
