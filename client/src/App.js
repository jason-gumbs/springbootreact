import React, { Component } from "react";
import LoginPage from "./components/LoginPage";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'



class App extends Component {


    render() {
        return (
            <div>
            <Router>
                <Switch>
                    <Route exact path="/" component={LoginPage} />
                    {/* <Route exact path="/" component={LandingPage} />
                    <Route exact path="/doors" component={DoorsList} />
                    <Route exact path="/doors/create" component={Form} />
                    <Route exact path="/doors/:doorId" component={SingleDoor} /> */}
                </Switch>
            </Router>
            </div>
        )
    }

}
export default App;
