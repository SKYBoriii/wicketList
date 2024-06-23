package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BucketListResponseDTO {

    private Long id;
    private String bucketWriter;
    private String bucketContent;

    public BucketListResponseDTO(Long id, String bucketWriter, String bucketContent) {
        this.id = id;
        this.bucketWriter = bucketWriter;
        this.bucketContent = bucketContent;
    }


}
