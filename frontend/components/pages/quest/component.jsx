import React, { Component, PropTypes } from 'react';

import Canvas from '../../layout/canvas';
import Container from '../../layout/container';
import Nav from '../../layout/nav';

import NavSection from '../../layout/nav-section';
import NavBrand from '../../layout/nav-brand';
import NavItem from '../../layout/nav-item';
import NavSearch from '../../layout/nav-search';

import WithHorizontalRule from '../../utils/with-horizontal-rule';
import Columns from '../../utils/columns';

export default class QuestPage extends Component {
  render() {
    const {
      QuestGallery,
    } = this.context;
    return (
      <Canvas>
        <Nav>

          {/* TODO: use correct markup and switch to DI */}
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
        <QuestGallery id={this.props.id} />
        <Container>
          <WithHorizontalRule>
            <Columns fractions={['2/3', '1/3']}>
              <div>quest</div>
              {/*               <Quest /> */}
              <div>sidebar</div>
            </Columns>
            <div>
              quests
            </div>
          </WithHorizontalRule>
        </Container>
      </Canvas>
    );
  }
}

QuestPage.contextTypes = {
  QuestGallery: PropTypes.func.isRequired,
};

QuestPage.propTypes = {
  id: PropTypes.number.isRequired,
}
