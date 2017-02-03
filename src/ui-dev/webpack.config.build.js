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
          loader: 'css-loader'
        },
      ],
      exclude: path.join(rootPath, 'src', 'ui'),
    }],
  },
};
