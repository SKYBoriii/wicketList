package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeBucketListContentDTO {

    private Long id;
    private String bucketContent;

    public ChangeBucketListContentDTO(Long id, String bucketContent) {
        this.id = id;
        this.bucketContent = bucketContent;
    }
}
