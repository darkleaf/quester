import React, { Component } from 'react';
import RegularGrid from '../../../utils/regular-grid';
import Title from '../../../widgets/title';

export default class SimilarQuests extends Component {
  render() {
    return (
      <div>
        <Title>{this.props.title}</Title>
        <RegularGrid columns={4}>
          {this.props.children.map(children => children)}
        </RegularGrid>
      </div>
    );
  }
}

SimilarQuests.propTypes = {
  title: React.PropTypes.string.isRequired,
  children: React.PropTypes.array.isRequired,
};
