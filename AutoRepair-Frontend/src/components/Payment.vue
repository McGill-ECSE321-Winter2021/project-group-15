<template>
  <div id="Payment">
<h2>Checkout Form</h2>

<div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black">$CA</span></h4>
      <p><a href="#">Product 1</a> <span class="price">$15</span></p>
      <hr>
      <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
    </div>
  </div>
<div class="row">
	<div class="col-75">
   		 <div class="container">
<form>
			         <div class="row">
        	
<div class="col-50">
 <h3>Payment</h3>
<label for="fname">Accepted Cards</label>
    <img src="../assets/AcceptedCards.png" width="40%" height="20%">


<label for="cname">Name on Card</label>

<input type="text" id="cname" name="cardname" placeholder="John More Doe">

<label for="ccnum">Credit card number</label>

<input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">

<label for="expmonth">Exp Month</label>

<input type="text" id="expmonth" name="expmonth" placeholder="September">
 		<div class="row">
              <div class="col-50">
<label for="expyear">Exp Year</label>

<input type="text" id="expyear" name="expyear" placeholder="2018">

</div>

 <div class="col-50">
 <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352">
</div>
</div>
</div>
</div>
        <input type="submit" value="Continue to checkout" class="btn">	
      </form>

</div>

	</div>
  
</div>
		</div>
</template>
<script>
</script>
<style>

body {
  font-family: Arial;
  font-size: 20px;
  padding: 4px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 10px 10px 12px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 3px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 4px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 15px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 10px 10px 10px;
  border: none;
  width: 60%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 15px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 10px;
  }
}

</style>



