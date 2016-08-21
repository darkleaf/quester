module.exports = {
  entry: './entry-file.js',
  output: {
    path: __dirname,
    filename: 'tests.js'
  },
  module: {
    loaders: [{
      test: /\.js$/,
      loader: 'babel'
    }, {
      test:   /\.css$/,
      loader: 'null-loader'
    }]
  },
  target: 'node'
};
