import React, { Component } from 'react';
import { FormattedNumber } from 'react-intl';
import styles from './styles.css';

export default class Price extends Component {
  render() {
    const { min, max } = this.props;
    return (
      <div className={styles.container}>
        <FormattedNumber
          value={min}
          style="currency"
          currency="rub"
          currencyDisplay="symbol"
          maximumFractionDigits={0}
        />
        &nbsp;&mdash;&nbsp;
        <FormattedNumber
          value={max}
          style="currency"
          currency="rub"
          currencyDisplay="symbol"
          maximumFractionDigits={0}
        />
      </div>
    );
  }
}

Price.propTypes = {
  min: React.PropTypes.number.isRequired,
  max: React.PropTypes.number.isRequired,
};
