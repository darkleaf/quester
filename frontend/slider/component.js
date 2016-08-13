import React, {Component} from 'react'
import styles from './styles.css'

export default class Slider extends Component {
  render() {
    const columns = React.Children.count(this.props.children);
    return (
      <div className={styles.container}>

        <div className={styles.header}>
          <div>{this.props.title}</div>
        </div>

        <div className={styles.content}>
          <div className={styles.leftArrow}>&lt;</div>

          <div className={styles.list}>
            {React.Children.map(this.props.children, (child) => {
              return <div className={styles[`item-${columns}`]}>
                {child}
              </div>
            })}
          </div>

          <div className={styles.rightArrow}>&gt;</div>
        </div>
      </div>
    )
  }
}

Slider.propTypes = {
  title: React.PropTypes.string.isRequired
};
