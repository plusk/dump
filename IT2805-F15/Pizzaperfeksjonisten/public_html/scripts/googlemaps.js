//Laster inn google maps plugin
document.addEventListener("DOMContentLoaded", whenLoaded);
function whenLoaded() {
    function initMap() {
        var location = {lat: 63.430515, lng: 10.395053};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 14,
            center: location
        });
        // Viser innhold når markør blir klikket på
        var contentString = '<div id="content">'+
            '<div id="siteNotice">'+
            '</div>'+
            '<div id="bodyContent">'+
            '<p><b>Pizzaperfeksjonisten</b> <br> Togveien 27F, 7048 Trondheim </p> ' + 
            '</div>'+
            '</div>';
        var infowindow = new google.maps.InfoWindow({
            content: contentString
        });
        //Setter markør
        var marker = new google.maps.Marker({
            position: location,
            map: map,
            title: 'Pizzaperfeksjonisten'
        });

        marker.addListener('click', function() {
            infowindow.open(map, marker);
        });
    }
    google.maps.event.addDomListener(window, 'load', initMap);
}