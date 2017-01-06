import React, { Component } from 'react';

import { IntlProvider } from 'react-intl';
import messages from '../messages';

import MainPageExample from './main-page-example';
import QuestPageExample from './quest-page-example';

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
        <div>
          <MainPageExample />
          <Divider />
          <QuestPageExample />
        </div>
      </IntlProvider>
    );
  }
}
