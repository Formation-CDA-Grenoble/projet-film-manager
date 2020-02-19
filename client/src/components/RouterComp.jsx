


import React from "react";
import Comp1 from './components/Comp1'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";

export default function RouterComp() {
  
    return (
    <Router>
      <div >
        <nav >
          <ul className = "header">
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/Favorite">Favorite</Link>
            </li>
            <li>
              <Link to="/To_Watch">To_watch</Link>
            </li>
            <li>
              <Link to="/History">History</Link>
            </li>
            

        
          </ul>
        </nav>


        <Switch>
          <Route path="/Favorite">
            <Favorite />
          </Route>
          <Route path="/To_Watch">
            <To_Watch />
          </Route>
          <Route path="/History">
            <History />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

function Favorite() {
  return <h2>favorite</h2>;
}

function To_Watch() {
  return <h2>To_Watch</h2>;
}

function Home() {
  return <h2>Home</h2>;
}

function History() {
  return <h2>History</h2>;
}
