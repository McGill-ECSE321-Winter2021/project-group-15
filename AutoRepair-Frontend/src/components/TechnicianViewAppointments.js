import axios from 'axios'
var config = require('../../config')



var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function AppointmentDto(id, ts, customer, service){
	this.id = id;
	this.ts = ts;
	this.customer = customer;
	this.service = service;
}

export default {
name: 'TechnicianAppointments',
created: function () {
   //Test Data

   const a1 = new AppointmentDto('1', 'ts1' , 'Mark' , 'Repair')
   const a2 = new AppointmentDto('2', 'ts2' , 'James', 'Diagnostic')

   //Sample initial content
	this.appointments = [a1,a2]
},
 data () {
      return {
	appointments: [],
	 newAppointment: {
		id:'',
        		ts: '',
		customer: '',
		service: ''
      	}
}
}
}

