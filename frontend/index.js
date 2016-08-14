import React, {Component} from "react";
import ReactDOM from "react-dom";

import {addLocaleData} from 'react-intl';
import ru from 'react-intl/locale-data/ru';
addLocaleData([...ru]);


import MainPage from "./examples/main-page"


ReactDOM.render(<MainPage />, document.getElementById('root')
);
