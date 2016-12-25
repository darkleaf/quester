import React, { Component } from 'react';
import { FormattedNumber } from 'react-intl';
import Icon from '../icon';

export default class Rating extends Component {
  render() {
    const { value } = this.props;
    return (
      <div>
        <Icon>
          <FormattedNumber value={value} minimumFractionDigits={0} maximumFractionDigits={1} />
        </Icon>
      </div>
    );
  }
}

Rating.propTypes = {
  value: React.PropTypes.number.isRequired,
};
