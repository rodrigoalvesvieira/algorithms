#include <stdio.h>

class BST {
public:
    BST* left;
    BST* right;
    int value;

    BST(int v) {
        value = v;
    }

    BST() : value(0) {};

    static void preOrder(BST root);
    static void inOrder(BST root);
    static void postOrder(BST root);
};

int main()
{

    BST *tree = new BST();

    return 0;
}