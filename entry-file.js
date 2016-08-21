const context = require.context('mocha!./frontend', true, /.+_test\.js?$/);
context.keys().forEach(context);