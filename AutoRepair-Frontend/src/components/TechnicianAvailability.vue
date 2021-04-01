<template>
<div id="technicianavailability">
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
        <input type="text" v-model="newTimeSlot.id" placeholder="Event Name">
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
          <button>Create</button>
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
  table {
  border: 1px solid #ccc;
  border-collapse: collapse;
  margin: 0;
  padding: 0;
  width: 100%;
  table-layout: fixed;
}
</style>