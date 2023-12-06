import React, { useState, useEffect } from 'react';
import Header from '../Components/Header';
import Footer from '../Components/Footer';
import FlightCard from '../Components/FlightCard';

const FlightList = () => {
  const [flights, setFlights] = useState([]);

  useEffect(() => {
    const fetchFlights = async () => {
      try {
        const response = await fetch('http://localhost:8080/flight');
        const data = await response.json();
        setFlights(data);
      } catch (error) {
        console.error('Error fetching flights:', error);
      }
    };
    fetchFlights();
  }, []);

  return (
    <div>
      <Header />
      <div className="flightsResults">
        {flights.map(flight => (
          <FlightCard key={flight.flightID} flight={flight} />
        ))}
      </div>
      <Footer />
    </div>
  );
};

export default FlightList;
