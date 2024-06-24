package skyboriii.wicketList.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "WishList")
@Data
public class WishList extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishId;

    // 글쓴이
    @Column(nullable = false)
    private int wishPrice;

    // 글 내용
    @Column(length = 100, nullable = false)
    private String wishItem;




}
