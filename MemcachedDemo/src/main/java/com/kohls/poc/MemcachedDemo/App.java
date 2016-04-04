package com.kohls.poc.MemcachedDemo;

import java.util.concurrent.Future;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	/*if(args.length < 2){
            System.out.println("Please specify command line options");
            return;
        }*/
    	//String commandName = args[0];
        MemcachedClient memcachedClient = new MemcachedClient(AddrUtil.getAddresses("127.0.0.1:11211"));
        String msg = "value";
        long startTime = System.currentTimeMillis();
        for(int i=0;i<9000000;i++) {
        	memcachedClient.add("key"+i, 3600, msg+i);
            if(i%1000000==0) {
               System.out.println("added " + i + " objects");
            }    
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        /*if(commandName.equals("get")){
            String keyName= args[1];
            System.out.println("Key Name " +keyName);
            System.out.println("Value of key " +memcachedClient.get(keyName));
        }else if(commandName.equals("set")){
            String keyName =args[1];
            String value=args[2];
            System.out.println("Key Name " +keyName + " value=" + value);
            Future<Boolean> result= memcachedClient.set(keyName, 0, value);
            System.out.println("Result of set " + result.get());
        }else if(commandName.equals("add")){
            String keyName =args[1];
            String value=args[2];
            System.out.println("Key Name " +keyName + " value=" + value);
            Future<Boolean> result= memcachedClient.add(keyName, 0, value);
            System.out.println("Result of add " + result.get());
        }else if(commandName.equals("replace")){
            String keyName =args[1];
            String value=args[2];
            System.out.println("Key Name " +keyName + " value=" + value);
            Future<Boolean> result= memcachedClient.replace(keyName, 0, value);
            System.out.println("Result of replace " + result.get());
        }else if(commandName.equals("delete")){
            String keyName =args[1];
            System.out.println("Key Name " +keyName );
            Future<Boolean> result= memcachedClient.delete(keyName);
            System.out.println("Result of delete " + result.get());
        }else{
            System.out.println("Command not found");
        }*/
        memcachedClient.shutdown();
    }
}
