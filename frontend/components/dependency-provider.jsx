import React, { Component, PropTypes } from 'react';

export default class DependencyProvider extends Component {
  getChildContext() {
    const context = Object.assign({}, this.props);
    delete context.children;
    return context;
  }

  render() {
    return <div>{this.props.children}</div>;
  }
}

const deps = [
  'LeftNavSection',
  'RightNavSection',
  'MainCarousel',
  'SelectionsSlider',
  'BestQuestsSlider',
  'NewQuestsSlider',
  'ReviewsSlider',
  'CompaniesSlider',
  'SelectionCard',
  'QuestCard',
  'ReviewCard',
  'CompanyCard',
  'QuestGallery',
  'QuestDescription',
  'QuestSchedule',
  'QuestLocation',
  'QuestSimilarQuests',
];

const types = deps.reduce(
  (obj, dep) => Object.assign(obj, { [dep]: PropTypes.func.isRequired }),
  {}
);

DependencyProvider.childContextTypes = types;

const mainProps = {
  children: PropTypes.any.isRequired,
};

DependencyProvider.propTypes = Object.assign(mainProps, types);
