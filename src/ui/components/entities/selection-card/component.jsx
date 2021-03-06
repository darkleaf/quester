import React, { Component } from 'react';
import styles from './styles.css';

export default class SelectionCard extends Component {
  render() {
    return (
      <div className={styles.container}>
        <img className={styles.image} src={this.props.imageUrl} role="presentation" />
        <div className={styles.name}>{this.props.name}</div>
      </div>
    );
  }
}

SelectionCard.propTypes = {
  name: React.PropTypes.string.isRequired,
  imageUrl: React.PropTypes.string.isRequired,
};
