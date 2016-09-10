ymaps.ready(init);
function init() {
    if(navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;

        });

    var myMap = new ymaps.Map('map', {
        center: [],
        zoom: 12,
        controls: ['zoomControl']
    })

   
}}