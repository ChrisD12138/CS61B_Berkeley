package bearmaps;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xuannan Dong
 */
public class final_test {

    @Test
    public void test(){
        Point A = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point B = new Point(4, 2);
        Point C = new Point(4, 5);
        Point D = new Point(3, 3); // constructs a Point with x = 1.1, y = 2.2
        Point E = new Point(1, 5);
        Point F = new Point(4, 4);
        KDTree kdt = new KDTree(Arrays.asList(A, B, C, D, E, F));
        NaivePointSet nn = new NaivePointSet(Arrays.asList(A, B, C, D, E, F));

        int T = 10;
        for(int i =0;i<T; i++){
            Random r = new Random();
            double x = r.nextDouble()*5;
            double y = r.nextDouble()*5;
            Point p1 = kdt.nearest(x, y); // returns p2
            Point p2 = nn.nearest(x,y);
            assertEquals(p1,p2);
        }

    }
}
