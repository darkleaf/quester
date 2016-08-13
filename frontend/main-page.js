import React, {Component} from 'react'

import {Nav, NavSection} from './nav'
import NavBrand from './nav-brand'
import NavItem from './nav-item'
import ContentSection from './content-section'
import MainCarousel from './main-carousel'
import MainFilter from './main-filter'
import Slider from './slider'
import QuestCard from './quest-card'
import SelectionCard from './selection-card'
import ReviewCard from './review-card'
import CompanyCard from './company-card'

export default class MainPage extends Component {
  render() {
    return (
      <div>
        <Nav>
          <NavSection>
            <NavBrand name="Quester" />
            <NavItem name="Квесты" />
          </NavSection>

          <NavSection>
            <NavItem name="Избранное" />
            <NavItem name="Выйти" />
          </NavSection>
        </Nav>
	      <MainCarousel>
          <MainFilter />
        </MainCarousel>
        <ContentSection>
          <Slider title="cool selection">
            <SelectionCard name="cool quest" />
            <SelectionCard name="cool quest2" />
            <SelectionCard name="cool quest2" />
            <SelectionCard name="cool quest2" />
          </Slider>
        </ContentSection>
        <ContentSection >
          <Slider title="cool quests">
            <QuestCard name="cool quest" />
            <QuestCard name="cool quest2" />
            <QuestCard name="cool quest2" />
            <QuestCard name="cool quest2" />
          </Slider>
        </ContentSection>
        <ContentSection highlighted >
          <Slider title="cool reviews">
            <ReviewCard name="cool quest" />
            <ReviewCard name="cool quest2" />
            <ReviewCard name="cool quest2" />
            <ReviewCard name="cool quest2" />
          </Slider>
        </ContentSection>
        <ContentSection >
          <Slider title="cool quests">
            <QuestCard name="cool quest" />
            <QuestCard name="cool quest2" />
            <QuestCard name="cool quest2" />
            <QuestCard name="cool quest2" />
          </Slider>
        </ContentSection>
        <ContentSection >
          <Slider title="cool companies">
            <CompanyCard name="cool quest" />
            <CompanyCard name="cool quest2" />
            <CompanyCard name="cool quest2" />
            <CompanyCard name="cool quest2" />
            <CompanyCard name="cool quest2" />
            <CompanyCard name="cool quest2" />
          </Slider>
        </ContentSection>
      </div>
    )
  }
}
