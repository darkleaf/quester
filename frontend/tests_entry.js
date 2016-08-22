const context = require.context('mocha!./examples', true, /_test\.js$/);
context.keys().forEach(context);