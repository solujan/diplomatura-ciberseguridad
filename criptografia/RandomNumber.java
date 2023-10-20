package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class MyApplication {

    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    // implemented after https://docs.oracle.com/javase/7/docs/api/java/util/Random.html
    public static int next(long seed) {
        long seed2 = (seed * multiplier +addend) & mask;
        return (int)(seed2 >>> 16);
    }

    public static void main(String[] args) {
        System.out.println("Random");
        Random random = new Random(123456L);
        List<Long> lista = new ArrayList<Long>();
        lista.add(-1073534824L);
        lista.add(-641110279L);
//      for(int i = 0;i<10;i++) {
//          Integer nextRandom = random.nextInt();
//          lista.add(nextRandom.longValue());
//          System.out.println(nextRandom);
//      }


//      x' 0000 0000 0000 0000 1011 0111 1101 1101 0110 1010 1110 1010 1111 1111 0101 1110
//                             |                                     |
//                              --------------------------------------
//      x1 1111 1111 1111 1111 1111 1111 1111 1111 1011 0111 1101 1101 0110 1010 1110 1010
//                                                 |                                     |
//                                                  --------------------------------------
//      65536 = 1 0000 0000 0000 0000
        
        long seed =0L;
        for (int i = 0; i < 65536; i++) {
            seed = lista.get(0) * 65536 + i;
            if (next(seed) == lista.get(1).intValue()) {
                System.out.println("Seed: " + seed);
                break;
            }
        }
        Random random1 = new Random((seed ^ 0x5DEECE66DL) & ((1L << 48) - 1));
        int primerNro = random1.nextInt();
        int segundoNro = random1.nextInt();
        int terceroNro = random1.nextInt();
        System.out.printf("PrimerNro: %d \nSegundo nro: %d \nTercer nro: %d", primerNro, segundoNro, terceroNro);

    }

}