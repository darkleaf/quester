import React, { Component, Children } from 'react';
import { FormattedMessage } from 'react-intl';
import classNames from 'classnames';
import Float from '../../utils/float';
import Title from '../../widgets/title';
import styles from './styles.css';

function Header({ title, seeAllUrl, totalCount }) {
  return (
    <Float align="left">
      <Title>{title}</Title>
      <div>
        <a href={seeAllUrl}>
          <FormattedMessage id="Slider.Header.totalCount" values={{ totalCount }} />
        </a>
      </div>
    </Float>
  );
}

Header.propTypes = {
  title: React.PropTypes.string.isRequired,
  seeAllUrl: React.PropTypes.string.isRequired,
  totalCount: React.PropTypes.number.isRequired,
};

export default class Slider extends Component {
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

            <div className={styles.children}>
              {Children.toArray(this.props.children).slice(0, 4)}
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
