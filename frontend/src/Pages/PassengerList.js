import React, { useState } from 'react';

const PassengerList = () => {
    const [flightId, setFlightId] = useState('');
    const [passengers, setPassengers] = useState([]);
    const [loading, setLoading] = useState(false);

    const fetchPassengers = async () => {
        if (!flightId) {
            alert("Please select a flight ID.");
            return;
        }
    
        setLoading(true);
        try {
            const response = await fetch(`http://localhost:8080/reservation/${flightId}/reservation`);
            if (!response.ok) {
                throw new Error(`Error: ${response.status}`);
            }
            const data = await response.json();
            setPassengers(data);
        } catch (error) {
            console.error('Fetch error:', error);
            alert('Error fetching passenger list');
        } finally {
            setLoading(false);
        }
    }
    

    return (
        <div className='passengerList'>
            <form onSubmit={(e) => { e.preventDefault(); fetchPassengers(); }}>
                <label htmlFor="flightId">Flight ID: </label>
                <input 
                    type="number" 
                    id="flightId"
                    value={flightId}
                    onChange={(e) => setFlightId(e.target.value)} 
                    placeholder="Enter Flight ID"
                />
                <button className='passengerListButton' type="submit">Get Passenger List</button>
            </form>
            {loading && <p>Loading...</p>}
            {passengers.length > 0 ? (
                <ul>
                    {passengers.map(passenger => (
                        <li key={passenger.CustomerID}>
                            {passenger.Name} - {passenger.ContactInfo} - {passenger.Address} - {passenger.Email} - {passenger.MemberStatus}
                        </li>
                    ))}
                </ul>
            ) : (
                !loading && <p>No passengers found for this flight.</p>
            )}
        </div>
    )
}

export default PassengerList;
