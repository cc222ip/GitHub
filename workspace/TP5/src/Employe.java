public class Employe extends EmployeBase {

	int salaire() {
		if(nbHeures > 35) {
			int hSup = nbHeures - 35;
			prime = hSup * txHSup;
		}
		return 0;
	}
	
}
