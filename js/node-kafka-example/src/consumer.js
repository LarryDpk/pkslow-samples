// consumer.js

const { Kafka } = require('kafkajs');

// Initialize Kafka
const kafka = new Kafka({
    clientId: 'my-consumer',
    brokers: ['localhost:9092'] // Replace with your Kafka broker addresses
});

// Create a consumer instance
const consumer = kafka.consumer({ groupId: 'test-group' });

const run = async () => {
    // Connect the consumer
    await consumer.connect();

    // Subscribe to the topic
    await consumer.subscribe({ topic: 'my-topic', fromBeginning: true });

    // Consume messages
    await consumer.run({
        eachMessage: async ({ topic, partition, message }) => {
            console.log({
                partition,
                offset: message.offset,
                value: message.value.toString(),
            });
        },
    });
};

run().catch(console.error);

console.log('Consumer running...');
