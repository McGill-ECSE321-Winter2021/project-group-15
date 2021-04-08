<template>
    <div id="createAccount" class="card">
        <span id="header" class="header">Administrator Login</span>
              <button onclick="window.location.href='http://localhost:8087/#/AdministratorRegister';"> Not registred yet? Click here.</button>

        <span id="title">Login:</span>
        <div v-if="showError">
            <div id="alert" class="alert alert-warning" role="alert">{{ errorMsg }}</div>
        </div>
        
          
                <b-container fluid>
            <b-form-input
                class="loginField"
                type="FullName"
                id="username"
                v-model="username"
                placeholder="username"
                aria-describedby="username-live-feedback"
                v-on:keyup.enter="AdministratorLogin(username, password)"
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
                placeholder="password"
                aria-describedby="password-live-feedback"
                v-on:keyup.enter="AdministratorLogin(username, password)"
            ></b-form-input>
            <b-form-invalid-feedback id="password-live-feedback">
            
            </b-form-invalid-feedback>
        </b-container>

    
       
        
            <button
                type="button"
                v-on:click="AdministratorLogin(username, password)"
                class="btn btn-primary btn-lg loginField button"
            >Login</button>
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
            
           
           
            },
        data(){
            return {
                Administrator: {
                    type: Object
                },
                errorMsg: "",
                showError: false,
                password: "",
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
                    path: "/Services",
                    name: "Services"
                });
            },

            
                AdministratorLogin: function( username, password) {
                this.errorMsg = "";
                this.showError = false;
                    AXIOS.post(`/loginadministrator/` + username + `/` + password + `/`)
                    .then(response =>{
                    AXIOS.post(`/loginadministrator/` + username + `/` + password + `/`)
                            .then (response => {
                                this.goToAdministratorDashboard();
                            })
                            .catch(e => {
                                console.log(e.message);
                                this.errorMsg = "Account does not exist";
                                this.showError = true;
                            });
                    })
                    .catch( e => {
                        this.errorMsg = "username is already in use";
                        this.showError = true;
                    });
                
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
