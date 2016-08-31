import React, { Component } from 'react';
import styles from './styles.css';

export default class Delimiter extends Component {
  render() {
    return (
      <div>
        <hr className={styles.delimiter} />
      </div>
    );
  }
}
