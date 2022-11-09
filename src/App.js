import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Home from './components/Home';
import AddProduct from './components/AddProduct';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/addproduct" exact component={AddProduct} />
      </Switch>
    </BrowserRouter>
  )
}

export default App;
