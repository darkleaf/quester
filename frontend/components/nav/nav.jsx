import React, { Component } from 'react';
import styles from './nav.css';

export default class Nav extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

Nav.propTypes = {
};
