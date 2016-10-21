import React, { Component } from 'react';
import styles from './styles.css';

const fractionRegex = /(\d+)\/(\d+)/;

function fractionComponents(fraction) {
  const matches = fraction.match(fractionRegex);
  return [matches[1], matches[2]];
}

export default class Columns extends Component {
  render() {
    return (
      <div className={styles.container}>
        {React.Children.map(this.props.children, (child, idx) => {
           const fraction = this.props.fractions[idx];
           const [numerator, denominator] = fractionComponents(fraction);
           const columnClass = styles[`column-${numerator}-${denominator}`];
           return (
             <div className={columnClass}>
             {child}
             </div>
           )
         })}
      </div>
    );
  }
}

Columns.propTypes = {
  children: React.PropTypes.any.isRequired,
  fractions: function(props, propName, componentName) {
    const error = new Error('Invalid prop `' + propName + '` supplied to' + ' `' + componentName + '`. Validation failed.');

    if (!props.fractions.every(f => fractionRegex.test(f))) return error;

    const childrenCount = React.Children.count(props.children);
    const fractionsCount = props.fractions.length;
    if (fractionsCount != childrenCount) return error;
  }
};
