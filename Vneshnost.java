package lab34;

//import java.util.Date;

public class Vneshnost extends Something implements material, Comparable<Vneshnost>{
	public String imya;
	public int prost;
	public Vneshnost(String imya, int prost){
		this.imya = imya;
		this.prost = prost;
	}
	public String getname(){return imya;}
	public int getint(){return prost;}
	public static String Material(){
		return "материальный(ые) ";
	}
	public static void vesh_v_vetrine (String vesh){
		if (vesh == "грим" || vesh == "парики" || vesh == "накладные бороды и усы" || vesh == "маска на верхнюю часть лица" || vesh == "маска с прорезами для глаз" || vesh == "маска цельная"){
			System.out.println("в ветрине находится" + Something.sushestvovanie() + Material() + vesh);
		}
		else {
			throw new IsItCorrectException("вы ввели не тот тип вещи");
		}
	}
	public static void maska(){
		String type1 = "маска на верхнюю часть лица";
		//тут лежит локальный класс
		class maska_v_vetrine{
			maska_v_vetrine(String mask){
			Vneshnost.vesh_v_vetrine(mask);
		}}
		maska_v_vetrine maska1 = new maska_v_vetrine(type1);
	}
	//тут лежит staticinner class
	public static class maska_type{
			maska_type(String yareyare){
				Vneshnost.vesh_v_vetrine(yareyare);
			}}
	//тут лежит inner class
	public class maska_type2{
		maska_type2(String mudamuda){
			Vneshnost.vesh_v_vetrine(mudamuda);
		}
	}
	@Override
	public String toString(){
		return imya;
	}
	@Override 
	public boolean equals(Object obj) {
		Vneshnost other = (Vneshnost) obj;
		boolean check = false;
		if (this.imya.equals(other.imya) /*|| this.imya.equals(other.imya)*/) {
			check = true;
		}
		return check;
	}
	@Override
	public int hashCode(){
		char [] chars = imya.toCharArray();
		int j = 0;
		for (int i = 0; i < chars.length; i++){
			j = j + Integer.valueOf(chars[i]);
		}
		return j;
	}
	@Override
	public int compareTo(Vneshnost odin){
		char [] chars = odin.imya.toCharArray();
		char [] chars1 = this.imya.toCharArray();
		int j = 0;
		int k = 0;
		for (int i = 0; i < chars.length; i++){
			j = j + Integer.valueOf(chars[i]);
		}
		for (int i = 0; i < chars1.length; i++){
			k = k + Integer.valueOf(chars1[i]);
		}
		if(j > k){return 1;}
		else if(j < k){return -1;}
		else {return 0;}
	}
}
