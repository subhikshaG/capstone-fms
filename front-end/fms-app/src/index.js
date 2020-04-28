import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './component/App';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';
import $ from 'jquery';
import Popper from 'popper.js';
import { BrowserRouter } from 'react-router-dom'

import { Provider } from 'react-redux'
import store from './store/store'


ReactDOM.render(<Provider store={store}><BrowserRouter><App /></BrowserRouter></Provider>, document.getElementById('root'));


