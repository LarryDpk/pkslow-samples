package com.pkslow.bigdata.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Flatten;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.SimpleFunction;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

import java.util.ArrayList;
import java.util.List;

public class WordCountDirect {
    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline pipeline = Pipeline.create(options);
        PCollection<String> lines = pipeline.apply("read from file",
                TextIO.read().from("/Users/larry/IdeaProjects/pkslow-samples/bigdata/apache-beam/direct-runner/src/main/resources/pkslow.txt"));

        PCollection<List<String>> wordList = lines.apply(MapElements.via(new SimpleFunction<String, List<String>>() {
            @Override
            public List<String> apply(String input) {
                List<String> result = new ArrayList<>();
               char[] chars = input.toCharArray();

                for (char c:chars) {
                    result.add(String.valueOf(c));
                }

              return result;
            }
        }));

        PCollection<String> words = wordList.apply(Flatten.iterables());

        PCollection<KV<String, Long>> wordCount = words.apply(Count.perElement());

        wordCount.apply(MapElements.via(new SimpleFunction<KV<String, Long>, String>() {
            @Override
            public String apply(KV<String, Long> count) {
                return String.format("%s : %s", count.getKey(), count.getValue());
            }
        })).apply(TextIO.write().to("word-count-result"));

        pipeline.run().waitUntilFinish();
    }
}
