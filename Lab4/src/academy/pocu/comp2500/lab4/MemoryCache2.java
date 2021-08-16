package academy.pocu.comp2500.lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryCache2 {

    private static int maxInstanceCount;
    private static HashMap<String, MemoryCache2> diskDriveMap = new HashMap<>();
    private static ArrayList<String> instanceCreatedSortList = new ArrayList<>();
    private EvictionPolicy evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    private ArrayList<Map<String, String>> createdSortList = new ArrayList<>();
    private ArrayList<Map<String, String>> usedUpdateList = new ArrayList<>();
    private int maxCacheEntry;

    private MemoryCache2() {
    }

    public static MemoryCache2 getInstance(String diskName) {
        if (diskDriveMap.containsKey(diskName)) {
            for (Map.Entry<String, MemoryCache2> list : diskDriveMap.entrySet()) {
                if (list.getKey().equals(diskName)) {
                    MemoryCache2 temp = diskDriveMap.get(diskName);
                    diskDriveMap.remove(diskName);
                    diskDriveMap.put(diskName, temp);
                    instanceCreatedSortList.remove(list.getKey());
                    instanceCreatedSortList.add(list.getKey());
                    return list.getValue();
                }
            }
        }

        if (diskDriveMap.size() >= maxInstanceCount && maxInstanceCount > 0) {
            diskDriveMap.remove(instanceCreatedSortList.get(0));
            instanceCreatedSortList.remove(0);
        }

        MemoryCache2 instance = new MemoryCache2();
        diskDriveMap.put(diskName, instance);
        instanceCreatedSortList.add(diskName);
        return instance;
    }

    public static void clear() {
        diskDriveMap.clear();
    }

    public static void setMaxInstanceCount(int count) {
        maxInstanceCount = count;
        int removeCount = diskDriveMap.size() - maxInstanceCount;
        if (diskDriveMap.size() > maxInstanceCount) {
            for (int i = 0; i < removeCount; i++) {
                diskDriveMap.remove(instanceCreatedSortList.get(0));
                instanceCreatedSortList.remove(0);
            }
        }
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    public void addEntry(String key, String value) {

        if (maxCacheEntry == 0) {
            entryAdder(key, value);
        } else if (maxCacheEntry == 1) {
            entryAdder(key, value);
            if (usedUpdateList.size() == 1) {
                usedUpdateList.remove(0);
                createdSortList.remove(0);
            }
        } else if (maxCacheEntry > 1) {
            entryAdder(key, value);
            if (createdSortList.size() > maxCacheEntry) {
                cacheRemove(evictionPolicy, createdSortList.size() - 2);
            }
        }
    }

    private void cacheRemove(EvictionPolicy evictionPolicy, int index) {
        switch (evictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                usedUpdateList.remove(createdSortList.get(0));
                createdSortList.remove(0);
                break;
            case LEAST_RECENTLY_USED:
                createdSortList.remove(usedUpdateList.get(0));
                usedUpdateList.remove(0);

                break;
            case LAST_IN_FIRST_OUT:
                usedUpdateList.remove(createdSortList.get(index));
                createdSortList.remove(index);
                break;
            default:
                break;
        }
    }

    private void entryAdder(String key, String value) {
        Map<String, String> entryCache = new HashMap<>();
        entryCache.put(key, value);
        boolean bCheck = true;

        for (Map<String, String> list : createdSortList) {
            if (list.containsKey(key)) {
                list.put(key, value); //생성순서 유지
                usedUpdateList.remove(list);
                usedUpdateList.add(entryCache);
                bCheck = false;
                break;
            }
        }
        if (bCheck) {
            createdSortList.add(entryCache);
            usedUpdateList.add(entryCache);
        }
    }

    public String getEntryOrNull(String key) {
        for (Map<String, String> list : usedUpdateList) {
            if (list.containsKey(key)) {
                Map<String, String> temp = list;
                usedUpdateList.remove(list);
                usedUpdateList.add(temp);
                return list.get(key);
            }
        }
        return null;
    }

    public void setMaxEntryCount(int count) {
        maxCacheEntry = count;
        int removeCount = createdSortList.size() - count;
        if (createdSortList.size() > maxCacheEntry) {
            for (int i = 0; i < removeCount; i++) {
                cacheRemove(evictionPolicy, createdSortList.size() - 1);
            }
        }
    }
}


