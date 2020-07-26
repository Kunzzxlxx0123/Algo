// Tìm ra bài toán con//
// Gọi S(i,j) là độ dài của đường đi nhỏ nhất từ cột một đến phần từ A(i,j)
// S(i,j) = min(S(i-1, j-1), S(i, j-1), S(i+1,j)) 
public class QuyHoachDongTimDuongDiTheoCot {

	static final int N = 4, M = 5, BIG = 100000;

	public static int A[][] = { 
		{ BIG, BIG, BIG, BIG, BIG }, 
		{ 4, 1, 4, 6, 5 },
		{ 6, 2, 1, 5, 1 }, 
		{ 1, 5, 4, 4, 3 }, 
		{ 2, 4, 5, 3, 4 },
		{ BIG, BIG, BIG, BIG, BIG } };

	static int S[][] = new int[N + 2][M];

	public static void main(String[] args) {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M; j++) {
				S[i][j] = BIG;
			}
		}
		// Tinh S
		for(int i = 1; i <= N; i++){
			S[i][0] = A[i][0];
		}
		
		for(int j = 1; j < M; j++){
			for(int i = 1; i <= N; i++){
				S[i][j] = A[i][j] + Math.min(S[i-1][j-1],Math.min(S[i][j-1], S[i+1][j-1]));
			}
		}
		
		for(int i = 0; i < N+2; i++){
			for(int j = 0; j < M; j++){
				System.out.print(S[i][j] + " ");
			}
			System.out.println();
		}
		
		// Tim gia tri min trong cot cuoi cung
		int minValue = BIG;
		for(int i = 1; i <= N; i++){
			if(minValue >S[i][M-1]) minValue = S[i][M-1];
		}
		
		System.out.println("Do dai duong di min = " + minValue);
	}

}
