package q10;

import java.util.ArrayList;
import java.util.ListIterator;

public class Process {
    
    private ArrayList<Integer> _inputs; // the input
    private CircularArrayList<Integer> _list; // the list (starts at 0 to 255)
    private ArrayList<Integer> _temp; // list for storing temp values
    private int _position = 0;
    private int _skipSize = 0;
    private static final int DEFAULT_ARRAY_SIZE = 256;
    private int _arraySize = DEFAULT_ARRAY_SIZE;
 


    public Process(int[] inputs) {
        _inputs = new ArrayList<Integer>();
        _list = new CircularArrayList<Integer>();
        _temp = new ArrayList<Integer>();
        for (int i : inputs) {
            _inputs.add(i);
        }
        for (int i = 0; i < _arraySize; i++) {
            _list.add(i);
        }  
    }

    public Process(int[] inputs, int size) {
        this(inputs);
        _arraySize = size;
        _list.clear();
        for (int i = 0; i < _arraySize; i++) {
            _list.add(i);
        }
    }

    /**
     * Run the process once with one of the puzzle inputs.
     */
    private void doProcess(int input) {
        int currentPos = _position;
        int endInd = currentPos + input - 1;
        while (endInd > _arraySize-1) {
            endInd -= _arraySize;
        }
        
        System.out.println(currentPos + " " + endInd);
        ListIterator<Integer> iter = _list.listIterator(currentPos);
      
        do {
            int num = iter.next();
            _temp.add(num);
            
            currentPos++;
            if (currentPos == _list.size()) {
                currentPos = 0;
            }
        } while (currentPos != endInd + 1);
        
        ListIterator<Integer> tempIter = _temp.listIterator(_temp.size());
        currentPos = _position;
        while (tempIter.hasPrevious()) {
            if (currentPos == _list.size()) {
                currentPos = 0;
            }
            _list.set(currentPos, tempIter.previous());
            currentPos++;
        }
        _temp.clear();
        
        _position += _skipSize+input;
        if (_position > _arraySize-1) {
            _position -= _arraySize;
        }
        _skipSize++;
    }

    public void run() {
        for (int i : _inputs) {
            doProcess(i);
            printList();
        }
    }


    public void printList() {
        for (int i = 0; i < _list.size(); i++) {
            System.out.print(_list.get(i) + " ");
        }
        
        System.out.println("\n");
    }

}