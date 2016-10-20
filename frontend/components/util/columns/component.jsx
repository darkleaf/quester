import React, { Component } from 'react';
import styles from './styles.css';

export default class Columns extends Component {
  render() {
    return (
      <div className={styles.container}>
        {React.Children.map(this.props.children, (child, idx) => {
           const fraction = this.props.fractions[idx];
           const columnClass = styles[`column-${fraction[0]}-${fraction[1]}`];
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
  fractions: React.PropTypes.arrayOf(React.PropTypes.array).isRequired,
};
