import React, { Component } from 'react';
import { IntlProvider } from 'react-intl';
import messages from '../messages';

import MainPage from './main-page';
import QuestPage from './quest-page';

function Divider() {
  const style = {
    padding: '25px 0',
    color: 'white',
    textAlign: 'center',
    background: 'black',
  };
  return <div style={style}>New page</div>;
}


export default class Examples extends Component {
  render() {
    return (
      <IntlProvider locale="ru" messages={messages}>
        <div>
          <MainPage />
          <Divider />
          <QuestPage />
        </div>
      </IntlProvider>
    );
  }
}
