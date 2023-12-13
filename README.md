# Rock-Paper-Scissors API

This API allows users to play the classic Rock-Paper-Scissors game. Here's a brief guide on how to set up and use the API.
The Rock-Paper-Scissors API provides endpoints to create players, start and join games, make moves, and retrieve game results. To use the API, follow the setup instructions and explore the available endpoints for an interactive gaming experience.
## Setup

1. **Clone the Repository:**
   ```bash
   git clone [repository_url]
   ```

2. **Navigate to the API Directory:**
   ```bash
   cd rock-paper-scissors-api
   ```

3. **Build and Run the API:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **API Endpoints:**
   - **Create Player Token:**
     - Endpoint: `/auth/token`
     - Method: `GET`
     - Description: Creates a new player and returns their unique player ID (token).

   - **Set Player Name:**
     - Endpoint: `/user/name`
     - Method: `POST`
     - Description: Associates a name with a player using their player ID (token).

   - **Start a Game:**
     - Endpoint: `/games/start`
     - Method: `POST`
     - Description: Starts a new game using the player's token.

   - **Join a Game:**
     - Endpoint: `/join/{gameId}`
     - Method: `POST`
     - Description: Joins an existing open game using the player's token and the game ID.

   - **List Open Games:**
     - Endpoint: `/games`
     - Method: `GET`
     - Description: Retrieves a list of open games.

   - **Get Game Information:**
     - Endpoint: `/games/{gameId}`
     - Method: `GET`
     - Description: Retrieves information about a specific game using the game ID.

   - **Make a Move:**
     - Endpoint: `/games/move/{sign}`
     - Method: `POST`
     - Description: Records a move (Rock, Paper, or Scissors) for a specific game and player.

   - **Show Game Result:**
     - Endpoint: `/games/result/{gameId}`
     - Method: `GET`
     - Description: Shows the result of a completed game.


