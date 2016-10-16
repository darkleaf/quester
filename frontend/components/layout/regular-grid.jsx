import React, { Component } from 'react';
import classNames from 'classnames';
import styles from './regular-grid.css';

export default class RegularGrid extends Component {
  render () {
    const containerClasses = classNames(
      styles.container,
      styles[`columns-${this.props.columns}`]
    );
    return (
      <div className={containerClasses}>
        {this.props.children}
      </div>
    );
  }
}

RegularGrid.propTypes = {
  children: React.PropTypes.array.isRequired,
  columns: React.PropTypes.oneOf(Array(12).fill().map((_, i) => i + 1)).isRequired,
}
