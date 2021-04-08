<template>
<div id="createappointment">
<ul>
  <li><a href="#/Services">Create services</a></li>
  <li><a class="active" href="#/CreateAppointment">Create appointments</a></li>

</ul>
  <h2>Create Appointments</h2>
  <h3>TimeSlots</h3>
  <table>
    <tr>
      <th>TimeSlot Id</th>
      <th>Date</th>
      <th>Start</th>
      <th>End</th>
      <!--<th>Edit</th>-->
    </tr>
    <tr v-for="timeSlot in timeSlots">
      <td>{{ timeSlot.id }}</td>
      <td>{{ timeSlot.date }}</td>
      <td>{{ timeSlot.startTime }}</td>
      <td>{{ timeSlot.endTime }}</td>
    </tr>
    
  </table>
  <h3>Services</h3>
  <table>
    <tr>
      <th>Service Name</th>
      <th>Service Id</th>
      <th>Cost</th>
      <th>Duration</th>
      <th>Service Type</th>
      <!--<th>Edit</th>-->
    </tr>
    <tr v-for="service in services">
      <td>{{ service.name }}</td>
      <td>{{ service.id }}</td>
      <td>{{ service.cost }}</td>
      <td>{{ service.duration }}</td>
      <td>{{ service.serviceType }}</td>

    </tr>
    </table>
     <input type="text" v-model="newAppointment.id" placeholder="Appointment Id">
     <label>TimeSlot:
      <select v-model="selectedTimeSlot">
        <option disabled value="">Please select one</option>
        <option v-for="timeSlot in timeSlots" >
          {{ timeSlot.id }}
        </option>
      </select>
    </label>
    <label>Service:
      <select v-model="selectedService">
        <option disabled value="">Please select one</option>
        <option v-for="service in services" >
          {{ service.name }}
        </option>
      </select>
    </label>
    <button v-bind:disabled="!selectedTimeSlot || !selectedService" @click="createAppointment(newAppointment.id,selectedService,selectedTimeSlot)">Create</button>
      <span v-if="errorAppointment" style="color:red">Error: {{errorAppointment}} </span>
</div>
</template>
<script src="./CreateAppointments.js">
</script>
<style>
#createappointment {
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

l {
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