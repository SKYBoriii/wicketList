package skyboriii.wicketList.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
abstract class BaseEntity {

    // db 가 알아서 인서트 해줌
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    // 자동으로 알아서 업데이트 해줌
    @LastModifiedDate
    @Column(name ="moddate" )
    private LocalDateTime modDate;

}
