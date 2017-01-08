import React, { Component, PropTypes } from 'react';
import { StickyContainer, Sticky } from 'react-sticky';

import Canvas from '../canvas';

export default class PubLayout extends Component {
  render() {
    const {
      nav,
    } = this.props;
    return (
      <StickyContainer>
        <Canvas>
          <Sticky style={{ zIndex: 1 }}>
            {nav}
          </Sticky>
          {this.props.children}
        </Canvas>
      </StickyContainer>
    );
  }
}

PubLayout.propTypes = {
  nav: PropTypes.object.isRequired,
  children: React.PropTypes.array.isRequired,
};
