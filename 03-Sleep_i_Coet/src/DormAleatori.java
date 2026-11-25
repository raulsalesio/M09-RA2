public class DormAleatori extends Thread {

    private long tempsCreacio;

    public DormAleatori(String nom) {
        super(nom);
        this.tempsCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int interval = (int) (Math.random() * 1000);
            long tempsTotal = System.currentTimeMillis() - tempsCreacio;

            System.out.printf("%-4s(%d) a dormir %4dms total %6dms%n", getName(), i, interval, tempsTotal);

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}