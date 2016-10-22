import React, { Component, PropTypes } from 'react';

export default class DependencyProvider extends Component {
  getChildContext() {
    const context = Object.assign({}, this.props);
    delete context.children;
    return context;
  }

  render() {
    return <div>{this.props.children}</div>;
  }
}

const deps = [
  'MainCarousel',
  'SelectionCardSlider',
  'SelectionCard',
];

const types = deps.reduce((obj, dep) => {
  obj[dep] = PropTypes.func.isRequired;
  return obj;
}, {});

DependencyProvider.childContextTypes = types;

const mainProps = {
  children: PropTypes.any.isRequired,
};

DependencyProvider.propTypes = Object.assign(mainProps, types);
