package lab34;

public class pugalo extends Something implements kolichestvo{
	public static int kolvopugal(int a){
		return a;
	}
	public static String vivod(){
		return Something.sushestvovanie();
	}

	@Override
	public String toString(){
		return "Есть " + this.pugal + " чучела";
	}

	public String typeOfMaterial;


	public void givename(String imya) throws IsItExistException{
		if (imya == "чучело"){
			this.typeOfMaterial = imya;
		} else{
			throw new IsItExistException("вы ввели не чучело");
		}
	}


	@Override 
	public boolean equals(Object obj) {
		pugalo other = (pugalo) obj;
		boolean check = false;
		if (this.typeOfMaterial.equals(other.typeOfMaterial) /*|| this.imya.equals(other.imya)*/) {
			check = true;
		}
		return check;
	}

	@Override
	public int hashCode(){
		char [] chars = typeOfMaterial.toCharArray();
		int j = 0;
		for (int i = 0; i < chars.length; i++){
			j = j + Integer.valueOf(chars[i]);
		}
		return j;
	}
}
