import React, {Component} from "react"
import styles from './styles.css'

export default class QuestCard extends Component {
  render() {
    return (
      <div className={styles.container}>
        <img className={styles.image} src={this.props.imageUrl} />
        <div className={styles.name}>{this.props.name}</div>
        <div className={styles.info}>
          <div className={styles.price}>
            {this.props.priceMin}
            -
            {this.props.priceMax}
          </div>
          <div className={styles.participants}>
            {this.props.participantsMin}
            -
            {this.props.participantsMax}
          </div>

          <div className={styles.rating}>
            {this.props.rating}
          </div>
        </div>
      </div>
    )
  }
}

QuestCard.propTypes = {
  name: React.PropTypes.string.isRequired,
  imageUrl: React.PropTypes.string.isRequired,

  priceMin: React.PropTypes.number.isRequired,
  priceMax: React.PropTypes.number.isRequired,

  participantsMin: React.PropTypes.number.isRequired,
  participantsMax: React.PropTypes.number.isRequired,

  rating: React.PropTypes.number.isRequired
};
