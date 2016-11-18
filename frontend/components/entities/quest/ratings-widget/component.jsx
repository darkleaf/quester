import React, { Component } from 'react';

import Float from '../../../utils/float';
import Rating from '../../../widgets/rating';

export default class RatingsWidget extends Component {
  render() {
    return (
      <div>
        <Float align="right">
          <Rating value="10" />
          <div>Атмосфера</div>
          <div>Сюжетная линия</div>
          <div>Загадки</div>
        </Float>
      </div>
    );
  }
}
