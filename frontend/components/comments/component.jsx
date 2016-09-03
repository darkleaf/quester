import React, { Component } from 'react';
import styles from './styles.css';

export default class Comments extends Component {
  render() {
    return (
      <div className={styles.container}>
        Comments
        {this.props.children}
      </div>
    );
  }
}

Comments.propTypes = {
  children: React.PropTypes.array.isRequired,
};
