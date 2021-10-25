package exercice1;

public class Main {
    public static void main(String[] args) {
        //question 1:
        Integer a = 7;
        Integer b=8;
        Double c = 7.0;
        Double d=8.0;
        long e = 112;
        long f = -12;
        String g = " Paris -";
        String h= " Marseille";
        //ENTIERS
        Somme<Integer> s1 = new Somme<Integer>() {
            @Override
            public Integer somme(Integer a, Integer b) {
                return a + b ;
            }
        };
        System.out.println("la somme des deux Integer a + b ="+ s1.somme(a,b));

        //DOUBLE
        Somme<Double> s2 = new Somme<Double>() {
            @Override
            public Double somme(Double a, Double b) {
                return a + b ;
            }
        };
        System.out.println("la somme des deux doubles a + b ="+ s2.somme(c,d));

        //LONG
        Somme<Long> s3 = new Somme<Long>() {
            @Override
            public Long somme(Long a, Long b) {
                return a + b ;
            }
        };
        System.out.println("la somme des deux longs a + b ="+ s3.somme(e,f));

        //STRING
        Somme<String> s4 = new Somme<String>() {
            @Override
            public String somme(String a, String b) {
                return a + b ;
            }
        };
        System.out.println("la somme des deux chaines de caractère a + b ="+ s4.somme(g,h));

        //lambda Integer
        Somme<Integer> s5 = (a1,b1) -> a1 + b1;
        System.out.println("test int lambda somme =" + s5.somme(a,b));

        //lambda Double
        Somme<Double> s6 = (a2,b2) -> a2 + b2;
        System.out.println("test double lambda somme =" + s6.somme(c,d));

        //lambda Long
        Somme<Long> s7 = (a2,b2) -> a2 + b2;
        System.out.println("test long lambda somme =" + s7.somme(e,f));

        //lambda String
        Somme<String> s8 = (a4,b4) -> a4 + b4;
        System.out.println("test String lambda somme =" + s8.somme(g,h));

        //question2




    }
}
