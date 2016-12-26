import React, { Component, PropTypes } from 'react';

const deps = [
  'LeftNavSection',
  'RightNavSection',
  'MainCarousel',
  'SelectionsSlider',
  'BestQuestsSlider',
  'NewQuestsSlider',
  'ReviewsSlider',
  'CompaniesSlider',
  'QuestGallery',
  'QuestDescription',
  'QuestSchedule',
  'QuestLocation',
  'QuestSimilarQuests',
  'QuestAddToFavorite',
  'QuestBooking',
];

export default class DependencyProvider extends Component {
  getChildContext() { return this.props.deps; }
  render() { return <div>{this.props.children}</div>; }
};

DependencyProvider.propTypes = {
  children: PropTypes.any.isRequired,
  deps: PropTypes.object.isRequired,
};

DependencyProvider.childContextTypes = deps.reduce(
  (obj, dep) => Object.assign(obj, { [dep]: PropTypes.func.isRequired }),
  {}
);
