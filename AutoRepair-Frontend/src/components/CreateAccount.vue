<template>
    <div id="CreateAccount">
     <h1>Online Registration Form</h1>

  <form action="/">
      <hr>
    <div class="accounttype">
      <input type="radio" value="Customer" id="radioOne" name="account" checked/>
      <label for="radioOne" class="radio" chec>Customer</label>
      <input type="radio" value="Technician" id="radioTwo" name="account" />
      <label for="radioTwo" class="radio">Technician</label>
    </div>
  <hr>

  <input type="text" name="username" id="username" placeholder="Username" required/>

  <input type="text" name="email" id="email" placeholder="Email Address" required/>

  <input type="text" name="lastName" id="lastName" placeholder="Last Name" required/>

  <input type="text" name="firstName" id="firstName" placeholder="First Name" required/>

  <input type="password" name="password" id="password" placeholder="Password" required/>

  <p>By clicking Register, you agree on our terms and condition.</p>
   
   <a href="#" class="button">Register</a>
  </form>
  </div>
</template>
<script src="./registrationPerson.js"> 
</script>
<style>
body, div, dl, dt, h1,
form, fieldset, input, textarea, p, blockquote, th, td { 
  padding:0;
  margin:0;}

  

:focus {outline:none}

body,
input,
textarea,
select {
  font-family: 'Open Sans', sans-serif;
  font-size: 16px;
  color: #4c4c4c;
}

p {
  font-size: 16px;
  width: 1000px;
  display: inline-block;
  margin-left: 18px;
}
h1 {
  font-size: 32px;
  font-weight: 300;
  color: #4c4c4c;
  text-align: center;
  padding-top: 10px;
  margin-bottom: 10px;
}


input[type=radio] {
  visibility: hidden;
}

form{
  margin: 0 30px;
}

label.radio {
	cursor: pointer;
  text-indent: 35px;
  overflow: visible;
  display: inline-block;
  position: relative;
  margin-bottom: 15px;
}

label.radio:before {
  background: #3a57af;
  content:'';
  position: absolute;
  top:2px;
  left: 0;
  width: 20px;
  height: 20px;
  border-radius: 100%;
}

label.radio:after {
	opacity: 0;
	content: '';
	position: absolute;
	width: 0.75em;
	height: 0.5em;
	background: transparent;
	top: 7.5px;
	left: 4.5px;
	border: 3px solid #ffffff;
	border-top: none;
	border-right: none;

	-webkit-transform: rotate(-45deg);
	-moz-transform: rotate(-45deg);
	-o-transform: rotate(-45deg);
	-ms-transform: rotate(-45deg);
	transform: rotate(-45deg);
}

input[type=radio]:checked + label:after {
	opacity: 1;
}

hr{
  color: #a9a9a9;
  opacity: 0.3;
}

input[type=text],input[type=password]{
  width: 1375px; 
  height: 39px; 
  -webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  -moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px; 
  border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  background-color: #fff; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  border: solid 1px #cbc9c9;
  margin-left: -5px;
  margin-top: 13px; 
  padding-left: 10px;
}

input[type=password]{
  margin-bottom: 25px;
}

.accounttype{
  margin-left: 8px;
  margin-top: 20px;
}

a.button {
  font-size: 14px;
  font-weight: 600;
  color: white;
  padding: 6px 25px 0px 20px;
  margin: 10px 8px 20px 0px;
  display: inline-block;
  float: right;
  text-decoration: none;
  width: 100px; height: 32px; 
  -webkit-border-radius: 5px; 
  -moz-border-radius: 5px; 
  border-radius: 4px; 
  background-color: #3a57af; 
  transition: all 0.1s linear 0s; 
  top: 10px;
  position: relative;
}

a.button:hover {
  top: 3px;
  background-color:#2e458b;
  -webkit-box-shadow: none; 
  -moz-box-shadow: none; 
  box-shadow: none;
  
}
</style>