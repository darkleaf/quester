import React, { Component } from 'react';

import { IntlProvider } from 'react-intl';
import messages from '../messages';

import WithStubs from './with-stubs';

import MainPage from '../components/pages/main';
/* import QuestPage from './quest-page';*/

function Divider() {
  const style = {
    padding: '25px 0',
    color: 'white',
    textAlign: 'center',
    background: 'black',
  };
  return <div style={style}>Divider</div>;
}

export default class Examples extends Component {
  render() {
    return (
      <IntlProvider locale="ru" messages={messages}>
        <WithStubs>
          <MainPage />
          <Divider />
        </WithStubs>
      </IntlProvider>
    );
  }
}
