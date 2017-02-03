import React from 'react';
import ReactDOM from 'react-dom';
import { AppContainer } from 'react-hot-loader';
import Examples from '../examples';

function render(Component) {
  ReactDOM.render(
    <AppContainer>
      <Component />
    </AppContainer>,
    document.getElementById('root'));
}

render(Examples);

if (module.hot) {
  module.hot.accept(() => {
    render(Examples);
  });
}
