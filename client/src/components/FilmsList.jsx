
import React from 'react';

import axios from 'axios';

export default class PersonList extends React.Component {
  state = {
    persons: []
  }

  componentDidMount() {
    axios.get(`https://jsonplaceholder.typicode.com/users`)
      .then(res => {
        const persons = res.data;
        this.setState({ persons });
      })
  }

  render() {
    return (
      <ul>
        { this.state.persons.map(person => <li>{person.name}</li>)}
      </ul>
    )
  }
}











// import React from 'react';

// import axios from 'axios';

// export default class FilmsList extends React.Component {
//   state = {
//     films: [] ,
//     errorMessage: null
//   }

//   componentDidMount() {
//     axios.get(`https://api.themoviedb.org/3/genre/movie/list?api_key=a7c17a12a5daad78663eaf3ff41d61d8&language=en-US`)
//       .then(res => {
//         const films = res.data;
//         this.setState({ films });
//       })
//       .catch(error => {
//         this.setState({ errorMessage: error.message });
//       });
//   }

//   render = () => {
   
//     const { data } = this.state;
//     if (data === null) {
//         return <div>fait chier.</div> ;
//       }
//       let test[] = {this.state.films.genres.map} ; 
//     return (

//       <ul>
//           test 
       
          
//       </ul>


//         /* {console.log (this.state.films.genres)} */
     
//         /* { this.state.films.map(film => <li>{film.name}</li>)} */
         
//         /* <li>{this.state[0]}</li>) */
//          //.films.genres[0]
//     )
//   }
// }
