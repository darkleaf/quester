import React, { Component } from 'react';
import styles from './styles.css';

export default class BadgesList extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

BadgesList.propTypes = {
  children: React.PropTypes.array.isRequired,
};
