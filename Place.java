package lab34;
import java.util.LinkedList;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class Place{
	public static void main(String [] args) throws IOException{
		LinkedList<Vneshnost> maski= new LinkedList<>();
		//чтение файла
		try{
			String filename = "lab34/anime.xml";
			Path path = Paths.get(filename);
			Scanner scan = new Scanner(path);
			while(scan.hasNext()){
				String line = scan.nextLine();
				if(line.contains("<Vneshnost>")){
					String imya = line.substring(line.indexOf(">") + 1, line.indexOf("/") - 1);
					maski.add(new Vneshnost(imya));
				}
			}
		}
		catch(IOException e){
			System.out.println("не найден файл или");
		}



		dom();
		Vneshnost grim = new Vneshnost("lol");
		try{
			grim.vesh_v_vetrine("грим");
		} catch(IsItCorrectException e){
			System.out.println(e.getMessage());
		}
		try{
			grim.vesh_v_vetrine("парики");
		} catch(IsItCorrectException e){
			System.out.println(e.getMessage());
		}

		grim.vesh_v_vetrine("накладные бороды и усы");

		grim.maska();
		Vneshnost prorez = new Vneshnost("ph");
		Vneshnost.maska_type2 type2 = prorez.new maska_type2("маска с прорезами для глаз");
		Vneshnost.maska_type type = new Vneshnost.maska_type("маска цельная");

		pugalo chuchelo = new pugalo();
		System.out.println(chuchelo.toString() + pugalo.vivod());
		Policeman trash = new Policeman();
		Criminal vor = new Criminal("фонарь");
		trash.typeOfMaterial = "чучело";
		vor.typeOfMaterial = "чучело";
		if (trash.equals(vor)){System.out.println("Что чучело полицейского, что чучело вора оба чучела");}
		System.out.println("серийный номер чучел(товар шел в комплекте) " + vor.hashCode());
		try{
			grim.vesh_v_vetrine("пистолет");
		} catch (IsItCorrectException e){
			System.out.println(e.getMessage());
		}

		Terminal terminal = new Terminal(maski);
		terminal.commander();
		terminal.save("lab34/anime.xml");
	}
	static void dom(){
		//здесь лежит анонимный класс и 3 часа работы
		Usi usi = new Usi(){
			public void otvet(){
				System.out.println("мы в музее");
			}
		};
		usi.otvet();
	}
}
