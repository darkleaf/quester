import React, { Component } from 'react';
import styles from './styles.css';

export default class Similar extends Component {
  render() {
    return (
      <div className={styles.similar}>
        {this.props.children}
      </div>
    );
  }
}

Similar.propTypes = {
  children: React.PropTypes.array.isRequired,
};
