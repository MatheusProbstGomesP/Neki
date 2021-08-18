import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import { BrowserRouter ,Switch, Route} from 'react-router-dom';

import Home from './pages/Home';
import Login from './pages/Login';
import Cadastro from './pages/Cadastro'

import {Menu} from './components/Menu'

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter >
    <Menu/>
      <Switch>
        <Route path="/" component={Home} exact/>
        <Route path="/login" component={Login} exact/>  
        <Route path="/cadastro" component={Cadastro} exact/> 
      </Switch>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);


