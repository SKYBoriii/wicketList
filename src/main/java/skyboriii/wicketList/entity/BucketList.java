package skyboriii.wicketList.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "BucketList")
@Data
public class BucketList extends BaseEntity{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long bucketId;

    // 버킷리스트 내용
    @Column(length = 1000, nullable = false)
    private String bucketContent;

    // 버킷리스트 완료 일자
    @Column( nullable = true )
    private String bucketGoal;

    private LocalDateTime completedAt;

}
