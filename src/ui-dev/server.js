const path = require('path');
const webpack = require('webpack');
const WebpackDevServer = require('webpack-dev-server');
const config = require('./webpack.config');

const port = 3001;
const host = 'localhost';
const rootPath = path.join(__dirname, '..', '..');

new WebpackDevServer(webpack(config), {
  publicPath: config.output.publicPath,
  contentBase: path.join(rootPath, 'src', 'ui-dev', 'public'),
  hot: true,
  historyApiFallback: true,
}).listen(port, host, function (err, result) {
  if (err) {
    return console.log(err);
  }

  console.log('Listening at http://' + host + ':' + port);
});
