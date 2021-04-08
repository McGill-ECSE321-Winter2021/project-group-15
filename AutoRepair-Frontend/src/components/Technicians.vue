<template>
  <div id="Technicians">
<div class="title">

<h2>Technicians</h2>
    <img src="../assets/TechnicianLogoGrey.png" width="15%" height="5%">
</div>
 <table>
    <tr>
      <th>Role</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <!--<th>Edit</th>-->
    </tr>
    <tr v-for="technician in technicians">
      <td>{{ technician.technicianRole }}</td>
      <td>{{ technician.firstName }}</td>
      <td>{{ technician.lastName }}</td>
      <td>{{ technician.email }}</td>
    </tr>
 
  </table>
</div>
</div>
</template>
<script src="./ourtechnicians">
</script>
<style>
#Technicians {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: white;
  }

h2{
margin-top: 5px;
background: black;
color: white;
padding: 10px 10px;
}
 table {
  margin-top: 10px;
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
}

th{
padding: 20px;
background: grey;
color: white;
}
td {
  text-align: center;
  padding: 16px;
}
</style>



