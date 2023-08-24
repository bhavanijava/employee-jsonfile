package com.web.pdfextractor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * A command-line utility for extracting data from PDF documents.
 */
@Component
public class PdfExtraction implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

//    @Value("classpath:OriginalData.pdf")
//    private Resource resourceFile1;
//
//    @Value("classpath:PdfFormExample.pdf")
//    private Resource resourceFile2;
//
//    /**
//     * Entry point of the command-line utility.
//     *
//     * @param args Command-line arguments
//     * @throws Exception if an error occurs during execution
//     */
//    @Override
//    public void run(String... args) throws Exception {
//        // Text Extraction
//        try (PDDocument document = PDDocument.load(resourceFile1.getFile())) {
//            PDFTextStripper textStripper = new PDFTextStripper();
//            textStripper.setStartPage(0);
//            textStripper.setEndPage(1);
//            String extractedText = textStripper.getText(document);
//            System.out.println("Extracted Text:");
//            System.out.println(extractedText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Form Data Extraction
//        try (PDDocument doc = PDDocument.load(resourceFile2.getFile())) {
//            System.out.println("Form Data Extraction:");
//            listFields(doc);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Image Extraction
//        int imageCounter = 0;
//        try (PDDocument document = PDDocument.load(resourceFile1.getFile())) {
//            System.out.println("Image Extraction:");
//            for (int pageNumber = 0; pageNumber < document.getNumberOfPages(); pageNumber++) {
//                PDPage page = document.getPage(pageNumber);
//                for (COSName objectName : page.getResources().getXObjectNames()) {
//                    if (page.getResources().isImageXObject(objectName)) {
//                        PDImageXObject image = (PDImageXObject) page.getResources().getXObject(objectName);
//                        BufferedImage bufferedImage = image.getImage();
//                        String outputFileName = "image_" + (++imageCounter) + ".png";
//                        ImageIO.write(bufferedImage, "PNG", new File(outputFileName));
//                        System.out.println("Image extracted: " + outputFileName);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println();
//        System.out.println("Total images extracted: " + imageCounter);
//
//        // Hyperlink Extraction
//        try (PDDocument document = PDDocument.load(new File("C:/Users/sankarb/Downloads/pdf-conversion-services.pdf"))) {
//            System.out.println("Hyperlink Extraction:");
//            int pageNum = 0;
//            for (PDPage page : document.getPages()) {
//                pageNum++;
//                List<PDAnnotation> annotations = page.getAnnotations();
//                for (PDAnnotation annotation : annotations) {
//                    if (annotation instanceof PDAnnotationLink) {
//                        PDAnnotationLink link = (PDAnnotationLink) annotation;
//                        PDAction action = link.getAction();
//                        if (action instanceof PDActionURI) {
//                            PDActionURI uriAction = (PDActionURI) action;
//                            String url = uriAction.getURI();
//                            System.out.println("Page " + pageNum + " URL: " + url);
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Extracts form field data from the given PDF document.
//     *
//     * @param doc PDF document
//     * @throws Exception if an error occurs during extraction
//     */
//    public static void listFields(PDDocument doc) throws Exception {
//        PDDocumentCatalog catalog = doc.getDocumentCatalog();
//        Optional<PDAcroForm> formOptional = Optional.ofNullable(catalog.getAcroForm());
//
//        if (formOptional.isPresent()) {
//            PDAcroForm form = formOptional.get();
//            List<PDField> fields = form.getFields();
//
//            for (PDField field : fields) {
//                Object value = field.getValueAsString();
//                String name = field.getFullyQualifiedName();
//                System.out.print(name + " : " + value);
//                System.out.println();
//            }
//        } else {
//            System.out.println("The form is not available.");
//        }
    
}
