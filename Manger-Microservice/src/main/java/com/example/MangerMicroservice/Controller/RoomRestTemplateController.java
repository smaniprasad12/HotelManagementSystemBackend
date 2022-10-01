package com.example.MangerMicroservice.Controller;


import com.example.MangerMicroservice.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@CrossOrigin("*")
@RestController
@RequestMapping("/Manager")
public class RoomRestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    static  final String RESERVATION_URL="http://localhost:8080/Receptionist/";

    @GetMapping("/restroom/{id}")
    public String fetchroom(@PathVariable(value = "id") int id){
        return restTemplate.exchange(RESERVATION_URL+"room/"+id, HttpMethod.GET,null,String.class).getBody();

    }
    @GetMapping("/restlistrooms")
    public String fetchallRooms(){
        return restTemplate.exchange(RESERVATION_URL+"room/list",HttpMethod.GET,null,String.class).getBody();
    }

    @PostMapping("/restroomsave")
    public String addRoom(@RequestBody Room room){
        return restTemplate.postForObject(RESERVATION_URL+"room/save",room,String.class);
    }

    @PutMapping("/updateroom/{id}")
    public String updateRoom(@PathVariable(value = "id") int id, @RequestBody Room room ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Room> entity = new HttpEntity<Room>(room,headers);

        return restTemplate.exchange(
                RESERVATION_URL+"room/edit/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @DeleteMapping("/deleteroom/{id}")
    public String deleteRoom(@PathVariable(value = "id") int id, @RequestBody Room room ) {

        return restTemplate.exchange(
                RESERVATION_URL+"room/delete/"+id, HttpMethod.DELETE, null, String.class).getBody();
    }

}
