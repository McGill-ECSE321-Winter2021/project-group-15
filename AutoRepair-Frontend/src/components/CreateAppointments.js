import axios from 'axios'


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
        timeSlots: '',
        
        
        services: '',
        technicians: '',
        

       // technicians: Technicians.technicians,
        
        
        response: [],
        selectedTimeSlot: '',
        selectedService: '',
        selectedTechnician: '',
        }
    },

    
    
    createAppointment: function (id,serviceName,timeSlotId,technicianLastName){

      AXIOS.get('/services')
      .then(response => {
        // JSON responses are automatically parsed.
        this.services = response.data
      })
      .catch(e => {
        this.errorService = e
      })

      AXIOS.get('/timeslots').then(response => {
        this.timeSlots = response.data
      }).catch(e => {
        this.errorTimeSlot = e
      })
        var indexServ = this.services.map(x => x.name).indexOf(serviceName)
        var indexTime = this.timeSlots.map(x => x.id).indexOf(timeSlotId)
        /** 
        this.newAppointment = new Appointment(id,indexServ,indexTime)
        this.newAppointment.id = id;
        this.newAppointment.service = indexServ
        this.newAppointment.timeSlot = indexTime
        this.appointmentsToBook.push(this.newAppointment)
        **/
        appointment = {
          id: id,
          timeslot: indexTime,
          service: indexServ ,
          technician: ''
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
