<template>
<div id="technicianavailability">
  <h2>Services</h2>
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
      <td>
        <button>Edit</button>
      </td>
    </tr>
    <tr>
      <td>
        <input type="text" v-model="newService.name" placeholder="Service Name">
      </td>
       <td>
        <input type="text" v-model="newService.id" placeholder="Service Id">
      </td>
      <td>
        <input type="text" v-model="newService.cost" placeholder="Service Cost">
      </td>
      <td>
        <input type="text" v-model="newService.duration" placeholder="Service Duration">
      </td>
      <td>
        <input type="text" v-model="newService.serviceType" placeholder="Service Type">
      </td>
      <button
          <button v-bind:disabled="!newService.name" v-on:click="createService(newService.name, newService.id, newService.cost, newService.duration, newService.serviceType)">Create</button>
      </td>
    </tr>
  </table>
      <span v-if="errorService" style="color:red">Error: {{errorService}} </span>
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