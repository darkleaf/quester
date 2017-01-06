import React, { Component, PropTypes } from 'react';

import PubLayout from '../../layout/pub-layout';

export default class MainPage extends Component {
  render() {
    const {
      nav,
      mainCarousel,
      selectionsSlider,
      bestQuestsSlider,
      reviewsSlider,
      newQuestsSlider,
      companiesSlider,
    } = this.props;
    return (
      <PubLayout nav={nav}>
        {mainCarousel}
        {selectionsSlider}
        {bestQuestsSlider}
        {reviewsSlider}
        {newQuestsSlider}
        {companiesSlider}
      </PubLayout>
    );
  }
}

MainPage.propTypes = {
  nav: PropTypes.object.isRequired,
  mainCarousel: PropTypes.object.isRequired,
  selectionsSlider: PropTypes.object.isRequired,
  bestQuestsSlider: PropTypes.object.isRequired,
  reviewsSlider: PropTypes.object.isRequired,
  newQuestsSlider: PropTypes.object.isRequired,
  companiesSlider: PropTypes.object.isRequired,
};
