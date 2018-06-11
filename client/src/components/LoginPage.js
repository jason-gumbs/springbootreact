import React, { Component } from "react"
import {Redirect} from 'react-router-dom'
import Container from "./Container"
import Row from "./Row"
import Col from "./Col"
import Panel from "./Panel"
import Search from "./Search"
import * as API from "../utils/API"


export default class LoginPage extends Component {
 
    state = {
    username:"",
    password:"",
    result:"",
    LoggedIn:false
  }
  

  handleInputChange = event => {
    const value = event.target.value
    const name = event.target.name
    this.setState({
      [name]: value
    })
  }

  // When the form is submitted, search the OMDB API for the value of `this.state.search`
  handleFormSubmit = event => {
    event.preventDefault()
    console.log("hey")
    API.createUser({  username: this.state.username,
      password: this.state.password})
      const {LoggedIn} = this.state
      .then(res => {
        if(!res.data){
          document.getElementById("result").innerHTML = "<p>username exist</p>"
          //swal(`username exist`)
        }else{
          document.getElementById("result").innerHTML = "<p >thank you are all signed up</p>"
         //swal(`thank you are all signed up`)
         this.setState({LoggedIn})
         }
 }) 
 .catch(err => console.log(err))
 }

 handleloginSubmit = event => {
   const {LoggedIn} = this.state
  event.preventDefault()
  console.log("raqqq")
  API.login({  username: this.state.username,
    password: this.state.password})
    .then(res => {
      if(!res.data){
        document.getElementById("result").innerHTML = "<p>wrong username/password</p>"
      
      }else{document.getElementById("result").innerHTML = "<p>`you are loged in</p>"
      this.setState({LoggedIn})
       }

    })
   
    .catch(err => console.log(err))

  
}

  render() {
    if(this.state.LoggedIn){
      return <Redirect to="/doors"/>
    }
    return (
      <Container>
        <Row>
          
          <Col size="md-4" className="m-auto">
            <Panel heading="Sign up/Login">
              <Search
                handleInputChange={this.handleInputChange}
                handleFormSubmit={this.handleFormSubmit}
                
              />
        <div id= "result">
        </div>
    
            </Panel>
          </Col>
        </Row>
      </Container>
    )
  }
}

 
