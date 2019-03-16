package lab34;

class Place{
	public static void main(String [] args){
		dom();
		Vneshnost grim = new Vneshnost();
		grim.vesh_v_vetrine("грим");
		grim.vesh_v_vetrine("парики");
		grim.vesh_v_vetrine("накладные бороды и усы");

		grim.maska();
		Vneshnost prorez = new Vneshnost();
		Vneshnost.maska_type2 type2 = prorez.new maska_type2("маска с прорезами для глаз");
		Vneshnost.maska_type type = new Vneshnost.maska_type("маска цельная");
		pugalo chuchelo = new pugalo();
		System.out.println(chuchelo.toString() + pugalo.vivod());
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