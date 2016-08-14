var path = require('path');
var webpack = require('webpack');

var autoprefixer = require('autoprefixer');
var use = require('postcss-use');

module.exports = {
  devtool: 'eval',
  entry: [
    'webpack-dev-server/client?http://localhost:3000',
    'webpack/hot/only-dev-server',
    './frontend/index'
  ],
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'bundle.js',
    publicPath: '/static/',
    library: 'UI'
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin()
  ],
  module: {
    loaders: [{
      test: /\.js$/,
      loaders: ['react-hot', 'babel'],
      include: path.join(__dirname, 'frontend')
    }, {
      test:   /\.css$/,
      loaders: [
        'style-loader',
        'css?modules&camelCase&localIdentName=[path][name]---[local]---[hash:base64:5]',
        'postcss']
    }]
  },
  postcss: function () {
    return [use({modules: '*' }), autoprefixer];
  }
};
