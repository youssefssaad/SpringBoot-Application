import React, { useState } from 'react';
import axios from 'axios';

const Admin = () => {
    const [crew, setCrew] = useState({ crew_name: '', crew_id: '' });
    const [aircraft, setAircraft] = useState({ model: '', capacity: '', aircraftId: '' });
    const [flight, setFlight] = useState({
        departureLocation: '',
        destination: '',
        departureTime: '',
        arrivalTime: '',
        flightId: ''
    });

    // Crew Management Functions
    const handleCrewChange = (e) => {
        const { name, value } = e.target;
        setCrew({ ...crew, [name]: value });
    };

    const handleAddCrew = async () => {
        try {
            await axios.post('http://localhost:8080/crew', crew);
            alert('Crew added successfully');
        } catch (error) {
            console.error('Error adding crew:', error);
            alert('Error adding crew');
        }
    };

    const handleRemoveCrew = async () => {
        try {
            await axios.delete(`http://localhost:8080/crew/${crew.crew_id}`);
            alert('Crew removed successfully');
        } catch (error) {
            console.error('Error removing crew:', error);
            alert('Error removing crew');
        }
    };

    const handleEditCrew = async () => {
        try {
            await axios.put(`http://localhost:8080/crew/${crew.crew_id}`, crew);
            alert('Crew updated successfully');
        } catch (error) {
            console.error('Error updating crew:', error);
            alert('Error updating crew');
        }
    };

    // Aircraft Management Functions
    const handleAircraftChange = (e) => {
        const { name, value } = e.target;
        setAircraft({ ...aircraft, [name]: value });
    };

    const handleAddAircraft = async () => {
        try {
            await axios.post('http://localhost:8080/aircraft', aircraft);
            alert('Aircraft added successfully');
        } catch (error) {
            console.error('Error adding aircraft:', error);
            alert('Error adding aircraft');
        }
    };

    const handleRemoveAircraft = async () => {
        try {
            await axios.delete(`http://localhost:8080/aircraft/${aircraft.aircraftId}`);
            alert('Aircraft removed successfully');
        } catch (error) {
            console.error('Error removing aircraft:', error);
            alert('Error removing aircraft');
        }
    };

    const handleEditAircraft = async () => {
        try {
            await axios.put(`http://localhost:8080/aircraft/${aircraft.aircraftId}`, aircraft);
            alert('Aircraft updated successfully');
        } catch (error) {
            console.error('Error updating aircraft:', error);
            alert('Error updating aircraft');
        }
    };

    // Flight Management Functions
    const handleFlightChange = (e) => {
        const { name, value } = e.target;
        if (name.includes("aircraft") || name.includes("crew")) {
            const [parentKey, childKey] = name.split(".");
            setFlight(prevState => ({
                ...prevState,
                [parentKey]: { ...prevState[parentKey], [childKey]: value }
            }));
        } else {
            setFlight({ ...flight, [name]: value });
        }
    };

    const handleAddFlight = async () => {
        try {
            const updatedFlight = {
                ...flight
            };
            await axios.post('http://localhost:8080/flight', updatedFlight);
            alert('Flight added successfully');
        } catch (error) {
            console.error('Error adding flight:', error);
            alert('Error adding flight');
        }
    };

    const handleRemoveFlight = async () => {
        try {
            await axios.delete(`http://localhost:8080/flight/${flight.flightId}`);
            alert('Flight removed successfully');
        } catch (error) {
            console.error('Error removing flight:', error);
            alert('Error removing flight');
        }
    };

    const handleEditFlight = async () => {
        try {
            const updatedFlight = {
                ...flight
            };
            await axios.put(`http://localhost:8080/flight/${flight.flightId}`, updatedFlight);
            alert('Flight updated successfully');
        } catch (error) {
            console.error('Error updating flight:', error);
            alert('Error updating flight');
        }
    };

    return (
        <div className='adminFunctions'>
            {/* Crew Management */}
            <div>
                <input type="text" name="crew_name" value={crew.crew_name} onChange={handleCrewChange} placeholder="Crew Name" />
                <input type="number" name="crew_id" value={crew.crew_id} onChange={handleCrewChange} placeholder="Crew ID for Remove" />
                <button onClick={handleAddCrew}>Add Crew</button>
                <button onClick={handleRemoveCrew}>Remove Crew</button>
            </div>

            {/* Aircraft Management */}
            <div>
                <input type="text" name="model" value={aircraft.model} onChange={handleAircraftChange} placeholder="Aircraft Model" />
                <input type="number" name="capacity" value={aircraft.capacity} onChange={handleAircraftChange} placeholder="Capacity" />
                <input type="number" name="aircraftId" value={aircraft.aircraftId} onChange={handleAircraftChange} placeholder="Aircraft ID for Edit/Remove" />
                <button onClick={handleAddAircraft}>Add Aircraft</button>
                <button onClick={handleRemoveAircraft}>Remove Aircraft</button>
                <button onClick={handleEditAircraft}>Edit Aircraft</button>
            </div>

            {/* Flight Management */}
            <div>
                <input type="text" name="departureLocation" value={flight.departureLocation} onChange={handleFlightChange} placeholder="Departure Location" />
                <input type="text" name="destination" value={flight.destination} onChange={handleFlightChange} placeholder="Destination" />
                <input type="datetime-local" name="departureTime" value={flight.departureTime} onChange={handleFlightChange} placeholder="Departure Time" />
                <input type="datetime-local" name="arrivalTime" value={flight.arrivalTime} onChange={handleFlightChange} placeholder="Arrival Time" />
                <input type="number" name="flightId" value={flight.flightId} onChange={handleFlightChange} placeholder="Flight ID for Edit/Remove" />
                <button onClick={handleAddFlight}>Add Flight</button>
                <button onClick={handleRemoveFlight}>Remove Flight</button>
                <button onClick={handleEditFlight}>Edit Flight</button>
            </div>
        </div>
    );
};

export default Admin;
