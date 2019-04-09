package lab34;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

import com.google.gson.Gson;
//import com.google.gson.JsonParser;

public class Terminal{
	LinkedList<Vneshnost> maski= new LinkedList<>();
	//Gson gson = new Gson();

	public Terminal (LinkedList<Vneshnost> abc){
		maski.addAll(abc);
	}
	

	public void commander(){
		//read(path);
		System.out.println("Start");
		Scanner command = new Scanner (System.in);
		String[] cmd = new String[10];
		cmd[0] = "";
		while(!cmd[0].equals("close")){
			System.out.println("Enter command:");
			if (command.hasNextLine()){cmd = command.nextLine().split(" ");}
			if (cmd.length==0) {throw new ArrayIndexOutOfBoundsException(); }
            //else {System.out.println("You don't enter a command. Retry!");}
            try{
            	switch (cmd[0]){
            		/**
            		*output to the standard output stream information about the collection (type, initialization date, number of elements, etc.)
            		*/
            		case("info"): {info();break;}
            		/**
            		*clear
            		*/
            		case("clear"): {maski.clear();break;}
            		/**
            		*
            		*/
            		//case("add"): {maski.add(gson.fromJson(cmd[1], lab34.Vneshnost.class));break;}
                    case("add"): {maski.add(new Gson().fromJson(cmd[1], Vneshnost.class));break;}
            	}
            }
            catch(Exception e){
            	System.out.println("vse ploho");
                e.printStackTrace();
            }
		}
	}
	public void info()
    {
        System.out.println("Type: Maski");
        System.out.println(maski);
        //System.out.println("Date:" + data);
        System.out.println("Size:" + maski.size());
    }





    public void save(String path) throws FileNotFoundException{
    	File file = new File(path);
    	PrintWriter pw = new PrintWriter(file);
    	pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
    	for (Vneshnost vnes : maski){
    		pw.println("<Vneshnost>" + vnes.getname() + "</Vneshnost>");
    	}
    	pw.flush();
    }

}