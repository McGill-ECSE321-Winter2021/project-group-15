import axios from 'axios'

var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function Services(serviceType,id,name,cost,duration)
{
    this.serviceType = serviceType;
    this.id = id;
    this.name = name;
    this.cost = cost;
    this.duration = duration;
}

export var servicesToAdd;

export default {
    name: 'service',
    data() {
        return {
            services: [],
            newService: {
                serviceType: '',
                       id: '',
                      name: '',
                      cost: '',
                    duration: '',
          

        },
        errorService: '',
        
        response: [],
    }
},
    createService: function (name,id,cost,duration,serviceType) {

        var p = new Services(serviceType,id,name,cost,duration)
        this.services.push(p)
        servicesToAdd = this.services
        this.newService.serviceType = '',
        this.newService.id = '',
        this.newService.name = '',
        this.newService.cost = '',
        this.newService.duration = '',
        service = {
          serviceType: serviceType,
          id: id,
          name: name,
          cost: cost,
          duration: duration,
    
        }
        AXIOS.post('/createservice', service)
          .then(response => {
          // JSON responses are automatically parsed.
            this.services.push(response.data)
            this.errorService = ''
            this.newService = ''
          })
          .catch(e => {
            var errorMsg = e.response.data.message
            console.log(errorMsg)
            this.errorTimeSlot = errorMsg
          })
      },

      created: function () {
        AXIOS.get('/services')
        .then(response => {
          // JSON responses are automatically parsed.
          this.services = response.data
        })
        .catch(e => {
          this.errorService = e
        })
      }
      

}