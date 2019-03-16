package lab34;

public class Vneshnost extends Something implements material{
	public static String Material(){
		return "материальный(ые) ";
	}
	public static void vesh_v_vetrine (String vesh){
		System.out.println("в ветрине находится" + Something.sushestvovanie() + Material() + vesh);
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
}
