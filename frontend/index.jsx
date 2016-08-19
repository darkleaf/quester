import React from 'react';
import ReactDOM from 'react-dom';

import { addLocaleData } from 'react-intl';
import ru from 'react-intl/locale-data/ru';
import Examples from './examples';

addLocaleData([...ru]);

ReactDOM.render(<Examples />, document.getElementById('root'));
