import React from 'react';
import 'react-dropdown/style.css'


import Dropdown, {
  DropdownToggle,
  DropdownMenu,
  DropdownMenuWrapper,
  MenuItem,
  DropdownButton
} from '@trendmicro/react-dropdown';

import '@trendmicro/react-buttons/dist/react-buttons.css';
import '@trendmicro/react-dropdown/dist/react-dropdown.css';




function HomeSearch (props) {


    
  return (
     <nav >
        <div   >
         
          <input type="text" /> 
         
          <DropdownButton q
              btnSize="xs"
              title="Genre"
              onSelect={(eventKey) => {
              }}
          >
                  <MenuItem eventKey={1}>genre1</MenuItem>
                  <MenuItem eventKey={2}>genre2</MenuItem>
                  <MenuItem eventKey={3}>genre3</MenuItem>
            </DropdownButton>
        </div>

     </nav>
      
    );
  }
  
  export default HomeSearch;
  