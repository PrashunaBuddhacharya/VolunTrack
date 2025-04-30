<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Volunteering Opportunities - Voluntrack</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/opportunities.css" />
</head>
<body>
    <div class="header">
        <h1>🌍 Explore Exciting Volunteering Opportunities</h1>
        <p>Across different countries, cultures, and communities!</p>
    </div>

    <div class="container">
        <div class="search-bar">
            <input type="text" id="searchInput" placeholder="Search by country, type..." onkeyup="filterCards()" />
        </div>

        <div class="grid" id="opportunityGrid">
            <!-- Repeat for all 8 opportunities -->
            <div class="card">
                <div class="img-square">
                    <img src="resources/thai.jpg" alt="Teach English in Thailand" />
                </div>
                <h3>Teach English in Thailand</h3>
                <p>Work with local students and explore Thai culture.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $300 (includes accommodation and meals)</p>
                    <p><strong>Duration:</strong> 4 weeks</p>
                    <p><strong>Description:</strong> Volunteers will assist in local schools, helping with English classes and organizing cultural exchange activities.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

            <div class="card">
                <div class="img-square">
                    <img src="resources/abc.jpg" alt="Wildlife Care in South Africa" />
                </div>
                <h3>Wildlife Care in South Africa</h3>
                <p>Help protect animals in a game reserve.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $500 (includes stay, meals, transport)</p>
                    <p><strong>Duration:</strong> 2-6 weeks</p>
                    <p><strong>Description:</strong> Assist rangers with feeding, medical care, and educational tourism programs.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

            <div class="card">
                <div class="img-square">
                    <img src="resources/brazil.jpg" alt="Community Education in Brazil" />
                </div>
                <h3>Community Education in Brazil</h3>
                <p>Support education and literacy programs.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $250</p>
                    <p><strong>Duration:</strong> 6 weeks</p>
                    <p><strong>Description:</strong> Volunteers will help children improve reading and writing skills while participating in fun cultural exchange sessions.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

            <div class="card">
                <div class="img-square">
                    <img src="resources/india.jpg" alt="Women Empowerment in India" />
                </div>
                <h3>Women Empowerment in India</h3>
                <p>Promote gender equality and leadership.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $150</p>
                    <p><strong>Duration:</strong> 5 weeks</p>
                    <p><strong>Description:</strong> Conduct workshops for local women and girls focused on rights awareness, health, and leadership skills.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

            <div class="card">
                <div class="img-square">
                    <img src="resources/mexico.jpg" alt="Climate Action in Mexico" />
                </div>
                <h3>Climate Action in Mexico</h3>
                <p>Raise awareness about climate change in local communities.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $180</p>
                    <p><strong>Duration:</strong> 4 weeks</p>
                    <p><strong>Description:</strong> Host educational events, plant trees, and collaborate with youth for sustainability.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

            <div class="card">
                <div class="img-square">
                    <img src="resources/japan.jpg" alt="Cultural Exchange in Japan" />
                </div>
                <h3>Cultural Exchange in Japan</h3>
                <p>Engage in tourism and local storytelling in Kyoto.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $350</p>
                    <p><strong>Duration:</strong> 3-5 weeks</p>
                    <p><strong>Description:</strong> Promote local heritage through cultural walks, digital content, and international exchange programs.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

            <div class="card">
                <div class="img-square">
                    <img src="resources/vietnam.jpg" alt="Eco Farming in Vietnam" />
                </div>
                <h3>Eco Farming in Vietnam</h3>
                <p>Promote sustainable agriculture and permaculture.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $100</p>
                    <p><strong>Duration:</strong> 6 weeks</p>
                    <p><strong>Description:</strong> Support organic farming practices, composting, and eco-building at local farms.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

            <div class="card">
                <div class="img-square">
                    <img src="resources/ghana.jpg" alt="Health Awareness in Ghana" />
                </div>
                <h3>Health Awareness in Ghana</h3>
                <p>Spread hygiene and health education in rural areas.</p>
                <div class="details">
                    <p><strong>Fee:</strong> $200</p>
                    <p><strong>Duration:</strong> 4-6 weeks</p>
                    <p><strong>Description:</strong> Collaborate with clinics and NGOs to deliver workshops and community outreach programs on public health and hygiene.</p>
                </div>
                <div class="btn-container">
                    <a href="#" class="btn" onclick="toggleDetails(event, this)">View Details</a>
                    <a href="#" class="btn">Apply</a>
                </div>
            </div>

        </div>
    </div>

    <script>
        function toggleDetails(event, btn) {
            event.preventDefault();
            const card = btn.closest(".card");
            const details = card.querySelector(".details");
            details.style.display = details.style.display === "block" ? "none" : "block";
        }

        function filterCards() {
            const input = document.getElementById("searchInput").value.toLowerCase();
            const cards = document.querySelectorAll(".card");
            cards.forEach(card => {
                const title = card.querySelector("h3").textContent.toLowerCase();
                const desc = card.querySelector("p").textContent.toLowerCase();
                card.style.display = (title.includes(input) || desc.includes(input)) ? "block" : "none";
            });
        }
    </script>
</body>
</html>
