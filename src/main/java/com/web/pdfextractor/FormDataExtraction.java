package com.web.pdfextractor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FormDataExtraction implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

//    @Override
//    public void run(String... args) throws Exception {
//        File file = new File("C:/Users/Bhavani sankar/Downloads/PdfFormExample.pdf");
//        try (PDDocument doc = PDDocument.load(file)) {
//            listFields(doc);
//        }
//    }
//
//    public static void listFields(PDDocument doc) throws Exception {
//        PDDocumentCatalog catalog = doc.getDocumentCatalog();
//        PDAcroForm form = catalog.getAcroForm();
//        List<PDField> fields = form.getFields();
//
//        System.out.println("Total Fields: " + fields.size());
//        for (PDField field : fields) {
//            String name = field.getFullyQualifiedName();
//            String value = field.getValueAsString();
//
//           System.out.print(name+" : "+value);
//           System.out.println();
//        }
//    }
}
