import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

//// 1. Create the button
//var button = document.createElement("button");
//button.innerHTML = "Add";
//
//// 2. Append somewhere
//var body = document.getElementsByTagName("body")[0];
//if (url === 'http://localhost:8087/#/Home'){
//body.appendChild(button);
//}
//// 3. Add event handler
//button.addEventListener ("click", function() {
//  alert("did something");
//});

/* Read

https://css-tricks.com/use-button-element/
*/

function CustomerDto(id, cardholderName, cardNumber,  expiryMonth, expiryYear, CVV)
{
        this.id = id;
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
        customerCCs: [],
        newCustomerCC: {
            id: '',
            cardholderName: '',
            cardNumber: '',
            expiryMonth:'',
            expiryYear: '',
            CVV: ''
        },
      errorCustomerCC: '',
      response: []
    }
},
    createCustomerCC: function (id, cardholderName, cardNumber,  expiryMonth, expiryYear, CVV) {
        this.newCustomerCC = new customerCC(id, cardholderName, cardNumber,  expiryMonth, expiryYear, CVV),
        this.newCustomerCC.id = id,
        this.newCustomerCC.cardholderName = cardholderName,
        this.newCustomerCC.cardNumber = cardNumber,
        this.newCustomerCC.expiryMonth= expiryMonth,
        this.newCustomerCC.expiryYear = expiryYear,
        this.newCustomerCC.CVV= CVV,
        this.customerCCs.push(this.newCustomerCC)
        customerCC = {
            id: id,
            cardholderName: cardholderName,
            cardNumber: cardNumber,
            expiryMonth: expiryMonth,
            expiryYear: expiryYear,
            CVV: CVV,
        },
        AXIOS.post('http://localhost:8087/customerCC/', customerCC).then(
             response => {
                  this.customerCCs.push(response.data)
                  this.errorCustomerCC = ''
                  this.newCustomerCC = ''
        }).catch(e => {
         var errorMsg = e.response.data.message;
           console.log(errorMsg);
           this.errorCustomerCC = errorMsg;
        })
    },

         created: async function () {
         const axiosOptions = {
        method: "get",
        baseURL: "http://localhost:8087",
        url: '/customerCCs/',
        };
        const response = await axios(axiosOptions);
       this.customerCCs.push(response.data);
          }
 }
