import React, { Component, PropTypes } from 'react';

import PubLayout from '../../layout/pub-layout';

export default class MainPage extends Component {
  render() {
    const {
      Nav,
      MainCarousel,
      SelectionsSlider,
      BestQuestsSlider,
      ReviewsSlider,
      NewQuestsSlider,
      CompaniesSlider,
    } = this.props;
    return (
      <PubLayout Nav={Nav}>
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

MainPage.propTypes = {
  Nav: PropTypes.func.isRequired,
  MainCarousel: PropTypes.func.isRequired,
  SelectionsSlider: PropTypes.func.isRequired,
  BestQuestsSlider: PropTypes.func.isRequired,
  ReviewsSlider: PropTypes.func.isRequired,
  NewQuestsSlider: PropTypes.func.isRequired,
  CompaniesSlider: PropTypes.func.isRequired,
};
