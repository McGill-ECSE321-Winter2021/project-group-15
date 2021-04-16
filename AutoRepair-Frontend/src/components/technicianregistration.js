import axios from 'axios'

var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function TechnicianDto(email, username, password, lastName, firstName, technicianRole)
{
    
    this.email = email;
    this.username = username;
    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.technicianRole = technicianRole;
}

export default {
    name: 'technicianregistration',
    data () {
      return {
        technicians: [],
        newTechnician: {
            email: '',
            username: '',
            password: '',
            lastName: '',
            firstName: '',
            technicianRole: '',
        },
        errorTechician: '',
      }
    },
    
createTechnician: async function (email, username, password, lastName, firstName, technicianRole){
    const axiosOptions = {
        method: "post",
        baseURL: "http://localhost:8080",
        url: '/technicianregister',
    data: {
        email: email,
        username: username,
        password: password,
        lastName: lastName,
        firstName: firstName,
        technicianRole: technicianRole
    }
    }
    const response = await axios(axiosOptions);
    this.timeSlots.push(response.data);
}
    
}
