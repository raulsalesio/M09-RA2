public class Motor extends Thread {

    private int potenciaActual;
    private volatile int potenciaObjectiu;
    private boolean haArrencat;

    public Motor(int id) {
        super("Motor " + id);
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.haArrencat = false;
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
        if (p > 0) {
            this.haArrencat = true;
        }
    }

    @Override
    public void run() {
        boolean estatAnteriorFerRes = false;

        while (true) {
            if (haArrencat && potenciaObjectiu == 0 && potenciaActual == 0) {
                System.out.println(getName() + ": FerRes Objectiu: 0 Actual: 0");
                break;
            }

            if (potenciaActual < potenciaObjectiu) {
                estatAnteriorFerRes = false;
                dormirAleatori();
                potenciaActual++;
                System.out.println(getName() + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                
                if (potenciaActual == potenciaObjectiu) {
                    System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    estatAnteriorFerRes = true;
                }
            } else if (potenciaActual > potenciaObjectiu) {
                estatAnteriorFerRes = false;
                dormirAleatori();
                potenciaActual--;
                System.out.println(getName() + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                
                if (potenciaActual == potenciaObjectiu && potenciaObjectiu != 0) {
                    System.out.println(getName() + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    estatAnteriorFerRes = true;
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dormirAleatori() {
        try {
            int temps = 1000 + (int) (Math.random() * 1001);
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}