import React, { Component } from 'react';

import Wrapper from '../wrapper';
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
      <Wrapper>
        <MainPageExample />
        <Divider />
        <QuestPageExample />
      </Wrapper>
    );
  }
}
