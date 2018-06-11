import React, { Component } from 'react'
import Modal from "react-responsive-modal";


export default class LandingPage extends Component {

    state = {
        
        open:false
       }

       onOpenModal = () => {
        this.setState({ open: true });
      };
    
      onCloseModal = () => {
        this.setState({ open: false });
      };


  render() {
    const { open } = this.state


    return (
      <div>
          <h1 className="App-title"> Home Depot</h1>
          <button onClick={ this.onOpenModal }>Welcome </button>
          <Modal open={open} onClose={ this.onCloseModal } little>
          <h1>Welcome To Doors Warehouse</h1>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam
            pulvinar risus non risus hendrerit venenatis. Pellentesque sit amet
            hendrerit risus, sed porttitor quam.
          </p>
        </Modal>
        
      </div>
    )
  }
}
