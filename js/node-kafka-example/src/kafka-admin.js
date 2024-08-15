const kafkaUtils = require("./kafka-utils");


async function adminFeatures() {

    const kafka = kafkaUtils.initKafka();
    const admin = kafka.admin();

    const topics = await admin.listTopics();
    console.log(topics);
    console.log(await admin.fetchTopicMetadata({topics: ['my-topic']}));
    console.log(await admin.fetchTopicOffsets('my-topic'));
    console.log(Date.now());
    //month need to -1, below time: 20240815 00:00:00 UTC
    const date = Date.UTC(2024,7,15,0,0,0,0);
    console.log(date);
    console.log(await admin.fetchTopicOffsetsByTimestamp('my-topic',date.valueOf()));

    console.log(await admin.fetchOffsets({ groupId: 'test-group', topics: ['my-topic'] }));


}

adminFeatures().catch(console.error);
