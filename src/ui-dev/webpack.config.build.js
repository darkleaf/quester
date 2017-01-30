const path = require('path');
const webpack = require('webpack');

const postcssImport = require('postcss-import');
const autoprefixer = require('autoprefixer');
const use = require('postcss-use');

const rootPath = path.join(__dirname, '..', '..');

module.exports = {
  entry:  path.join(rootPath, 'src', 'ui', 'entries', 'main'),
  output: {
    path: path.join(rootPath, 'resources', 'public', 'ui'),
    filename: 'bundle.js',
    library: 'ui',
    libraryTarget: 'var',
  },
  resolve: {
    extensions: ['', '.js', '.jsx'],
  },
  module: {
    loaders: [{
      test: /\.jsx?$/,
      loaders: ['babel'],
      include: path.join(rootPath, 'src', 'ui'),
    }, {
      test: /\.css$/,
      loaders: [
        'style-loader',
        'css?modules&camelCase',
        'postcss'
      ],
      include: path.join(rootPath, 'src', 'ui'),
    }, {
      test: /\.css$/,
      loaders: [
        'style-loader',
        'css'
      ],
      exclude: path.join(rootPath, 'src', 'ui'),
    }],
  },
  postcss() {
    return [postcssImport, use({ modules: '*' }), autoprefixer];
  },
};
