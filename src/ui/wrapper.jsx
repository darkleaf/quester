import React, { Component, PropTypes } from 'react';

import { addLocaleData, IntlProvider } from 'react-intl';
import ru from 'react-intl/locale-data/ru';
import messages from './messages';

addLocaleData([...ru]);

// locale можно как параметр предавать, если появится другой язык

export default class Wrapper extends Component {
  render() {
    return (
      <IntlProvider locale="ru" messages={messages}>
        <div>
          {this.props.children}
        </div>
      </IntlProvider>
    );
  }
}

Wrapper.propTypes = {
  children: PropTypes.any.isRequired,
};
