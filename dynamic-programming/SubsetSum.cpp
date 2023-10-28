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


bool subset_sum(vector<int> set, int sum);


int main(void) {

    vector<int> set = {3, 34, 4, 12, 5, 2};
    int sum = 9;

    bool sol = subset_sum(set,sum);
    cout << "Can the set ";
    for (auto elem : set) {
        cout << elem << " ";
    }
    cout << " sum up to " << sum << " ? \n\n";

    cout << std::boolalpha << sol;


    return 0;
}


bool subset_sum(vector<int> set, int sum) {

    int n = set.size();
    
    vector< vector<bool> > subset_table (n + 1, vector<bool>(sum + 1) );

    for (int i = 0; i <= n; ++i) {
        
        for (int j = 0; j <= sum; ++j) {
            
            // base case i==0
            if (i == 0) {
                subset_table[i][j] = false;
            }

            // base case j==0
            else if (j == 0) {
                subset_table[i][j] = true;
            }

            // recursive step
            else {
                if (set[i - 1] > j) {
                    subset_table[i][j] = subset_table[i - 1][j];
                }
                if (set[i - 1] <= j) {
                    subset_table[i][j] = subset_table[i - 1][j] || subset_table[i - 1][j - set[i-1]];
                }
            }
        }
    }


    return subset_table[n][sum];
}