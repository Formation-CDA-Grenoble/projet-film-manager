// ce composant est juste un test de props

import React from 'react';


function Comp1 (props) {
    return (
     
      <div className = "divi" >
        <h2> {props.testProps}</h2>
        <img src = {props.imgUrlProps}/>
      </div>
    );
  }
  
  export default Comp1;
  