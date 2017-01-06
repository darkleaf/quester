/* eslint no-shadow: "off", react/prop-types: "off", no-empty-pattern: "off" */

import React from 'react';
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
        url="/1"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 2"
        url="/2"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 3"
        url="/3"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 4"
        url="/4"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 5"
        url="/5"
        imageUrl="http://placehold.it/300x210"
        priceMin={4500}
        priceMax={9500}
        participantsMin={2}
        participantsMax={5}
        rating={9.3}
      />
      <QuestCard
        name="QuestCard 6"
        url="/6"
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

export default function WithDeps({ children }) {
  return <DependencyProvider deps={deps}>{children}</DependencyProvider>;
}
