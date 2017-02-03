goog.provide('js.ui');

require('nprogress/nprogress.css');
const NProgress = require('nprogress');
NProgress.configure({ showSpinner: false });
js.ui.Nprogress = Nprogress;

js.ui.React = require('react');
js.ui.ReactDOM = require('react-dom');
js.ui.Wrapper = require('../wrapper');
js.ui.MainPage = require('../components/pages/main');
js.ui.QuestPage = require('../components/pages/quest');
js.ui.Nav = require('../components/layout/nav');
js.ui.NavSection = require('../components/layout/nav-section');
js.ui.NavBrand = require('../components/layout/nav-brand');
js.ui.NavItem = require('../components/layout/nav-item');
js.ui.NavSearch = require('../components/layout/nav-search');
js.ui.MainCarousel = require('../components/layout/main-carousel');
js.ui.MainFilter = require('../components/layout/main-filter');
js.ui.Slider = require('../components/layout/slider');
js.ui.Gallery = require('../components/layout/gallery');
js.ui.SelectionCard = require('../components/entities/selection-card');
js.ui.QuestCard = require('../components/entities/quest-card');
js.ui.ReviewCard = require('../components/entities/review-card');
js.ui.CompanyCard = require('../components/entities/company-card');
js.ui.QuestSimilarQuests = require('../components/entities/quest/similar-quests');
js.ui.QuestDescription = require('../components/entities/quest/description');
js.ui.QuestSchedule = require('../components/entities/quest/schedule');
js.ui.QuestLocation = require('../components/entities/quest/location');
