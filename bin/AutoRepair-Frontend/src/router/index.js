import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Hello from '@/components/Hello'
import FirstComponent from '@/components/FirstComponent'
import About from '@/components/About'
import Technicians from '@/components/Technicians'
import CreateAccount from'@/components/CreateAccount'
import Payment from '@/components/Payment'
//import OrderSummary from '@/components/OrderSummary'
import Services from '@/components/Services.vue'
import CustomerDashboard from '@/components/CustomerDashboard'
import CustomerAppointments from '@/components/CustomerAppointments'
import CustomerPaymentInfo from '@/components/CustomerPaymentInfo'
import TechnicianAvailability from '@/components/TechnicianAvailability'
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
               path: '/CreateAccount',
               name: 'CreateAccount',
               component: CreateAccount
           },
           {
           path: '/Payment',
           name: 'Payment',
           component: Payment
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
           path: '/CustomerDashboard',
           name: 'CustomerDashboard',
           component: CustomerDashboard
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
