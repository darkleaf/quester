import React, { Component } from 'react';

import AppContainer from '../components/app-container';
import { Nav, NavSection } from '../components/nav';
import NavBrand from '../components/nav-brand';
import NavItem from '../components/nav-item';
import NavSearch from '../components/nav-search';
import QuestCarousel from '../components/quest-carousel';
import QuestHeader from '../components/quest-header';
import QuestBadges from '../components/quest-badges';
import Badge from '../components/badge';
import Delimiter from '../components/delimiter';
import QuestSchedule from '../components/quest-schedule';
import CompanyContacts from '../components/company-contacts';
import Comments from '../components/comments';
import Comment from '../components/comment';
import QuestsSets from '../components/quests-sets';
import QuestCard from '../components/quest-card';

const divStyle = {
  display: 'flex',
  flexDirection: 'column',
  justifyContent: 'center',
  alignItems: 'stretch',
  padding: '5px',
};

function ContentSectionMain(props) {
  return (
    <div style={divStyle}>
      {props.children}
    </div>
  );
}
ContentSectionMain.propTypes = {
  children: React.PropTypes.array.isRequired,
};
function QuestShortDescription() {
  return (
    <div style={{ border: '1px solid black', margin: '5px' }}>
      QuestShortDescription
    </div>
  );
}
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
          <CompanyContacts />
          <Delimiter />
          <Comments>
            <Comment />
            <Comment />
            <Comment />
            <Comment />
          </Comments>
          <Delimiter />
          <QuestsSets>
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
          </QuestsSets>
        </ContentSectionMain>
      </AppContainer>
    );
  }
}
