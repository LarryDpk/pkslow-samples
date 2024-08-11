// backend/server.js
const express = require('express');
const http = require('http');
const WebSocket = require('ws');

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

// Serve static files from the frontend
app.use(express.static('../ui/build'));

// WebSocket connection
wss.on('connection', (ws) => {
    console.log('New client connected');

    ws.on('message', (message) => {
        console.log(`Received: ${message}`);
        ws.send(`Echo: ${message}`);
    });

    ws.on('close', () => {
        console.log('Client disconnected');
    });
});

// Start the server
server.listen(8080, () => {
    console.log('Server is running on http://localhost:8080');
});
