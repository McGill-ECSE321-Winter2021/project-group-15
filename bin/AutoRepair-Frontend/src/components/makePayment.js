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


export default {
name: 'viewAppointments',
created: function () {
   //Test Data

   const a1 = new AppointmentDto('1', 'ts1' , 'John' , 'Repair')
   const a2 = new AppointmentDto('2', 'ts2' , 'William', 'Diagnostic')

   //Sample initial content
	this.appointments = [a1,a2]
},
 data () {
      return {
	appointments: [],
	 newAppointment: {
		id:'',
        		ts: '',
		technician: '',
		service: ''
      	}
}
}
}

