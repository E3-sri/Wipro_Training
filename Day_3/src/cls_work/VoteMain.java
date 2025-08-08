package cls_work;

public class VoteMain {

	public static void main(String[] args) {
	
		voting v1=new voting();
		v1.setName("Lakshmi Hymavathi");
        v1.setVoterId("VOTER12345");
        
        v1.vote();  
        v1.vote();
        v1.vote();
        
        System.out.println("Voter Name: " + v1.getName());
        System.out.println("Voter ID: " + v1.getVoterId());
        System.out.println("Has Voted: " + v1.getStatus());
        
		
	}

}