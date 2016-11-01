import React, { Component } from 'react';

export default class Comment extends Component {
  render() {
    return (
      <div>{this.props.tempName}</div>
    );
  }
}

Comment.propTypes = {
  tempName: React.PropTypes.string.isRequired,
};
