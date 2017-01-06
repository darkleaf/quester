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
      Nav,
      Gallery,
      SimilarQuests,
      Description,
      Schedule,
      Location,
      AddToFavorite,
      Booking,
    } = this.props;
    return (
      <PubLayout Nav={Nav}>
        <Gallery />
        <Container>
          <WithHorizontalRule>
            <Columns fractions={['2/3', '1/3']}>
              <WithHorizontalRule>
                <Description />
                <Schedule />
                <Location />
              </WithHorizontalRule>
              <StickyContainer className={styles.sidebar}>
                <Sticky stickyClassName={styles.sticky}>
                  <AddToFavorite />
                  <Booking />
                </Sticky>
              </StickyContainer>
            </Columns>
            <SimilarQuests />
          </WithHorizontalRule>
        </Container>
      </PubLayout>
    );
  }
}

QuestPage.propTypes = {
  Nav: PropTypes.func.isRequired,
  Gallery: PropTypes.func.isRequired,
  Description: PropTypes.func.isRequired,
  Schedule: PropTypes.func.isRequired,
  Location: PropTypes.func.isRequired,
  SimilarQuests: PropTypes.func.isRequired,
  AddToFavorite: PropTypes.func.isRequired,
  Booking: PropTypes.func.isRequired,
};
