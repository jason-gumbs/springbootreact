import axios from "axios";
const BASEURL = "http://localhost:8080/post";



  export let createUser = (query) =>{
    
    return axios.post(BASEURL, query);
  };

  export let login = (query) =>{
    
    return axios.post("http://localhost:8080/request", query);
  };
