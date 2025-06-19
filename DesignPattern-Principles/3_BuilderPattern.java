class Computer {
    private String CPU, RAM, Storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    public static class Builder {
        private String CPU, RAM, Storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU; return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM; return this;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage; return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    public String toString() {
        return "Computer[CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + "]";
    }
}

class BuilderTest {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder().setCPU("i5").setRAM("8GB").setStorage("512GB SSD").build();
        System.out.println(pc);
    }
}