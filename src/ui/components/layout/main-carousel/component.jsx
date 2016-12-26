import React, { Component, PropTypes } from 'react';
import classNames from 'classnames';
import styles from './styles.css';

export default class MainCarousel extends Component {
  constructor(props) {
    super(props);
    this.state = {
      currentIndex: 0,
    };
  }

  handleClick(index) {
    this.setState({ currentIndex: index });
  }

  render() {
    const currentSlide = this.props.slides[this.state.currentIndex];
    return (
      <div className={styles.container}>
        <img
          className={styles.image}
          src={currentSlide.imageUrl}
          role="presentation"
        />

        <div className={styles.inner}>
          {this.props.children}
        </div>

        <div className={styles.bottom}>
          <div
            className={styles.title}
            dangerouslySetInnerHTML={{ __html: currentSlide.title }}
          />

          <ul className={styles.indicators}>
            {this.props.slides.map((slide, index) => {
              const classes = classNames(
                 styles.indicator,
                {
                  [styles.activeIndicator]: this.state.currentIndex === index,
                }
               );
              return (
                <li
                  key={index}
                  className={classes}
                  onClick={this.handleClick.bind(this, index)}
                />
              );
            })}
          </ul>
        </div>
      </div>
    );
  }
}

MainCarousel.propTypes = {
  slides: PropTypes.arrayOf(PropTypes.shape({
    title: PropTypes.string.isRequired,
    imageUrl: PropTypes.string.isRequired,
  })),
  children: PropTypes.element,
};
