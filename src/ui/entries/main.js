/* eslint global-require: "off" */

require('nprogress/nprogress.css');

const store = {
  NProgress: require('nprogress'),
  React: require('react'),
  ReactDOM: require('react-dom'),
  Wrapper: require('../wrapper').default,
  MainPage: require('../components/pages/main').default,
  QuestPage: require('../components/pages/quest').default,
  Nav: require('../components/layout/nav').default,
  NavSection: require('../components/layout/nav-section').default,
  NavBrand: require('../components/layout/nav-brand').default,
  NavItem: require('../components/layout/nav-item').default,
  NavSearch: require('../components/layout/nav-search').default,
  MainCarousel: require('../components/layout/main-carousel').default,
  MainFilter: require('../components/layout/main-filter').default,
  Slider: require('../components/layout/slider').default,
  Gallery: require('../components/layout/gallery').default,
  SelectionCard: require('../components/entities/selection-card').default,
  QuestCard: require('../components/entities/quest-card').default,
  ReviewCard: require('../components/entities/review-card').default,
  CompanyCard: require('../components/entities/company-card').default,
  QuestSimilarQuests: require('../components/entities/quest/similar-quests').default,
  QuestDescription: require('../components/entities/quest/description').default,
  QuestSchedule: require('../components/entities/quest/schedule').default,
  QuestLocation: require('../components/entities/quest/location').default,
};

store.NProgress.configure({ showSpinner: false });

// Свистопляски, чтобы Closure Compiler не минифицировал имена
// Можно будет потом неймспейсы вводить =)
module.exports = name => store[name];
