package proxy;

public class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image: " + filename + " from remote server (high latency)...");
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image " + filename + " loaded successfully!");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
