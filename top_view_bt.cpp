//Structure of binary tree
struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
};

// top view
void topView(struct Node *root)
{
	if(root == NULL)
		return;

	Node *temp = NULL;

    queue<Node *> nodes;
    queue<int> left;
    queue<int> right;

    int max_left = 0,
    	max_right = 0,
    	leftV = 0,
    	rightV = 0;

    cout<<root->data<<" ";

    if(root->left != NULL)
    {
    	nodes.push(root->left);
    	left.push(1);
    	right.push(-1);
    }
    if(root->right != NULL)
    {
    	nodes.push(root->right);
    	left.push(-1);
    	right.push(1);
    }



    while(!nodes.empty())
    {
    	int s = nodes.size();

    	for(int i=1;i<=s;++i)
    	{
    		temp = nodes.front();
    		leftV = left.front();
    		rightV = right.front();
    		
    		nodes.pop();left.pop();right.pop();    		
    		
    		if(leftV > max_left)
    		{
    			cout<<temp->data<<" ";
    			max_left = leftV;
    		}
    		if(rightV > max_right)
    		{
    			cout<<temp->data<<" ";
    			max_right = rightV;
    		}


    		if(temp->left != NULL)
    		{
    			nodes.push(temp->left);
    			left.push(leftV + 1);
    			right.push(rightV - 1);
    		}

    		if(temp->right != NULL)
    		{
    			nodes.push(temp->right);
    			left.push(leftV - 1);
    			right.push(rightV + 1);
    		}
    	}

    }
}
