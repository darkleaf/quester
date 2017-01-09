import React, { Component, PropTypes } from 'react';
import styles from './styles.css';

export default class Gallery extends Component {
  constructor(props) {
    super(props);
    this.state = {
      offset: 0,
    };

    this.handleLeftArrowClick = this.handleLeftArrowClick.bind(this);
    this.handleRightArrowClick = this.handleRightArrowClick.bind(this);
    this.windowLength = 3;
  }

  getWindow() {
    const { offset } = this.state;
    const count = this.props.imageUrls.length;
    const leftPart = this.props.imageUrls.slice(offset, offset + this.windowLength);
    const rightPart = this.props.imageUrls.slice(0, this.windowLength - leftPart.length);
    return leftPart.concat(rightPart);
  }

  handleLeftArrowClick() {
    const { offset } = this.state;
    const count = this.props.imageUrls.length;
    const newOffset = offset === 0 ? count - 1 : offset - 1;
    this.setState({ offset: newOffset });
  }

  handleRightArrowClick() {
    const { offset } = this.state;
    const count = this.props.imageUrls.length;
    const newOffset = offset === count - 1 ? 0 : offset + 1;
    this.setState({ offset: newOffset });
  }

  render() {
    const [left, center, right] = this.getWindow();

    return (
      <div className={styles.container}>
        <div className={styles.sections}>
          <div className={styles.leftSection}>
            <img src={left} />
          </div>

          <div className={styles.centerSection}>
            <div
              onClick={this.handleLeftArrowClick}
              className={styles.leftArrow}
            />
            <img src={center} />
            <div
              onClick={this.handleRightArrowClick}
              className={styles.rightArrow}
            />
          </div>

          <div className={styles.rightSection}>
            <img src={right} />
          </div>
        </div>
      </div>
    );
  }
}

Gallery.propTypes = {
  imageUrls: PropTypes.arrayOf(PropTypes.string),
};
