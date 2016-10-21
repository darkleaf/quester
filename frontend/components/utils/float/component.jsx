import React, { Component } from 'react';
import classNames from 'classnames';
import styles from './styles.css';

export default class Float extends Component {
  render() {
    const containerClassNames = classNames(
      styles.container,
      styles[`align-${this.props.align}`],
    );
    return (
      <div className={containerClassNames}>
        {this.props.children}
      </div>
    );
  }
}

Float.propTypes = {
  children: React.PropTypes.any.isRequired,
  align: React.PropTypes.oneOf(['left', 'center', 'right', 'space-between']),
};
