import React, { Component } from 'react';
import styles from './styles.css';

import Advantage from '../../widgets/advantage';
import Icon from '../../widgets/icon';
import Rating from '../../widgets/rating';

import Float from '../../util/float';
import WithHorizontalRule from '../../util/with-horizontal-rule';

function Description() {
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
      <div className={styles.description}>
        Служба Яндекс.Рефераты предназначена для студентов и школьников, дизайнеров и журналистов,
        создателей научных заявок и отчетов — для всех, кто относится к тексту,
        как к количеству знаков.
      </div>
    </div>
  );
}

function Schedule() {
  return (
    <div>schedule</div>
  );
}

export default class Quest extends Component {
  render() {
    return (
      <div>
        <WithHorizontalRule>
          <Description />
          <Schedule />
        </WithHorizontalRule>
      </div>
    );
  }
}

Quest.propTypes = {};
