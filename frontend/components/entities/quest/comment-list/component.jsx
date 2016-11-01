import React, { Component/* , PropTypes */ } from 'react';

import RatingsWidget from '../ratings-widget';
import WithHorizontalRule from '../../../utils/with-horizontal-rule';

export default class CommentList extends Component {
  render() {
    return (
      <div>
        <div>Comments</div>
        <RatingsWidget />
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
