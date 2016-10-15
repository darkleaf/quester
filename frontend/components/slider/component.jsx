import React, { Component } from 'react';
import { FormattedMessage } from 'react-intl';
import classNames from 'classnames';
import styles from './styles.css';

function Header({ title, seeAllUrl, totalCount }) {
  return (
    <div className={styles.header}>
      <div className={styles.title}>{title}</div>
      <div>
        <a href={seeAllUrl}>
          <FormattedMessage id="Slider.Header.totalCount" values={{ totalCount }} />
        </a>
      </div>
    </div>
  );
}

Header.propTypes = {
  title: React.PropTypes.string.isRequired,
  seeAllUrl: React.PropTypes.string.isRequired,
  totalCount: React.PropTypes.number.isRequired,
};

export default class Slider extends Component {
  constructor(props) {
    super(props);
    this.renderChild = this.renderChild.bind(this);
  }

  renderChild(child) {
    const columns = React.Children.count(this.props.children);
    return <div className={styles[`item-${columns}`]}>{child}</div>;
  }

  render() {
    const containerClasses = classNames(
      styles.container,
      { [styles.highlighted]: this.props.highlighted }
    );
    return (
      <div className={containerClasses}>
        <div className={styles.inner}>
          <Header {...this.props} />

          <div className={styles.content}>
            <div className={styles.leftArrow}>&lt;</div>

            <div className={styles.list}>
              {React.Children.map(this.props.children, this.renderChild)}
            </div>

            <div className={styles.rightArrow}>&gt;</div>
          </div>
        </div>
      </div>
    );
  }
}

Slider.propTypes = {
  children: React.PropTypes.array.isRequired,
  highlighted: React.PropTypes.bool,
};
