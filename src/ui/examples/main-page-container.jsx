import React, { Component, PropTypes } from 'react';

import MainPage from '../components/pages/main';

import Nav from '../components/layout/nav';
import NavSection from '../components/layout/nav-section';
import NavBrand from '../components/layout/nav-brand';
import NavItem from '../components/layout/nav-item';
import NavSearch from '../components/layout/nav-search';
import MainCarousel from '../components/layout/main-carousel';
import MainFilter from '../components/layout/main-filter';
import Slider from '../components/layout/slider';
import Gallery from '../components/layout/gallery';
import SelectionCard from '../components/entities/selection-card';
import ReviewCard from '../components/entities/review-card';
import CompanyCard from '../components/entities/company-card';
import QuestCard from '../components/entities/quest-card';

function NavContainer() {
  return (
    <Nav>
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
  );
}

function MainCarouselContainer() {
  return (
    <MainCarousel
      slides={[
        {
          title: '<b>Москва 2048,</b> Клаустрофобия',
          imageUrl: 'http://placehold.it/1900x500',
        },
        {
          title: '2',
          imageUrl: 'http://placehold.it/1900x500',
        },
        {
          title: '3',
          imageUrl: 'http://placehold.it/1900x500',
        },
      ]}
    >
      <MainFilter />
    </MainCarousel>
  );
}

function SelectionCardContainer({id}) {
  return (
    <SelectionCard
      name={`SelectionCard ${id}`}
      imageUrl="http://placehold.it/300x300"
    />
  )
}

function QuestCardContainer({id}) {
  return (
    <QuestCard
      name={`QuestCard ${id}`}
      url="/some-url"
      imageUrl="http://placehold.it/300x210"
      priceMin={4500}
      priceMax={9500}
      participantsMin={2}
      participantsMax={5}
      rating={9.3}
    />
  )
}

function ReviewCardContainer({id}) {
  return (
    <ReviewCard
      name={`ReviewCard ${id}`}
      imageUrl="http://placehold.it/300x350"
    />
  )
}

function CompanyCardContainer({id}) {
  return (
    <CompanyCard
      name={`CompanyCard ${id}`}
      imageUrl="http://placehold.it/190x140"
      questCount={7}
    />
  )
}

function SelectionsSliderContainer() {
  return (
    <Slider
      title="Подборки квестов"
      totalCount={26}
      seeAllUrl="/selections"
      windowLength={4}
    >
      <SelectionCardContainer id="1" />
      <SelectionCardContainer id="2" />
      <SelectionCardContainer id="3" />
      <SelectionCardContainer id="4" />
      <SelectionCardContainer id="5" />
    </Slider>
  );
}

function BestQuestsSliderContainer() {
  return (
    <Slider
      title="Лучшие квесты"
      totalCount={14}
      seeAllUrl="/best"
      windowLength={4}
    >
      <QuestCardContainer id="1" />
      <QuestCardContainer id="2" />
      <QuestCardContainer id="3" />
      <QuestCardContainer id="4" />
      <QuestCardContainer id="5" />
    </Slider>
  );
}

function ReviewsSliderContainer() {
  return (
    <Slider
      title="Обзоры"
      totalCount={14}
      seeAllUrl="/reviews"
      windowLength={4}
      highlighted
    >
      <ReviewCardContainer id="1" />
      <ReviewCardContainer id="2" />
      <ReviewCardContainer id="3" />
      <ReviewCardContainer id="4" />
      <ReviewCardContainer id="5" />
    </Slider>
  );
}

function NewQuestsSliderContainer() {
  return (
    <Slider
      title="Новые квесты"
      totalCount={14}
      seeAllUrl="/new"
      windowLength={4}
    >
      <QuestCardContainer id="1" />
      <QuestCardContainer id="2" />
      <QuestCardContainer id="3" />
      <QuestCardContainer id="4" />
      <QuestCardContainer id="5" />
    </Slider>
  );
}

function CompaniesSliderContainer() {
  return (
    <Slider
      title="Компании"
      totalCount={14}
      seeAllUrl="/companies"
      windowLength={6}
    >
      <CompanyCardContainer id="1" />
      <CompanyCardContainer id="2" />
      <CompanyCardContainer id="3" />
      <CompanyCardContainer id="4" />
      <CompanyCardContainer id="5" />
      <CompanyCardContainer id="6" />
      <CompanyCardContainer id="7" />
    </Slider>
  );
}

export default class MainPageContainer extends Component {
  render() {
    return (
      <MainPage
        Nav={NavContainer}
        MainCarousel={MainCarouselContainer}
        SelectionsSlider={SelectionsSliderContainer}
        BestQuestsSlider={BestQuestsSliderContainer}
        ReviewsSlider={ReviewsSliderContainer}
        NewQuestsSlider={NewQuestsSliderContainer}
        CompaniesSlider={CompaniesSliderContainer}
      />
    )
  }
}
