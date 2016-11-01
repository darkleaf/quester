import React, { Component } from 'react';

import Float from '../../../utils/float';

export default class RatingsWidget extends Component {
  render() {
    return (
      <div>
        <Float align="left">
          <div>Рейтинг по основаниям отзывов</div>
        </Float>
        <Float align="right">
          <div>Different ratings</div>
        </Float>
      </div>
    );
  }
}
