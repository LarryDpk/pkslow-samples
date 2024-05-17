
bin/kafka-topics.sh --bootstrap-server host:9092 --list
bin/kafka-consumer-groups.sh --bootstrap-server host:9092 --list
bin/kafka-consumer-groups.sh --bootstrap-server host:9092 --describe --group groupName

bin/kafka-consumer-groups.sh --bootstrap-server host:9092 --list \
| xargs -I {} bin/kafka-consumer-groups.sh --bootstrap-server host:9092 --describe --group {} \
> kafka.consumer-groups.info.txt



$ bin/kafka-run-class.sh kafka.tools.GetOffsetShell   --broker-list localhost:9092   \
--topic baeldung   | awk -F  ":" '{sum += $3} END {print "Result: "sum}' \
Result: 3




