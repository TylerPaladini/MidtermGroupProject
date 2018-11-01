<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript">

var geocoder = new google.maps.Geocoder();
var address = "new york";

geocoder.geocode( { 'address': address}, function(results, status) {

if (status == google.maps.GeocoderStatus.OK) {
    var latitude = results[0].geometry.location.latitude;
    var longitude = results[0].geometry.location.longitude;
    alert(latitude);
    } 
}); 

function myMap() {
	var mapProp = {
		center : new google.maps.LatLng(latitude, longitude),
		zoom : 13,
	};
	var map = new google.maps.Map(document.getElementById("googleMap"),
			mapProp);
}
</script>
