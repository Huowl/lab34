package lab34;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.NoSuchElementException;
import com.google.gson.Gson;
import java.util.Date;


public class Terminal{
    Date date = new Date();
	LinkedList<Vneshnost> maski= new LinkedList<>();

	public Terminal (LinkedList<Vneshnost> abc){
		maski.addAll(abc);
	}
	

	public void commander(){
		System.out.println("Start");
		Scanner command = new Scanner (System.in);
		String[] cmd = new String[10];
		cmd[0] = "";
		while(!cmd[0].equals("close")){
			System.out.println("Enter command:");
			if (command.hasNextLine()){cmd = command.nextLine().split(" ");}
			if (cmd.length==0) {throw new ArrayIndexOutOfBoundsException(); }
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
            		*add element in collection
            		*/
                    case("add"): {maski.add(new Gson().fromJson(cmd[1], Vneshnost.class));break;}
                    /**
                    *remove element
                    */
                    case("remove"): {rem(new Gson().fromJson(cmd[1], Vneshnost.class));break;}
                    /**
                    *ПАСХАЛОЧКА
                    */
                    case("music"): {music();break;}
                    /**
                    *show all elements
                    */
                    case("show"): {System.out.println(maski);break;}
                    /**
                    *remove last object in collection
                    */
                    case("remove_last"):{remover() /*removeLast()*/;break;}
                    /**
                    *delete all lower objects
                    */
                    case("remove_lower"):{remlow(new Gson().fromJson(cmd[1], Vneshnost.class));break;}
            	}
            }
            catch(NoSuchElementException ex){
                System.out.println("коллекция пустая или нет нужного элемента");
            }
            catch(Exception e){
            	System.out.println("ОШИБКА! Введите команду заново");
            }
		}
	}
	public void info()
    {
        System.out.println("Type: Maski");
        System.out.println(maski);
        System.out.println("Date:" + date);
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

    public void remover() throws NoSuchElementException{
        this.maski.removeLast();
    }

    public void rem(Vneshnost opa){
        LinkedList<Vneshnost> abc = new LinkedList<Vneshnost>();
        abc.addAll(maski);
        maski.clear();
        for (Vneshnost vnes : abc){
            if(!vnes.imya.equals(opa.imya)){
                maski.add(vnes);
            }
        }
    }

    public void remlow(Vneshnost opa){
        LinkedList<Vneshnost> abc = new LinkedList<Vneshnost>();
        abc.addAll(maski);
        maski.clear();
        for (Vneshnost vnes : abc){
            if(!vnes.imya.equals(opa.imya)){
                maski.add(vnes);
            }
            else{break;}
        }
    }

    public void music() throws IOException{
        System.out.println("Играет OutKast - Hey Ya!");
    try {
    File soundFile = new File("lab34/OutkastHeyYa.wav");
    //Получаем AudioInputStream
    //Вот тут могут полететь IOException и UnsupportedAudioFileException
    AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
    //Получаем реализацию интерфейса Clip
    //Может выкинуть LineUnavailableException
    Clip clip = AudioSystem.getClip();
    //Загружаем наш звуковой поток в Clip
    //Может выкинуть IOException и LineUnavailableException
    clip.open(ais);
    clip.setFramePosition(0); //устанавливаем указатель на старт
    clip.start(); 
} catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
    exc.printStackTrace();}
    }

}