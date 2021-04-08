import axios from 'axios'
var config = require('../../config')

//var backendConfigurer = function(){
//  switch(process.env.NODE_ENV){
 //     case 'development':
//          return 'http://' + config.dev.backendHost + ':' + config.dev.backendPort;
 //     case 'production':
 //         return 'https://' + config.build.backendHost + ':' + config.build.backendPort ;
//  }
//};

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function ServiceDto(name, cost, duration){

		this.name = name;
		this.cost  = cost;
		this.duration = duration;
}
export default {
	name: 'Services',
created: function () {
   //Test Data
   const t1 = new ServiceDto('Wheel Replacement','150$','3')
   const t2 = new ServiceDto('Diagnostic','100$','2')
   const t3 = new ServiceDto('Standard Oil Change','29.99$','1')



   //Sample initial content
   this.services = [t1,t2,t3]
},
 data () {
      return {
        Services: [],
	 newService: {
		name:'',
        		cost: '',
		duration: ''
	
   
      	}
}
}
}
