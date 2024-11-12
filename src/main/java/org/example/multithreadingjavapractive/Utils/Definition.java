package org.example.multithreadingjavapractive.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Definition implements Callable<List<WordObject>>{

    private final String word;
    private final Connection connection;

    public Definition(String word, Connection connection){
        this.connection = connection;
        this.word = word;
    }
    @Override
    public List<WordObject> call() throws Exception {
        List<WordObject> results = new ArrayList<>();
        String query ="SELECT word, type, definition from dictionaryWords where word like ? LIMIT 15 ORDER BY word ASC";
        try (PreparedStatement statement = connection.prepareStatement(query)){
        statement.setString(1, word  + "%");
        try (ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                String word = resultSet.getString("word");
                String definition = resultSet.getString("definition");
                String type = resultSet.getString("type");
                results.add(new WordObject(word,type,definition));
            }
        }
        }

        return results;
    }
}
