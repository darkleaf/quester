import React, {Component} from "react"
import styles from './styles.css'

export default class MainCarousel extends Component {
  render() {
    return (
      <div className={styles.container}>
        <img className={styles.image}
             src={this.props.currentImageUrl} />

        <div className={styles.inner}>
          {this.props.children}
        </div>

        <div className={styles.bottom}>
          <div dangerouslySetInnerHTML={{__html: this.props.title}} />
        </div>
      </div>
    )
  }
}

MainCarousel.propTypes = {
  title: React.PropTypes.string.isRequired,
  currentImageUrl: React.PropTypes.string.isRequired,
  children: React.PropTypes.element
};
