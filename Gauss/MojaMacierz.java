//Anna Konstantynowicz, gr. 3
import static java.lang.Math.*;
import java.util.Random;
public class MojaMacierz{
  static int N=4;

  static int losuj_r(){
    Random ran = new Random();
    int r = ran.nextInt(131071)-65536;
    return r;
  }

  static float[][] losuj_A_float(){
    float[][] macierz= new float[N][N];
    for (int i=0;i<N;i++){
      for (int j=0;j<N;j++){
        macierz[i][j]= (float) losuj_r()/65536;
      }
    }
    return macierz;
  }

  static float[] losuj_B_float(){
    float[] wektor= new float[N];
    for (int i=0;i<N;i++){
        wektor[i]= (float) losuj_r()/65536;
    }
    return wektor;
  }

  static double[][] losuj_A_double(){
    double[][] macierz= new double[N][N];
    for (int i=0;i<N;i++){
      for (int j=0;j<N;j++){
        macierz[i][j]= (double) losuj_r()/65536;
      }
    }
    return macierz;
  }

  static double[] losuj_B_double(){
    double[] wektor= new double[N];
    for (int i=0;i<N;i++){
        wektor[i]= (double) losuj_r()/65536;
    }
    return wektor;
  }

  static void PG(float[][] A, float[] B){
    float max;
    int p;
    for (int i=0;i<N;i++){
      for (int j=i;j<N;j++){
        max = abs(A[i][j]);
        p=i;
        for (int k=i+1;k<N;k++){
          if(abs(A[k][j])>max){
            max=abs(A[k][j]);
            p=k;
          }
        }
        if (A[i][j]!=max){
          for (int l=0;l<N;l++){
            float tmp = A[i][l];
            A[i][l] = A[p][l];
            A[p][l] = tmp;
          }
          float tmp = B[i];
          B[i] = B[p];
          B[p] = tmp;
        }
      }
      System.out.println();
      System.out.println();

      for (int ii=0;ii<N;ii++){
        for (int jj=0;jj<N;jj++){
          System.out.print(A[ii][jj] + " ");
        }
        System.out.print("| " + B[ii]);
        System.out.println();
      }

    }

  }

	public static void main(String[] args){

    float[][] mf = losuj_A_float();
    float[] wf= losuj_B_float();
    for (int i=0;i<N;i++){
      for (int j=0;j<N;j++){
        System.out.print(mf[i][j] + " ");
      }
      System.out.print("| " + wf[i]);
      System.out.println();
    }

    PG(mf,wf);
    System.out.println();
    System.out.println();

    for (int i=0;i<N;i++){
      for (int j=0;j<N;j++){
        System.out.print(mf[i][j] + " ");
      }
      System.out.print("| " + wf[i]);
      System.out.println();
    }
    /*double[][] md = losuj_A_double();
    double[] wd = losuj_B_double();
    for (int i=0;i<N;i++){
      for (int j=0;j<N;j++){
        System.out.print(md[i][j] + " ");
      }
      System.out.print("| " + wd[i]);
      System.out.println();
    }*/
	}
}
