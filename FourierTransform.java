import java.util.ArrayList;

public class FourierTransform {
   public static void main(String[] args) {
      // Create input array
      ArrayList<Double> arr = new ArrayList<Double>();
      for (int i = 0; i < 100; i++) {
         arr.add(Math.sin(i)+2*Math.sin(4*i));
      }
      
      double inter = .5; // Interval that graph is spaced out
      int max_val = 10; // Size of the domain of the graph
      
      // Apply Fourier Transform to arr and store it in out
      ArrayList<Double> out = new ArrayList<Double>();
      for (int i = 0; i < max_val/inter; i++) {
         out.add(four(arr,i*inter)); // Call Fourier Transform Function
      }
      
      System.out.println(out); // Print out the array
      printarr(out, inter, max_val); // Call custom made print method to display graph
   }
   
   public static double four(ArrayList<Double> arr, double freq) {
      double ans_r = 0; // Real value
      double ans_i = 0; // Imaginary Value
      
      ///// The integral to calculate the Fourier Transform of a function is the integral of f(x)*e^(-iwx) dx
      ///// This is essentially a Laplace Transform (integral of f(x)*e^(-sx) dx) where s = iw
      
      ///// From euler's identity (e^(ix) = cos(x) + i*sin(x)), we get the real integral to be the integral of f(x)*cos(-xw) dx
      ///// and the imaginary integral to be the integral of f(x)*sin(-xw) dx
      
      ///// Note: The negative signs inside of the trig functions can be left out because the resulting values are squared
      
      // Calculate the real value using an integral over a discretized domain
      for (int x = 0; x < arr.size(); x++) {
         ans_r += arr.get(x) * Math.cos(freq*x);
      }
      
      // Calculate the imaginary value using an integral over a discretized domain
      for (int x = 0; x < arr.size(); x++) {
         ans_i += arr.get(x) * Math.sin(freq*x);
      }
      
      // Return the magnitude of the value in the imaginary plane
      return Math.sqrt(Math.pow(ans_r,2)+Math.pow(ans_i,2));
   }
   
   public static void printarr(ArrayList<Double> arr, double inter, int size) {
      int scale = 10; // Scale factor
      
      // Put all of values from arr in a new array and scale them down so they fit on the screen
      // Find max value of those scaled values
      ArrayList<Integer> newarr = new ArrayList<Integer>();
      int max = 0;
      for (double num : arr) {
         newarr.add((int)(num/scale));
         if (num/scale > max) {
            max = (int)(num/scale);
         }
      }
      
      // Make spikes using the information about the max value
      for (int i = 0; i <= max; i++) {
         for (int j = 0; j < newarr.size(); j++) {
            if (newarr.get(j) - max >= 0) {
               System.out.print(" *  ");
            }
            else if (newarr.get(j) - max < 0) {
               System.out.print("    ");
            }
            newarr.set(j, newarr.get(j) + 1);
         }
         System.out.println();
      }
      
      // Print out numbers along the bottom
      for (int i = 0; i < size/inter; i++) {
         System.out.print(i*inter + " ");
      }
   }
}