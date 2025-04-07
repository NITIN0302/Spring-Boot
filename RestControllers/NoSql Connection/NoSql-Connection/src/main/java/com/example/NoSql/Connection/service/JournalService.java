package com.example.NoSql.Connection.service;

import com.example.NoSql.Connection.entity.Journal;
import com.example.NoSql.Connection.repository.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JournalService {
    @Autowired
    private JournalRepo journalrepo;

    public void saveEntry(Journal journal){
        journalrepo.save(journal);
    }

    public List<Journal> getAll(){
        return journalrepo.findAll();
    }

    public Optional<Journal> getDataById(String Id){
        Optional<Journal> result = journalrepo.findById(Id);
        return result;
    }

    public void deleteData(String id){
        journalrepo.deleteById(id);
    }

    public Journal updateInfo(String id,Journal newEntry){
        Journal result = journalrepo.findById(id).orElse(null);
        if(result != null){
            result.setName(newEntry.getName() == null ? result.getName():newEntry.getName());
            result.setEmail(newEntry.getEmail() == null ? result.getEmail():newEntry.getEmail());
        }
        journalrepo.save(result);
        return newEntry;
    }
}
