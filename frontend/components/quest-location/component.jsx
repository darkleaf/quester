import React, { Component } from 'react';
import styles from './styles.css';

export default class QuestLocation extends Component {
  render() {
    return (
      <div className={styles.location}>
        {this.props.children}
      </div>
    );
  }
}

QuestLocation.propTypes = {
  children: React.PropTypes.array.isRequired,
};
