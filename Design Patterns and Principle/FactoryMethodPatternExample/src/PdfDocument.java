package factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document (.pdf) in Viewer...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document.");
    }
}
