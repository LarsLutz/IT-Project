package chat;

import java.util.TimerTask;

public class getNachricht extends TimerTask{
	
	private Chat_Controller controller;
    private Chat_Model model;

	public getNachricht(Chat_Controller c,Chat_Model m) {
		// TODO Auto-generated constructor stub
		
		 this.controller = c;
	        this.model = m;

	}
	
	@Override
	public void run() {
		String temp = Chat_Model.getUpdate();
		System.err.println("Time "+temp);
		
		if (!temp.isEmpty()&& Chat_Model.getIstneu()){
		if (temp.equals("$START")){
			System.out.println("Chat startet");
		}else{
		controller.textArea1.appendText(temp+ "\n");
		Chat_Model.setIstneu(false);
		}
		}
		
	}

}
