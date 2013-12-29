#include <stdio.h>
#include <algorithm>
using namespace std;

// vlw, Duhan
int main()
{
    int N = 500000;
    int arr[N];
    for (int i = 0; i < N; ++i) arr[i] = i;

    std::random_shuffle (arr, arr + N);

    for (int i = 0; i < N; i++) printf("%d\n", arr[i]);

    return 0;
}