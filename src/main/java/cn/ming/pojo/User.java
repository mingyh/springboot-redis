package cn.ming.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by ASUS on 2020/8/15.
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private String name;
    private int age;
}
