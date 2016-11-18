import React, { Component } from 'react';

import RatingsWidget from '../ratings-widget';
import Float from '../../../utils/float';

export default class Comment extends Component {
  render() {
    return (
      <div>{this.props.tempName}
        <Float align="left"><RatingsWidget /></Float>
      </div>
    );
  }
}

Comment.propTypes = {
  tempName: React.PropTypes.string.isRequired,
};
