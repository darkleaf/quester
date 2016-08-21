import React, { Component } from 'react';
import classNames from 'classnames';
import styles from './styles.css';


export default class ContentSection extends Component {
  render() {
    const classes = classNames(
      styles.container,
      { [styles.highlighted]: this.props.highlighted }
    );
    return (
      <div className={classes}>
        <div className={styles.inner}>
          {this.props.children}
        </div>
      </div>
    );
  }
}

ContentSection.propTypes = {
  highlighted: React.PropTypes.bool,
  children: React.PropTypes.element.isRequired,
};

ContentSection.defaultProps = {
  highlighted: false,
};
