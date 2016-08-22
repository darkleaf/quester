import React from 'react';
import { describe, it } from 'mocha';
import assert from 'assert';
import Examples from './index';

import ReactDOMServer from 'react-dom/server';

describe('<Examples>', () => {
  it('shouldn\'t be empty', () => {
    var html = ReactDOMServer.renderToStaticMarkup(<Examples/>);
    assert(html.length > 0);
  });
});