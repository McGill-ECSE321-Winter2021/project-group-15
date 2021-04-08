<template>
<div id="bookappointment">
<ul>
  <li><a class="active" href="#/BookAppointment">Request appointment</a></li>
  <li><a href="#/CustomerDashboard/ViewAppointments">My Appointments</a></li>
  <li><a href="#/CustomerDashboard/ViewPaymentInfos">Payment Informations</a></li>
  <li><a href="#/Home">Logout</a></li>

</ul>
  <h2>Book an appointment</h2>
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
      
</div>
</template>
<script src="./BookAppointments.js">
</script>
<style>
#bookappointment {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: white;
    background: black;
  }
  table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  padding: 0;
  width: 100%;
  table-layout: fixed;
 margin-left: 15%;
  width: 85%;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 15%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
  font-family: "Arial";
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #262626;
  color: white;
  text-decoration: bold;
}

li a:hover:not(.active) {
  background-color:#c34230;
  color: white;
}


th, td {
  text-align: center;
  padding: 16px;
}
</style>