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
import java.util.Collections;


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
        String[] cmdr = new String[10];
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                try{
                    save(Place.svet);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

        });
		cmd[0] = "";
        cmdr = cmd;
		while(!cmd[0].equals("close")){
			System.out.println("Enter command:");
			if (command.hasNextLine()){cmd = command.nextLine().split(" ");}
			if (cmd.length==0) {cmd=cmdr;}
            try{
            	switch (cmd[0]){
            		/**
            		*output to the standard output stream information about the collection (type, initialization date, number of elements, etc.)
            		*/
            		case("info"): {Collections.sort(this.maski);info();break;}
            		/**
            		*clear
            		*/
            		case("clear"): {maski.clear();break;}
            		/**
            		*add element in collection
            		*/
                    case("add"): {
                        if (!cmd[1].equals("{}")){
                            maski.add(new Gson().fromJson(cmd[1], Vneshnost.class));break;
                        }
                        else {System.out.println("отсутствуют данные!");break;}
                    }
                    /**
                    *remove element
                    */
                    case("remove"): {
                        if (!cmd[1].equals("{}")){
                            rem(new Gson().fromJson(cmd[1], Vneshnost.class));break;}
                        else {System.out.println("отсутствуют данные!");}
                    }
                    /**
                    *ПАСХАЛОЧКА
                    */
                    case("music"): {music();break;}
                    /**
                    *show all elements
                    */
                    case("show"): {Collections.sort(this.maski);System.out.println(maski);break;}
                    /**
                    *remove last object in collection
                    */
                    case("remove_last"):{remover();break;}
                    /**
                    *delete all lower objects
                    */
                    case("remove_lower"):{
                        if (!cmd[1].equals("{}")){
                            remlow(new Gson().fromJson(cmd[1], Vneshnost.class));break;}
                        else {System.out.println("отсутствуют данные!");}
                    }
                    case("close"):{break;}
                    default: {System.out.println("Мы не знаем такую команду(");}
            	}
            }
            catch(NoSuchElementException ex){
                System.out.println("коллекция пустая или нет нужного элемента");
            }
            catch (ArrayIndexOutOfBoundsException exex){System.out.println("пробелы - это плохо");}
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
        if (file.canWrite()){
        	PrintWriter pw = new PrintWriter(file);
    	   pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
           pw.println("<Vneshnost>");
    	   for (Vneshnost vnes : maski){
    	       pw.println("<Vneshnost imya=\"" + vnes.getname() + "\" prost=\"" + vnes.getint() + "\"/>");
    	   }
           pw.println("</Vneshnost>");
    	   pw.flush();
        }
        else{System.out.println("Дайте права для чтения файла");}
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