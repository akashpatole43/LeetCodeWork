package Medium;

/*
 * Title = 50. Pow(x, n)
 * 
 * Question = Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * yutube solution chala nhi isliye mene mera solve kiya but time exceed aara
 */
public class QuestionId50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//youtube video ans was not solving the prb = https://www.youtube.com/watch?v=l0YC3876qxg
class SolutionQuestionId50 {
    public double myPow(double x, int n) {

        double a = 1;   // ans 
        int nnn = n;    // to handle -ve n 
        if (nnn<0) nnn = -1*nnn;        // if n is -ve then make it +ve
        for (int i = nnn ; i > 0 ; i--) {
            a = a*x;
        }
        if (n<0) a = 1/a;       // if n is -ve then ans = 1/ans
        return a;
/*
        // Step 1:
        // store n in new varible to work on, use long to stop it from getting overflow
        long nn = n;
        double ans = 1.0; // for answer use double

        // Step 2:
        // check if nn is -ve, if so then convert it to +ve
        if (nn < 0) nn = -1 * nn;

        // Step 3:
        // loop till nn is less than 0
        while (nn > 0) {
            // Step 4:
            // if nn is even no then n=n/2 and x=x*x
            if (n%2 == 0) {
                nn = nn/2;
                x = x*x;
            } else { // nn is odd no then ans = ans*x and n = n-1
                nn = nn-1;
                ans = ans*x;
            }
        }

        // Step 5:
        // if in step2 we converted -ve to +ve then the ans will be ans = 1/ans
        if (n < 0) ans = (double)(1.0) / (double)(ans);

        // return ans
        return ans;
        */
    }
}