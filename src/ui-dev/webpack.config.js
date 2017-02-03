const path = require('path');
const webpack = require('webpack');

const postcssImport = require('postcss-import');
const autoprefixer = require('autoprefixer');
const use = require('postcss-use');

const rootPath = path.join(__dirname, '..', '..');

module.exports = {
  devtool: 'eval',
  entry: [
    'react-hot-loader/patch',
    'webpack-dev-server/client?http://localhost:8080',
    'webpack/hot/only-dev-server',
    path.join(rootPath, 'src', 'ui', 'entries', 'example'),
  ],
  output: {
    path: path.join(rootPath, 'dist'),
    filename: 'bundle.js',
    publicPath: '/static/',
  },
  devServer: {
    hot: true,
    contentBase: path.join(rootPath, 'src', 'ui-dev', 'public'),
    publicPath: '/static/'
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NamedModulesPlugin(),
  ],
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  module: {
    rules: [
      {
        test: /\.jsx?$/,
        use: [
          {
            loader: 'babel-loader',
            options: {
              presets: ["es2015", "react"],
              plugins: ["react-hot-loader/babel"],
            }
          }
        ],
      include: path.join(rootPath, 'src', 'ui'),
      },
      {
        test: /\.css$/,
        use: [
          {
            loader: 'style-loader',
          },
          {
            loader: 'css-loader',
            options: {
              modules: true,
              camelCase: true,
              localIdentName: '[folder]---[local]---[hash:base64:3]',
            },
          },
          {
            loader: 'postcss-loader',
            options: {
              importLoaders: 1,
              plugins: () => [postcssImport, use({ modules: '*' }), autoprefixer],
            },
          },
        ],
        include: path.join(rootPath, 'src', 'ui'),
      },
      {
        test: /\.css$/,
        use: [
          'style-loader',
          'css-loader',
        ],
        exclude: path.join(rootPath, 'src', 'ui'),
      }
    ],
  },
};
