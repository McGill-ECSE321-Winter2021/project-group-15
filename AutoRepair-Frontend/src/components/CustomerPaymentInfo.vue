<template>
  <div id="CustomerAppointments">
<ul>
  <li><a href="#home">Request appointment</a></li>
  <li><a href="#/CustomerDashboard/ViewAppointments">My Appointments</a></li>
  <li><a href="#/CustomerDashboard/ViewAppointments">My Bills</a></li>
  <li><a href="#/CustomerDashboard/ViewPaymentInfos">My Account</a></li>
  <li><a class="active" href="#/CustomerDashboard/ViewPaymentInfos">Payment Informations</a></li>
</ul>
<h2>Cards</h2>
<label for="fname">Accepted Cards</label>
    <img src="../assets/AcceptedCards.png" width="20%" height="10%">
<table>
  <tr>
      <th>Cardholder Name</th>
      <th>Credit Card Number</th>
      <th>Expiry Month</th>
      <th>Expiry Year</th>
      <th>CVV</th>
      <!--<th>Edit</th>-->
  </tr>
    </tr>
    <tr v-for="customer in customers">
      <td>{{ customer.cardholderName }}</td>
      <td>{{ customer.cardNumber }}</td>
      <td>{{ customer.expiryMonth }}</td>
      <td>{{ customer.expiryYear }}</td>
      <td>{{ customer.CVV }}</td>
      <button v-bind:disabled="!newCustomer.cardholderName === '' && !newCustomer.cardNumber === ''"@click="myCreateFunction()">EDIT</button>
    </tr>
 <tr>
      <td>
        <input type="text" v-model="newCustomer.cardholderName" placeholder="John Mills">
      </td>
       <td>
        <input type="text" v-model="newCustomer.cardNumber" placeholder="1234-5678-9876-5432"  maxlength="20">
      </td>
      <td>
        <input type="text" v-model="newCustomer.expiryMonth" placeholder="02"  maxlength="2">
      </td>
      <td>
        <input type="text" v-model="newCustomer.expiryYear" placeholder="2025"  maxlength="4">
      </td>
      <td>
        <input type="password" v-model="newCustomer.CVV" placeholder="***"  maxlength="3">
      </td>
 	<td>
        <button v-bind:disabled="(newCustomer.cardholderName === '') && (newCustomer.cardNumber === '')"@click="createCustomerCC(newCustomer.cardholderName, newCustomer.cardNumber, newCustomer.expiryMonth, newCustomer.expiryYear, newCustomer.CVV   )">Add</button>

    

    </td>
    </tr>
</table>
</div>
</div>
</template>
<script src="./CustomerPaymentCredentials.js">
</script>
<style>
#CustomerPaymentInfo{
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
  padding: 0px;
}
</style>