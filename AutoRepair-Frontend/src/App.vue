<template>
  <div id="app">
<div class="topInfos">
    <img src="./assets/logo.png" width="15%" height="5%">
  <p> Customer Support 514-123-4567 </p>
<hr class="rounded">
<hr class="rounded">
</div>
<div class="topnav">
  <a href="#/Home"><i class="fa fa-fw fa-search"></i>Home</a>
  <a href="#/Services">Services</a>
  <a href="#/Technicians">Our Technicians</a>
  <a href="#/About">About us</a>
  <a href="#/Payment">PaymentVue</a>
  <a href="#/CreateAccount">Create an account</a>
  <a href="#/CustomerDashboard"><img src="./assets/Login.png" width="60" height="50">Login</a>

</div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
#app {
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
.header{
  padding: 0px 0;
  font-size: 0px;
}

/* Add a black background color to the top navigation */
.topnav {
padding: 2px 2px;
  background-color: #262626;
  overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: center;
  color: white;
  text-align: center;
  padding: 30px 30px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color:  #ddd;
  text-decoration: underline;
  color: black;
}



/* Add a black background color to the top informations */
.topInfos {
  background-color: black;
  overflow: hidden;
  color: white;
  text-align: left;
  padding: 2px 2px;
  font-size: 12px;
  float: center;

}


/* Rounded border */
hr.rounded {
  border-top: 1px solid white;
  border-radius: 10px;
  margin-top: 0px;
  margin-bottom: 2px;

}


</style>
