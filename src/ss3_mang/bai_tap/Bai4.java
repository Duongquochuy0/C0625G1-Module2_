package ss3_mang.bai_tap;

public class Bai4 {
    public static void main(String[] args) {
        int [][] matrix ={{1,2,3},{4,2,1}};
        int max =0;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                if(matrix[i][j]>max){
                    max = matrix[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
