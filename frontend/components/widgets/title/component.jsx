import React, { Component } from 'react';
import styles from './styles.css';

export default class Title extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

Title.propTypes = {
  children: React.PropTypes.any,
};
