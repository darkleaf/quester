import React, { Component } from 'react';
import styles from './styles.css';

export default class Canvas extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

Canvas.propTypes = {
  children: React.PropTypes.array.isRequired,
};
