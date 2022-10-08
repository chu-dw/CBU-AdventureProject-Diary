import { BrowserRouter, Route, Routes } from "react-router-dom";
import React from 'react';
import Calendar from "./routes/Calendar";
import Login from "./routes/Login";
import Join from "./routes/Join";
import Design from "./routes/Design";
import Writing from "./routes/Writing";
import Profile from "./routes/Profile";

const App : React.FC = () => {
  return (
    <BrowserRouter>
      <Routes>    
       <Route path="/" element={<Login />} />
       <Route path="/join" element={<Join />} />
       <Route path="/calender" element={<Calendar />} />
       <Route path="/design" element={<Design />} />
       <Route path="writing" element={<Writing />} />
       <Route path="/profile" element={<Profile/>} />
      </Routes>
    </BrowserRouter>
  );
}



export default App;
