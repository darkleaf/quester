const path = require('path');
const webpack = require('webpack');

const postcssImport = require('postcss-import');
const autoprefixer = require('autoprefixer');
const use = require('postcss-use');

const rootPath = path.join(__dirname, '..', '..');

module.exports = {
  devtool: 'eval',
  entry: [
    'webpack-dev-server/client?http://localhost:3000',
    'webpack/hot/only-dev-server',
    path.join(rootPath, 'src', 'ui', 'entries', 'example'),
  ],
  output: {
    path: path.join(rootPath, 'dist'),
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
      include: path.join(rootPath, 'src', 'ui'),
    }, {
      test: /\.css$/,
      loaders: [
        'style-loader',
        'css?modules&camelCase&localIdentName=[folder]---[local]---[hash:base64:3]',
        'postcss'],
    }],
  },
  postcss() {
    return [postcssImport, use({ modules: '*' }), autoprefixer];
  },
};
