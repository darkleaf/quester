import React, { Component } from 'react';
import styles from './styles.css';

export default class NavBrand extends Component {
  render() {
    const { name, url } = this.props;
    return (
      <div className={styles.container}>
        <a href={url}>{name}</a>
      </div>
    );
  }
}

NavBrand.propTypes = {
  name: React.PropTypes.string.isRequired,
  url: React.PropTypes.string.isRequired,
};
