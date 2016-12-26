/* eslint no-shadow: "off", react/prop-types: "off", no-empty-pattern: "off" */

import React, { PropTypes } from 'react';
import DependencyProvider from '../components/dependency-provider';

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
import SimilarQuests from '../components/entities/quest/similar-quests';

import QuestDescription from '../components/entities/quest/description';
import QuestSchedule from '../components/entities/quest/schedule';
import QuestLocation from '../components/entities/quest/location';

const deps = {};

function LeftNavSectionContainer() {
  return (
    <NavSection>
      <NavBrand name="Quester" />
      <NavItem name="Квесты" />
      <NavItem name="Подборки" />
      <NavItem name="Обзоры" />
      <NavItem name="Компании" />
      <NavSearch />
    </NavSection>
  );
}
deps.LeftNavSection = LeftNavSectionContainer;

function RightNavSectionContainer() {
  return (
    <NavSection>
      <NavItem name="Москва" />
      <NavItem name="Избранное" />
      <NavItem name="Выйти" />
    </NavSection>
  );
}
deps.RightNavSection = RightNavSectionContainer;

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

function SelectionsSliderContainer() {
  return (
    <Slider
      title="Подборки квестов"
      totalCount={26}
      seeAllUrl="/selections"
    >
      <SelectionCard
        name="SelectionCard 1"
        imageUrl="http://placehold.it/300x300"
      />
      <SelectionCard
        name="SelectionCard 2"
        imageUrl="http://placehold.it/300x300"
      />
      <SelectionCard
        name="SelectionCard 3"
        imageUrl="http://placehold.it/300x300"
      />
      <SelectionCard
        name="SelectionCard 4"
        imageUrl="http://placehold.it/300x300"
      />
    </Slider>
  );
}
deps.SelectionsSlider = SelectionsSliderContainer;

function BestQuestsSliderContainer() {
  return (
    <Slider
      title="Лучшие квесты"
      totalCount={14}
      seeAllUrl="/best"
    >
      <QuestCard
        name="QuestCard 1"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 2"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 3"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 4"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
    </Slider>
  );
}
deps.BestQuestsSlider = BestQuestsSliderContainer;

function ReviewsSliderContainer() {
  return (
    <Slider
      title="Обзоры"
      totalCount={14}
      seeAllUrl="/reviews"
      highlighted
    >
      <ReviewCard
        name="ReviewCard 1"
        imageUrl="http://placehold.it/300x350"
      />
      <ReviewCard
        name="ReviewCard 2"
        imageUrl="http://placehold.it/300x350"
      />
      <ReviewCard
        name="ReviewCard 3"
        imageUrl="http://placehold.it/300x350"
      />
      <ReviewCard
        name="ReviewCard 4"
        imageUrl="http://placehold.it/300x350"
      />
    </Slider>
  );
}
deps.ReviewsSlider = ReviewsSliderContainer;

function NewQuestsSliderContainer(props) {
  return (
    <Slider
      title="Новые квесты"
      totalCount={14}
      seeAllUrl="/new"
    >
      <QuestCard
        name="QuestCard 1"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 2"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 3"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 4"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
    </Slider>
  );
}
deps.NewQuestsSlider = NewQuestsSliderContainer;

function CompaniesSliderContainer() {
  return (
    <Slider
      title="Компании"
      totalCount={14}
      seeAllUrl="/companies"
    >
      <CompanyCard
        name="CompanyCard 3"
        imageUrl="http://placehold.it/190x140"
        questCount={7}
      />
      <CompanyCard
        name="CompanyCard 122"
        imageUrl="http://placehold.it/190x140"
        questCount={4}
      />
      <CompanyCard
        name="CompanyCard 12"
        imageUrl="http://placehold.it/190x140"
        questCount={12}
      />
      <CompanyCard
        name="CompanyCard 23"
        imageUrl="http://placehold.it/190x140"
        questCount={6}
      />
      <CompanyCard
        name="CompanyCard 22"
        imageUrl="http://placehold.it/190x140"
        questCount={3}
      />
      <CompanyCard
        name="CompanyCard 1"
        imageUrl="http://placehold.it/190x140"
        questCount={2}
      />
    </Slider>
  );
}
deps.CompaniesSlider = CompaniesSliderContainer;

function QuestGalleryContainer({ id }) {
  return (
    <Gallery
      left="http://placehold.it/991x495/555"
      center={`http://placehold.it/990x495/222?text=id:+${id}`}
      right="http://placehold.it/992x495"
    />
  );
}
deps.QuestGallery = QuestGalleryContainer;

function QuestDescriptionContainer({ /* id */ }) {
  return (
    <QuestDescription />
  );
}
deps.QuestDescription = QuestDescriptionContainer;

function QuesetScheduleContainer({ /* id */ }) {
  return (
    <QuestSchedule />
  );
}
deps.QuestSchedule = QuesetScheduleContainer;

function QuestLocationContainer({ /* id */ }) {
  return (
    <QuestLocation />
  );
}
deps.QuestLocation = QuestLocationContainer;

function QuestSimilarQuestsContainer({ /* id */ }) {
  return (
    <SimilarQuests title="Похожие квесты">
      <QuestCard
        name="QuestCard 1"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 2"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 3"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 4"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 5"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 6"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
    </SimilarQuests>
  );
}
deps.QuestSimilarQuests = QuestSimilarQuestsContainer;

function QuestAddToFavoriteContainer({ /* id */ }) {
  return (
    <div>add to favorite</div>
  );
}
deps.QuestAddToFavorite = QuestAddToFavoriteContainer;

function QuestBookingContainer({ /* id */ }) {
  return (
    <div style={{ height: '100px', border: '1px gray solid' }}>quest booking form</div>
  );
}
deps.QuestBooking = QuestBookingContainer;

export default function WithDeps({children}) {
  return <DependencyProvider deps={deps}>{children}</DependencyProvider>;
}
