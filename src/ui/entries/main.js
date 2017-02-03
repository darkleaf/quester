const store = {};

require('nprogress/nprogress.css');
const NProgress = require('nprogress');
NProgress.configure({ showSpinner: false });
store.NProgress = NProgress;
store.React = require('react');
store.ReactDOM = require('react-dom');
store.Wrapper = require('../wrapper').default;
store.MainPage = require('../components/pages/main').default;
store.QuestPage = require('../components/pages/quest').default;
store.Nav = require('../components/layout/nav').default;
store.NavSection = require('../components/layout/nav-section').default;
store.NavBrand = require('../components/layout/nav-brand').default;
store.NavItem = require('../components/layout/nav-item').default;
store.NavSearch = require('../components/layout/nav-search').default;
store.MainCarousel = require('../components/layout/main-carousel').default;
store.MainFilter = require('../components/layout/main-filter').default;
store.Slider = require('../components/layout/slider').default;
store.Gallery = require('../components/layout/gallery').default;
store.SelectionCard = require('../components/entities/selection-card').default;
store.QuestCard = require('../components/entities/quest-card').default;
store.ReviewCard = require('../components/entities/review-card').default;
store.CompanyCard = require('../components/entities/company-card').default;
store.QuestSimilarQuests = require('../components/entities/quest/similar-quests').default;
store.QuestDescription = require('../components/entities/quest/description').default;
store.QuestSchedule = require('../components/entities/quest/schedule').default;
store.QuestLocation = require('../components/entities/quest/location').default;

// Свистопляски, чтобы Closure Compiler не минифицировал имена
// Можно будет потом неймспейсы вводить =)
module.exports = name => store[name];
