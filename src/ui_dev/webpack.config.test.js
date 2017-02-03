const path = require('path');
const rootPath = path.join(__dirname, '..', '..');

module.exports = {
  entry: path.join(rootPath, 'src', 'ui', 'entries', 'tests.js'),
  output: {
    path: path.join(rootPath, 'dist'),
    filename: 'tests.js',
  },
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
              plugins: [
                ["istanbul", {"exclude": ["**/*_test.jsx"]}]
              ],
            },
          },
        ],
        include: path.join(rootPath, 'src', 'ui'),
      }, {
        test: /\.css$/,
        loader: 'null-loader',
      }
    ],
  },
  target: 'node',
};
