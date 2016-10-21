import React, { Component } from 'react';
import styles from './styles.css';

export default class WithHorizontalRule extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

WithHorizontalRule.propTypes = {
  children: React.PropTypes.any,
};
