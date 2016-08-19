import React, { Component } from 'react';
import { FormattedMessage } from 'react-intl';
import styles from './styles.css';

export default class CompanyCard extends Component {
  render() {
    return (
      <div className={styles.container}>
        <img className={styles.image} src={this.props.imageUrl} role="presentation" />
        <div className={styles.name}>{this.props.name}</div>
        <div className={styles.questCount}>
          <FormattedMessage
            id="CompanyCard.questCount"
            values={{ questCount: this.props.questCount }}
          />
        </div>
      </div>
    );
  }
}

CompanyCard.propTypes = {
  name: React.PropTypes.string.isRequired,
  imageUrl: React.PropTypes.string.isRequired,
  questCount: React.PropTypes.number.isRequired,
};
