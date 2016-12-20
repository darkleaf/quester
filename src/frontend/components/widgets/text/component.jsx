import React, { Component } from 'react';
import styles from './styles.css';

export default class Text extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

Text.propTypes = {
  children: React.PropTypes.any,
};
