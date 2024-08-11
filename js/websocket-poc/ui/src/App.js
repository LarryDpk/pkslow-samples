// frontend/src/App.js
import React, { useEffect, useState } from 'react';

function App() {
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState('');
  const [ws, setWs] = useState(null);

  useEffect(() => {
    const socket = new WebSocket('ws://localhost:8080');

    socket.onopen = () => {
      console.log('Connected to WebSocket server');
    };

    socket.onmessage = (event) => {
      setMessages((prevMessages) => [...prevMessages, event.data]);
    };

    socket.onclose = () => {
      console.log('Disconnected from WebSocket server');
    };

    setWs(socket);

    return () => {
      socket.close();
    };
  }, []);

  const sendMessage = () => {
    if (ws && input.trim()) {
      ws.send(input);
      setInput('');
    }
  };

  return (
      <div style={{ padding: '20px' }}>
        <h1>WebSocket Chat</h1>
        <div>
          <input
              type="text"
              value={input}
              onChange={(e) => setInput(e.target.value)}
              onKeyPress={(e) => e.key === 'Enter' && sendMessage()}
              style={{ marginRight: '10px' }}
          />
          <button onClick={sendMessage}>Send</button>
        </div>
        <div style={{ marginTop: '20px' }}>
          <h2>Messages:</h2>
          {messages.map((msg, index) => (
              <p key={index}>{msg}</p>
          ))}
        </div>
      </div>
  );
}

export default App;
