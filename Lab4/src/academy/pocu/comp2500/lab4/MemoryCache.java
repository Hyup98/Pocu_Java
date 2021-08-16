package academy.pocu.comp2500.lab4;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.HashMap;

public class MemoryCache {
    private static int instanceCount = 0;
    private static int maxInstanceNum = Integer.MAX_VALUE;
    private static EvictionPolicy mode = EvictionPolicy.LEAST_RECENTLY_USED;
    private static ArrayList<String> usingLog = new ArrayList<>();
    public static ArrayList<MemoryCache> caches = new ArrayList<>();
    private String diskName;
    private HashMap<String,String> entry = new HashMap<>();//캐쉬속 데이터
    private ArrayList<String> entryOrder = new ArrayList<>();
    private ArrayList<String> usingEntryLog = new ArrayList<>();
    private int MaxEntryNum;//케쉬속 데이터 최대용량
    private int entryCount;//캐쉬속 데이터 현재 갯수

    private MemoryCache(String diskName){
        this.diskName = diskName;
        instanceCount++;
        entryCount = 0;
        MaxEntryNum = Integer.MAX_VALUE;

    }

    public static MemoryCache getInstance(String hardDiskName){

        for(int i = 0; i < caches.size(); i++) {
            if(caches.get(i).diskName.equals(hardDiskName)) {
                /*
                MemoryCache tem = caches.get(i);
                caches.remove(i);
                caches.add(tem);
                usingLog.add(hardDiskName);
                */
                MemoryCache.useCache(caches.get(i));
                return caches.get(i);
            }
        }

        if(instanceCount < maxInstanceNum){
            MemoryCache tem = new MemoryCache(hardDiskName);
            caches.add(tem);
            usingLog.add(hardDiskName);
            return tem;
        }

        else{
            deleteOneCache();
            MemoryCache tem = new MemoryCache(hardDiskName);
            caches.add(tem);
            usingLog.add(hardDiskName);
            return tem;
        }
    }

    public static void deleteOneCache(){
        if(caches.size() == 0) {
            return;
        }

        if(mode == EvictionPolicy.FIRST_IN_FIRST_OUT){
            for(int i  =0; i < usingLog.size(); i++) {
                if(usingLog.get(i).equals(caches.get(0).diskName)) {
                    usingLog.remove(i);
                    break;
                }
            }
            caches.remove(0);
            instanceCount--;
        }
        else if(mode == EvictionPolicy.LAST_IN_FIRST_OUT){
            for(int i  =0; i < usingLog.size(); i++) {
                if(usingLog.get(i).equals(caches.get(0).diskName)) {
                    usingLog.remove(i);
                    break;
                }
            }
            caches.remove(caches.size()-1);
            instanceCount--;
        }
        else {
            for (int i = 0; i < caches.size(); i++) {
                if (usingLog.get(0).equals(caches.get(i).diskName)) {
                    caches.remove(i);
                    break;
                }
            }
            usingLog.remove(0);
            instanceCount--;
        }
    }

    public static void useCache(MemoryCache instance){
        for(int i = 0 ; i < usingLog.size(); i++) {
            if(usingLog.get(i).equals(instance.diskName)) {
                usingLog.remove(i);
                break;
            }
        }
        usingLog.add(instance.diskName);
    }

    public String getDiskName(){
        return diskName;
    }

    static public void  clear(){
        caches.clear();
        usingLog.clear();
        instanceCount = 0;
    }

    public static void setMaxInstanceCount(int num){
        maxInstanceNum = num;
        while(true){
            if(instanceCount <= num) {
                break;
            }
            deleteOneCache();
        }
        return;
    }

    public void deleteCachEntry(){
        if(entry.size() == 0) {
            return;
        }
        if(mode == EvictionPolicy.FIRST_IN_FIRST_OUT){
            entry.remove(entryOrder.get(0));
            for(int i = 0 ; i < usingEntryLog.size(); i++)
            {
                if(usingEntryLog.get(i).equals(entryOrder.get(0))) {
                    usingEntryLog.remove(i);
                    break;
                }
            };
            entryOrder.remove(0);
            entryCount--;
        }
        else if(mode == EvictionPolicy.LAST_IN_FIRST_OUT){
            entry.remove(entryOrder.get(entryOrder.size() - 1));
            for(int i = 0 ; i < usingEntryLog.size(); i++)
            {
                if(usingEntryLog.get(i).equals(entryOrder.get(entryOrder.size() - 1))) {
                    usingEntryLog.remove(i);
                    break;
                }
            };
            entryOrder.remove(entryOrder.size() - 1);
            entryCount--;
        }
        else {
            entry.remove(usingEntryLog.get(0));
            for(int i = 0 ; i < entryOrder.size(); i++)
            {
                if(entryOrder.get(i).equals(usingEntryLog.get(0))) {
                    entryOrder.remove(i);
                    break;
                }
            }
            usingEntryLog.remove(0);
            entryCount--;
        }
    }

    public void setEvictionPolicy(EvictionPolicy policy) {
        mode = policy;
    }

    public void addEntry(String key,String value){
        if (entry.containsKey(key)) {
            for(int i = 0; i < usingEntryLog.size(); i++) {
                if(usingEntryLog.get(i).equals(key)) {
                    usingEntryLog.remove(i);
                    break;
                }
            }
            usingEntryLog.add(key);
            entry.put(key, value);

        }

        if(entryCount < MaxEntryNum) {
            entryOrder.add(key);
            entry.put(key, value);
            usingEntryLog.add(key);
            entryCount++;
        }
        else {
            deleteCachEntry();
            entry.put(key, value);
            usingEntryLog.add(key);
            entryOrder.add(key);
            entryCount++;
        }

    }

    public String getEntryOrNull(String key){
        if(entry.containsKey(key)){
            for(int i = 0; i < usingEntryLog.size(); i++) {
                if(usingEntryLog.get(i).equals(key)) {
                    usingEntryLog.remove(i);
                    break;
                }
            }
            usingEntryLog.add(key);
            return entry.get(key);
        }
        else{
            return null;
        }
    }

    public void setMaxEntryCount(int num){
        MaxEntryNum = num;
        while(true) {
            if(entryCount <= num) {
                break;
            }
            deleteCachEntry();
        }
    }
}
