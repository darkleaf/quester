const webpack = require('webpack');
const WebpackDevServer = require('webpack-dev-server');
const config = require('./webpack.config');

const port = 3001;
const host = 'localhost';

new WebpackDevServer(webpack(config), {
  publicPath: config.output.publicPath,
  hot: true,
  historyApiFallback: true,
}).listen(port, host, function (err, result) {
  if (err) {
    return console.log(err);
  }

  console.log('Listening at http://' + host + ':' + port);
});
