import React, {Component} from "react"
import {injectIntl, intlShape} from 'react-intl'
import styles from './styles.css'

class NavSearch extends Component {
  render() {
    const intl = this.props.intl;
    return (
      <div className={styles.container}>
        <input
          className={styles.input}
          placeholder={intl.formatMessage({id: 'NavSearch.placeholder'})} />
      </div>
    )
  }
}

NavSearch.propTypes = {
  intl: intlShape.isRequired
};

export default injectIntl(NavSearch)
