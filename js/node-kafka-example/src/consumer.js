// consumer.js

const { Kafka } = require('kafkajs');
const fs = require('fs');

// Initialize Kafka
let kafka = null;
if (process.env.KAFKA_SSL_DISABLE) {
    kafka = new Kafka({
        clientId: 'my-consumer',
        brokers: ['localhost:9092'] // Replace with your Kafka broker addresses
    });
} else {
    kafka = new Kafka({
        clientId: 'my-consumer',
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
