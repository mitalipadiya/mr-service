package com.marketresearch.mits.web.controller;
import com.marketresearch.mits.web.model.VerticalsDto;
import com.marketresearch.mits.web.repositories.VerticalsRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/verticals")
public class VerticalsController {
    private VerticalsRepository verticalsRepository;
    VerticalsController(VerticalsRepository verticalsRepository){
        this.verticalsRepository = verticalsRepository;
    }

    @GetMapping
    public ResponseEntity<List<VerticalsDto>> getAllVerticals(){
        return new ResponseEntity<>(verticalsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping({"{/id}"})
    public ResponseEntity getVerticalById(@PathVariable("id") ObjectId id){
        return new ResponseEntity(verticalsRepository.findBy_id(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VerticalsDto> saveVertical(@RequestBody VerticalsDto verticals){
        verticals.set_id(ObjectId.get());
        verticalsRepository.save(verticals);
        return new ResponseEntity(verticals, HttpStatus.CREATED);
    }

    @PutMapping({"{/id}"})
    public void modifyVerticalById(@PathVariable("id") ObjectId id, @RequestBody VerticalsDto verticals) {
        verticals.set_id(id);
        verticalsRepository.save(verticals);
    }

    @DeleteMapping({"{/id}"})
    public void deleteVertical(@PathVariable ObjectId id) {
        verticalsRepository.delete(verticalsRepository.findBy_id(id));
    }
}
