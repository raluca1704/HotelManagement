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
                    hotelDiv.innerHTML = `<h3>${hotel.name}</h3><p>Latitude: ${hotel.latitude}, Longitude: ${hotel.longitude}</p>`;
                    hotelsContainer.appendChild(hotelDiv);
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
