

var map = new BMap.Map("container"); 
// 创建地图实例  

 var points = [];

$.ajax({url:"../hello/list.json",type:"GET",success:function(datas){
	
for(i in datas){
		//console.log(datas[i]);
	points[i] = {"lng":datas[i].longitude,"lat":datas[i].latitude,"count":datas[i].density};
}
       console.log(points.length);
        
     var point = new BMap.Point(points[0].lng,points[0].lat);
      
        map.centerAndZoom(point,16); 
        map.addControl(new BMap.NavigationControl());    
        map.addControl(new BMap.ScaleControl());    
        map.addControl(new BMap.OverviewMapControl());    
        map.addControl(new BMap.MapTypeControl());  
        map.enableScrollWheelZoom();

        if(!isSupportCanvas()){
        	alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
        }
        
        heatmapOverlay = new BMapLib.HeatmapOverlay({"radius":10});
    	map.addOverlay(heatmapOverlay);
    	heatmapOverlay.setDataSet({data:points,max:250});
    	
        heatmapOverlay.show();
              
}});



if(!isSupportCanvas()){
	alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
}

//判断浏览区是否支持canvas
function isSupportCanvas(){
    var elem = document.createElement('canvas');
    return !!(elem.getContext && elem.getContext('2d'));
}
//var point = new BMap.Point();  // 创建点坐标  






//var tileLayer = new BMap.TileLayer({isTransparentPng: true});
//
//tileLayer.getTilesUrl = function(tileCoord, zoom) {
//	var x = tileCoord.x*zoom;
//	var y = tileCoord.y*zoom;
//	return "http://developer.baidu.com/map/jsdemo/img/border.png";
//}

//map.addTileLayer(tileLayer);

// 初始化地图，设置中心点坐标和地图级别  