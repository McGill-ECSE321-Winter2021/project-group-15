<template>
  <div id="CustomerAppointments">
<ul>
  <li><a href="#/BookAppointment">Request appointment</a></li>
  <li><a href="#/CustomerDashboard/ViewAppointments">My Appointments</a></li>
  <li><a class="active" href="#/CustomerDashboard/ViewPaymentInfos">Payment Informations</a></li>
  <li><a href="#/Home">Logout</a></li>

</ul>
<h2>Cards</h2>
<label for="fname">Accepted Cards</label>
    <img src="../assets/AcceptedCards.png" width="20%" height="10%">
<table>
  <tr>
        <th>Identifier</th>
      <th>Cardholder Name</th>
      <th>Credit Card Number</th>
      <th>Expiry Month</th>
      <th>Expiry Year</th>
      <th>CVV</th>
      <!--<th>Edit</th>-->
  </tr>
    </tr>
    <tr v-for="customerCC in customerCCs">
      <td>{{ customerCC.id }}</td>
      <td>{{ customerCC.cardholderName }}</td>
      <td>{{ customerCC.cardNumber }}</td>
      <td>{{ customerCC.expiryMonth }}</td>
      <td>{{ customerCC.expiryYear }}</td>
      <td>{{ customerCC.CVV }}</td>
      <button v-bind:disabled="!newcustomerCC.cardholderName === '' && !newcustomerCC.cardNumber === ''"@click="myCreateFunction()">EDIT</button>
    </tr>
<tr>
    <td>
        <input type="text" v-model="newCustomerCC.id" placeholder="id">
    </td>
     <td>
        <input type="text" v-model="newCustomerCC.cardholderName" placeholder="John Mills">
    </td>
    <td>
        <input type="text" v-model="newCustomerCC.cardNumber" placeholder="12345678987654321" maxlength="16">
    </td>
      <td>
        <input type="number" v-model="newCustomerCC.expiryMonth" placeholder="02" min="01" maz="12" maxlength="2">
    </td>
    <td>
        <input type="number" v-model="newCustomerCC.expiryYear" placeholder="2024" min="2021" maxlength="4">
    </td>
     <td>
        <input type="password" v-model="newCustomerCC.CVV" placeholder="123"  maxlength="3">
    </td>
    <td>
    <button v-bind:disabled="(newCustomerCC.id && newCustomerCC.cardholderName && newCustomerCC.cardNumber && newCustomerCC.expiryMonth && newCustomerCC.expiryYear && newCustomerCC.CVV === '')""@click="createCustomerCC( this.id = id,
        this.cardholderName = cardholderName,
        this.cardNumber = cardNumber,
        this.expiryMonth= expiryMonth,
        this.expiryYear = expiryYear,
        this.CVV= CVV)"> Add </button>
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

.ui-datepicker-calendar {
   display: none;
}


</style>
