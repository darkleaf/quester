import React, { Component } from 'react';

import AppContainer from '../components/app-container';
import { Nav, NavSection } from '../components/nav';
import NavBrand from '../components/nav-brand';
import NavItem from '../components/nav-item';
import NavSearch from '../components/nav-search';
import QuestCarousel from '../components/quest-carousel';
import ContentSectionMain from '../components/content-section-main';
import QuestHeader from '../components/quest-header';
import QuestBadges from '../components/quest-badges';
import Badge from '../components/badge';
import QuestShortDescription from '../components/quest-short-description';
import Delimiter from '../components/delimiter';
import QuestSchedule from '../components/quest-schedule';
import QuestLocation from '../components/quest-location';
import LocationMap from '../components/location-map';
import LocationContacts from '../components/location-contacts';
import Comments from '../components/comments';
import Comment from '../components/comment';
import Similar from '../components/similar';
import QuestCard from '../components/quest-card';


export default class QuestPage extends Component {
  render() {
    return (
      <AppContainer>
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
        <ContentSectionMain>
          <QuestCarousel />
          <QuestHeader />
          <QuestBadges>
            <Badge />
            <Badge />
            <Badge />
            <Badge />
            <Badge />
            <Badge />
          </QuestBadges>
          <QuestShortDescription />
          <Delimiter />
          <QuestSchedule />
          <QuestLocation>
            <LocationMap />
            <LocationContacts />
          </QuestLocation>
          <Delimiter />
          <Comments>
            <Comment />
            <Comment />
            <Comment />
            <Comment />
          </Comments>
          <Delimiter />
          <Similar>
            <QuestCard
              name="Insania 2.0"
              imageUrl="https://placeimg.com/300/210/arch"
              priceMin={4500}
              priceMax={9500}
              participantsMin={2}
              participantsMax={5}
              rating={9.3}
            />
            <QuestCard
              name="Фантомас против всех"
              imageUrl="https://placeimg.com/300/210/arch"
              priceMin={4500}
              priceMax={9500}
              participantsMin={2}
              participantsMax={5}
              rating={9.3}
            />
            <QuestCard
              name="Психоатрическая больница"
              imageUrl="https://placeimg.com/300/210/arch"
              priceMin={4500}
              priceMax={9500}
              participantsMin={2}
              participantsMax={5}
              rating={9}
            />
            <QuestCard
              name="Коллекционер"
              imageUrl="https://placeimg.com/300/210/arch"
              priceMin={4500}
              priceMax={9500}
              participantsMin={2}
              participantsMax={5}
              rating={9.3}
            />
          </Similar>
        </ContentSectionMain>
      </AppContainer>
    );
  }
}
