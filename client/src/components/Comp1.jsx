// ce composant est juste un test de props

import React from 'react';
import AuthService from '../service/AuthService';

function Comp1 (props) {
    return (
     
      <div className = "divi" >
        <h2>  <AuthService.getUserInfo></AuthService.getUserInfo></h2>
       
  
        <img src = {props.imgUrlProps}/>
        <h5>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci natus voluptatum sed saepe quam perferendis corporis, modi eius tempora voluptate.</h5>
    
      </div>
    );
  }
  
  export default Comp1;
  