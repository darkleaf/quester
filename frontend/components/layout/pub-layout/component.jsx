import React, { Component, PropTypes } from 'react';
import { StickyContainer, Sticky } from 'react-sticky';

import Canvas from '../canvas';
import Nav from '../nav';

export default class PubLayout extends Component {
  render() {
    const {
      LeftNavSection,
      RightNavSection,
    } = this.context;
    return (
      <StickyContainer>
        <Canvas>
          <Sticky style={{zIndex: 1}}>
            <Nav>
              <LeftNavSection />
              <RightNavSection />
            </Nav>
          </Sticky>
          {this.props.children}
        </Canvas>
      </StickyContainer>
    );
  }
}

PubLayout.contextTypes = {
  LeftNavSection: PropTypes.func.isRequired,
  RightNavSection: PropTypes.func.isRequired,
};

PubLayout.propTypes = {
  children: React.PropTypes.array.isRequired,
};
