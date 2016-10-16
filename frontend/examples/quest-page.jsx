import React, { Component } from 'react';
/* TODO: удалить стили, когда разберемся с временными компонентами */
import styles from './quest-page.css';

import Canvas from '../components/layout/canvas';
import Nav from '../components/layout/nav'
import NavSection from '../components/layout/nav-section';
import NavBrand from '../components/layout/nav-brand';
import NavItem from '../components/layout/nav-item';
import NavSearch from '../components/layout/nav-search';

import Gallery from '../components/layout/gallery';

/* import QuestCarousel from '../components/layout/quest-carousel';
 * import Badge from '../components/widgets/badge';
 * import HorizontalRule from '../components/layout/horizontal-rule';
 *
 * import QuestSchedule from '../components/quest-schedule';
 * import CompanyContacts from '../components/company-contacts';
 * import Comments from '../components/comments';
 * import Comment from '../components/comment';
 * import QuestCard from '../components/quest-card';
 * import RegularGrid from '../components/layout/regular-grid';*/


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
      <Canvas>
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

        <Gallery
          left="https://placeimg.com/991/495/arch"
          center="https://placeimg.com/990/495/arch"
          right="https://placeimg.com/992/495/arch"
        />

        {/* <ContentSectionMain>
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
        <RegularGrid columns={4}>

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
        </RegularGrid>
        </ContentSectionMain> */}
      </Canvas>
    );
  }
}
