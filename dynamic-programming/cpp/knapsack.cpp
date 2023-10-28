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


void knapsack(int n, int W, vector<int> values, vector<int> weights, vector< vector<int> > &knapsack_table);
void print_knapsack(int i, int w, vector< vector<int> > knapsack_table, vector<int>values, vector<int> weights);


int main(void) {

    vector<int> values = {7, 5, 10, 15, 9, 8, 4};		// values (how many units of that element)
    vector<int> weights = {1, 1, 2, 5, 3, 4, 2}; 		// weights (how much each element weights)
    int W = 15;					                        // knapsack capacity

    int n = values.size();
    vector< vector<int> > knapsack_table (n + 1, vector<int> (W + 1) );

	print_knapsack(n, W, knapsack_table, values, weights);


    return 0;
}

void knapsack(int n, int W, vector<int> values, vector<int> weights, vector< vector<int> > &knapsack_table) {

	for (int i = 0; i <= n; ++i) {
		
		for (int j = 0; j <= W; ++j) {
			
			// base case i==0 or j==0
			if (i == 0 || j == 0) {
				knapsack_table[i][j] = 0;
			}

			// recursive step
			else {
				if (weights[i - 1] > j) {
					knapsack_table[i][j] = knapsack_table[i - 1][j];
				}
				else {
					knapsack_table[i][j] = std::max(knapsack_table[i - 1][j], knapsack_table[i - 1][j - weights[i - 1]] + values[i - 1]);
				}
			}
		}
	}

}

// i = object of index i
// w = remaining capacity of the knapsack
void print_knapsack(int i, int w, vector< vector<int> > knapsack_table, vector<int>values, vector<int> weights) {
	
	if (i == 0 || w == 0) {
		cout << "\n";
	}
	else {

		if (weights[i - 1] > w) {
			print_knapsack(i - 1, w, knapsack_table, values, weights);
		}
		else {

			if (knapsack_table[i - 1][w - weights[i - 1]] + values[i - 1] >= knapsack_table[i - 1][w]) {
				print_knapsack(i - 1, w - weights[i - 1], knapsack_table, weights, values);
				cout << "Object " << i << "   weight: " << weights[i - 1] << "   value: " << values[i - 1] << "\n";
			}
			else {
				print_knapsack(i - 1, w, knapsack_table, values, weights);
			}
		}
	}
}
