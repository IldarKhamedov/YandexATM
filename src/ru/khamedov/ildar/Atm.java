package ru.khamedov.ildar;

import java.util.Map;
import java.util.TreeMap;

public class Atm {
    private TreeMap<Integer, Integer> cash = new TreeMap<>((o1, o2) -> -(o1 - o2));

    public Atm(Map<Integer, Integer> cash) {
        this.cash.putAll(cash);
    }

    public Atm() {
    }

    public int getBalance(){
        int balance=0;
        for(Integer key:cash.keySet()){
            balance=balance+key*cash.get(key);
        }
        return balance;
    }

    public boolean checkSum(int sumClient) {
        if(sumClient%cash.lastKey()!=0){
            return false;
        }
        for (Integer key : cash.keySet()) {
            if(sumClient%key==0 && sumClient <= key*cash.get(key)){
                return true;
            }
            sumClient=sumClient-(key*(sumClient/key <= cash.get(key) ? sumClient/key : cash.get(key)));
        }
        return false;
    }

    public boolean getSumClient(int sumClient) {
        if (!checkSum(sumClient)) {
            return false;
        }
        for (Integer key : cash.keySet()) {
            int allowedCount=(sumClient/key <= cash.get(key) ? sumClient/key : cash.get(key));
            sumClient=sumClient-(key*allowedCount);
            cash.put(key,cash.get(key)-allowedCount);
        }
        return true;
    }
}
