// consumer.js
const kafkaUtils = require("./kafka-utils");

const kafka = kafkaUtils.initKafka();

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
