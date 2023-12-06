import {useState} from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import "./index.css";
import FlightList from "./Pages/FlightList";
import PassengerList from "./Pages/PassengerList"
import Admin from "./Pages/Admin";
import Login from "./Pages/Login";
import Register from "./Pages/Register";
import FlightCard from "./Components/FlightCard";

function ProtectedRoute({ allowedRoles, userRole, children }) {
  if (allowedRoles.includes(userRole)) {
    return <div>{children}</div>;
  }
  else {
    return <Navigate to="/" replace />;
  }
}

function App(){
  const [userRole, setUserRole] = useState(null);

  const handleLogin = (isSuccessful, role) => {
    setUserRole(isSuccessful ? role : null);
  };

    return(
    <BrowserRouter>
      <Routes>
          <Route path="/login" element={<Login onLogin={handleLogin} />} />
          <Route path="/admin" element={<Admin />}/>
          <Route path="/attendant" element={<PassengerList />} />
          <Route path="/" element={<FlightList />} />
          <Route path="/flights/:id" element={<FlightCard />} />
          <Route path="/register" element={<Register onRegister={Login} />} />
      </Routes>
    </BrowserRouter>
);
}
export default App;