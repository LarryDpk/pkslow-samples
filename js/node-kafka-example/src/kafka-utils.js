const { Kafka } = require('kafkajs');
const fs = require('fs');

function initKafka() {
    // Initialize Kafka
    if (process.env.KAFKA_SSL_DISABLE) {
        const kafka = new Kafka({
            clientId: 'my-producer',
            brokers: ['localhost:9092'] // Replace with your Kafka broker addresses
        });
        return kafka;
    } else {
        const kafka = new Kafka({
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
        return kafka;
    }
}

module.exports = {
    initKafka
}

