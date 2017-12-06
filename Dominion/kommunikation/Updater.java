package kommunikation;

import java.io.IOException;

import chat.Chat_Controller;
import chat.Chat_Model;

public class Updater implements Runnable{
		
	
		    private Decoder decoder;
		    private String up;
		    private Chat_Controller controller;
		    
	
		    public String getUp() {
				return up;
			}

			public void setUp(String up) {
				this.up = up;
			}

			public Updater(Decoder decoder){
		        this.decoder = decoder;
		       //changelistener stringproperty
		        
		        
		        
		    }
	
		    @Override
		    public void run() {
		    	
		    	
		    	while(true){
		    		System.out.println("Decoder liesst");
		        this.decoder.lesen(); 
		               
		    	
		        try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		    }
		    
		   
		    
		    
		}


