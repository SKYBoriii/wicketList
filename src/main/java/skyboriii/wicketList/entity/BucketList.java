package skyboriii.wicketList.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "BucketList")
@Data
public class BucketList {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long bucketId;

    // 버킷리스트 작성자
    @Column(length = 50,nullable = false)
    private String bucketWriter;

    // 버킷리스트 내용
    @Column(length = 1000,nullable = false)
    private String bucketContent;

    // 정보 생성 일자
    private LocalDateTime buketCreatedAt;

    // 정보 변경 일자
    private LocalDateTime buketUpdatedAt;


}
