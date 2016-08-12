import React, {Component} from "react"
import styles from './styles.css'

export default class MainCarousel extends Component {
  render() {
    return (
      <div className={styles.container}>
        main-carousel
        <div className={styles.inner}>{this.props.children}</div>
      </div>
    )
  }
}

MainCarousel.propTypes = {
  children: React.PropTypes.element
};
