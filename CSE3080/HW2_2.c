#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int check_array(int* arr, int n, int min, int cnt);

int main() {

	int n;
	int num;
	int* arr = (int *)malloc(sizeof(int) * (n+1));
	int cnt = 0;

	scanf("%d", &n);

	for(int i=0; i<n; i++){
		scanf("%d", &num);
		arr[i] = num;
	}

	int min = arr[0];
	for(int i=0; i<n; i++){
		if(min > arr[i]){
			min = arr[i];
		}
	}//최소 입력값찾기

	printf("%d\n", check_array(arr, n, min, cnt));

	free(arr);
	return 0;
}

int check_array(int* arr, int n, int tmp, int cnt) {
	
	int check = 0;//연속이면 1, 연속이 아니면 0

	for(int i=0; i<n; i++){
		if(arr[i] == tmp){
			cnt++;
			tmp++;
			i=-1;
		}
	}//tmp는 배열의 최솟값으로 설정하고, 배열을 탐색하면서 tmp값을 갖는 원소가 있는지 확인한다.
	//만약 있다면 cnt 값과 tmp값을 1 증가시켜  다시 처음부터 원소를 탐색한다.
	//모두 탐색한 후에 cnt가 n값이라면 중복되는 값 없이 연속적인 원소만을 가지고 있다.

	if(cnt == n) check = 1;

	return check;
}
