import React, { Component } from 'react';
import styles from './styles.css';

export default class NavSection extends Component {
  render() {
    return (
      <div className={styles.container}>
        {this.props.children}
      </div>
    );
  }
}

NavSection.propTypes = {
  children: React.PropTypes.array.isRequired,
};
