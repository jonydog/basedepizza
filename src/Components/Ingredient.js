import React, { Component } from 'react';
import $ from 'jquery';

class Ingredient extends React.Component{

render() {
  return (
    <tr>
      <td>{this.props.ingredient.name}</td>
    </tr>
  )
}
}

export default Ingredient;
