import React, { Component } from 'react'
import * as API from "../utils/API"
import DoorTable from "./DoorTable"

export default class DoorsList extends Component {

    state = {
        doors: [],
    }

    componentWillMount() {
        API.getAllDoors().then(response => {
            if (response.status === !200) {
                window.alert('Error: Server is down!!', response.data.error)
            } else {
                this.setState({ doors })
            }
        })
    }

    render() {
        return (
            <div>
                {/* <a href="doors/create">
            <button> Create Door</button>
        </a> */}
                <div>
                    <DoorTable doors={this.state.doors} />
                </div>
            </div>
        )
    }
}
