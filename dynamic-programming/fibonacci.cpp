/**
	* @author 	Luca Cortinovis	luca1cortinovis@gmail.com
	* @since	28/10/2023
	*
	* You can find me here:
	* GitHub	Luca Cortinovis (NeptuneLuke)
*/

#include <iostream>
#include <string>
#include <vector>


using
std::string,
std::vector,
std::cout,
std::cin;


vector<int> fibonacci_iter(int n);
int fibonacci_rec(int n);


int main(void) {

	cout << "Insert the nth number of Fibonacci: \n";
	int n = 0;
	cin >> n;
	cout << "\n\n";


	// Fibonacci iterative
	vector<int> fib = fibonacci_iter(n);
	cout << "Fibonacci sequence: ";
	for (auto elem : fib) {
		cout << elem << " ";
	}
	cout << "\n\n";


	// Fibonacci recursive
	int fib_num = fibonacci_rec(n);
	cout << "Fibonacci recursive: " << fib_num;


	return 0;
}


vector<int> fibonacci_iter(int n) {

	vector<int> fib(n + 1);
	fib[0] = 0;
	fib[1] = 1;

	for (int i = 2; i <= n; i++)
		fib[i] = fib[i - 1] + fib[i - 2];

	return fib;
}

int fibonacci_rec(int n) {

	if (n <= 1)
		return n;
	else
		return fibonacci_rec(n - 1) + fibonacci_rec(n - 2);
}