import sys

from pyspark.sql import SparkSession
from operator import add


def run_spark(filename):
    spark = SparkSession.builder.appName('pkslow-local').getOrCreate()
    lines = spark.read.text(filename).rdd.map(lambda r: r[0])
    counts = lines.flatMap(lambda x: x.split(' ')) \
        .map(lambda x: (x, 1)) \
        .reduceByKey(add)
    output = counts.collect()
    output.sort(key=lambda item: item[1])
    for (word, count) in output:
        print("%s: %i" % (word, count))

    spark.stop()


if __name__ == '__main__':
    if len(sys.argv) != 2:
        print("Usage: wordcount <file>", file=sys.stderr)
        sys.exit(-1)
    filename = sys.argv[1]
    run_spark(filename)
