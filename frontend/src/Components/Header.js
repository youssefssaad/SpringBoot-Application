import { FaSearch, FaCalendarAlt, FaSignInAlt, FaUserPlus } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const Header = () => {
  const navigate = useNavigate();

  const handleRegisterClick = () => {
    navigate('/Register');
  };

  const handleLoginClick = () => {
    navigate('/Login');
  };

  return (
    <div className="header">
      <h1 className="headerTitle"> Book your flight here! </h1>
      <p className="headerDescription"> Make an account to be eligible for promos and free flights!</p>          
      <div className="headerItems">
          <button className="headerButton" onClick={handleRegisterClick}>
            Register <FaUserPlus />
          </button>
          <button className="headerButton" onClick={handleLoginClick}>
            Login <FaSignInAlt />
          </button>
      </div>
    </div>
  )
}

export default Header;
