import React, {Component} from 'react'
import {FormattedMessage} from 'react-intl'
import styles from './styles.css'

function Header({title, seeAllUrl, totalCount}) {
  return <div className={styles.header}>
    <div className={styles.title}>{title}</div>
    <div>
      <a href={seeAllUrl}>
        <FormattedMessage id="Slider.Header.totalCount" values={{totalCount}} />
      </a>
    </div>
  </div>
}


export default class Slider extends Component {
  render() {
    const columns = React.Children.count(this.props.children);
    return (
      <div className={styles.container}>

        <Header {...this.props} />

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
  title: React.PropTypes.string.isRequired,
  seeAllUrl: React.PropTypes.string.isRequired,
  totalCount: React.PropTypes.number.isRequired
};
