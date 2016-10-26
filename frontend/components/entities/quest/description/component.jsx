import React, { Component/* , PropTypes */ } from 'react';
import styles from './styles.css';

import Advantage from '../../../widgets/advantage';
import Icon from '../../../widgets/icon';
import Rating from '../../../widgets/rating';
import Float from '../../../utils/float';
import Text from '../../../widgets/text';

export default class Description extends Component {
  render() {
    return (
      <div>
        <Float align="left">
          <div>007: Доктор Но</div>
          <Rating value={9.8} />
          <Icon>10</Icon>
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
        <Text>
          Служба Яндекс.Рефераты предназначена для студентов и школьников,
          дизайнеров и журналистов,
          создателей научных заявок и отчетов — для всех,
          кто относится к тексту,
          как к количеству знаков.
        </Text>
      </div>
    );
  }
}

Description.propTypes = {};
