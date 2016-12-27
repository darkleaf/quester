import { addLocaleData } from 'react-intl';
import ru from 'react-intl/locale-data/ru';

addLocaleData([...ru]);

export { default as React } from 'react';
export { default as ReactDOM } from 'react-dom';
export { IntlProvider } from 'react-intl';

export { default as messages } from '../messages';
export { default as DependencyProvider } from '../components/dependency-provider';

export { default as MainPage } from '../components/pages/main';
export { default as QuestPage } from '../components/pages/quest';

export { default as NavSection } from '../components/layout/nav-section';
export { default as NavBrand } from '../components/layout/nav-brand';
export { default as NavItem } from '../components/layout/nav-item';
export { default as NavSearch } from '../components/layout/nav-search';

export { default as MainCarousel } from '../components/layout/main-carousel';
export { default as MainFilter } from '../components/layout/main-filter';
export { default as Slider } from '../components/layout/slider';

export { default as SelectionCard } from '../components/entities/selection-card';
export { default as QuestCard } from '../components/entities/quest-card';
export { default as ReviewCard } from '../components/entities/review-card';
export { default as CompanyCard } from '../components/entities/company-card';
