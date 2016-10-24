import React, { Component, PropTypes } from 'react';

import Canvas from '../canvas';
import Nav from '../nav';

export default class PubLayout extends Component {
  render() {
    const {
      LeftNavSection,
      RightNavSection,
    } = this.context;
    return (
      <Canvas>
        <Nav>
          <LeftNavSection />
          <RightNavSection />
        </Nav>
        {this.props.children}
      </Canvas>
    );
  }
}

PubLayout.contextTypes = {
  LeftNavSection: PropTypes.func.isRequired,
  RightNavSection: PropTypes.func.isRequired,
}

PubLayout.propTypes = {
  children: React.PropTypes.array.isRequired,
};
