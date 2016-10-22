import React, { Component, PropTypes } from 'react';

import Canvas from '../../layout/canvas';
import Nav from '../../layout/nav';

import NavSection from '../../layout/nav-section';
import NavBrand from '../../layout/nav-brand';
import NavItem from '../../layout/nav-item';
import NavSearch from '../../layout/nav-search';


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

          {/* TODO: use correct markup and switch to DI */}
          <NavSection>
            <NavBrand name="Quester" />
            <NavItem name="Квесты" />
            <NavItem name="Подборки" />
            <NavItem name="Обзоры" />
            <NavItem name="Компании" />
            <NavSearch />
          </NavSection>
          <NavSection>
            <NavItem name="Москва" />
            <NavItem name="Избранное" />
            <NavItem name="Выйти" />
          </NavSection>

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
