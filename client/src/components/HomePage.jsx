import React from 'react';
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";



function HomePage () {
    return (
     
      <div className = "homi" >
        <h2> films : </h2>
        <Link to="/films/1">film1</Link>
        <Link to="/films/1">film2</Link>
        <Link to="/films/1">film3</Link>
        
       
        
      </div>
    );
  }
  
  export default HomePage;
