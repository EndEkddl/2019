#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

void partition(char** str, int x, int n, int start);
void printStr(char* str, char* a, int aLen);

int main() {

	char* a = (char *)malloc(sizeof(char) * 11);
	int aLen, start;

	scanf("%s", a);
	char* b = (char *)malloc(sizeof(char) * aLen);

	for (int i = 0; i < aLen; i++) {
		b[i] = 'A';
	}

	int x = 1;

	for (int i = 1; i < aLen; i++) {
		x *= 2;
	}
	
	char** str = (char**)malloc(sizeof(char *) * x);

	for (int i = 0; i < x; i++) {
		str[i] = (char *)malloc(sizeof(char) * aLen);
		for (int j = 0; j < aLen-1; j++) {
			str[i][j] = b[j];
		}
	}


	int n = 0;
	start = 0;

	partition(str, x, n, start);

	for (int i = 0; i < x; i++) {
		printStr(str[i], a, aLen);
	}

	free(a);
	free(b);
	for (int i = 0; i < x; i++) {
		free(str[i]);
	}
	free(str);

	return 0;

}

void partition(char** str, int x, int n, int start) {

	if (x < 2) return;

	int half = x / 2;
	char slash = 'B';

	
	for (int i = start; i < start + half; i++) {
		str[i][n] = slash;
	}

	n++;


	partition(str, x / 2, n, start);
	partition(str, x / 2, n, start + half);

	return;
}



void printStr(char* str, char* a, int aLen) {

	int length = aLen;

	for (int j = 0; j < length-1; j++) {
		
		printf("%d", a[j]- '0');
		if (str[j] == 'A') {
			printf("/");
		}
		else {
			continue;
		}
	}
	printf("%d\n", a[aLen - 1] - '0');

	return;
}
