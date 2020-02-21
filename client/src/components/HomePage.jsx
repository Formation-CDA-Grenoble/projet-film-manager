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
        <h3><Link to="/films/1">film1</Link></h3>
        <h3><Link to="/films/1">film2</Link></h3>
        <h3> <Link to="/films/1">film3</Link></h3>
        
        
        
       
        
      </div>
    );
  }
  
  export default HomePage;
