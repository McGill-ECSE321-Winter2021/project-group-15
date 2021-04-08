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


function AppointmentDto(id, ts, technician, service){
	this.id = id;
	this.ts = ts;
	this.technician = technician;
	this.service = service;
}

export default {
name: 'viewAppointments',
created: function () {
   //Test Data

   const a1 = new AppointmentDto('1', '12/04/2021 9:00-10:00' , 'John' , 'Repair')
   const a2 = new AppointmentDto('2', '14/04/2021 13:00-16:00' , 'Brandon', 'Diagnostic')

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

