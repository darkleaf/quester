import React, { Component, PropTypes } from 'react';
import DependencyProvider from '../components/dependency-provider';

import MainCarousel from '../components/layout/main-carousel';
import MainFilter from '../components/layout/main-filter';

import Slider from '../components/layout/slider';
import SelectionCard from '../components/entities/selection-card';
import ReviewCard from '../components/entities/review-card';
import CompanyCard from '../components/entities/company-card';
import QuestCard from '../components/entities/quest-card';

const deps = {};

function MainCarouselContainer() {
  return (
    <MainCarousel
      title="<b>Москва 2048,</b> Клаустрофобия"
      currentImageUrl="http://placehold.it/1900x500"
      indicators={[
        { onClick: () => null },
        { onClick: () => null, active: true },
        { onClick: () => null },
      ]}
    >
      <MainFilter />
    </MainCarousel>
  );
}
deps.MainCarousel = MainCarouselContainer;

function SelectionCardSliderContainer(props, context) {
  const { SelectionCard } = context;
  return (
    <Slider
      title="Подборки квестов"
      totalCount={26}
      seeAllUrl="/selections"
    >
      <SelectionCard id={1} />
      <SelectionCard id={2} />
      <SelectionCard id={3} />
      <SelectionCard id={4} />
    </Slider>
  );
}
SelectionCardSliderContainer.contextTypes = {
  SelectionCard: PropTypes.func.isRequired,
};
deps.SelectionCardSlider = SelectionCardSliderContainer;

function SelectionCardContainer({ id }) {
  return (
    <SelectionCard
      name={`SelectionCard #${id}`}
      imageUrl="http://placehold.it/300x300"
    />
  );
}
deps.SelectionCard = SelectionCardContainer;

export default class WithStubs extends Component {
  render() {
    return <DependencyProvider {...deps}>{this.props.children}</DependencyProvider>;
  }
}
