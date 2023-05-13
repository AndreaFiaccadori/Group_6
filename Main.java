package Gruppo_6;

public class Main {

	public static void main(String[] args) {
		Plank p = new Plank(2);
		
		// Rimozione celle per testare metodo isToFill
		p.takeTile(2,3);
		p.takeTile(2,5);
		
		p.takeTile(3,3);
		p.takeTile(3,4);
		p.takeTile(3,6);

		p.takeTile(4,2);
		p.takeTile(4,3);
		p.takeTile(4,5);
		p.takeTile(4,7);

		p.takeTile(5,2);
		p.takeTile(5,4);
		p.takeTile(5,6);

		p.takeTile(6,3);
		p.takeTile(6,5);

		p.takeTile(7,4);
		
		// Rimuovere commenti per far ritornare true
		//p.takeTile(1,4);
		//p.takeTile(5,1);
		System.out.println(p);
		System.out.println(p.isToFill());
	}

}
