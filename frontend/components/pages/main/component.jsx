import React, { Component, PropTypes } from 'react';

import PubLayout from '../../layout/pub-layout';

export default class MainPage extends Component {
  render() {
    const {
      MainCarousel,
      SelectionsSlider,
      BestQuestsSlider,
      ReviewsSlider,
      NewQuestsSlider,
      CompaniesSlider,
    } = this.context;
    return (
      <PubLayout>
        <MainCarousel />
        <SelectionsSlider />
        <BestQuestsSlider />
        <ReviewsSlider />
        <NewQuestsSlider />
        <CompaniesSlider />
      </PubLayout>
    );
  }
}

MainPage.contextTypes = {
  MainCarousel: PropTypes.func.isRequired,
  SelectionsSlider: PropTypes.func.isRequired,
  BestQuestsSlider: PropTypes.func.isRequired,
  ReviewsSlider: PropTypes.func.isRequired,
  NewQuestsSlider: PropTypes.func.isRequired,
  CompaniesSlider: PropTypes.func.isRequired,
};
