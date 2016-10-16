const path = require('path');
const webpack = require('webpack');

const postcssImport = require('postcss-import');
const autoprefixer = require('autoprefixer');
const use = require('postcss-use');

module.exports = {
  devtool: 'eval',
  entry: [
    'webpack-dev-server/client?http://localhost:3000',
    'webpack/hot/only-dev-server',
    './frontend/index',
  ],
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'bundle.js',
    publicPath: '/static/',
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
  ],
  resolve: {
    extensions: ['', '.js', '.jsx'],
  },
  module: {
    loaders: [{
      test: /\.jsx?$/,
      loaders: ['react-hot', 'babel'],
      include: path.join(__dirname, 'frontend'),
    }, {
      test: /\.css$/,
      loaders: [
        'style-loader',
        'css?modules&camelCase&localIdentName=[path][name]---[local]---[hash:base64:5]',
        'postcss'],
    }],
  },
  postcss() {
    return [postcssImport, use({ modules: '*' }), autoprefixer];
  },
};
