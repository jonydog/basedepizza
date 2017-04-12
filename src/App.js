import React, { Component } from 'react';
import $ from 'jquery';
import './App.css';
import PizzaList from './Components/PizzaList';
import Slider from './Components/Slider';
import cors from 'cors';

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {pizzas: []};
	}

  getPizzas(){
    $.ajax({
      url: 'http://localhost:8080/pizzas/all',
      dataType: 'json',
      cache: false,
      success: function(data){
        this.setState({pizzas:data}, function(){
            console.log(this.state);
        });
      }.bind(this),
      error: function(xhr, status, err){
        console.log(err);
      }
    });
  }

	componentWillMount(){
		this.state.pizzas = this.getPizzas();
	}

	componentDidMount() {
		this.state.pizzas = this.getPizzas();
	}

	render() {
		return (
			<div className=" App">
				<h1> Select your pizza </h1>
				<br />
				<Slider />
				<PizzaList pizzas={this.state.pizzas}/>
			</div>
		);
	}
}

export default App;
