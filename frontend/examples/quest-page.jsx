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
            <Badge/>
            <Badge/>
            <Badge/>
            <Badge/>
            <Badge/>
            <Badge/>
          </QuestBadges>
          <QuestShortDescription/>
        </ContentSectionMain>
      </AppContainer>
    )
  }
}