package skyboriii.wicketList.data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BucketListDTO {

    private String bucketWriter;
    private String bucketContent;


    public BucketListDTO(String bucketWriter, String bucketContent) {
        this.bucketWriter = bucketWriter;
        this.bucketContent = bucketContent;
    }
}
