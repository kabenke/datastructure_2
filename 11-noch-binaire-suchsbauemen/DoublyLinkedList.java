public class DoublyLinkedList<T>
implements Iterable<T>
{
    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( T content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void addFirst( T content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            first.connectAsPred( e );
            first = e;
        }
        size++;
    }

    public T getFirst() 
    {
        if ( !isEmpty() )
        {
            return first.getContent();
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    public T get( int index ) 
    {
        if ( index >= 0 && index < size )
        {
            Element current = first;
            for ( int i = 0; i < index; i++ )
            {
                current = current.getSucc();
            }
            return current.getContent();
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    public T removeFirst()
    {
        if ( !isEmpty() ) 
        {
            T result = first.getContent();
            if ( first.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            }
            else
            {
                first = last = null;
            }
            size--;
            return result;
        }
        else
        {
            throw new IllegalStateException();
        }
    }
    public boolean isPalindrom()
    {
       Element up = first;
       Element down = last;
       
       int m = size()/2;
       
       for(int i = 0 ; i< m ; i++)
       {
         if(!up.equals(down)){
            
                return false;
            }
           else{
             up = up.getSucc();
             down = down.getPred();
            }
           
    
        }
           return true;
    }
    public int longuestSequence()
    {
       int max , count ;
       max = count = 0;
       if(size() > 0)
       {
           Element current ;
           
           max = count = 1;
           
           current = first.getSucc();
           
           while(current != null)
           {
               if(current.getPred().content.equals(current))
               {
                 count ++;
                 
                 current = current.getSucc();
               }
               else{
                
                   if(count > max)
                   {
                    
                       count = max;
                       
                       count = 1;
                       
                       current=current.getSucc();
                    }
                }
               
                
           }
           
          
       }
       
        return max;
    
    }
     public void sub( T p)
       {
          if(p != null && size()>2)
          {
            Element current = last;

            while( current.getPred() != null && !p.equals(current.getContent()))
            {
                current = current.getPred();
            }

            if(current!=null)
            {
                first = current;
                current.disconnectPred();
            }

          }
        }
    
    public void toPrepend( T[] toPred)
    {
       Element current = first; //es gibt zumindestens eine liste
         
       if(toPred.length > 0)
       {
          if(size() > 0 ) // Die Liste ist nicht leer
          {
            
            current = first;
            
            for(int i = toPred.length-1 ; i > 0 ; i--)
            {  
                current.connectAsPred(new Element(toPred[i]));
                  first = current = current.getPred();
              
                
            }

          }
          // die Liste ist leer
          else{
              
            
             current = first = new Element(toPred[0]);
              
             for(int i = 1 ; i< toPred.length ; i++ )
             {  
                 
                   current.connectAsSucc(new Element(toPred[i]));
                   last = current = current.getSucc();
                 
             }
            }
          size+=toPred.length;
        }
    }
         public DoublyLinkedList AppendFirst(Iterable data)
         {
            DoublyLinkedList result = new DoublyLinkedList();
            if(data != null)
            {
                   Iterator<T> it = data.iterator();
                    
                    Element current = result.first =  new Element(it.next());
                    
                    int count = 1;
                    while(it.hasNext())
                    {
                        current.connectAsSucc(new Element(it.next()));
                        result.last = current = current.getSucc();
                        count++;
                       
                    }
                    result.size += count;
                    
                    if(isEmpty()){return  result;}
                    else{
                           result.last.connectAsSucc(first);
                           first = result.first;
                           size+=result.size();
                           result = null;
                           return this;
                           
                    }
            }
            return this;
         }
        
        
        
        public static<X> boolean containEquals(Iterator<X> it , X value , int n)
        {
           if(it != null)
           {
              int count = 0;
              
              while(it.hasNext())
              {   X temp = it.next();
                  if(temp != null && temp.equals(value))
                  {
                     count++;  
                  }
                   
              }
              
               return count == n;
            
           }
           
           return false;
           
        }
        
        
    
        public void showAll()
        {
            Element current = first;
            while ( current != null )
            {
                System.out.print( current.getContent().toString() );
                if ( current != last )
                {
                    System.out.print(", ");
                }
                current = current.getSucc();
            }
            System.out.println();
        }
        
    
        // Iterator
    
        public Iterator<T> iterator()
        {
            return new ForwardIterator();
        }
    
        private abstract class ListIterator implements Iterator<T>
        {
            Element current;
    
            public boolean hasNext()
            {
                return current != null;
            }
    
            public T next()
            {
                if ( hasNext() )
                {
                    T content = current.getContent();
                    current = step();
                    return content;
                }
                else
                {
                    throw new IllegalStateException();
                }
            }
    
            abstract Element step();
    
        }

    private class ForwardIterator extends ListIterator
    {
        public ForwardIterator()
        {
            current = first;
        }
        
        Element step()
        {
            return current.getSucc();
        }
    }

    
    // strategies

    public static abstract class SubstitutionStrategy<E>
    {
        public abstract E substitute( E ref );
    }

    public void substituteAll( SubstitutionStrategy<T> s )
    {
        Element current = first;
        while ( current != null )
        {
            current.setContent( s.substitute( current.getContent() ) );
            current = current.getSucc();
        }
    }

    public static abstract class InspectionStrategy<E>
    {
        public abstract void inspect( E ref );
    }

    public void inspectAll( InspectionStrategy<T> s )
    {
        Element current = first;
        while ( current != null )
        {
            s.inspect( current.getContent() );
            current = current.getSucc();
        }
    }

    public static abstract class DeletionStrategy<E>
    {
        public abstract boolean select( E ref );
    }

    public void deleteSelected( DeletionStrategy<T> s )
    {
        Element current = first;
        while ( current != null )
        {
            Element candidate = current;
            current = current.getSucc(); 
            if ( s.select( candidate.getContent() ) )
            {
                remove( candidate );
            }
        }
    }

    private void remove( Element e )
    {
        if ( e != null ) 
        {
            if ( e.hasSucc() && e.hasPred() )
            {
                e.getPred().connectAsSucc( e.getSucc() );
            } else if ( e == first && e.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            } else if ( e == last && e.hasPred() )
            {
                last = last.getPred();
                last.disconnectSucc();
            } else {
                first = last = null;
            }
            size--;
        }
    }

    // Element

    private class Element
    {
        private T content;
        private Element pred, succ;

        public Element( T c )
        {
            content = c;
            pred = succ = null;
        }

        public T getContent()
        {
            return content;
        }

        public void setContent( T c )
        {
            content = c;
        }

        public boolean hasSucc()
        {
            return succ != null;
        }

        public Element getSucc()
        {
            return succ;
        }

        public void disconnectSucc()
        {
            if ( hasSucc() ) 
            {
                succ.pred = null;
                succ = null;
            }
        }

        public void connectAsSucc( Element e)
        {
            disconnectSucc();
            if ( e != null ) 
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        public boolean hasPred()
        {
            return pred != null;
        }

        public Element getPred()
        {
            return pred;
        }

        public void disconnectPred()
        {
            if ( hasPred() )
            {
                pred.succ = null;
                pred = null;

            }
        }

        public void connectAsPred( Element e )
        {
            disconnectPred();
            if ( e != null )
            {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }
    }

}
