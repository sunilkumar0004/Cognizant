package builder;

public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Builder Pattern ===");

        Computer officePC = new Computer.Builder("Intel Core i3", "8GB", "256GB SSD")
                .build();

        Computer gamingPC = new Computer.Builder("AMD Ryzen 7", "32GB", "1TB NVMe SSD")
                .setGPU(true)
                .setOS("Windows 11")
                .setWiFi(true)
                .build();

        Computer devPC = new Computer.Builder("Intel Core i7", "64GB", "2TB NVMe SSD")
                .setWiFi(true)
                .setOS("Ubuntu 22.04 LTS")
                .build();

        System.out.println("Basic Office PC: " + officePC);
        System.out.println("Gaming PC:       " + gamingPC);
        System.out.println("Dev Workstation: " + devPC);
    }
}
