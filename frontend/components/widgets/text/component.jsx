import React, { Component } from 'react';

export default class Text extends Component {
  render() {
    return (
      <div>
        {this.props.children}
      </div>
    );
  }
}

Text.propTypes = {
  children: React.PropTypes.any,
};
