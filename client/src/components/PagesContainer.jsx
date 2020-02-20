// ce composant est juste un test de props
//non en fait maintenant c'est le composant de history a voir et favoris

import React from 'react';


function PagesContainer (props) {
    return (
     
      <div className = "divi" >
        <h2> {props.testProps}</h2>
        <img src = {props.imgUrlProps}/>
        <h5>Lorem ipsum dolor sit amet consectetur adipisicing elit. Adipisci natus voluptatum sed saepe quam perferendis corporis, modi eius tempora voluptate.</h5>
      </div>
    );
  }
  
  export default PagesContainer;
  