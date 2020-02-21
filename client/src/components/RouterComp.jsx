
import React from "react";
import PagesContainer from "./PagesContainer.jsx" ;
import HomePage from "./HomePage.jsx" ;
import FilmsList from "./FilmsList.jsx" ;
import FilmsPage from "./FilmsPage" ;
import HomeSearch from "./HomeSearch" ; 
import Button from 'react-bootstrap/Button';
import LoginComponent from './LoginComponent'
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
        <nav  >
        
          <ul className = "header">
          
            
            <Button variant="outline-secondary" size="lg">
            <Link to="/">Home</Link>
           </Button>

            <h4>
              <Link to="/Favorite">Favorite</Link>
            </h4>


            <h4>
              <Link to="/To_Watch">To_watch</Link>
            </h4>


            <h4>
              <Link to="/History">History</Link>
            </h4>

            
            <h4>
              <Link to="/login">Login</Link>
            </h4>
            

        
          </ul>
        </nav>

        <Switch >
          <Route exact path="/Favorite">
            <Favorite />
          </Route>
          <Route exact path="/To_Watch">
            <To_Watch />
          </Route>
          <Route exact path="/History">
            <History />
          </Route>
           <Route exact path="/">
            <Home />
          </Route>
          <Route exact path="/login">
            <Login />
          </Route>
          <Route exact path="/films/1">
            <Films />
          </Route>
        </Switch>
        
      
      </div>
    </Router>
  );
}

function Home() {
  return  (
  <div className = "bigHome">
          <HomeSearch />
          <HomePage />  
       
  </div>
   
  )
  
         
}

function Films() {
  return (
    <div>
      <FilmsList/>
    </div>
   

  )
}

function Favorite() {
  return  <PagesContainer 
            testProps = "favorite"
            imgUrlProps = "https://image.tmdb.org/t/p/w500//sh6Kn8VBfXotJ6qsvJkdfscxXKR.jpg"
          />
          
}

function To_Watch() {
  return <PagesContainer 
          testProps = "to_watch"
          imgUrlProps = "https://image.tmdb.org/t/p/w500/qNs0HRSEvSKmtcMiVa2O1yWUKCk.jpg"
          />
}



function History() {
  return <PagesContainer 
          testProps = "History"
          imgUrlProps = "https://image.tmdb.org/t/p/w500/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg"
          />
}

function Login() {
  return <LoginComponent/>
}


