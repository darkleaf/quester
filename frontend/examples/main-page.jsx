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

import QuestCard from '../components/domain/quest-card';
import SelectionCard from '../components/domain/selection-card';
import ReviewCard from '../components/domain/review-card';
import CompanyCard from '../components/domain/company-card';

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
          currentImageUrl="https://placeimg.com/1900/500/arch"
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
            imageUrl="https://placeimg.com/300/300/arch"
          />
          <SelectionCard
            name="Страшные"
            imageUrl="https://placeimg.com/300/300/arch"
          />
          <SelectionCard
            name="Семейные"
            imageUrl="https://placeimg.com/300/300/arch"
          />
          <SelectionCard
            name="Виртуальная реальность"
            imageUrl="https://placeimg.com/300/300/arch"
          />
        </Slider>

        <Slider
          title="Лучшие квесты"
          totalCount={14}
          seeAllUrl="/best"
        >
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
        </Slider>

        <Slider
          title="Обзоры"
          totalCount={14}
          seeAllUrl="/reviews"
          highlighted
        >
          <ReviewCard
            name="Выбираем самый технологичный квест"
            imageUrl="https://placeimg.com/300/350/arch"
          />
          <ReviewCard
            name="Квесты для любителей побегать"
            imageUrl="https://placeimg.com/300/350/arch"
          />
          <ReviewCard
            name="Куда сходить семье с ребенком"
            imageUrl="https://placeimg.com/300/350/arch"
          />
          <ReviewCard
            name="Выбираем самый необычный квест"
            imageUrl="https://placeimg.com/300/350/arch"
          />
        </Slider>

        <Slider
          title="Новые квесты"
          totalCount={14}
          seeAllUrl="/new"
        >
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
        </Slider>

        <Slider
          title="Компании"
          totalCount={14}
          seeAllUrl="/companies"
        >
          <CompanyCard
            name="Клаустрафобия"
            imageUrl="https://placeimg.com/190/140/arch"
            questCount={94}
          />
          <CompanyCard
            name="Квеструм"
            imageUrl="https://placeimg.com/190/140/arch"
            questCount={22}
          />
          <CompanyCard
            name="Западня"
            imageUrl="https://placeimg.com/190/140/arch"
            questCount={19}
          />
          <CompanyCard
            name="Escape quest"
            imageUrl="https://placeimg.com/190/140/arch"
            questCount={12}
          />
          <CompanyCard
            name="Quest Gamer"
            imageUrl="https://placeimg.com/190/140/arch"
            questCount={5}
          />
          <CompanyCard
            name="Quest Room"
            imageUrl="https://placeimg.com/190/140/arch"
            questCount={4}
          />
        </Slider>
      </Canvas>
    );
  }
}
