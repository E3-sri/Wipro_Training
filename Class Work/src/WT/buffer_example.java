package WT;

public class buffer_example {

	public static void main(String[] args) {
		StringBuffer receipt=new StringBuffer();
		receipt.append(" Receipt\n");
		receipt.append("Customer:-Lakshmi Hymavathi\n");
		receipt.append("items:\n");
		receipt.append("1.Banana-55\n");
		receipt.append("2.Potato-40\n");
		receipt.append("3.Milk-95\n");
		receipt.append("4.Bread-80\n");
		receipt.insert(0, "Supermart");
		//receipt.replace(1,0,"Chocoloate");

		receipt.append("\nTotal:	270\n");
		System.out.println(receipt.toString());
		System.out.println("***Thank You for Shopping***\n");
		
		System.out.println(receipt.reverse());
		

	}

}
