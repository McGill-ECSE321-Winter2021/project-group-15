import axios from 'axios'
import timeSlotsToAdd from './TechnicianTimeslot.js'
import servicesToAdd from './Services.js'

var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    name : 'bookappointment',
    data(){
        return {
            appointmentsToBook: [],
        }
    }
}