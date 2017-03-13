#define _CRT_SECURE_NO_DEPRECATE

#include "rwchead.h"

int* quickSort(int* inputarray, int pivot, int r);
int partition(int* inputarray, int pivot, int r);
void swap(int* i, int* j);

int main(void) {

	char* inputFileName = "random.txt";
	char* outpuFileName = "c quick sort.txt";

	int count = countElement(inputFileName);

	int* readfile = readTxtfile(inputFileName, count);

	int* sortedArray = quickSort(readfile, 0, count-1);

	writeTxtFile(sortedArray, outpuFileName, count);

	printf("!] Sucess! \n");

}

int* quickSort(int* inputarray, int pivot, int r) {
	int q = 0;
	
	if (pivot < r) {
		q = partition(inputarray, pivot, r);
		inputarray = quickSort(inputarray, pivot, q - 1);
		inputarray = quickSort(inputarray, q + 1, r);
	}

	return inputarray;
}

int partition(int* inputarray, int pivot, int r) {
	int x = inputarray[r];
	int i = pivot - 1;
	int j;

	for (j = pivot; j < r; j++) {
		if (inputarray[j] <= x) {
			i++;
			swap(&inputarray[i], &inputarray[j]);
		}
	}
	i++;
	swap(&inputarray[i], &inputarray[r]);

	return i;
}

void swap(int* i, int* j) {
	int temp = *i;
	*i = *j;
	*j = temp;
}