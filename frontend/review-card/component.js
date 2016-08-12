import React, {Component} from "react"
import styles from './styles.css'

export default class ReviewCard extends Component {
  render() {
    return (
      <div className={styles.container}>
        <div>{this.props.name}</div>
      </div>
    )
  }
}

ReviewCard.propTypes = {
  name: React.PropTypes.string.isRequired
};
