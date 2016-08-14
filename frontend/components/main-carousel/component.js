import React, {Component, PropTypes} from "react"
import classNames from 'classnames'
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
          <div className={styles.title} dangerouslySetInnerHTML={{__html: this.props.title}} />

          <ul className={styles.indicators}>
            {this.props.indicators.map(indicator => {
              const handler = indicator.onClick.bind(indicator);
              const classes = classNames(
                styles.indicator,
                {
                  [styles.activeIndicator]: indicator.active
                }
              );
              return <li onClick={handler} className={classes}/>
            })}
          </ul>
        </div>
      </div>
    )
  }
}

MainCarousel.propTypes = {
  title: PropTypes.string.isRequired,
  currentImageUrl: PropTypes.string.isRequired,
  indicators: PropTypes.arrayOf(PropTypes.object).isRequired,
  children: PropTypes.element
};
