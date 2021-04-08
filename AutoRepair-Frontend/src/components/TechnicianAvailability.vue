<template>
<div id="technicianavailability">

<ul>
  <li><a class="active" href="#/TechnicianAvailability">Add Availability</a></li>
  <li><a href="#/TechnicianAppointments">My Appointments</a></li>
  <li><a href="#">My Account</a></li>
  <li><a href="#/Home">Logout</a></li>


</ul>
  <h2>Availabilities</h2>
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
      
   
      <<td>
        <button>Edit</button>
      </td>
    </tr>
    <tr>
      <td>
        <input type="text" v-model="newTimeSlot.id" placeholder="TimeSlot id">
      </td>
      <td>
        <input type="date" v-model="newTimeSlot.date" placeholder="YYYY-MM-DD">
      </td>
      <td>
        <input type="time" v-model="newTimeSlot.startTime" placeholder="HH:mm">
      </td>
      <td>
        <input type="time" v-model="newTimeSlot.endTime" placeholder="HH:mm">
      </td>
      <td>
        <button
          <button v-bind:disabled="!newTimeSlot.id" v-on:click="createTimeSlot(newTimeSlot.id,newTimeSlot.date,newTimeSlot.startTime,newTimeSlot.endTime)">Create</button>
      </td>
    
    </tr>
  </table>
  
      <span v-if="errorTimeSlot" style="color:red">Error: {{errorTimeSlot}} </span>
</div>
</template>
<script src="./TechnicianTimeslot.js">
</script>
<style>
#technicianavailability {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: #f2ece8;
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
</style>
