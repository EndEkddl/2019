#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void permutation(int* num, char* op, char* arr, int setsize, int* arrsize, int c, int i, int target, int* check2);
void beTarget(int target, char* arr, int* num, int* arrsize, int* check2);//consider paste
void checkBlank(int target, char* arr, int* num, int* arrsize, int* check2);
void checkMul(int target, char* arr, int* num, int* arrsize, int* check2);
void printArr(char* arr, int* num, int* arrsize, int* check2);

int main() {
	
	char* str = (char *)malloc(sizeof(char) * 11);
	char* op = (char *)malloc(sizeof(char) * 5);
	int arrsize;
	int num;
	int target;
	int setsize = 4;
	int check2 = 0;

	scanf("%s", str);
	arrsize = strlen(str) - 1;
	num = atoi(str);
	scanf("%d", &target);
	int* num1 = (int *)calloc(sizeof(int),(arrsize+1));
	int* num2 = (int *)calloc(sizeof(int),(arrsize+1));
	char* arr = (char *)malloc(sizeof(char) * arrsize);

	op[0] = '+';
	op[1] = '-';
	op[2] = '*';
	op[3] = '&';

	for(int i=arrsize; i>0; i--) {
		num1[i-1] = num % 10;
		num2[i-1] = num % 10;
		num /= 10;
	}

	int i;
	permutation(num1, op, arr, setsize, &arrsize, arrsize, i, target, &check2);


	if(check2 == 0) {
		printf("None\n");
	}
	free(str);
	free(num1);
	free(num2);
	free(op);
	free(arr);

	return 0;
}
void swap(char *a, char *b){

	char copy = *a;
	*a = *b;
	*b = copy;

	return ;
}
void permutation(int* num, char* op, char* arr, int setsize, int* arrsize, int* c, int i, int target, int* check2) {

	if(!arrsize) {
		for(int i =0; i < *arrsize; i++) {
			printf("%c ", arr[i]);
		}
		printf("\n");
		checkBlank(target, arr, num, &c, check2);
		checkMul(target, arr, num, &c, check2);
		return ;
	}

	else{
		for(i = setsize-1; i>=0; i--){
			swap(&op[i], &op[setsize-1]);
			arr[*arrsize-1] = op[setsize-1];//
			permutation(num, op, arr, setsize, &(*arrsize - 1), c, i, target, check2);
			swap(&op[i], &op[setsize-1]);
		}
	}
}
void beTarget(int target, char* arr, int* num, int* arrsize, int* check2) {

	int check = 0;
	int result = num[0];

	*arrsize = strlen(arr);

	for(int i=0; i < *arrsize; i++) {

		if(arr[i] == '+') {
			result += arr[i+1];
		}		
		else if(arr[i] == '-'){
			result -= arr[i+1];
		}
	}

	if(result == target){
		check = 1;
		*check2 = 1;
	} 

	if(check == 1) {
		printArr(arr, num, arrsize, check2);
	}

	return;

}
void checkBlank(int target, char* arr, int* num, int* arrsize, int* check2){

	int numLen = *arrsize + 1;

	for(int i=0; i < *arrsize; i++) {
		printf("%d",num[i]);
		printf("%c", arr[i]);
	}
	printf("%d\n", num[*arrsize]);
	for(int i=0; i < *arrsize; i++) {
		if(arr[i] == '&') {
			num[i] *= 10;
			num[i] += num[i+1];
			printf("num : %d\n",num[i]);
			for(int j = i; j < *arrsize-2; j++) {
				num[j+1] = num[j+2];
				arr[j] = arr[j+1];
			}
			num = (int *)realloc(num, sizeof(int)*(numLen-1));
			arr = (char *)realloc(arr, sizeof(char) * (*arrsize-1));
			(*arrsize)--;
			numLen--;
		}

		else continue;
	}

	return ;
}

void checkMul(int target, char* arr, int* num, int* arrsize, int* check2){

	int numLen = *arrsize + 1;

	for(int i=0; i < *arrsize; i++) {
		if(arr[i] == '*'){
			num[i] *= num[i+1];	
			for(int j = i; j < *arrsize - 2; j++) {
				num[j+1] = num[j+2];
				arr[j] = arr[j+1];
			}
			num = (int *)realloc(num, sizeof(int)*(numLen-1));
			arr = (char *)realloc(arr, sizeof(char) * (*arrsize-1));
		}
		else continue;
	}
	beTarget(target, arr, num, *arrsize, *check2);

	return ;
}

void printArr(char* arr, int* num, int* arrsize, int* check2){
	
	for(int i=0; i < *arrsize; i++) {
		printf("%d", num[i]);
		printf("%c", arr[i]);
	}
	printf("%d\n", num[*arrsize]);


	return;
}
