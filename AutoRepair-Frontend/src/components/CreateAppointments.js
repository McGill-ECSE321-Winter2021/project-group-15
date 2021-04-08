import axios from 'axios'
import timeSlotsToAdd from './TechnicianTimeslot.js'
import servicesToAdd from './Services.js'
import Technicians from './ourtechnicians.js'

var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    name: 'createappointment',
    data() {
        return {
            appointments: [],
        newAppointment: {
          id: '',
          service: '',
          timeSlot: '',
          technician: '',
        },
        appointmentsToBook: [],
        errorAppointment: '',
        timeSlots: timeSlotsToAdd,
        
        
        services: servicesToAdd,
        

       // technicians: Technicians.technicians,
        
        
        response: [],
        selectedTimeSlot: '',
        selectedService: ''
        }
    },
    createAppointment: function (id,serviceName,timeSlotId){
        var indexServ = this.services.map(x => x.name).indexOf(serviceName)
        var indexTime = this.timeSlots.map(x => x.id).indexOf(timeSlotId)
        this.newAppointment = new Appointment(id,indexServ,indexTime)
        this.newAppointment.id = id;
        this.newAppointment.service = indexServ
        this.newAppointment.timeSlot = indexTime
        this.appointmentsToBook.push(this.newAppointment)
        appointment = {
          id: id,
          timeslot: indexTime,
          service: indexServ ,
        },
        AXIOS.post('http://localhost:8080/appointment/', appointment).then(
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
      }
}