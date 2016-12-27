import React, { Component, Children, PropTypes } from 'react';
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
  title: PropTypes.string.isRequired,
  seeAllUrl: PropTypes.string.isRequired,
  totalCount: PropTypes.number.isRequired,
};

export default class Slider extends Component {
  constructor(props) {
    super(props);
    this.state = {
      offset: 0,
    };

    this.handleLeftArrowClick = this.handleLeftArrowClick.bind(this);
    this.handleRightArrowClick = this.handleRightArrowClick.bind(this);
  }

  getWindow() {
    const { offset } = this.state;
    const { windowLength } = this.props;
    const children = Children.toArray(this.props.children);
    const leftPart = children.slice(offset, offset + windowLength);
    const rightPart = children.splice(0, offset - (children.length - windowLength));
    return leftPart.concat(rightPart);
  }

  handleLeftArrowClick() {
    const { offset } = this.state;
    const count = Children.count(this.props.children);
    const newOffset = offset === 0 ? count - 1 : offset - 1;
    this.setState({ offset: newOffset });
  }

  handleRightArrowClick() {
    const { offset } = this.state;
    const count = Children.count(this.props.children);
    const newOffset = offset === count - 1 ? 0 : offset + 1;
    this.setState({ offset: newOffset });
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
            <div
              onClick={this.handleLeftArrowClick}
              className={styles.leftArrow}
            >
              &lt;
            </div>

            <div className={styles.children}>
              {this.getWindow()}
            </div>

            <div
              onClick={this.handleRightArrowClick}
              className={styles.rightArrow}
            >
              &gt;
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Slider.propTypes = {
  children: PropTypes.array.isRequired,
  highlighted: PropTypes.bool,
  windowLength: PropTypes.number.isRequired,
};
