import React from 'react';
import { useNavigate } from 'react-router-dom';
import airplaneLogo from './airplanelogo.png';

const FlightCard = ({ flight }) => {
  const navigate = useNavigate();

  const handleSeatClick = () => {
      navigate(`/flight/${flight.flightId}/seatmap`);
  };

  const formatDateTime = (dateString) => {
    const date = new Date(dateString);
    return date.toLocaleString();
  };

  return (
      <div className="flightCard">
          <img src={airplaneLogo} alt="Airplane" className="flightCardImage"/>
          <h1 className='flightCardDescriptionTitle'>{flight.destination}</h1>
          <span className='flightCardDescriptionSubTitle'>Group7 Air</span>
          <span className='flightCardDescriptionSchedule'>Takeoff: {formatDateTime(flight.departureTime)}. Landing: {formatDateTime(flight.arrivalTime)}.</span>
          <span className='flightCardDescriptionSchedule'>Aircraft: {flight.aircraft?.model}</span>
          <span className='flightCardDescriptionPrice'>${flight.price}</span>
          <button className='flightCardDescriptionButton' onClick={handleSeatClick}>Select Seat</button>
      </div>
  )
}

export default FlightCard;
