public class Maleducati {
    public static void main(String[] args) {
        System.out.println("Sono: "+Thread.currentThread().getName()+" Facciamoli parlare");
        Person1 p1=new Person1("Mario");
        Person2 p2=new Person2("Luigi");
        p1.start();
        p2.start();



    }
}