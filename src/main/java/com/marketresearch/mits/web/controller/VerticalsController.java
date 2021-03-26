package com.marketresearch.mits.web.controller;
import com.marketresearch.mits.web.model.VerticalsDto;
import com.marketresearch.mits.web.repositories.VerticalsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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
    public ResponseEntity getVerticalById(@PathVariable("id") String id){
        return new ResponseEntity(verticalsRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VerticalsDto> saveVertical(@RequestBody VerticalsDto vertical){
        VerticalsDto verticalsDto = verticalsRepository.save(new VerticalsDto(vertical.getName(), vertical.getCategory()));
        return new ResponseEntity(verticalsDto, HttpStatus.CREATED);
    }

    @PutMapping({"{id}"})
    public ResponseEntity modifyVerticalById(@PathVariable("id") String id, @RequestBody VerticalsDto verticals) {
        verticals.setId(id);
        VerticalsDto verticalDto = verticalsRepository.save(verticals);
        return new ResponseEntity(verticalDto, HttpStatus.OK);

    }

    @DeleteMapping({"{id}"})
    public ResponseEntity deleteVertical(@PathVariable String id) {
        try {
            verticalsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
