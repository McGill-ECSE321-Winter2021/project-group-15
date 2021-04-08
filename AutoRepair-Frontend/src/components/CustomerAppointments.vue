<template>
  <div id="CustomerAppointments">
<ul>
  <li><a href="#/BookAppointment">Request appointment</a></li>
  <li><a class="active" href="#/CustomerDashboard/ViewAppointments">My Appointments</a></li>
  <li><a href="#/CustomerDashboard/ViewPaymentInfos">Payment Informations</a></li>
  <li><a href="#/Home">Logout</a></li>

</ul>
<h2>Your Appointments</h2>
<table>
  <tr>
      <th>Appointment ID</th>
      <th>TimeSlot</th>
      <th>Technician</th>
      <th>Service</th>
  </tr>
    </tr>
    <tr v-for="appointment in appointments">
      <td>{{ appointment.id }}</td>
      <td>{{ appointment.ts }}</td>
      <td>{{ appointment.technician }}</td>
      <td>{{ appointment.service }}</td>
    </tr>
</table>
</div>
</div>
</template>
<script src="./ViewAppointments">
</script>
<style>
#CustomerAppointments{
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
table {
	margin-left: 15%;
  width: 85%;
  border: 1px solid #ddd;
}

th, td {
  text-align: center;
  padding: 16px;
}
</style>


