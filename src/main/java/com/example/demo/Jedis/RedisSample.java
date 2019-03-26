package com.example.demo.Jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author Mikorn vietnam
 * Created on 26-Mar-19.
 */

public class RedisSample {
    public static Map<String, String> putoMap(Account account) {
        Map<String, String> hash = new HashMap<>();
        hash.put("username", account.getUserName());
        hash.put("password", account.getPassWord());
        return hash;
    }
    public static void main(String[] args) throws InterruptedException {
        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");

        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: " + jedis.ping());

        //redis string
        jedis.set("name", "Thach Le");
        System.out.println("String: " + jedis.get("name"));

        //redis list
        jedis.lpush("fruits", "Banana");
        jedis.lpush("fruits", "Guava");
        jedis.lpush("fruits", "Apple");
        // Get the stored data and print it
        List list = jedis.lrange("fruits", 0, 3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("List: " + list.get(i));
        }

        //redis hash
        Account account = new Account("thachlp", "thachlp");
        jedis.hmset("account", putoMap(account));
        Map<String, String> properties = jedis.hgetAll("account");
        System.out.println("Account: " + properties.get("username") + "/" + properties.get("password"));

        //get data
        System.out.println("fish: " + jedis.get("fish"));
//        jedis.pfmerge("fish", "temp");
//        System.out.println("temp: " + jedis.get("temp"));
//        System.out.println("HyperLoglog Count: " + jedis.pfcount("fish"));
    }
}
