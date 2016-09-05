import React, { Component } from 'react';
/* TODO: удалить, когда разберемся с временными компонентами */
import styles from './quest-page.css';

import AppContainer from '../components/app-container';
import { Nav, NavSection } from '../components/nav';
import NavBrand from '../components/nav-brand';
import NavItem from '../components/nav-item';
import NavSearch from '../components/nav-search';
import QuestCarousel from '../components/quest-carousel';
import Badge from '../components/badge';
import HorizontalRule from '../components/horizontal-rule';
import QuestSchedule from '../components/quest-schedule';
import CompanyContacts from '../components/company-contacts';
import Comments from '../components/comments';
import Comment from '../components/comment';
import QuestCard from '../components/quest-card';

function ContentSectionMain(props) {
  return (
    <div style={{ padding: '5px' }}>
      {React.Children.map(props.children, (child) => <div style={{ margin: '10px' }}>{child}</div>)}
    </div>
  );
}
ContentSectionMain.propTypes = {
  children: React.PropTypes.array.isRequired,
};
function QuestShortDescription() {
  return (
    <div style={{ border: '1px solid black' }}>
      QuestShortDescription
    </div>
  );
}
function ItemGrid(props) {
  return (
    <div>
      <div style={{ paddingBottom: '5px' }}>{props.title}</div>
      <div className={styles.itemGridItems}>{props.children}</div>
    </div>
  );
}
ItemGrid.propTypes = {
  children: React.PropTypes.array.isRequired,
  title: React.PropTypes.string.isRequired,
};
function QuestHeader() {
  return (
    <div style={{ border: '1px solid black' }}>Quest Header</div>
  );
}
function BadgesList(props) {
  return (
    <div className={styles.badgesList}>
      {props.children}
    </div>
  );
}
BadgesList.propTypes = {
  children: React.PropTypes.array.isRequired,
};
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
          <BadgesList>
            <Badge />
            <Badge />
            <Badge />
            <Badge />
            <Badge />
            <Badge />
          </BadgesList>
          <QuestShortDescription />
          <HorizontalRule />
          <QuestSchedule />
          <CompanyContacts />
          <HorizontalRule />
          <Comments>
            <Comment />
            <Comment />
            <Comment />
            <Comment />
          </Comments>
          <HorizontalRule />
          <ItemGrid title="Похожие квесты">
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
            <QuestCard
              name="Коллекционер"
              imageUrl="https://placeimg.com/300/210/arch"
              priceMin={4500}
              priceMax={9500}
              participantsMin={2}
              participantsMax={5}
              rating={9.3}
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
          </ItemGrid>
        </ContentSectionMain>
      </AppContainer>
    );
  }
}
