// import React, { Component } from 'react';
// import Axios from 'axios';
// //import Loader from 'react-loader-spinner';

// import FilmsPage from './FilmsPage';

// export default class FilmsPageContainer extends Component {
//     state = {
//       data: null,
//       errorMessage: null,
//     }
  
//     async componentDidMount() {
//       const id = this.props.match.params.id;
//       try {
//         const response = await Axios.get(`http://localhost:8080/api/movies/${id}`);
//         const { data } = response;
//         this.setState({ data });
//       }
//       catch(error) {
//         this.setState({ errorMessage: error.message });
//       }
//       }

// render() {
//     const { data, errorMessage } = this.state;

//     if (errorMessage) {
//       return (
//        <div>
//           {errorMessage}
//       <div/>
//       );
    

//     if (data === null) {
//       return <FilmsPage />;
//     }

   
//     }
// }
// }
