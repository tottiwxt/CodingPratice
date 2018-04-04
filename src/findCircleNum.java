


public class findCircleNum {
	
	
	/* 法1   dfs
	public int findCircleNum(int[][] M) {
		int count = 0;
		int n = M[0].length;
		int[] visited = new int[n];
		for(int i = 0; i<n;i++){
			if(visited[i]==1)
				continue;
			dfs(M,visited,i);
			count++;
		}
		
		return count;
    }

	private void dfs(int[][] m, int[] visited, int i) {

		for(int j = 0;j<m[0].length;j++){
			if(m[i][j]==1&&visited[j]!=1){
				visited[j] = 1;
			dfs(m, visited, j);
			}
		}
	}
	*/
	
	// 法2： 并查集
	public int findCircleNum(int[][] M) {
		int count = 0;
		int n = M[0].length;
		int[] root = new int[n];
		for(int i = 0;i<n;i++){
			root[i] = i;
		}
		for(int i=0;i<n;i++)
			for(int j = 0 ; j<n;j++){
				if(M[i][j]==1){
					if(find(i,root)!=find(j,root)){
						Union(i,j,root);
					}
					else 
						continue;
				}
				
			}
		for(int i = 0;i<n;i++)
			if(root[i]==i)
				count++;
		
		
		return count;
    }

	private void Union(int i, int j, int[] root) {
		// TODO Auto-generated method stub
		root[find(j,root)]= i;
	}

	private int find(int i, int[] root) {
		// TODO Auto-generated method stub
		if(root[i]==i)
			return i;
		else {
			return find(root[i], root);
		}
		
	
	}
	
	
	
	
}
