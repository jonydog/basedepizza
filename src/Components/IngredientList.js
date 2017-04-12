import React, { Component } from 'react';
import Ingredient from './Ingredient';
import PropTypes from 'prop-types';

class IngredientList extends React.Component{
	render() {
		let ingredients;
		if(this.props.ingredients){
			ingredients = this.props.ingredients.map(ingredient => {return(<Ingredient key={ingredient.id} ingredient={ingredient}/>)});
		}
		return (
			<table>
				<tbody>
					{ingredients}
				</tbody>
			</table>
		)
	}
}

export default IngredientList;
