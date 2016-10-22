import React, { Component, PropTypes } from 'react';

import Canvas from '../../layout/canvas';
import Nav from '../../layout/nav';

export default class MainPage extends Component {
  render() {
    const { MainCarousel,
            SelectionsSlider,
            BestQuestsSlider,
            ReviewsSlider,
            NewQuestsSlider,
            CompaniesSlider,
    } = this.context;
    return (
      <Canvas>
        <Nav>
          foo
        </Nav>
        <MainCarousel />
        <SelectionsSlider />
        <BestQuestsSlider />
        <ReviewsSlider />
        <NewQuestsSlider />
        <CompaniesSlider />
      </Canvas>
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
