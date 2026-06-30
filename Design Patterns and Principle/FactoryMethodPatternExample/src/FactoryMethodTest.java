package factory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Factory Method Pattern ===");

        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("--- Generating Word Document ---");
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        System.out.println("\n--- Generating PDF Document ---");
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        System.out.println("\n--- Generating Excel Document ---");
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}
