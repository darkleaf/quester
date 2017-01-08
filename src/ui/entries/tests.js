const context = require.context('./', true, /_test\.jsx?$/);
context.keys().forEach(context);
