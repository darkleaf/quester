import React, { Component, PropTypes } from 'react';

export default function dependencyProviderBuilder(name, deps) {
  const DependencyProvider = class extends Component {
    getChildContext() { return deps; }
    render() { return <div>{this.props.children}</div>; }
  };

  DependencyProvider.displayName = `DependencyProvider(${name})`;

  DependencyProvider.propTypes = {
    children: React.PropTypes.any.isRequired,
  };

  DependencyProvider.childContextTypes = Object.keys(deps).reduce(
    (obj, dep) => Object.assign(obj, { [dep]: PropTypes.any }),
    {}
  );

  return DependencyProvider;
}
