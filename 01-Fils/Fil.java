
public class Fil extends Thread {

    private int delay;

    public Fil(String nom, int prioritat, int delay) {
        super(nom);
        this.setPriority(prioritat);
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);

            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (int j = 0; j < 1000; j++) {
                }
            }
        }
        System.out.println("Acaba el fil " + getName());
    }
}