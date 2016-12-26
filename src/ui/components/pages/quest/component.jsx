import React, { Component, PropTypes } from 'react';
import { StickyContainer, Sticky } from 'react-sticky';

import PubLayout from '../../layout/pub-layout';
import Container from '../../layout/container';

import WithHorizontalRule from '../../utils/with-horizontal-rule';
import Columns from '../../utils/columns';

import styles from './styles.css';

export default class QuestPage extends Component {
  render() {
    const {
      QuestGallery,
      QuestSimilarQuests,
      QuestDescription,
      QuestSchedule,
      QuestLocation,
      QuestAddToFavorite,
      QuestBooking,
    } = this.context;
    return (
      <PubLayout>
        <QuestGallery id={this.props.id} />
        <Container>
          <WithHorizontalRule>
            <Columns fractions={['2/3', '1/3']}>
              <WithHorizontalRule>
                <QuestDescription id={this.props.id} />
                <QuestSchedule id={this.props.id} />
                <QuestLocation id={this.props.id} />
              </WithHorizontalRule>
              <StickyContainer className={styles.sidebar}>
                <Sticky stickyClassName={styles.sticky}>
                  <QuestAddToFavorite id={this.props.id} />
                  <QuestBooking id={this.props.id} />
                </Sticky>
              </StickyContainer>
            </Columns>
            <QuestSimilarQuests id={this.props.id} />
          </WithHorizontalRule>
        </Container>
      </PubLayout>
    );
  }
}

QuestPage.contextTypes = {
  QuestGallery: PropTypes.func.isRequired,
  QuestDescription: PropTypes.func.isRequired,
  QuestSchedule: PropTypes.func.isRequired,
  QuestLocation: PropTypes.func.isRequired,
  QuestSimilarQuests: PropTypes.func.isRequired,
  QuestAddToFavorite: PropTypes.func.isRequired,
  QuestBooking: PropTypes.func.isRequired,
};

QuestPage.propTypes = {
  id: PropTypes.number.isRequired,
};
