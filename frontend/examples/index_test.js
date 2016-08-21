import { describe, it } from 'mocha';
import assert from 'assert';

describe('some test', () => {
  it('should work', () => {
    assert.equal(1, 1);
  });
  it('shouldn\'t work', () => {
    assert.equal(1, 2);
  });
});