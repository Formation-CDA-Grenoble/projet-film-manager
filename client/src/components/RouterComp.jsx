


import React from "react";
import Comp1 from "./Comp1" ;
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

            <button>
              <Link to="/">home</Link>
            </button>

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


        <Switch >
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
  return  <Comp1 
            testProps = "favorite"
          />
}

function To_Watch() {
  return <Comp1 
          testProps = "to_watch"
          imgUrlProps = "https://image.tmdb.org/t/p/w500/qNs0HRSEvSKmtcMiVa2O1yWUKCk.jpg"
          />
}

function Home() {
  return <Comp1 
          testProps = "Home"
          
          />
}

function History() {
  return <Comp1 
          testProps = "History"
          imgUrlProps = "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"
          />
}
