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

   const a1 = new AppointmentDto('1', '12/04/2021 9:00-10:00' , 'Mark' , 'Repair')
   const a2 = new AppointmentDto('2', '14/04/2021 13:00-16:00' , 'James', 'Diagnostic')

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

