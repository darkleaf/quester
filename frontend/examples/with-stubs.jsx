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

function SelectionsSliderContainer(props, context) {
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
SelectionsSliderContainer.contextTypes = {
  SelectionCard: PropTypes.func.isRequired,
};
deps.SelectionsSlider = SelectionsSliderContainer;

function BestQuestsSliderContainer(props, context) {
  const { QuestCard } = context;
  return (
    <Slider
      title="Лучшие квесты"
      totalCount={14}
      seeAllUrl="/best"
    >
      <QuestCard id={1} />
      <QuestCard id={2} />
      <QuestCard id={3} />
      <QuestCard id={4} />
    </Slider>
  )
}
BestQuestsSliderContainer.contextTypes = {
  QuestCard: PropTypes.func.isRequired,
}
deps.BestQuestsSlider = BestQuestsSliderContainer;

function ReviewsSliderContainer(props, context) {
  const { ReviewCard } = context;
  return (
    <Slider
      title="Обзоры"
      totalCount={14}
      seeAllUrl="/reviews"
      highlighted
    >
      <ReviewCard id={1} />
      <ReviewCard id={2} />
      <ReviewCard id={3} />
      <ReviewCard id={4} />
    </Slider>
  )
}
ReviewsSliderContainer.contextTypes = {
  ReviewCard: PropTypes.func.isRequired,
}
deps.ReviewsSlider = ReviewsSliderContainer;

function NewQuestsSliderContainer(props, context) {
  const { QuestCard } = context;
  return (
    <Slider
      title="Новые квесты"
      totalCount={14}
      seeAllUrl="/new"
    >
      <QuestCard id={5} />
      <QuestCard id={6} />
      <QuestCard id={7} />
      <QuestCard id={8} />
    </Slider>
  )
}
NewQuestsSliderContainer.contextTypes = {
  QuestCard: PropTypes.func.isRequired,
}
deps.NewQuestsSlider = NewQuestsSliderContainer;

function CompaniesSliderContainer(props, context) {
  const { CompanyCard } = context;
  return (
    <Slider
      title="Компании"
      totalCount={14}
      seeAllUrl="/companies"
    >
      <CompanyCard id={1} />
      <CompanyCard id={2} />
      <CompanyCard id={3} />
      <CompanyCard id={4} />
      <CompanyCard id={5} />
      <CompanyCard id={6} />
    </Slider>
  )
}
CompaniesSliderContainer.contextTypes = {
  CompanyCard: PropTypes.func.isRequired,
}
deps.CompaniesSlider = CompaniesSliderContainer;

function SelectionCardContainer({ id }) {
  return (
    <SelectionCard
      name={`SelectionCard #${id}`}
      imageUrl="http://placehold.it/300x300"
    />
  );
}
deps.SelectionCard = SelectionCardContainer;

function QuestCardContainer({ id }) {
  return (
    <QuestCard
      name={`QuestCard #${id}`}
      imageUrl="http://placehold.it/300x210"
      priceMin={4500}
      priceMax={9500}
      participantsMin={2}
      participantsMax={5}
      rating={9.3}
    />
  )
}
deps.QuestCard = QuestCardContainer;

function ReviewCardContainer({ id }) {
  return (
    <ReviewCard
      name={`ReviewCard #${id}`}
      imageUrl="http://placehold.it/300x350"
    />
  )
}
deps.ReviewCard = ReviewCardContainer;

function CompanyCardContainer({id}) {
  return (
    <CompanyCard
      name={`CompanyCard #${id}`}
      imageUrl="http://placehold.it/190x140"
      questCount={id}
    />
  )
}
deps.CompanyCard = CompanyCardContainer;

export default class WithStubs extends Component {
  render() {
    return <DependencyProvider {...deps}>{this.props.children}</DependencyProvider>;
  }
}
