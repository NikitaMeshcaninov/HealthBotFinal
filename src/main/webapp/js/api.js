ymaps.ready(init);
function init() {
    var myMap = new ymaps.Map('map', {
        center: [49.992167, 36.231202],
        zoom: 12,
        controls: ['zoomControl']
    })
}