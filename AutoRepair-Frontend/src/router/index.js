import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import About from '@/components/About'
import Technicians from '@/components/Technicians'
import OpeningHours from  '@/components/OpeningHours'
import Login from '@/components/Login'
import TechnicianRegister from '@/components/TechnicianRegister'
import TheServices from '@/components/TheServices'
import TechnicianLogin from '@/components/TechnicianLogin'
import CustomerRegister from '@/components/CustomerRegister'
import CustomerLogin from '@/components/CustomerLogin'
import AdministratorRegister from '@/components/AdministratorRegister'
import AdministratorLogin from '@/components/AdministratorLogin'

import Services from '@/components/Services'
import CustomerDashboard from '@/components/CustomerDashboard'
import CustomerAppointments from '@/components/CustomerAppointments'
import CustomerPaymentInfo from '@/components/CustomerPaymentInfo'
import TechnicianAvailability from '@/components/TechnicianAvailability'
import TechnicianAppointments from'@/components/TechnicianAppointments'
import BookAppointment from '@/components/BookAppointment'
import CreateAppointment from '@/components/CreateAppointment'



Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Home',
      name: 'Home',
      component: Home
    },
    {
        path: '/About',
        name: 'About',
        component: About
    },
   
          
           {
           path: '/Services',
           name: 'Services',
           component: Services
       },
           
           {
           path: '/Technicians',
           name: 'Technicians',
           component: Technicians
       },
           {
           path: '/OpeningHours',
           name: 'OpeningHours',
           component: OpeningHours
       },
           
           {
           path: '/TheServices',
           name: 'TheServices',
           component: TheServices
       },
//           {
//           path: '/Payment',
//           name: 'Payment',
//           component: Payment
//       },
//           {
//             path: '/OrderSummary',
//             name: 'OrderSummary',
//             component: OrderSummary
//           },
           
           {
           path: '/Login',
           name: 'Login',
           component: Login
       },
           
           {
           path: '/TechnicianRegister',
           name: 'TechnicianRegister',
           component: TechnicianRegister
       },
           {
           path: '/TechnicianLogin',
           name: 'TechnicianLogin',
           component: TechnicianLogin
       },
           
           {
           path: '/CustomerRegister',
           name: 'CustomerRegister',
           component: CustomerRegister
       },
           
           {
           path: '/CustomerLogin',
           name: 'CustomerLogin',
           component: CustomerLogin
       },
           
           {
           path: '/AdministratorRegister',
           name: 'AdministratorRegister',
           component: AdministratorRegister
       },
           {
           path: '/AdministratorLogin',
           name: 'AdministratorLogin',
           component: AdministratorLogin
       },
           
           {
           path: '/TechnicianAvailability',
           name: 'TechnicianAvailability',
           component: TechnicianAvailability
       },
           
           {
           path: '/CustomerDashboard',
           name: 'CustomerDashboard',
           component: CustomerDashboard
       },
           
           {
           path: '/BookAppointment',
           name: 'BookAppointment',
           component: BookAppointment
       },
           {
           path: '/CustomerDashboard/ViewAppointments',
           name: 'CustomerAppointments',
           component: CustomerAppointments
       },
           {
           path: '/CustomerDashboard/ViewPaymentInfos',
           name: 'CustomerPaymentInfo',
           component: CustomerPaymentInfo
       },
       {
         path: '/TechnicianAvailability',
         name: 'TechnicianAvailability',
         component: TechnicianAvailability
       },
           
           {
             path: '/TechnicianAppointments',
             name: 'TechniciansAppointments',
             component: TechnicianAppointments
           },
       {
         path: '/BookAppointment',
         name: 'BookAppointment',
         component: BookAppointment
       },
       {
         path: '/CreateAppointment',
         name: 'CreateAppointment',
         component: CreateAppointment
       }
          
//    {
//       path: '/',
//       name: 'Payment',
//       component: Payment
//     }
  ]
})
