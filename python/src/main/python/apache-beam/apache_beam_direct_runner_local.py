import logging
import re

import apache_beam as beam


def run():
    with beam.Pipeline() as pipeline:
        print('pipeline start')
        result = (pipeline
                  | 'Read Text' >> beam.io.ReadFromText('/Users/larry/IdeaProjects/pkslow-samples/LICENSE')
                  | 'ExtractWords' >> beam.FlatMap(lambda x: re.findall(r'[A-Za-z\']+', x))
                  | 'count' >> beam.combiners.Count.PerElement()
                  | beam.MapTuple(lambda word, count: '%s: %s' % (word, count))
                  | beam.io.WriteToText('direct_runner_local_output.txt'))
        print(result)
        print('pipeline done')


if __name__ == '__main__':
    # logging.getLogger().setLevel(logging.INFO)
    logging.basicConfig(
        format='%(asctime)s %(levelname)-8s %(message)s',
        level=logging.INFO,
        datefmt='%Y-%m-%d %H:%M:%S')
    run()
