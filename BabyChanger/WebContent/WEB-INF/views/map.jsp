<div id="googleMap" style="width: 300px; height: 300px;"></div>

<script>

	/* import ${location.address.street }${location.address.street2 }
	${location.address.city } ${location.address.state }
	${location.address.zipCode } from './detailedResults.jsp'; */
	
	function myMap() {
		var mapProp = {
			center : new google.maps.LatLng(39.608852, -104.902814),
			zoom : 13,
		};
		var map = new google.maps.Map(document.getElementById("googleMap"),
				mapProp);
	}
	
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDuasZ77g0MHSWUPiLZdB_ckxl69Fa_iis&callback=myMap"></script>

<!-- if allow to see your location, will  -->
<!-- 	<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
    
    <div id="map"></div>
    <script>
      // Note: This example requires that you consent to location sharing when
      // prompted by your browser. If you see the error "The Geolocation service
      // failed.", it means you probably did not give permission for the browser to
      // locate you.
      var map, infoWindow;
      function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -34.397, lng: 150.644},
          zoom: 6
        });
        infoWindow = new google.maps.InfoWindow;

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(function(position) {
            var pos = {
              lat: position.coords.latitude,
              lng: position.coords.longitude
            };

            infoWindow.setPosition(pos);
            infoWindow.setContent('Location found.');
            infoWindow.open(map);
            map.setCenter(pos);
          }, function() {
            handleLocationError(true, infoWindow, map.getCenter());
          });
        } else {
          // Browser doesn't support Geolocation
          handleLocationError(false, infoWindow, map.getCenter());
        }
      }

      function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                              'Error: The Geolocation service failed.' :
                              'Error: Your browser doesn\'t support geolocation.');
        infoWindow.open(map);
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDuasZ77g0MHSWUPiLZdB_ckxl69Fa_iis&callback=initMap">
    </script> -->