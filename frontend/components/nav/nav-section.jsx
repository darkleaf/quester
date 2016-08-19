import React, { Component } from 'react';
import styles from './nav-section.css';

export default class NavSection extends Component {
  render() {
    return (
      <div className={styles.container}>
        {React.Children.map(this.props.children, child => {
          return (<div className={styles.item}>
            {child}
          </div>);
        })}
      </div>
    );
  }
}

NavSection.propTypes = {
};
