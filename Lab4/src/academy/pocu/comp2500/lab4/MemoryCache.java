package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.HashMap;

public class MemoryCache {
    private String diskName;
    private int inputNum;
    private static int instanceCount = 0;
    private static int maxInstanceNum = Integer.MAX_VALUE;
    private static EvictionPolicy mode = EvictionPolicy.LEAST_RECENTLY_USED;
    private HashMap<String,String> entry;
    private HashMap<Integer,String> log;
    private int MaxEntryNum;
    private int entryCount;
    private static ArrayList<Integer> queue = new ArrayList<Integer>();
    private static HashMap<Integer,MemoryCache> cacheInstance = new HashMap<Integer,MemoryCache>();

    private MemoryCache(String diskName){
        this.diskName = diskName;
        inputNum = instanceCount;
        entry = new HashMap<>();
        cacheInstance.put(instanceCount,this);
        instanceCount++;
        queue.add(inputNum);
        log = new HashMap<Integer,String>();
        entryCount = 0;
    }

    public MemoryCache getInstance(String hardDiskName){
        if(instanceCount < maxInstanceNum){
            MemoryCache tem = new MemoryCache(hardDiskName);
            cacheInstance.put(instanceCount,tem);
            return tem;
        }

        else{
            deleteOneCache();
            MemoryCache tem = new MemoryCache(hardDiskName);
            instanceCount++;
            cacheInstance.put(instanceCount,tem);
            return tem;
        }
    }

    public void deleteOneCache(){
        if(mode == EvictionPolicy.FIRST_IN_FIRST_OUT){
            for (int i = 0; i < cacheInstance.size(); i++ ) {
                cacheInstance.put(i,cacheInstance.get(i+1));
            }
            cacheInstance.put(instanceCount-1,null);
            instanceCount--;
            queue.remove(queue.indexOf(0));
            for (int i = 0; i < queue.size(); i++ ) {
                int tem = queue.get(i);
                queue.add(i,tem-1);
            }
        }
        else if(mode == EvictionPolicy.LAST_IN_FIRST_OUT){
            instanceCount--;
            cacheInstance.remove(instanceCount);
            queue.remove(queue.indexOf(instanceCount));
        }
        else {
            int tem = queue.get(0);
            queue.remove(0);
            for(int i = 0; i < queue.size(); i++){
                if(queue.get(i) > tem ){
                    queue.set(i, queue.get(i)-1);
                }
            }
            cacheInstance.remove(tem);
            instanceCount--;
        }
    }


    public void useCache(MemoryCache instance){
        int tem = 0;
        for(int i = 0;i<cacheInstance.size();i++)
        {
            if(cacheInstance.get(i) == instance){
                tem = i;
            }
        }
        int check = queue.indexOf(tem);
        queue.remove(check);
        queue.add(tem);

    }

    public String getDiskName(){
        return diskName;
    }

    static public void  clear(){
        for(int i = 0;i< cacheInstance.size();i++){
            cacheInstance.get(i).entry.clear();
            cacheInstance.get(i).mqueue.clear();
        }
        cacheInstance.clear();
        instanceCount = 0;
    }

    public void  setMaxInstanceCount(int num){
        maxInstanceNum = num;
        while(true){
         if(instanceCount<=maxInstanceNum)
             break;
        }
        deleteOneCache();
    }


    public void deleteCcachEntry(){
        if(mode == EvictionPolicy.FIRST_IN_FIRST_OUT){

        }
        else if(mode == EvictionPolicy.LAST_IN_FIRST_OUT){

        }
        else {

        }
    }

    public void setEvictionPolicy(EvictionPolicy policy) {
        mode = policy;
    }

    public void addEntry(String key,String value){
        if(entry.containsKey(key))
        {
            entry.put(key,value);
        }
        else{
            if(entryCount == MaxEntryNum){
                deleteCcachEntry();
            }
            entry.put(key, value);
        }

    }

    public String getEntryOrNull(String key){
        if(entry.containsKey(key)){
            return key;
        }
        else{
            return null;
        }
    }

    public void setMaxEntryCount(int num){
        maxInstanceNum = num;
    }



}
