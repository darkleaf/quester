const path = require('path');

module.exports = {
  entry: './frontend/tests_entry.js',
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'tests.js',
  },
  resolve: {
    extensions: ['', '.js', '.jsx'],
  },
  module: {
    loaders: [{
      test: /\.jsx?$/,
      loader: 'babel',
      include: path.join(__dirname, 'frontend'),
    }, {
      test: /\.css$/,
      loader: 'null-loader',
    }],
  },
  target: 'node',
};
