import React, { Component } from 'react';

import Quest from '../components/entities/quest';
import QuestCard from '../components/entities/quest-card';

import Canvas from '../components/layout/canvas';
import Gallery from '../components/layout/gallery';
import Container from '../components/layout/container';
import Nav from '../components/layout/nav';
import NavSection from '../components/layout/nav-section';
import NavBrand from '../components/layout/nav-brand';
import NavItem from '../components/layout/nav-item';
import NavSearch from '../components/layout/nav-search';

import WithHorizontalRule from '../components/util/with-horizontal-rule';
import RegularGrid from '../components/util/regular-grid';
import Columns from '../components/util/columns';

import Title from '../components/widgets/title';

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
          left="http://placehold.it/991x495/555"
          center="http://placehold.it/990x495/222"
          right="http://placehold.it/992x495"
        />

        <Container>
          <WithHorizontalRule>
            <Columns fractions={[[2, 3], [1, 3]]}>
              <Quest />
              <div>sidebar</div>
            </Columns>

            <div>
              <Title>Похожие квесты</Title>
              <RegularGrid columns={4}>
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
                <QuestCard
                  name="Коллекционер"
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
              </RegularGrid>
            </div>
          </WithHorizontalRule>
        </Container>
      </Canvas>
    );
  }
}
