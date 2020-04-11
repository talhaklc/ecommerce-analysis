package com.n12.search.analysis;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerApplication {
    public static void main(String[] args) {
        String server = "localhost:9092";
        Properties config = new Properties();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,server);
        config.put(ProducerConfig.CLIENT_ID_CONFIG,"e-com-search-service");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,new StringSerializer().getClass().getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,new StringSerializer().getClass().getName());

        Producer kafkaProducer = new KafkaProducer(config);

        List<String> productList = Arrays.asList("Makarna", "Nike Ayakkabi", "Dell laptop", "Samsung Lcd Tv", "Balık","Paspas","Bıçak","Maske");
        while (true){
            SearchProductModel spm=new SearchProductModel();
            spm.setCity(ThreadLocalRandom.current().nextInt(1,81+1));
            spm.setUserId(ThreadLocalRandom.current().nextInt(200,250+1));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            spm.setTimestamp(timestamp);

            Random random=new Random();
            int i = random.nextInt(productList.size());
            spm.setSearch(productList.get(i));

            Gson gson=new Gson();
            String value = gson.toJson(spm);
            kafkaProducer.send(new ProducerRecord("search-analysis",value));
        }
    }
}
