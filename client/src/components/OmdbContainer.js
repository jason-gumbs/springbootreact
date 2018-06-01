import React, { Component } from "react";
import Container from "./Container";
import Row from "./Row";
import Col from "./Col";
import Panel from "./Panel";
import Search from "./Search";
import * as API from "../utils/API";


class OmdbContainer extends Component {
  constructor(props) {
    super(props);
    this.handleResultChange = this.handleResultChange.bind(this);
    this.state = {
    username:"",
    password:"",
    result:""
  };
  }
  // When this component mounts, search for the movie "The Matrix"
  componentDidMount() {
   
  }
  handleResultChange(result) {
    this.setState({result});
  }

 

  handleInputChange = event => {
    
    const value = event.target.value;
    const name = event.target.name;
    this.setState({
      [name]: value
    });
  };

  // When the form is submitted, search the OMDB API for the value of `this.state.search`
  handleFormSubmit = event => {
    event.preventDefault();
    console.log("hey")
    API.createUser({  username: this.state.username,
      password: this.state.password})
      .then(res => {
        if(!res.data){
          document.getElementById("result").innerHTML = "<p>username exist</p>";
          //swal(`username exist`);
        }else{
          document.getElementById("result").innerHTML = "<p >thank you are all signed up</p>";
         //swal(`thank you are all signed up`)
         
         ;}
 }) 
 .catch(err => console.log(err));
 };

 handleloginSubmit = event => {
  event.preventDefault();
  console.log("raqqq")
  API.login({  username: this.state.username,
    password: this.state.password})
    .then(res => {
      if(!res.data){
        document.getElementById("result").innerHTML = "<p>wrong username/password</p>";
      
      }else{document.getElementById("result").innerHTML = "<p>`you are loged in</p>";
       }

    })
   
    .catch(err => console.log(err));

  
};

  render() {
    return (
      <Container>
        <Row>
          
          <Col size="md-4" className="m-auto">
            <Panel heading="Sign up/Login">
              <Search
               
                handleInputChange={this.handleInputChange}
                handleFormSubmit={this.handleFormSubmit}
                handleloginSubmit={this.handleloginSubmit}
              />
        <div id= "result">
        </div>
    
            </Panel>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default OmdbContainer;
