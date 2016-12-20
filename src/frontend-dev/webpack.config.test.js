const path = require('path');
const rootPath = path.join(__dirname, '..', '..');

module.exports = {
  entry: path.join(rootPath, 'src', 'frontend', 'tests_entry.js'),
  output: {
    path: path.join(rootPath, 'dist'),
    filename: 'tests.js',
  },
  resolve: {
    extensions: ['', '.js', '.jsx'],
  },
  module: {
    loaders: [{
      test: /\.jsx?$/,
      loader: 'babel',
      include: path.join(rootPath, 'src', 'frontend'),
    }, {
      test: /\.css$/,
      loader: 'null-loader',
    }],
  },
  target: 'node',
};
