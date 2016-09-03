import React, { Component } from 'react';
import styles from './styles.css';

export default class QuestBadges extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

QuestBadges.propTypes = {
  children: React.PropTypes.array.isRequired,
};
