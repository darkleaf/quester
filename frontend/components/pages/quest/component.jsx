import React, { Component, PropTypes } from 'react';

import PubLayout from '../../layout/pub-layout';
import Container from '../../layout/container';

import WithHorizontalRule from '../../utils/with-horizontal-rule';
import Columns from '../../utils/columns';

export default class QuestPage extends Component {
  render() {
    const {
      QuestGallery,
      QuestSimilarQuests,
      QuestDescription,
      QuestSchedule,
      QuestLocation,
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
              <div>sidebar</div>
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
};

QuestPage.propTypes = {
  id: PropTypes.number.isRequired,
};
