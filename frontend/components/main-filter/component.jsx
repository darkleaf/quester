import React, { Component } from 'react';
import { FormattedMessage } from 'react-intl';

export default class MainFilter extends Component {
  render() {
    return (
      <div>
        <div>
          <FormattedMessage id="MainFilter.title" />
        </div>
        {/* TODO pass as children*/}
        <div>Категрия Участники Дата Цена Найти</div>

      </div>
    );
  }
}

MainFilter.propTypes = {
};
