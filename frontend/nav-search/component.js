import React, {Component} from "react"
import styles from './styles.css'

export default class NavSearch extends Component {
  render() {
    return (
      <div className={styles.container}>
        <input className={styles.input} placeholder={this.props.placeholder} />
      </div>
    )
  }
}

NavSearch.propTypes = {
  placeholder: React.PropTypes.string.isRequired
};
