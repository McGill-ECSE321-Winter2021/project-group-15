import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function TimeSlotDto(id, date, start, end)
{
    this.id = id;
    this.date = date;
    this.startTime = start;
    this.endTime = end;

}

function ServiceDto(serviceType,id,name,cost,duration)
{
    this.serviceType = serviceType;
    this.id = id;
    this.name = name;
    this.cost = cost;
    this.duration = duration;
}

export default {
    name: 'technicianavailability',
created: function () {
    // Test data
   // const id = new PersonDto('John')
   // const p2 = new PersonDto('Jill')
    // Sample initial content
   // this.persons = [p1, p2]
	//Test Data
   const p1 = new ServiceDto('Test','123','Hi','12$', '1 hour', 'Test')
   const p2 = new ServiceDto('Test2','1233','Hey','200$', '30 minutes', 'Test')

//Sample initial content
this.services = [p1, p2]
  },
    data () {
      return {
        timeSlots: [],
        newTimeSlot: {
          id: '',
          date: '',
          startTime: '',
          endTime: ''
        },
        
        errorTimeSlot: '',
        services: [],
        newService: {
          serviceType: '',
          id: '',
          name: '',
          cost: '',
          duration: '',

        },
        errorService: '',
        appointments: [],
        response: []
      }
    },
    //...
  }