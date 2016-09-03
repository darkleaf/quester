import React, { Component } from 'react';
import styles from './styles.css';

export default class QuestsSets extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

QuestsSets.propTypes = {
  children: React.PropTypes.array.isRequired,
};
