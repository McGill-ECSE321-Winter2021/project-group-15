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


function TechnicianDto(technicianRole, email, username, password,
			firstName, lastName){

		this.technicianRole = technicianRole;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
}
export default {
	name: 'Technicians',
created: function () {
   //Test Data
   const t1 = new TechnicianDto('Inspector','john.smith@email.com','Smith','Idkd', 'John', 'Smith')
   const t2 = new TechnicianDto('Diagnostic','brandon.miller@email.com','Smith','kjnss', 'Brandon', 'Miller')

   //Sample initial content
   this.technicians = [t1,t2]
},
 data () {
      return {
        technicians: [],
	 newTechnician: {
		technicianRole:'',
        		email: '',
		username: '',
		password: '',
		firstName: '',
		lastName: ''
   
      	}
}
}
}
