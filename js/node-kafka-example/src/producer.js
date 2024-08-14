// producer.js

const { Kafka } = require('kafkajs');
const cron = require('node-cron');
const fs = require('fs');

// Initialize Kafka
let kafka = null;
if (process.env.KAFKA_SSL_DISABLE) {
    kafka = new Kafka({
        clientId: 'my-producer',
        brokers: ['localhost:9092'] // Replace with your Kafka broker addresses
    });
} else {
    kafka = new Kafka({
        clientId: 'my-producer',
        brokers: ['localhost:9093'],
        ssl: {
            rejectUnauthorized: false, // Optionally, set to false for self-signed certs
            ca: [fs.readFileSync('/Users/larry/IdeaProjects/pkslow-samples/other/kafka-ssl-security/ca-cert.pem', 'utf-8')],
            key: fs.readFileSync('/Users/larry/IdeaProjects/pkslow-samples/other/kafka-ssl-security/kafka-client-key.pem', 'utf-8'),
            cert: fs.readFileSync('/Users/larry/IdeaProjects/pkslow-samples/other/kafka-ssl-security/kafka-client-cert.pem', 'utf-8')
            // passphrase: 'keystore-password'
        },
    });
}


// Create a producer instance
const producer = kafka.producer();

// Function to send a message to Kafka
const sendMessage = async () => {
    try {
        await producer.connect();
        await producer.send({
            topic: 'my-topic', // Replace with your Kafka topic
            messages: [{ value: `Message sent at ${new Date().toISOString()}` }],
        });
        console.log('Message sent successfully');
        await producer.disconnect();
    } catch (err) {
        console.error('Error sending message', err);
    }
};

// Schedule a cron job to send a message every 3 seconds
cron.schedule('*/3 * * * * *', () => {
    console.log('Cron job running...');
    sendMessage();
});

console.log('Producer running...');
