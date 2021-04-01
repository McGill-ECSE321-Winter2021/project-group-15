<template>
<div id="bookappointment">
  <h2>Book an appointment</h2>
      <table>
        <tr>
           <th>Appointment Id</th>
        </tr>
        <tr v-for="appointment in appointments" >
            <td>{{ appointment.id }}</td>
            <td> 
              <ul>
                <li v-for="service in appointment.getServices()">
                  {{service.name}}
                </li>
              </ul>
            </td>
            <td>
               <button>Book Appointment</button>
            </td>
        </tr>
       </table>
      <span v-if="errorAppointment" style="color:red">Error: {{errorAppointment}} </span>
</div>
</template>
<script src="./BookAppointment.js">
</script>
<style>
#bookappointment {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: #f2ece8;
  }
  table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
}
</style>