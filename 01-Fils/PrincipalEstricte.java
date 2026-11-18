public class PrincipalEstricte {

    public static void main(String[] args) {
        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, 1);
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, 1);

        juan.start();
        pepe.start();

        System.out.println("Termina thread main");
    }
}