const path = require('path');
const webpack = require('webpack');

const UglifyJSPlugin = require('uglifyjs-webpack-plugin');

const postcssImport = require('postcss-import');
const autoprefixer = require('autoprefixer');
const use = require('postcss-use');

const rootPath = path.join(__dirname, '..', '..');

module.exports = {
  entry:  path.join(rootPath, 'src', 'ui', 'entries', 'main'),
  output: {
    path: path.join(rootPath, 'dist'),
    filename: 'ui.js',
    library: 'ui',
    libraryTarget: 'var',
  },
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  module: {
    rules: [{
      test: /\.jsx?$/,
      use: [
        {
          loader: 'babel-loader',
          options: {
            presets: ["es2015", "react"],
          }
        }
      ],
      include: path.join(rootPath, 'src', 'ui'),
    }, {
      test: /\.css$/,
      use: [
        {
          loader: 'style-loader'
        }, {
          loader: 'css-loader',
          options: {
            modules: true,
            camelCase: true,
            minimize: true,
          },
        }, {
          loader: 'postcss-loader',
          options: {
            importLoaders: 1,
            plugins: () => [postcssImport, use({ modules: '*' }), autoprefixer],
          }
        },
      ],
      include: path.join(rootPath, 'src', 'ui'),
    }, {
      test: /\.css$/,
      use: [
        {
          loader: 'style-loader'
        }, {
          loader: 'css-loader',
          options: {
            minimize: true,
          }
        },
      ],
      exclude: path.join(rootPath, 'src', 'ui'),
    }],
  },
  plugins: [
    new webpack.optimize.UglifyJsPlugin({
      compress: false,
      mangle: false,
      beautify: true,
      comments: true,
    }),
  ]
};
