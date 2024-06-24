package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeBucketListContentDTO {

    private Long id;
    private String bucketContent;
    // 목표 기한 바꾸기

    public ChangeBucketListContentDTO(Long id, String bucketContent) {
        this.id = id;
        this.bucketContent = bucketContent;
    }
}
