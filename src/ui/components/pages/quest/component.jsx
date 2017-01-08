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
      nav,
      gallery,
      similarQuests,
      description,
      schedule,
      location,
      addToFavorite,
      booking,
    } = this.props;
    return (
      <PubLayout nav={nav}>
        {gallery}
        <Container>
          <WithHorizontalRule>
            <Columns fractions={['2/3', '1/3']}>
              <WithHorizontalRule>
                {description}
                {schedule}
                {location}
              </WithHorizontalRule>
              <StickyContainer className={styles.sidebar}>
                <Sticky stickyClassName={styles.sticky}>
                  {addToFavorite}
                  {booking}
                </Sticky>
              </StickyContainer>
            </Columns>
            {similarQuests}
          </WithHorizontalRule>
        </Container>
      </PubLayout>
    );
  }
}

QuestPage.propTypes = {
  nav: PropTypes.object.isRequired,
  gallery: PropTypes.object.isRequired,
  description: PropTypes.object.isRequired,
  schedule: PropTypes.object.isRequired,
  location: PropTypes.object.isRequired,
  similarQuests: PropTypes.object.isRequired,
  addToFavorite: PropTypes.object.isRequired,
  booking: PropTypes.object.isRequired,
};
