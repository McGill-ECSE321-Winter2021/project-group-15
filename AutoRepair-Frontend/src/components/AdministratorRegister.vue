<template>
    <div id="createAccount" class="card">
        <span id="header" class="header">Administrator Registration Form</span>
        <button onclick="window.location.href='http://localhost:8087/#/AdministratorLogin';"> Already have an account? Click here.</button>

        <span id="title">Create Account:</span>
        <div v-if="showError">
            <div id="alert" class="alert alert-warning" role="alert">{{ errorMsg }}</div>
        </div>
        
                <b-container fluid>
            <b-form-input
                class="loginField"
                type="text"
                id="email"
                v-model="email"
                placeholder="Enter email"
                :state="emailState"
                v-on:keyup.enter="createAdministrator(email, username, password, lastName, firstName)"
            ></b-form-input>
            <b-form-invalid-feedback id="email-live-feedback">
                Can't be empty
                            </b-form-invalid-feedback>
        </b-container>
        
                <b-container fluid>
            <b-form-input
                class="loginField"
                type="FullName"
                id="username"
                v-model="username"
                placeholder="username"
                :state="usernameState"
                aria-describedby="username-live-feedback"
                v-on:keyup.enter="createAdministrator(email, username, password, lastName, firstName)"
            ></b-form-input>
            <b-form-invalid-feedback id="username-live-feedback">
                Can't be empty
            </b-form-invalid-feedback>
        </b-container>
        
               
        <b-container fluid>
            <b-form-input
                class="loginField"
                type="password"
                id="password"
                v-model="password"
                placeholder="Enter password"
                :state="passwordState"
                aria-describedby="password-live-feedback"
                v-on:keyup.enter="createAdministrator(email, username, password, lastName, firstName)"
            ></b-form-input>
            <b-form-invalid-feedback id="password-live-feedback">
                Password must be at least 8 characters
            </b-form-invalid-feedback>
        </b-container>

    
        <b-container fluid>
            <b-form-input
                class="loginField"
                type="lastName"
                id="lastName"
                v-model="lastName"
                placeholder="Last Name"
                :state="lastNameState"
                aria-describedby="lastName-live-feedback"
                v-on:keyup.enter="createAdministrator(email, username, password, lastName, firstName)"
            ></b-form-input>
            <b-form-invalid-feedback id="lastname-live-feedback">
                Can't be empty
            </b-form-invalid-feedback>
        </b-container>
        
        
                <b-container fluid>
            <b-form-input
                class="loginField"
                type="firstName"
                id="firstName"
                v-model="firstName"
                placeholder="First Name"
                :state="firstNameState"
                aria-describedby="firstname-live-feedback"
                v-on:keyup.enter="createAdministrator(email, username, password, lastName, firstName)"

            ></b-form-input>
            <b-form-invalid-feedback id="firstName-live-feedback">
                Can't be empty
            </b-form-invalid-feedback>
        </b-container>
        
            <button
                type="button"
                v-on:click="createAdministrator(email, username, password, lastName, firstName)"
                class="btn btn-primary btn-lg loginField button"
            >Create an Account</button>
        </b-container>
    </div>
</template>

<script>
import axios from "axios";
import Router from "../router";
var config = require("../../config");
// Axios config
var frontendUrl = "http://" + config.dev.host + ":" + config.dev.port;
var backendUrl =
  "http://" + config.dev.backendHost + ":" + config.dev.backendPort;
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { "Access-Control-Allow-Origin": frontendUrl }
});
    export default {
        computed: {
           emailState() {
           var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

            return this.email.match(mailformat) ? true : false
            },
            usernameState() {
            return this.username.length > 0 ? true : false
            },
            
            passwordState() {
            return this.password.length > 7 ? true : false
            },
            lastNameState() {
            return this.lastName.length > 0 ? true : false
            },
            
            firstNameState() {
                return this.firstName.length > 0 ? true : false
            },
           
            },
        data(){
            return {
                administrator: {
                    type: Object
                },
                errorMsg: "",
                showError: false,
                password: "",
                firstName: "",
                lastName: "",
                email: "",
                username: ""
            };
        },
        methods: {
            returnToLogin: function(){
                Router.push({
                    path: "/",
                    name: "welcome"
                });
            },
            goToHomePage: function(){
                Router.push({
                    path: "/Home",
                    name: "Home"
                });
            },
               goToAdministratorDashboard: function(){
                Router.push({
                    path: "/AdministratorRegister",
                    name: "Services"
                });
            },

                createAdministrator: function(email, username, password, firstName, lastName) {
                this.errorMsg = "";
                this.showError = false;
        
             
                                this.goToAdministratorDashboard();
                    
                
            }
        }
    }
</script>

<style>
#title {
  text-align: left;
  color: black;
  font-size: 30px;
  padding-left: 15px;
}
#send {
  align-content: left;
}
#name {
  text-align: left;
  color: black;
  font-size: 26px;
  padding-left: 15px;
}
#createAccount {
  width: 50%;
  max-height: auto;
  min-width: 550px;
  margin: auto;
  margin-top: 15px;
  padding: 15px;
  text-align: left;
}
.loginField {
  width: 100%;
  border-radius: 4px;
  border: 0px;
  padding: 2%;
  margin: auto;
  margin-top: 15px;
}
.button {
  color: white;
      background-color: #D44F1EFF;

}
.rtrn-btn {
    margin-top: 4px;
    margin-left: 0;
    width: 15%;
}
.header {
font: Roboto;
    text-align: center;
    font-size: 40px;
    color: white;
    background-color: black;
    border-radius: 5px;
}
</style>
