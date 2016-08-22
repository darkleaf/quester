var path = require('path');

module.exports = {
  entry: './frontend/tests_entry.js',
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'tests.js'
  },
  module: {
    loaders: [{
      test: /\.js$/,
      loader: 'babel'
    }, {
      test:   /\.css$/,
      loader: 'null-loader'
    }]
  },
  target: 'node'
};
