package com.jg.hazelcast;

import com.hazelcast.client.config.ClientConfig;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
 
public class App {
    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.addAddress("35.238.39.237:5701");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        
        IMap<Integer, Address> mapAddress = client.getMap("address");
        mapAddress.put(1, getAddress());
 
        System.out.println("Customer with key 1: "+ mapAddress.get(1));
        System.out.println("Map Size:" + mapAddress.size());
        
        IMap map = client.getMap("address");
        
        System.out.println("Map Size:" + map.size());
        Address address = (Address) map.get(1);
        System.out.println(address);
    }
    
    public static Address getAddress() {
    	
    	Address address = new Address();
    	address.setCity("Mckinney");
    	address.setState("Texas");
    	address.setStreet("10112 Placid Drive");;
    	address.setZipCode(75072);
    	return address;
    	
    }
    
}