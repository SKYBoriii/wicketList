package skyboriii.wicketList.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "WishList")
@Data
public class WishList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishId;

    // 글쓴이
    @Column(nullable = false)
    private String wishWriter;

    // 글 내용
    @Column(nullable = false)
    private String wishContent;

    // 정보 만든 시간
    private LocalDateTime WishCreatedAt;

    // 정보 변경 일자
    private LocalDateTime WishUpdatedAt;

}
