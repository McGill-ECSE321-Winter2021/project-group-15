import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function CustomerDto(cardholderName, cardNumber,  expiryMonth, expiryYear, CVV)
{
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.CVV = CVV;
}


export default {
    name: 'CustomerPaymentCredentials',
    data () {
      return {
        customers: [],
        newCustomer: {
         cardholderName: '',
	cardNumber: '',
	expiryMonth:'',
	expiryYear: '',
	CVV: ''
        },
	response: []

    }
},
created: function () {
	//Test Data
	const c1 = new CustomerDto('Emily Mills','1234-4567-8909-8765','03','2023', '000')
	const c2 = new CustomerDto('Roger Mills','0000-0000-0000-0000','02','2022', '111')

	//Sample initial content
	this.customers = [c1,c2]
},
methods: {
    createCustomerCC: function (cardholderName, cardNumber,  expiryMonth, expiryYear, CVV) {
      // Create a new person and add it to the list of people
      var p = new CustomerDto(cardholderName, cardNumber,  expiryMonth, expiryYear, CVV)
      this.customers.push(p)
      // Reset the name field for new creditcards
      this.newCustomer.cardholderName = ''
      this.newCustomer.cardNumber = ''
      this.newCustomer.expiryMonth= ''
      this.newCustomer.expiryYear = ''
      this.newCustomer.CVV= ''

    }, 
    modifyCustomerCC: function (cardholderName, cardNumber,  expiryMonth, expiryYear, CVV){
 this.newCustomer.cardholderName = ''
      this.customer.cardNumber = 'ASLK'
      this.customer.expiryMonth= ''
      this.customer.expiryYear = ''
      this.customer.CVV= ''

}
}
}