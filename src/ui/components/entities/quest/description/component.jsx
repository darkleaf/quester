import React, { Component, PropTypes } from 'react';
import styles from './styles.css';

import Advantage from '../../../entities/advantage';
import Icon from '../../../widgets/icon';
import Rating from '../../../widgets/rating';
import Float from '../../../utils/float';
import Text from '../../../widgets/text';

export default class Description extends Component {
  render() {
    return (
      <div>
        <Float align="left">
          <div>{this.props.name}</div>
          <Rating value={this.props.rating} />
          <Icon>{this.props.commentsCount}</Icon>
        </Float>
        <div className={styles.advantages}>
          <Float align="space-between">
            <Advantage />
            <Advantage />
            <Advantage />
            <Advantage />
            <Advantage />
            <Advantage />
          </Float>
        </div>
        <Text>{this.props.description}</Text>
      </div>
    );
  }
}

Description.propTypes = {
  name: PropTypes.string.isRequired,
  rating: PropTypes.number.isRequired,
  commentsCount: PropTypes.number.isRequired,
  description: PropTypes.string.isRequired,
};
