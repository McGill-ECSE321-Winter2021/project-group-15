import axios from 'axios'
//import AutoRepairService from '@/AutoRepair-Backend/src/main/java/ca/mcgill/ecse321/projectgroup15/service/AutoRepairService'
//import Technician from '@/AutoRepair-Backend/src/main/java/ca/mcgill/ecse321/projectgroup15/model/Technician'
//import TechnicianDto from '@/AutoRepair-Backend/src/main/java/ca/mcgill/ecse321/projectgroup15/dto/TechnicianDto'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function TimeSlot(id, date, start, end)
{
    this.id = id;
    this.date = date;
    this.startTime = start;
    this.endTime = end;
    

}

function Services(serviceType,id,name,cost,duration)
{
    this.serviceType = serviceType;
    this.id = id;
    this.name = name;
    this.cost = cost;
    this.duration = duration;
}

function Appointment(id,service,timeSlot){
  this.id = id;
  this.service = service;
  this.timeSlot = timeSlot;
}





export default {
    name: 'technicianavailability',
    data () {
      return {
        appointments: [],
        newAppointment: {
          id: '',
          service: '',
          timeSlot: ''
        },
        appointmentsToBook: [],
        errorAppointment: '',
        timeSlots: [],
        newTimeSlot: {
          id: '',
          date: '',
          startTime: '',
          endTime: '',
          
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
        
        response: [],
        selectedTimeSlot: '',
        selectedService: ''
      }
    },
     
    createTimeSlot: function (id,date,startTime,endTime) {
      AXIOS.post('/createtimeslot/', new TimeSlot(id,date,startTime,endTime))
        .then(response => {
        // JSON responses are automatically parsed.
          this.timeSlots.push(response.data)
          this.errorTimeSlot = ''
          this.newTimeSlot = ''
        })
        .catch(e => {
          var errorMsg = e.response.data.message
          console.log(errorMsg)
          this.errorTimeSlot = errorMsg
        })
    },
    createAppointment: function (id,serviceName,timeSlotId){
      var indexServ = this.services.map(x => x.name).indexOf(serviceName)
      var indexTime = this.timeSlots.map(x => x.id).indexOf(timeSlotId)
      this.newAppointment = new Appointment(id,indexServ,indexTime)
      this.newAppointment.id = id;
      this.newAppointment.service = indexServ
      this.newAppointment.timeSlot = indexTime
      this.appointmentsToBook.push(this.newAppointment)
      AXIOS.post('/appointment/', new Appointment(id,indexServ,indexTime)).then(
        response => {
          this.appointments.push(response.data)
          this.errorAppointment = ''
          this.newAppointment = ''
          

        }

      ).catch(e => {
        var errorMsg = e.response.data.message
        console.log(errorMsg)
        this.errorAppointment = errorMsg
      })
    },
    created: function () {
      // Test data
     // const id = new PersonDto('John')
     // const p2 = new PersonDto('Jill')
      // Sample initial content
     // this.persons = [p1, p2]
    //Test Data
    // const p1 = new ServiceDto('Test','123','Hi','12$', '1 hour', 'Test')
   //  const p2 = new ServiceDto('Test2','1233','Hey','200$', '30 minutes', 'Test')
  
      //Sample initial content
      this.services = [p1, p2]
      // Initializing persons from backend
    AXIOS.get('/services')
    .then(response => {
      // JSON responses are automatically parsed.
      this.services = response.data
    })
    .catch(e => {
      this.errorService = e
    }),
    AXIOS.get('/timeslots').then(response => {
      this.timeSlots = response.data
    }).catch(e => {
      this.errorTimeSlot = e
    })

  },

  
  createService: function (name,id,cost,duration,serviceType) {
    AXIOS.post('/createservice', new Services(name,id,cost,duration,serviceType))
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
  }

 
}