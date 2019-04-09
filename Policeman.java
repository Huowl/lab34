package lab34;

public class Policeman extends pugalo{
	enum Veshi { MEDNAYA_KASKA, DUBINKA }
	Veshi vesh = Veshi.MEDNAYA_KASKA;
	Veshi vesh1 = Veshi.DUBINKA;
	Policeman(){
		System.out.println(vesh.name() + " , " + vesh1.name() + " находятся на чучеле полицейского" + Something.sushestvovanie());
		try{
			givename("чучелол");
		} catch(IsItExistException e){
			System.out.println(e.getMessage());
			try{
				givename("чучело");
			} catch(IsItExistException er){
				System.out.println(er.getMessage());
			}
		}
	}
}
