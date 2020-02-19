// ce composant est juste un test de props

import React from 'react';


function Comp1 (props) {
    return (
     
      <div className = "divi" >
        <h2> {props.testProps}</h2>
        <img src = {props.imgUrlProps}/>
        <h5>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci natus voluptatum sed saepe quam perferendis corporis, modi eius tempora voluptate.</h5>
      </div>
    );
  }
  
  export default Comp1;
  