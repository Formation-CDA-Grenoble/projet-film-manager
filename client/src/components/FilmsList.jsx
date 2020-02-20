import React from 'react';

import axios from 'axios';

export default class FilmsList extends React.Component {
  state = {
    films: []
  }

  componentDidMount() {
    axios.get(`https://api.themoviedb.org/3/genre/movie/list?api_key=a7c17a12a5daad78663eaf3ff41d61d8&language=en-US`)
      .then(res => {
        const films = res.data;
        this.setState({ films });
      })
  }

  render = () => {
   
   
    if (this.state === null) {
        return <div>fsdfsfs</div> ;
      }
   
    return (
        
      <ul>
        {/* { this.state.films.map(film => <li>{film.name}</li>)} */}
         {console.log (this.state.films.genres)}
          {/* <li>{this.state[0]}</li>) */}
      </ul>
     
      //.films.genres[0]
    )
  }
}
