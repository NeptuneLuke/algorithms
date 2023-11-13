/**
* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
*
* You can find me here:
* GitHub	Luca Cortinovis(NeptuneLuke)
*/

#include <iostream>
#include <vector>


using
std::vector,
std::cout,
std::cin;


void selection_sort(vector<int>& myVector);
void swap(vector<int>& myVector, int a, int b);


int main(void) {

	vector<int> myVector(5);
	int number;
	for (int i = 0; i < myVector.size(); ++i) {
		cout << "Insert number: ";
		cin >> number;
		myVector[i] = number;
		cout << "\n";
	}


	selection_sort(myVector);

	for (int i = 0; i < myVector.size(); ++i) {
		cout << myVector[i] << "\n";
	}

	return 0;
}


void selection_sort(vector<int>& myVector) {

	for (int i = 0; i < myVector.size() - 1; ++i) {

		int min = i;
		for (int j = i + 1; j < myVector.size(); ++j) {

			if (myVector[j] < myVector[min]) {
				min = j;
			}
		}

		swap(myVector, i, min);
	}

}

void swap(vector<int> &myVector, int a, int b) {

	int temp = myVector[a];
	myVector[a] = myVector[b];
	myVector[b] = temp;
}