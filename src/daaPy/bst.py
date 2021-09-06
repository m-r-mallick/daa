class Node :
    def __init__(self, key = None) :
        self.data = key
        self.lchild = None
        self.rchild = None
        self.parent = None

def insert(node, root = None) :
    y = None
    x = root
    while x != None :
        y = x
        if node.data < x.data :
            x = x.lchild
        else :
            x = x.rchild
    node.parent = y
    if y is None :
        root = node
    elif node.data < y.data :
        y.lchild = node
    else :
        y.rchild = node

def search(root, val) :
    if root == None or root.data == val :
        return root
    if root.data > val :
        return search(root.lchild, val)
    elif root.data < val :
        return search(root.rchild, val)

def inorder(root) :
    if root :
        inorder(root.lchild)
        print(root.data)
        inorder(root.rchild)

def findSuccessor(root) :
    if root.rchild is not None :
        temp = root.rchild
        while temp.lchild is not None :
            temp = temp.lchild
        return temp
    y = root.parent
    while y is not None and root == y.rchild :
        root = y
        y = y.parent
    return y

def transplant(root, u, v) :
    if u.parent == None :
        root = v
    elif u == u.parent.lchild :
        u.parent.lchild = v
    else :
        u.parent.rchild = v
    if v is not None :
        v.parent = u.parent

def delete(root, val) :
    temp = search(root, val)
    if temp is not None :
        if temp.lchild == None :
            transplant(root, temp, temp.rchild)
        elif temp.rchild == None :
            transplant(root, temp, temp.lchild)
        else :
            y = findSuccessor(temp)
            if y.parent != temp :
                transplant(root, y, y.rchild)
                y.rchild = temp.rchild
                y.rchild.parent = y
            transplant(root, temp, y)
            y.lchild = temp.lchild
            y.lchild.parent = y
        print("Value Deleted From Tree!")
    else :
        print("Value not present in tree!")

i = int(input("Enter ROOT_NODE val : "))
tree = Node(i)

try :
    while True :
        i = int(input("Enter value to insert (Ctrl-C to quit) : "))
        insert(Node(i), tree)
except :
    print("\nInsertion Terminated Using Keyboard Interrupt!")
    pass

print("Inorder Tree Traversal : ")
inorder(tree)

try :
    while True :
        i = int(input("Enter value to delete (Ctrl-C to quit) : "))
        delete(tree, i)
except KeyboardInterrupt :
    print("\nDeletion Terminated Using Keyboard Interrupt!")
    pass

print("Inorder Tree Traversal after deletion : ")
inorder(tree)