import java.util.*;
import java.util.stream.*;
public class MyClass {
    public static void main(String args[]) {
        List<Integer> inputlist = new ArrayList<Integer>(Arrays.asList(5,5,1));
        int notavailvalue = changefinder(inputlist);
         System.out.println("The change value not available is " + notavailvalue);
        
        
        
    }
    
public static Integer changefinder(List<Integer> inputlist) {
    
        List<Integer> sumlistmain = new ArrayList<Integer>();
        sumlistmain = sumgenerator(inputlist);
        Integer min = inputlist.stream().min(Integer::compare).get();
        Integer sum = inputlist.stream().mapToInt(Integer::intValue).sum();
        
        Integer OutputSum = 0;

        for(int i=min;i<=sum+1;i++){
            if(!sumlistmain.contains(i))
            {
                return i;
            }
        }
        
        return 0;
    
}    

public static List<Integer> sumgenerator(List<Integer> inputlist) {
    
    List<Integer> dummy = new ArrayList<Integer>();
    List<List<Integer>> mypermlists = new ArrayList<List<Integer>>();
     List<Integer> sumlist = new ArrayList<Integer>();
    
    subsetgenerator(mypermlists,inputlist,dummy);
    
           
        
        for(List<Integer> mypermlistsingle : mypermlists){
            System.out.println("mypermlistsingle is : "+ mypermlistsingle.toString());
            int sumindarr = mypermlistsingle.stream().mapToInt(Integer::intValue).sum();
            if(!sumlist.contains(sumindarr))
            {
            sumlist.add(sumindarr);
            }
        }
    
    Collections.sort(sumlist);
        for(Integer s : sumlist){
            System.out.println("s value is : "+ s); 
        }
        
        return sumlist;
}
    
    public static void subsetgenerator(List<List<Integer>> mypermlists,List<Integer> templist,List<Integer> newtemplist) {
        
        if(!templist.isEmpty()){
            
            int arraylength = templist.size()-1;
            for(int i=0;i<=arraylength;i++)
            {
                List<Integer> newtemplistloop = new ArrayList<>();
                newtemplistloop.addAll(newtemplist);
                newtemplistloop.add(templist.get(i));
                List<Integer> tempalllist = new ArrayList<>();
                Collections.sort(newtemplistloop);
                                if(!mypermlists.contains(newtemplistloop))
                {
                mypermlists.add(newtemplistloop);
                }
                // mypermlists.add(newtemplistloop);
                // templist.remove(0);
                tempalllist.addAll(templist);
                tempalllist.remove(i);
                subsetgenerator(mypermlists,tempalllist,newtemplistloop);
            }
            
            return;
            
        }
        else
        {
            return;
        }
        
    }
    
}
