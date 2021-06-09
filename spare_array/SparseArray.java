package datastruct.spare_array;

/**
 * @Author: Targue
 * @Date: 2021/6/8-16:09
 * @E-mail: 18961568969@163.com
 * @Description:
 **/
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0：没有棋子
        //1：黑子，2：蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][4] = 2;
        chessArr[4][5] = 5;

        //输出原始数组
        System.out.println("原始的二维数组");
        for(int[] row:chessArr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转稀疏矩阵
        //1.先遍历二维数组得到非0数据的个数
        int sum = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr[i][j]!=0){
                    sum++;
                }
            }
        }

        //创建稀疏矩阵
        int sparesArr[][] = new int[sum+1][3];
        sparesArr[0][0] = 11;
        sparesArr[0][1] = 11;
        sparesArr[0][2] = sum;
        int count = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr[i][j]!=0){
                    count++;
                    sparesArr[count][0] = i;
                    sparesArr[count][1] = j;
                    sparesArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println();
        //打印稀疏数组
        System.out.println("稀疏矩阵为：");
        for(int[] arr:sparesArr){
                System.out.printf("%d\t%d\t%d\t\n",arr[0],arr[1],arr[2]);
        }

        //将稀疏矩阵还原为原矩阵
        int height = sparesArr[0][0];
        int width = sparesArr[0][1];
        int total = sparesArr[0][2];
        int sourceArr[][] = new int[height][width];
        //初始化矩阵
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                sourceArr[i][j] = 0;
            }
        }
        //矩阵赋值
        for(int num=1;num<=total;num++){
            int tem_height = sparesArr[num][0];
            int tem_width = sparesArr[num][1];
            int value = sparesArr[num][2];
            sourceArr[tem_height][tem_width] = value;
        }
        System.out.println();
        System.out.println("根据稀疏矩阵转换后的原矩阵为：");
        //输出转换后的稀疏矩阵
        for(int[] arr:sourceArr){
            for(int data:arr){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
