import React, { Component } from 'react';

import Canvas from '../components/layout/canvas';
import Nav from '../components/layout/nav';
import NavSection from '../components/layout/nav-section';
import NavBrand from '../components/layout/nav-brand';
import NavItem from '../components/layout/nav-item';
import NavSearch from '../components/layout/nav-search';
import MainCarousel from '../components/layout/main-carousel';
import MainFilter from '../components/layout/main-filter';
import Slider from '../components/layout/slider';

import QuestCard from '../components/entity/quest-card';
import SelectionCard from '../components/entity/selection-card';
import ReviewCard from '../components/entity/review-card';
import CompanyCard from '../components/entity/company-card';

export default class MainPage extends Component {
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

        <Slider
          title="Подборки квестов"
          totalCount={26}
          seeAllUrl="/selections"
        >
          <SelectionCard
            name="Перформансы"
            imageUrl="http://placehold.it/300x300"
          />
          <SelectionCard
            name="Страшные"
            imageUrl="http://placehold.it/300x300"
          />
          <SelectionCard
            name="Семейные"
            imageUrl="http://placehold.it/300x300"
          />
          <SelectionCard
            name="Виртуальная реальность"
            imageUrl="http://placehold.it/300x300"
          />
        </Slider>

        <Slider
          title="Лучшие квесты"
          totalCount={14}
          seeAllUrl="/best"
        >
          <QuestCard
            name="Insania 2.0"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9.3}
          />
          <QuestCard
            name="Фантомас против всех"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9.3}
          />
          <QuestCard
            name="Психоатрическая больница"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9}
          />
          <QuestCard
            name="Коллекционер"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9.3}
          />
        </Slider>

        <Slider
          title="Обзоры"
          totalCount={14}
          seeAllUrl="/reviews"
          highlighted
        >
          <ReviewCard
            name="Выбираем самый технологичный квест"
            imageUrl="http://placehold.it/300x350"
          />
          <ReviewCard
            name="Квесты для любителей побегать"
            imageUrl="http://placehold.it/300x350"
          />
          <ReviewCard
            name="Куда сходить семье с ребенком"
            imageUrl="http://placehold.it/300x350"
          />
          <ReviewCard
            name="Выбираем самый необычный квест"
            imageUrl="http://placehold.it/300x350"
          />
        </Slider>

        <Slider
          title="Новые квесты"
          totalCount={14}
          seeAllUrl="/new"
        >
          <QuestCard
            name="Insania 2.0"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9.3}
          />
          <QuestCard
            name="Фантомас против всех"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9.3}
          />
          <QuestCard
            name="Психоатрическая больница"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9.3}
          />
          <QuestCard
            name="Коллекционер"
            imageUrl="http://placehold.it/300x210"
            priceMin={4500}
            priceMax={9500}
            participantsMin={2}
            participantsMax={5}
            rating={9.3}
          />
        </Slider>

        <Slider
          title="Компании"
          totalCount={14}
          seeAllUrl="/companies"
        >
          <CompanyCard
            name="Клаустрафобия"
            imageUrl="http://placehold.it/190x140"
            questCount={94}
          />
          <CompanyCard
            name="Квеструм"
            imageUrl="http://placehold.it/190x140"
            questCount={22}
          />
          <CompanyCard
            name="Западня"
            imageUrl="http://placehold.it/190x140"
            questCount={19}
          />
          <CompanyCard
            name="Escape quest"
            imageUrl="http://placehold.it/190x140"
            questCount={12}
          />
          <CompanyCard
            name="Quest Gamer"
            imageUrl="http://placehold.it/190x140"
            questCount={5}
          />
          <CompanyCard
            name="Quest Room"
            imageUrl="http://placehold.it/190x140"
            questCount={4}
          />
        </Slider>
      </Canvas>
    );
  }
}
