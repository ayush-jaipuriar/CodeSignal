/*
Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose digits is equal to product. If there is no such integer, return -1 instead.

Example

For product = 12, the output should be
digitsProduct(product) = 26;
For product = 19, the output should be
digitsProduct(product) = -1.
*/

int digitsProduct(int product) {
    using namespace std;
    if (product == 0) {
        return 10;
    }
    if (product == 1) {
        return 1;
    }
    string res = "";
    for (int factor = 9; factor >= 2; factor--) {
        while (product % factor == 0) {
            res = to_string(factor) + res;
            product /= factor;
        }
    }
    if (product != 1) {
        return -1;
    }
    return stoi(res);

}
