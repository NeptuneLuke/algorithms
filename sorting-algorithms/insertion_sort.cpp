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


void insertion_sort(vector<int>& myVector);


int main(void) {

	vector<int> myVector(5);
	int number;
	for (int i = 0; i < myVector.size(); ++i) {
		cout << "Insert number: ";
		cin >> number;
		myVector[i] = number;
		cout << "\n";
	}


	insertion_sort(myVector);

	for (int i = 0; i < myVector.size(); ++i) {
		cout << myVector[i] << "\n";
	}

	return 0;
}


void insertion_sort(vector<int>& myVector) {

	for (int i = 1; i < myVector.size(); ++i) {

		int tmp = myVector[i];
		int j = i - 1;
		while (j >= 0 && myVector[j] > tmp) {
			myVector[j + 1] = myVector[j];
			j--;
		}

		myVector[j + 1] = tmp;
	}

}