import React, { Component } from 'react';
import styles from './styles.css';

export default class NavSection extends Component {
  renderChild(child) {
    return <div className={styles.item}>{child}</div>;
  }

  render() {
    return (
      <div className={styles.container}>
        {React.Children.map(this.props.children, this.renderChild)}
      </div>
    );
  }
}

NavSection.propTypes = {
  children: React.PropTypes.array.isRequired,
};
