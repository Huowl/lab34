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
}