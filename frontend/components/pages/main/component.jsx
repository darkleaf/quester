import React, { Component, PropTypes } from 'react';

import Canvas from '../../layout/canvas';
import Nav from '../../layout/nav';


export default class MainPage extends Component {
  render() {
    const { MainCarousel, SelectionCardSlider } = this.context;
    return (
      <Canvas>
        <Nav>
          foo
        </Nav>
        <MainCarousel />
        <SelectionCardSlider />
      </Canvas>
    );
  }
}

MainPage.contextTypes = {
  MainCarousel: PropTypes.any.isRequired,
  SelectionCardSlider: PropTypes.any.isRequired,
}
