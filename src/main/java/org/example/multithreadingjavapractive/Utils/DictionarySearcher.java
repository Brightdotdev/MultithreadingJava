package org.example.multithreadingjavapractive.Utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DictionarySearcher{
    private final ExecutorService executorService;
    private  final Connection connection;


    public DictionarySearcher(int threadPoolSize){
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.connection = SqlDatabaseManager.getConnection();
    }
    public void shutDown(){
        executorService.shutdown();
    }

    public List<WordObject> searchDefinition (String word){
        List<WordObject> results  = new ArrayList<>();
        try{
            Future<List<WordObject>> future = executorService.submit(new Definition(word,connection));
            results = future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return results;
    }
}
