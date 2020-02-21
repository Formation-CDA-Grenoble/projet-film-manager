// ce composant est juste un test de props
//non en fait maintenant c'est le composant de history a voir et favoris

import React from 'react';


function PagesContainer (props) {
    return (
     <nav className = "diviDessus">
        <div className = "divi" >
          <h2> {props.testProps}</h2>
          <img src = {props.imgUrlProps}/>
          <h5>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Pariatur sequi in obcaecati, beatae accusamus qui veritatis, velit ipsum quisquam soluta debitis eligendi nam. Modi esse quas, ipsum nisi at voluptates reprehenderit quidem quos quasi asperiores, hic perferendis? Veritatis, eaque? Error voluptate laborum dolores commodi culpa fugiat quos veniam odit quisquam. Officia laborum accusamus sit labore obcaecati accusantium voluptatum asperiores, incidunt eveniet quisquam id adipisci reprehenderit maiores laboriosam dicta ipsa. Porro delectus, et placeat voluptatibus quis quo libero atque aliquid ratione quas deleniti aperiam aspernatur architecto, error officia adipisci esse commodi temporibus? Iusto et architecto pariatur dolore maxime quam aspernatur deleniti quia veritatis harum nam laborum, sequi enim laudantium nobis voluptatibus incidunt expedita eius id unde assumenda mollitia! Ipsa doloremque commodi quisquam reprehenderit cumque. Hic tempore doloribus, deserunt quisquam eveniet facere eum repellat ipsam quibusdam? Minus aliquam in provident magnam pariatur veniam praesentium. Quas iste sed consequatur? Veniam est ipsa accusantium ab esse assumenda sapiente expedita dignissimos odit maxime tempora deserunt, reprehenderit in nemo, inventore consectetur porro nisi dolores deleniti fuga provident tenetur at! Sunt doloremque ducimus aut aspernatur eveniet, similique praesentium voluptates aliquid. Molestias dolore recusandae, adipisci fugiat ex eius laboriosam repellat sit at, dicta voluptas reiciendis distinctio enim nemo.</h5>
        </div>
     </nav>
     
    );
  }
  
  export default PagesContainer;
  