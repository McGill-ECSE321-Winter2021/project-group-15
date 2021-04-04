<template>
  <div id="Login">
  
<div class="header">
  <h1>Welcome !</h1>
  <p> <i> What type of user are you?</i></p>
</div>

  <div class="btn-group">

    <button class="button" onclick="window.location.href='http://localhost:8087/#/CustomerRegister';">
Customer
    </button>
    
        <button class="button" onclick="window.location.href='http://localhost:8087/#/TechnicianRegister';">
Technician
    </button>
    
    
</div>
</div>
</template>
<script>
</script>

<style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

.btn-group .button {
  background-color: #D44F1EFF; /* Dark Orange */
  border: 1px solid orange;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  cursor: pointer;
  width: 150px;
  display: block;
}

.btn-group .button:not(:last-child) {
  border-bottom: none; /* Prevent double borders */
}

.btn-group .button:hover {
  background-color: #FF5F24FF;
}

/* Header/Logo Title */
.header {
  padding: 30px;
  text-align: center;
  background: black;
  color: white;
  font-size: 30px;
}
</style>



