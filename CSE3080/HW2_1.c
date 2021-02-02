#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void pmatch_all(char* str, char* pat, int* fail);
void failure(char *pat, int* fail);
int main() {

	char* str = (char *)malloc(sizeof(char)* 31);
	char* pat = (char *)malloc(sizeof(char)* 31);
	int* fail = (int *)malloc(sizeof(int)* 31);

	scanf("%s", str);
	scanf("%s", pat);

	failure(pat, fail);
	pmatch_all(str, pat, fail);

	free(str);
	free(pat);
	free(fail);
	
	return 0;
}

void failure(char *pat, int* fail){

	int i;
	int n = strlen(pat);

	fail[0] = -1;

	for(int j=1; j<n; j++) {
		i = fail[j-1];
		while((pat[j] != pat[i+1]) && i>=0){
			i = fail[i];
			if(pat[j] == pat[i+1]){
				fail[j] = i+1;
			}
			else fail[j] = -1;
		}//접두사와 접미사가 일치하는 최대길이- 1을 배열에 넣어준다. 	
	}

	return ;
}
void pmatch_all(char* str, char* pat, int* fail){

	int i = 0,j = 0;
	int lenS = strlen(str);
	int lenP = strlen(pat);
	
	while(i<lenS && j<lenP){ 

		if(str[i] == pat[j]){
			if(j == lenP-1){
				printf("%d\n", i-lenP+1);
				j = fail[j-1]+1;
			}//str과 pat의 문자가 완전히 일치하는 경우
			i++;
			j++;
		}
		else if(!j){
			i++;
		}
		else{
			j = fail[j-1]+1;
		}//이미 같은 부분을 다시 확인하지 않도록 함
	}

	return ;
}
