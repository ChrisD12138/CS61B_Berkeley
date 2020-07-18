package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
//import	java.lang.invoke.MethodHandleImpl.BindCaller.T;

public class PercolationStats {
    double []x; //用于记录T次实验的结果
    public PercolationStats(int N, int T, PercolationFactory pf){
        if (N<0||T<0) throw new IndexOutOfBoundsException();
        x = new double[T];
        pf.make(N);
    }   // perform T independent experiments on an N-by-N grid
    public double mean(){
        return StdStats.mean(x);
//        double sum = 0;
//        for (double x_i:x) sum += x_i;
//        return sum/x.length;
    }                                           // sample mean of percolation threshold
    public double stddev(){
        return StdStats.stddev(x);
//        double s_2=0;
//        for(double x_i:x) s_2+=Math.pow(x_i-this.mean(),2);
//        return Math.pow((s_2)/x.length-1,0.5);
    }                                         // sample standard deviation of percolation threshold
    public double confidenceLow(){
        return this.mean()-1.96*this.stddev()/(Math.pow(x.length,0.5));
    }                                  // low endpoint of 95% confidence interval
    public double confidenceHigh(){
        return this.mean()+1.96*this.stddev()/(Math.pow(x.length,0.5));
    }                                 // high endpoint of 95% confidence interval
}
