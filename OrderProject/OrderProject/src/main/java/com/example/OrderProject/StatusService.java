package com.example.OrderProject;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    public String processStatus(boolean recieving) {
        if (recieving) {
            return "springfundamentals/Recieved";
        } else {
            return "springfundamentals/Delivered";
        }
    }
}
