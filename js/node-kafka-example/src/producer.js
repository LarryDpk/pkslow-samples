// producer.js

const cron = require('node-cron');
const kafkaUtils = require("./kafka-utils");

const kafka = kafkaUtils.initKafka();

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
