import React from 'react';
import styles from './styles.css';

export default function NavBrand({ name, url }) {
  return (
    <div className={styles.container}>
      <a href={url}>{name}</a>
    </div>
  );
}

NavBrand.propTypes = {
  name: React.PropTypes.string.isRequired,
  url: React.PropTypes.string.isRequired,
};
