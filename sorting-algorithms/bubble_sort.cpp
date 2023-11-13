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


void bubble_sort(vector<int> &myVector);


int main(void) {

	vector<int> myVector(5);
	int number;
	for (int i = 0; i < myVector.size(); ++i) {
		cout << "Insert number: ";
		cin >> number;
		myVector[i] = number;
		cout << "\n";
	}


	bubble_sort(myVector);

	for (int i = 0; i < myVector.size(); ++i) {
		cout << myVector[i] << "\n";
	}

	return 0;
}


void bubble_sort(vector<int> &myVector) {

	bool swap = true;

	while (swap) {
		swap = false;
		for (int i = 0; i < myVector.size() - 1; i++) {

			if (myVector[i] > myVector[i + 1]) {

				int app = myVector[i];
				myVector[i] = myVector[i + 1];
				myVector[i + 1] = app;
				swap = true;
			}
		}
	}

}