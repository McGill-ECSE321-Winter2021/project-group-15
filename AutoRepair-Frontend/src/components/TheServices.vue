<template>
  <div id="OurServices">
<div class="title">

<h2>Our Services</h2>
    <img src="../assets/Services.png" width="50%" height="5%">
</div>
 <table>
    <tr>
      <th>Service</th>
      <th>Cost</th>
      <th>Duration - hours</th>
    </tr>
    <tr v-for="service in services">
      <td>{{ service.name }}</td>
      <td>{{ service.cost }}</td>
      <td>{{ service.duration }}</td>
    </tr>
 
  </table>
</div>
</div>
</template>
<script src="./ourservices.js">
</script>
<style>
#OurServices {
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



