import React, { Component/* , PropTypes */ } from 'react';

import RatingsWidget from '../ratings-widget';
import WithHorizontalRule from '../../../utils/with-horizontal-rule';
import Float from '../../../utils/float';

export default class CommentList extends Component {
  render() {
    return (
      <div>
        <div>Comments</div>
        <Float align="space-between"><p>Рейтинг на основании отзывов</p><RatingsWidget /></Float>
        <WithHorizontalRule>
          {this.props.children}
        </WithHorizontalRule>
      </div>
    );
  }
}

CommentList.propTypes = {
  children: React.PropTypes.array.isRequired,
};
