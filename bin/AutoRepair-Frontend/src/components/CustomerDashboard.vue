
<template>
  <div id="CustomerDashboard">
<ul>
   <li><a class="active" href="#home">Request appointment</a></li>
  <li><a href="#/CustomerDashboard/ViewAppointments">My Appointments</a></li>
  <li><a href="#/CustomerDashboard/ViewAppointments">My Bills</a></li>
  <li><a href="#/CustomerDashboard/ViewPaymentInfos">My Account</a></li>
  <li><a href="#/CustomerDashboard/ViewPaymentInfos">Payment Informations</a></li>

</ul>
</div>
</template>
<script>
</script>
<style>
#CustomerDashboard{
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
</style>


