import React, { Component } from 'react';
import { FormattedNumber } from 'react-intl';
import styles from './styles.css';

function Price({ min, max }) {
  return (
    <div className={styles.price}>
      <FormattedNumber
        value={min} style="currency"
        currency="rub" currencyDisplay="symbol"
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

function Participants({ min, max }) {
  return (
    <div className={styles.participants}>
      {min}&mdash;{max}
    </div>
  );
}

function Rating({ value }) {
  return (
    <div className={styles.rating}>
      <FormattedNumber value={value} minimumFractionDigits={0} maximumFractionDigits={1} />
    </div>
  );
}

export default class QuestCard extends Component {
  render() {
    return (
      <div className={styles.container}>
        <img className={styles.image} src={this.props.imageUrl} role="presentation" />
        <div className={styles.name}>{this.props.name}</div>
        <div className={styles.info}>
          <Price min={this.props.priceMin} max={this.props.priceMax} />
          <Participants min={this.props.participantsMin} max={this.props.participantsMax} />
          <Rating value={this.props.rating} />
        </div>
      </div>
    );
  }
}

Price.propTypes = {
  min: React.PropTypes.number.isRequired,
  max: React.PropTypes.number.isRequired,
};

Participants.propTypes = {
  min: React.PropTypes.number.isRequired,
  max: React.PropTypes.number.isRequired,
};

Rating.propTypes = {
  value: React.PropTypes.number.isRequired,
};

QuestCard.propTypes = {
  name: React.PropTypes.string.isRequired,
  imageUrl: React.PropTypes.string.isRequired,

  priceMin: React.PropTypes.number.isRequired,
  priceMax: React.PropTypes.number.isRequired,

  participantsMin: React.PropTypes.number.isRequired,
  participantsMax: React.PropTypes.number.isRequired,

  rating: React.PropTypes.number.isRequired,
};
