import React, { Component } from 'react';
import $ from 'jquery';
import IngredientList from './IngredientList';

class Pizza extends React.Component{
	constructor(props){
		super(props);
		this.state={ingredients: []};
	}

	getIngredients(){
		$.ajax({
			url: 'http://localhost:8080/pizzas/' + this.props.pizza.id + '/ingredients',
			dataType: 'json',
			cache: false,
			success: function(data){
				this.setState({ingredients:data}, function(){
						console.log(this.state);
				});
			}.bind(this),
			error: function(xhr, status, err){
				console.log(err);
			}
		});
	}

	componentWillMount(){
		this.state.ingredients = this.getIngredients();
	}

	componentDidMount() {
		this.state.ingredients = this.getIngredients();
	}

	render() {
		return (
			<tr>
				<td>{this.props.pizza.name}</td>
				<td>{this.props.pizza.description}</td>
				<td>{this.props.pizza.isVegetarian.toString()}</td>
				<td>{this.props.pizza.priceInEuros}</td>
				<IngredientList ingredients={this.state.ingredients} />
			</tr>
		)
	}
}

export default Pizza;
