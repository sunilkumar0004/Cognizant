package builder;

public class Computer {

    private final String CPU;
    private final String RAM;
    private final String storage;

    private final boolean hasGPU;
    private final boolean hasWiFi;
    private final String OS;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.hasGPU = builder.hasGPU;
        this.hasWiFi = builder.hasWiFi;
        this.OS = builder.OS;
    }

    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean isHasGPU() { return hasGPU; }
    public boolean isHasWiFi() { return hasWiFi; }
    public String getOS() { return OS; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
               ", hasGPU=" + hasGPU + ", hasWiFi=" + hasWiFi + ", OS=" + OS + "]";
    }

    public static class Builder {

        private final String CPU;
        private final String RAM;
        private final String storage;

        private boolean hasGPU = false;
        private boolean hasWiFi = false;
        private String OS = "None";

        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        public Builder setGPU(boolean hasGPU) {
            this.hasGPU = hasGPU;
            return this;
        }

        public Builder setWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
