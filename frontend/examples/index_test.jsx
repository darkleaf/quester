/* global describe it */
import React from 'react';
import ReactDOMServer from 'react-dom/server';
import assert from 'assert';
import Examples from './index';

describe('Examples component', () => {
  it('should be present', () => {
    const html = ReactDOMServer.renderToStaticMarkup(<Examples />);
    assert(html.length > 0);
  });
});
