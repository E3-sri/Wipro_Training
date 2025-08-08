package WT;
public class str_methods {
	public static void main(String[]args)
	{
	String name1="sree lakshmi";
	System.out.println(" Welcome "+name1.toUpperCase());
	System.out.println("Lower Case:"+name1.toLowerCase());
	System.out.println("Length of String:"+name1.length());
	String name2=" Chaturvedula";
	System.out.println("Concatenation:"+name1.concat(name2));
	System.out.println("Substring:"+name1.substring(0,4));
	System.out.println();
	String name="SREE LAKSHMI";
	System.out.println(name1.equals(name));//equals comparision
	System.out.println(name1.equalsIgnoreCase(name));//equals Ignore case comparision
	System.out.println(name1.compareTo(name));//comparision
	System.out.println(name1.compareToIgnoreCase(name));//Ignore case comparision
	System.out.println();
	
	System.out.println(name1.trim()); //returns same if there is no spaces
	System.out.println(name.toCharArray());
	String name3="";
	System.out.println(name3.isEmpty()); //empty method
	
	System.out.println(name1.isBlank());//Blank Method
	
	String j=" Java Programing ";
	System.out.println(j.trim());//remove spaces
	
	System.out.println(j.indexOf("Java")); //gives where java starts.
	
	System.out.println(j.lastIndexOf('o'));  // gives the last occurance
	double k=548.369d;
	long i=458396L;
	String m="Mohammad";
	System.out.println(String.valueOf(k));
	System.out.println(String.valueOf(i));
	System.out.println();

	System.out.println(m.endsWith("ad"));
	System.out.println(m.endsWith("Java"));
	System.out.println(m.getBytes());

	System.out.println();
	String a="xyz";
	String b="XYZ";
	System.out.println(a==b);
	
	System.out.println(m.replaceFirst("M","m"));  //replace first character
	
	String s1=" @sree@ ";
	System.out.println(s1.trim());









	
	
	

	}
}
	