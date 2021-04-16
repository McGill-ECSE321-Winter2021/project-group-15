import axios from 'axios'

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




 export var timeSlotsToAdd;
 




export default {
    name: 'technicianavailability',
    data () {
      return {
        
        
        timeSlots: [],
        newTimeSlot: {
          id: '',
          date: '',
          startTime: '',
          endTime: '',
          
        },
        
        
        
        errorTimeSlot: ''
        
        
      }
    },

    

      createTimeSlot: function (id,date,startTime,endTime) {
      
        var p = new TimeSlot(id, date, startTime, endTime)
        this.timeSlots.push(p);
        this.newTimeSlot.id = ''
        this.newTimeSlot.date = ''
        this.newTimeSlot.startTime = ''
        this.newTimeSlot.endTime = ''
        timeSlotsToAdd = this.timeSlots;
        
       /** 
        const axiosData = {
          method: "post",
          baseURL: "http://localhost:8080/",
          url: '/createtimeslot/',
          data : {
            id: id,
            date: date,
            startTime: startTime,
            endTime: endTime,
            repairShop: '',
            technician: '',
            service: ''
    
          }
        }
       
        const response = await axios(axiosOptions);
        this.timeSlots.push(response.data);
        
      },
      **/
    
     timeSlot = {
      id: id,
      date: date,
      startTime: startTime,
      endTime: endTime,
      repairShop: '',
      technician: '',
      service: ''

    },
    
      
      AXIOS.post('http://localhost:8080/createtimeslot/', timeSlot)
        .then(response => {
        // JSON responses are automatically parsed.
          console.log('success');
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
     
    /** 
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
    },
    **/
    created: async function () {
      // Test data
     // const id = new PersonDto('John')
     // const p2 = new PersonDto('Jill')
      // Sample initial content
     // this.persons = [p1, p2]
    //Test Data
    // const p1 = new ServiceDto('Test','123','Hi','12$', '1 hour', 'Test')
   //  const p2 = new ServiceDto('Test2','1233','Hey','200$', '30 minutes', 'Test')
  
      //Sample initial content
      //this.services = [p1, p2]
      
    /** 
    AXIOS.get('/services')
    .then(response => {
      // JSON responses are automatically parsed.
      this.services = response.data
    })
    .catch(e => {
      this.errorService = e
    }),
    **/
   const axiosOptions = {
    method: "get",
    baseURL: "http://localhost:8087",
    url: '/timeSlots/',
    
  };
 
  const response = await axios(axiosOptions);
  this.timeSlots = response.data
    /**  
    AXIOS.get('/timeslots').then(response => {
      this.timeSlots = response.data
    }).catch(e => {
      this.errorTimeSlot = e
    })
    **/
  },

  
  

 
}