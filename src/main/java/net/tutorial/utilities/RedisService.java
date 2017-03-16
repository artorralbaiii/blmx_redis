package net.tutorial.utilities;

import java.io.PrintWriter;
import redis.clients.jedis.Jedis;

public class RedisService {
	
	private final String HOSTNAME = ""; // PUT YOUR REDIS HOSTNAME HERE
	private final String PASSWORD = ""; // PUT YOU REDIS PASSWORD HERE
	private final int PORT = 0; // PUT YOUR REDIS PORT HERE
	
	private Jedis jedis = null;
	
	public RedisService() {
		
		jedis = new Jedis(HOSTNAME, PORT);
		jedis.auth(PASSWORD);

		if (!jedis.exists("string_test")) {
			jedis.set("string_test", "This is a string");
	
			jedis.lpush("list_test", "List Item 1");
			jedis.lpush("list_test", "List Item 2");
			
			jedis.sadd("set_test", "Set Item 1");
			jedis.sadd("set_test", "Set Item 2");
			
			jedis.hset("hash_test", "Key1", "Value 1");
			jedis.hset("hash_test", "Key2", "Value 2");
			
			jedis.zadd("ranking", 100, "Player1");
			jedis.zadd("ranking", 50, "Player2");
			jedis.zadd("ranking", 110, "Player3");
		}
		
	}
	
	public void printValues(PrintWriter  out) {
		
		out.println("<h3>Retrieve value from String Type</h3>");
		out.println("Result :");
		out.println("<br>");
		out.println(jedis.get("string_test"));
		
		out.println("<h3>Retrieve values from List</h3>");
		out.println("Result :");
		out.println("<br>");
		out.println(jedis.lrange("list_test", 0, -1) );
		
		out.println("<h3>Retrieve values from Sets</h3>");
		out.println("Result :");
		out.println("<br>");
		out.println(jedis.smembers("set_test"));
		
		out.println("<h3>Retrieve values from Hash</h3>");
		out.println("Result :");
		out.println("<br>");
		out.println(jedis.hgetAll("hash_test"));
		
		out.println("<h3>Retrieve values from Sorted Sets</h3>");
		out.println("Result :");
		out.println("<br>");
		out.println(jedis.zrevrange("ranking", 0, 2));
				
	}
	
}
