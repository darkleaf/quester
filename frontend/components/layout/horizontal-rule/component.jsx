import React, { Component } from 'react';
import styles from './styles.css';

export default class HorizontalRule extends Component {
  render() {
    return (
      <hr className={styles.horizontalLine} />
    );
  }
}
