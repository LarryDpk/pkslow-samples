
bin/kafka-topics.sh --bootstrap-server host:9092 --list
bin/kafka-consumer-groups.sh --bootstrap-server host:9092 --list
bin/kafka-consumer-groups.sh --bootstrap-server host:9092 --describe --group groupName

$ bin/kafka-run-class.sh kafka.tools.GetOffsetShell   --broker-list localhost:9092   \
--topic baeldung   | awk -F  ":" '{sum += $3} END {print "Result: "sum}' \
Result: 3




