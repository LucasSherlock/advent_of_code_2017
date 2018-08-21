package q10;

import java.util.ArrayList;
import java.util.ListIterator;
   
   
   /**
     * An arraylist that loops around.
     */
    public class CircularArrayList<E> extends ArrayList<E> {
        
        private static final long serialVersionUID = 1L;

        public CircularArrayList() {
            super();
        }

        public E get(int index) {
            
            if (index == this.size()) {
                index = 0;
            } else if (index == -1) {
                index = this.size()-1;
            }
            
            return super.get(index);
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return new CircListItr(index);
        }

        private class CircListItr implements ListIterator<E> {
            
            private int _cursor;
            private int _size = CircularArrayList.this.size();
            

            public CircListItr(int index) {
                _cursor = index;
            }


            public boolean hasNext() {
                return true;
            }

            public E next() {
                E nextObj = CircularArrayList.this.get(_cursor);
                _cursor++;
                if (_cursor == _size) {
                    _cursor = 0;
                }
                return nextObj;
            }

            public boolean hasPrevious() {
                return true;
            }

            public E previous() {
                E nextObj = CircularArrayList.this.get(_cursor - 1);
                _cursor--;
                if (_cursor == -1) {
                    _cursor = _size - 1;
                }
                return nextObj;
            }

            public void add(E e) {
                throw new UnsupportedOperationException("Method not Implemented");
            }

            public void remove() {
                throw new UnsupportedOperationException("Method not Implemented");
            }

            public void set(E e) {
                throw new UnsupportedOperationException("Method not Implemented");
            }

            public int previousIndex() {
                return _cursor - 1;
            }

            public int nextIndex() {
                return _cursor;
            

        }
    
    }
}