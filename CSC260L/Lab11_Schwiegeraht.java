import java.io.*;
import java.util.*;
public class Lab11_Schwiegeraht {

	public static void main(String[] args)  throws IOException{
		
		String data[][] = input("test1.txt");
		process("test2.txt",data);
		output("output.txt", data);
	}
	public static String[][] input(String fileName) throws IOException{
		Scanner in=new Scanner(new File(fileName));
		int rows = in.nextInt(),columns = in.nextInt();
		String array[][] = new String[rows][columns];
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				array[i][j] = in.next();
			}
		}
		in.close();
		return array;
	}
	
	public static void process(String filename, String[][] array) throws IOException{
		Scanner in=new Scanner(new File(filename));
		int errors = 0,totalRows=0;
		while(in.hasNext()) {
			totalRows++;
			int int1 = in.nextInt();
			int int2 = in.nextInt();
			String str1 = in.next();
			String str2 = in.next();
			
			if(array[int1][int2].equals(str1)){
				errors++;
				array[int1][int2] = str1;
			}

		}
		System.out.printf("File accessed: %s\nNumber of Transactions: %d\nTotal Errors: %d",filename,totalRows,errors);
		in.close();
	}
	
	public static void output(String filename, String[][] array) throws IOException{
		PrintWriter pw=new PrintWriter(new File(filename));
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				pw.print(array[i][j] + "\t");
			}
			pw.println();
		}
		pw.close();
	}
	
}

//File accessed: test2.txt
//Number of Transactions: 7
//Total Errors: 4
