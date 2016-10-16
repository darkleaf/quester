import React, { Component } from 'react';
import Price from '../../widgets/price';
import Icon from '../../widgets/icon';
import Rating from '../../widgets/rating';
import styles from './styles.css';

function Participants({ min, max }) {
  return (
    <div>
      <Icon>
        {min}&mdash;{max}
      </Icon>
    </div>
  );
}

Participants.propTypes = {
  min: React.PropTypes.number.isRequired,
  max: React.PropTypes.number.isRequired,
};

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

QuestCard.propTypes = {
  name: React.PropTypes.string.isRequired,
  imageUrl: React.PropTypes.string.isRequired,

  priceMin: React.PropTypes.number.isRequired,
  priceMax: React.PropTypes.number.isRequired,

  participantsMin: React.PropTypes.number.isRequired,
  participantsMax: React.PropTypes.number.isRequired,

  rating: React.PropTypes.number.isRequired,
};
