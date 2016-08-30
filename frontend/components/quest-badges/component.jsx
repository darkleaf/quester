import React, { Component } from 'react';
import ClassNames from 'classnames';
import styles from './styles.css';

export default class QuestBadges extends Component {
  render() {
    return (
      <div className={styles.badges}>
        {this.props.children}
      </div>
    )
  }
}