package dcll.hmas.MySimpleXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;

public class ReadXML {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ParsingException
	 * @throws ValidityException
	 */
	public static void main(String[] args) throws ValidityException,
			ParsingException, IOException {
		System.out.println(args[0]);
		try {
			InputStream ins = new FileInputStream(args[0]);
			InputStreamReader insr = new InputStreamReader(ins);
			BufferedReader br = new BufferedReader(insr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				System.out.println(ligne);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		;

		// lire et analyser le fichier XML
		Builder builder = new Builder();
		File f = new File(args[0]);
		Document doc = builder.build(f);
		Element root = doc.getRootElement();
		System.out.println("Noeud Racine : " + root.getLocalName());
		// lire fils
		Elements students = root.getChildElements();
		Element nameChild = null;
		for (int i = 0; i < students.size(); i++) {
			System.out
					.println("Noeud Fils : " + students.get(i).getLocalName());
			// lire 1er fils avec nom de tag 'name'
			nameChild = students.get(i).getFirstChildElement("name");
			if (nameChild != null) {
				System.out.println("Name : " + nameChild.getValue());
			}
		}
	}
}
