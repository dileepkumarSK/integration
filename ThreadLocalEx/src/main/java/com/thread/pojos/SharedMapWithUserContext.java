package com.thread.pojos;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedMapWithUserContext implements Runnable {
	 
    public static Map<Integer, Context> userContextPerUserId
      = new ConcurrentHashMap<>();
    private Integer userId;
 

    @Override
    public void run() {
       
        userContextPerUserId.put(userId, new Context("ddd"));
    }

    // standard constructor
}