import React, { Component, PropTypes } from 'react';

import QuestPage from '../components/pages/quest';

import Nav from '../components/layout/nav';
import NavSection from '../components/layout/nav-section';
import NavBrand from '../components/layout/nav-brand';
import NavItem from '../components/layout/nav-item';
import NavSearch from '../components/layout/nav-search';
import Gallery from '../components/layout/gallery';
import QuestCard from '../components/entities/quest-card';
import SimilarQuests from '../components/entities/quest/similar-quests';
import QuestDescription from '../components/entities/quest/description';
import QuestSchedule from '../components/entities/quest/schedule';
import QuestLocation from '../components/entities/quest/location';

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

function GalleryContainer() {
  return (
    <Gallery
      left="http://placehold.it/991x495/555"
      center="http://placehold.it/990x495/222"
      right="http://placehold.it/992x495"
    />
  );
}

function DescriptionContainer() {
  return (
    <QuestDescription />
  );
}

function ScheduleContainer() {
  return (
    <QuestSchedule />
  );
}

function LocationContainer() {
  return (
    <QuestLocation />
  );
}

function QuestCardContainer({ id }) {
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
  );
}

QuestCardContainer.propTypes = {
  id: PropTypes.any.isRequired,
};

function SimilarQuestsContainer() {
  return (
    <SimilarQuests title="Похожие квесты">
      <QuestCardContainer id="1" />
      <QuestCardContainer id="2" />
      <QuestCardContainer id="3" />
      <QuestCardContainer id="4" />
      <QuestCardContainer id="5" />
      <QuestCardContainer id="6" />
    </SimilarQuests>
  );
}

function AddToFavoriteContainer() {
  return (
    <div>add to favorite</div>
  );
}

function BookingContainer() {
  return (
    <div style={{ height: '100px', border: '1px gray solid' }}>quest booking form</div>
  );
}

export default class QuestPageExample extends Component {
  render() {
    return (
      <QuestPage
        nav={<NavContainer />}
        gallery={<GalleryContainer />}
        similarQuests={<SimilarQuestsContainer />}
        description={<DescriptionContainer />}
        schedule={<ScheduleContainer />}
        location={<LocationContainer />}
        addToFavorite={<AddToFavoriteContainer />}
        booking={<BookingContainer />}
      />
    );
  }
}
