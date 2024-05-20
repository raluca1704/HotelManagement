document.addEventListener("DOMContentLoaded", () => {
    const loadHotelsBtn = document.getElementById("loadHotelsBtn");
    if (loadHotelsBtn) {
        loadHotelsBtn.addEventListener("click", () => {
            loadHotels();
        });
    } else {
        console.error("Button with ID 'loadHotelsBtn' not found");
    }
});

function loadHotels() {
    fetch('/api/hotels/all')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            const hotelsContainer = document.getElementById("hotelsContainer");
            hotelsContainer.innerHTML = ""; // Clear previous content

            if (data.length > 0) {
                data.forEach(hotel => {
                    const hotelDiv = document.createElement("div");
                    hotelDiv.className = "hotel";
                    hotelDiv.dataset.hotelId = hotel.id; // Add hotel ID as a data attribute
                    hotelDiv.innerHTML = `<h3>${hotel.name}</h3><p>Latitude: ${hotel.latitude}, Longitude: ${hotel.longitude}</p>`;
                    hotelsContainer.appendChild(hotelDiv);
                });

                // Add event listener to hotel elements to handle selection
                hotelsContainer.querySelectorAll(".hotel").forEach(hotelDiv => {
                    hotelDiv.addEventListener("click", () => {
                        const selectedHotelId = hotelDiv.dataset.hotelId;
                        showRooms(selectedHotelId);
                    });
                });
            } else {
                hotelsContainer.innerHTML = "<p>No hotels found.</p>";
            }
        })
        .catch(error => {
            console.error('Error fetching hotels:', error);
            const hotelsContainer = document.getElementById("hotelsContainer");
            hotelsContainer.innerHTML = "<p>Error loading hotels. Please try again later.</p>";
        });
}

function showRooms(hotelId) {
    fetch(`/api/hotels/${hotelId}/rooms`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            const roomsContainer = document.getElementById("roomsContainer");
            roomsContainer.innerHTML = ""; // Clear previous content

            if (data.length > 0) {
                data.forEach(room => {
                    const roomDiv = document.createElement("div");
                    roomDiv.className = "room";
                    roomDiv.innerHTML = `<p>Room Number: ${room.roomNumber}</p><p>Type: ${room.type}</p><p>Price: ${room.price}</p>`;
                    roomsContainer.appendChild(roomDiv);
                });
                roomsContainer.style.display = "block"; // Show the rooms container
            } else {
                roomsContainer.innerHTML = "<p>No rooms available.</p>";
            }
        })
        .catch(error => {
            console.error('Error fetching rooms:', error);
            const roomsContainer = document.getElementById("roomsContainer");
            roomsContainer.innerHTML = "<p>Error loading rooms. Please try again later.</p>";
        });
}

function findNearbyHotels() {
    const radius = document.getElementById('radius').value;

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(position => {
            const latitude = position.coords.latitude;
            const longitude = position.coords.longitude;

            fetch(`/api/hotels/nearby?latitude=${latitude}&longitude=${longitude}&radius=${radius}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    const resultsDiv = document.getElementById('hotelsContainer');
                    resultsDiv.innerHTML = '';

                    if (data.length > 0) {
                        data.forEach(hotel => {
                            const hotelDiv = document.createElement('div');
                            hotelDiv.className = "hotel";
                            hotelDiv.dataset.hotelId = hotel.id; // Add hotel ID as a data attribute
                            hotelDiv.innerHTML = `<h3>${hotel.name}</h3><p>Latitude: ${hotel.latitude}, Longitude: ${hotel.longitude}</p>`;
                            resultsDiv.appendChild(hotelDiv);
                        });
                    } else {
                        resultsDiv.innerHTML = "<p>No nearby hotels found.</p>";
                    }
                })
                .catch(error => {
                    console.error('Error fetching nearby hotels:', error);
                    const resultsDiv = document.getElementById('hotelsContainer');
                    resultsDiv.innerHTML = "<p>Error loading nearby hotels. Please try again later.</p>";
                });
        }, error => {
            console.error('Error getting location:', error);
            alert('Error getting location. Please allow location access and try again.');
        });
    } else {
        alert('Geolocation is not supported by this browser.');
    }
}
