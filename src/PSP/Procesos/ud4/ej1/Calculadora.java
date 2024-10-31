package PSP.Procesos.ud4.ej1;

import PSP.Procesos.ud4.ThreadColor;

import java.util.Arrays;
import java.util.Random;

public class Calculadora {

    private static final int arrayNum = 10;
    private static final int minRange = 1;
    private static final int maxRange = 10;
    private int total = 0;

    public int calcularSuma(int[] nums){
        String threadName = Thread.currentThread().getName();
        ThreadColor enumColor = ThreadColor.valueOf(threadName);

        System.out.println(enumColor.color() + Arrays.toString(nums));
        for(int num : nums){
            total = total + num;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(enumColor.color() + total);
        return total;
    }

    public int calcularSuma() {
        Random r = new Random();
        int[] nums = new int[arrayNum];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(minRange, maxRange + 1);
        }
        total = calcularSuma(nums);
        return total;
    }
}
