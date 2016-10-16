import React, { Component } from 'react';
import styles from './styles.css';

export default class Gallery extends Component {
  render() {
    const { left, center, right } = this.props;
    return (
      <div className={styles.container}>
        <div className={styles.sections}>
          <div className={styles.leftSection}>
            <img src={left} />
          </div>

          <div className={styles.centerSection}>
            <div className={styles.leftArrow} />
            <img src={center} />
            <div className={styles.rightArrow} />
          </div>

          <div className={styles.rightSection}>
            <img src={right} />
          </div>
        </div>
      </div>
    );
  }
}

Gallery.propTypes = {
  left: React.PropTypes.string,
  center: React.PropTypes.string.isRequired,
  right: React.PropTypes.string,
}
