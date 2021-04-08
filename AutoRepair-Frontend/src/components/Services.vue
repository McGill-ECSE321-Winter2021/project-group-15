<template>
<div id="service">
<ul>
  <li><a class="active" href="#/Services">Create services</a></li>
  <li><a href="#/CreateAppointment">Create appointments</a></li>
  <li><a href="#/Home">Logout</a></li>

</ul>
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
<script src="./CreateServices.js">
</script>
<style>
#service {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: #f2ece8;
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