package com.example.NoSql.Connection.controller;

import com.example.NoSql.Connection.entity.Journal;
import com.example.NoSql.Connection.repository.JournalRepo;
import com.example.NoSql.Connection.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalservice;

    @GetMapping
    public List<Journal> getAllEntry() {
        List<Journal> result = journalservice.getAll();
        return result;
    }

    @PostMapping
    public ResponseEntity<Boolean> createEntry(@RequestBody Journal myEntry) {

        try {
            journalservice.saveEntry(myEntry);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } catch (Exception ex) {

        }
        return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("id/{Id}")
    public ResponseEntity<Journal> getJournalEntryById(@PathVariable String Id) {
        Optional<Journal> result = journalservice.getDataById(Id);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{Id}")
    public ResponseEntity<?> deleteJournalEntry(@PathVariable String Id) {
        journalservice.deleteData(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{Id}")
    public Journal updateJournalEntry(@PathVariable String Id, @RequestBody Journal myEntry) {
        Journal result = journalservice.updateInfo(Id, myEntry);
        return result;
    }

}
