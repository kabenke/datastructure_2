public class SearchTree
{

    private Node node;
    private SearchTree leftChild, rightChild;

    public SearchTree(int... A)
    {
        for (int i=0; i<A.length ;i++ ) {
            add((int)A[i]);
        }
    }

    public boolean isEmpty()
    {
      return node == null;
    }

    public void add( int t )
    {
        SearchTree current = this;

        while ( !current.isEmpty() && current.node.getKey() != t )
        {
          if ( current.node.getKey() > t )
          {
            current = current.leftChild;
          }
          else
          {
            current = current.rightChild;
          }
        }

        if ( current.isEmpty() )
        {
          current.node = new Node( t );
          current.leftChild = new SearchTree();
          current.rightChild = new SearchTree();
        }


    }

    public void show()


    {
        if ( !isEmpty() )
        {
            leftChild.show();
            System.out.println( node.toString() );
            rightChild.show();
        }


    }


    //voici la methode qui permet de compter les knoten

    public int countNodes()
    {

     //si l'arbre n'est pas vide elle contient minimum 1 knoten
      if (!isEmpty())
       {
         return 1+leftChild.countNodes()+rightChild.countNodes();
       }
      else
      {

       return 0;
      }
    }

    public static void main(String[] args) {

      int[] Array = {11,41,5,43,17,31,7,14,15};
      SearchTree tree = new SearchTree (Array);
      System.out.println(tree.countNodes()); // la reponse attendue seras 9

     }

}

