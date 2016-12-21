const path = require('path');
const webpack = require('webpack');

const postcssImport = require('postcss-import');
const autoprefixer = require('autoprefixer');
const use = require('postcss-use');

const rootPath = path.join(__dirname, '..', '..');

module.exports = {
  entry:  path.join(rootPath, 'src', 'frontend', 'entries', 'main'),
  output: {
    path: path.join(rootPath, 'resources', 'public', 'frontend'),
    filename: 'bundle.js',
    library: 'frontend',
    libraryTarget: 'var',
  },
  resolve: {
    extensions: ['', '.js', '.jsx'],
  },
  module: {
    loaders: [{
      test: /\.jsx?$/,
      loaders: ['babel'],
      include: path.join(rootPath, 'src', 'frontend'),
    }, {
      test: /\.css$/,
      loaders: [
        'style-loader',
        'css?modules&camelCase',
        'postcss'],
    }],
  },
  postcss() {
    return [postcssImport, use({ modules: '*' }), autoprefixer];
  },
};
