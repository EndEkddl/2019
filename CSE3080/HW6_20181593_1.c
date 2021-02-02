#include <stdio.h>
#include <stdlib.h>

typedef struct node *node_pointer;
typedef struct node {
	int vertex;
	node_pointer link;
}node;

node_pointer* graph;
int* visited;
FILE* fp1 = NULL;
FILE* fp2 = NULL;
void dfs(int v);

int main(){

	int n;
	int i,j;
	int num;
	
	node_pointer ptr = (node_pointer)malloc(sizeof(node));
	node_pointer w = (node_pointer)malloc(sizeof(node));

	fp1 = fopen("input.txt", "r");
	fp2 = fopen("output.txt", "w");

	if(fp1 == NULL || fp2 == NULL) printf("FILE OPEN ERROR!\n");

	fscanf(fp1, "%d", &n);
	visited = (int *)malloc(sizeof(int)*n +1);

	graph = (node_pointer*)malloc(sizeof(node_pointer)*50);
	for(i=0; i<n; i++){
		visited[i] = 0;
		graph[i] = (node_pointer)malloc(sizeof(node));
		graph[i]->vertex = i;
	}
	for(i=0; i<n; i++){
		for(j=0; j<n; j++){
			fscanf(fp1, "%d ", &num);
			if(num == 1){	
				ptr = graph[i];
				w = (node_pointer)malloc(sizeof(node));
				w->vertex = j;
				w->link = NULL;
				while(ptr->link != NULL){
					ptr = ptr->link;
				}
				ptr->link = w;

			}
		}
	}
	for(i=0; i<n; i++){
		if(visited[i] == 0){
			dfs(i);
			fprintf(fp2, "\n");
		}
	}
	
	free(visited);
	fclose(fp1);
	fclose(fp2);

	return 0;
}

void dfs(int v){
	node_pointer w;
	visited[v] = 1;
	fprintf(fp2, "%d ", v);

	for(w = graph[v]; w; w = w->link){
		if(visited[w->vertex] == 0){
			dfs(w->vertex);
		}
	}

	return ;
}
