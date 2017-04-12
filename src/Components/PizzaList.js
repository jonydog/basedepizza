import React, { Component } from 'react';
import Pizza from './Pizza';
import PropTypes from 'prop-types';
import Coverflow from 'react-coverflow';

class PizzaList extends React.Component{
	render() {
		let pizzas;
		if(this.props.pizzas){
			pizzas = this.props.pizzas.map(pizza => {return(<Pizza key={pizza.id} pizza={pizza}/>)});
		}
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Vegetarian</th>
						<th>PriceEuros</th>
						<th>Ingredients</th>
					</tr>
					{pizzas}
				</tbody>
			</table>
		)
	}
}

export default PizzaList;
