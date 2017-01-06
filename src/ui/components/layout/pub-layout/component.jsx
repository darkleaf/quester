import React, { Component, PropTypes } from 'react';
import { StickyContainer, Sticky } from 'react-sticky';

import Canvas from '../canvas';

export default class PubLayout extends Component {
  render() {
    const {
      Nav
    } = this.props;
    return (
      <StickyContainer>
        <Canvas>
          <Sticky style={{ zIndex: 1 }}>
            <Nav />
          </Sticky>
          {this.props.children}
        </Canvas>
      </StickyContainer>
    );
  }
}

PubLayout.propTypes = {
  Nav: PropTypes.func.isRequired,
  children: React.PropTypes.array.isRequired,
};
