<template>
<div id="bookappointment">
  <h2>Book an appointment</h2>
      <h2>My appointments</h2>
  <table>
    <tr>
      <th>Appointment id</th>
      <th>Technician name</th>
      <th>Service type</th>
      <th>Start time</th>
      <th>End time</th>
      
      <!--<th>Edit</th>-->
    </tr>
    <tr v-for="appointment in appointmentsToBook">
      <td>{{ appointment.id }}</td>
      <td>{{ appointment.technician.lastName }}</td>
      <td>{{ appointment.service.serviceType }}</td>
      <td>{{ appointment.timeSlot.startTime }}</td>
      <td>{{ appointment.timeSlot.endTime }}</td>
      <td>
        <button>Book Appointment</button>
      </td>
    </tr>
    </table>
      <span v-if="errorAppointment" style="color:red">Error: {{errorAppointment}} </span>
</div>
</template>
<script src="./CreateAppointments.js">
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