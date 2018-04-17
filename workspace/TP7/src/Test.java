import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader a = null;
		FileReader b = null;
		try {
			b = new FileReader("Test.rtf");
			a = new BufferedReader(b);
			String tmp;
			while((tmp = a.readLine()) != null) {
				System.out.println(tmp);
			}
			ecrire("Test.rtf", "Manoun's");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			a.close();
			b.close();
		}
	}
	public static void ecrire(final String file_name, final String data) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			File file = new File(file_name);
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
