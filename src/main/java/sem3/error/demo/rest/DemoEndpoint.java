package sem3.error.demo.rest;


import sem3.error.demo.error.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("api/names")
public class DemoEndpoint {

    static Map<Integer, String> names;

    static {
        names = new HashMap<>();
        names.put(1, "Peter");
        names.put(2, "Jan");
        names.put(3, "Janne");
        names.put(4, "Sandra");
    }

    @GetMapping
    Collection<String> getNames() {
        return names.values();
    }

    @GetMapping("/{id}")
    String getName(@PathVariable int id) {
        String name = names.get(id);
        // With the CrudRepository you can get an optional and do it like this
        // findById(id).orElseThrow(()->new NotFoundException("No name with id: " + id));
        if (name == null) {
            throw new NotFoundException("No name with id: " + id);
        }
        return name;
    }


    @GetMapping("/v2/{id}")
    String getNameV2(@PathVariable int id) {
        String name = names.get(id);
        if (name == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Could not find any name for id: "+id);
        }
        //You should DEFINITELY use Optional responses with your repositories
        //aRepository.findById(id).orElseThrow(()-> new )
        return name;
    }


    @GetMapping("/null-pointer")
    int getLength(){
        String name = "Hans";
        if(true){
            name = null;
        }
        return name.length();
    }

    @GetMapping("/silly-endpoint")
    boolean doThrow() {
        if (true) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "UPPs");
        }
        return true;
    }



}
