import React, { Component } from 'react';

export default class Icon extends Component {
  render() {
    return (
      <div>
        <span>i</span>
        {this.props.children}
      </div>
    );
  }
}

Icon.propTypes = {
  children: React.PropTypes.any,
};
