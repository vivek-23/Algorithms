/*Complete the function below
Node is as follows:
struct Node
{
    int data;
    int lCount;
 
    Node* left;
    Node* right;
};*/
int KthSmallestElement(Node *root, int k)
{
	int curr_rank = 0;
	
	while(root != NULL)
	{	
		if(k!=curr_rank && k - curr_rank <= root->lCount) root = root->left;
		else
		{
			curr_rank += 1 + root->lCount;
			if(curr_rank == k) return root->data;
			root = root->right; 
		}
	}

	return 0;
}
