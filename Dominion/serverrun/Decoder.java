package serverrun;

/**
 * @author Lars Lutz
 */
public class Decoder {
	

	   private Player player1;
	   private Player player2;

	    public Decoder(){

	    }

//		String string = "004-034556";
//		String[] parts = string.split("-");
	    
	    public void verarbeite(Player player1, Player player2){
	        String data = player1.getDataIn();

	        switch (data){
	            case "login":   verarbeiteLogin(data);
	            break;
	        }
	    }

	    private void verarbeiteLogin(String data){
	        player2.setDataOut(data+"tada");
	    }
	}



